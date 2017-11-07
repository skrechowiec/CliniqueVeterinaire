package fr.eni.veterinaire.personels.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.veterinaire.personels.bll.BLLException;
import fr.eni.veterinaire.personels.bll.PersonnelManager;
import fr.eni.veterinaire.personels.bo.Personnel;
import fr.eni.veterinaire.personels.dal.FactoryDAO;
import fr.eni.veterinaire.personels.dal.PersonnelDAO;

public class AfficheAjoutPersonnel extends JDialog{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//attribut
	
	private JPanel panneauAjoutPersonnel, ecranDonnee, ecranBouton;
	private Personnel nouveauPersonnel = null;
	private String nom, motDePasse, metier;
	private JTextField txtNom, txtMotDePasse;
	
	private ButtonGroup groupMetier;
	private JRadioButton boutonMetierAdm;
	private JRadioButton boutonMetierVet;
	private JRadioButton boutonMetierSec;
	
	private JButton btnAjout, btnAnnule;
	private String Metier = null;
	
	JLabel lblNom= new JLabel("Nom : ");
	JLabel lblMotDePasse= new JLabel("Mot de passe : ");
	JLabel lblMetier= new JLabel("Metier : ");
	
	JFrame parent;
	
	//ecran principal
	public AfficheAjoutPersonnel(JFrame parent) {
		this.parent = parent;
		this.setModal(true);
		setTitle("Nouveau Personnel"); //le titre
		this.setSize(new Dimension(400, 400)); //la taille
		this.setResizable(true); //taille non modifiable
		this.setLocationRelativeTo(null);
		panneauAjoutPersonnel = getPanneauAjoutPersonnel(); //creation du panneau principal
		this.setContentPane(getPanneauAjoutPersonnel()); 		//Ajouter le panel à la JFrame

	}	

	//Création des champs textes
	public JTextField getTxtNom() {
		if(txtNom == null){
			txtNom= new JTextField(20);
		}	
		return txtNom;
	}

	public JTextField getTxtMotDePasse() {
		if(txtMotDePasse == null){
			txtMotDePasse= new JTextField(20);
		}
		return txtMotDePasse;
	}
	
	
	public ButtonGroup getGroupMetier(){
		if (groupMetier == null){
			groupMetier = new ButtonGroup();
			groupMetier.add(boutonMetierAdm);	
			groupMetier.add(boutonMetierSec);	
			groupMetier.add(boutonMetierVet);	
				
		}
		return groupMetier;
	}

	public JRadioButton getBoutonMetierAdm() {
		if (boutonMetierAdm == null){
			boutonMetierAdm = new JRadioButton("Administrateur");
			boutonMetierAdm.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					Metier = "Adm"; 
				}
			});
		}
		return boutonMetierAdm;
	}

	public JRadioButton getBoutonMetierSec() {
		if (boutonMetierSec == null){
			boutonMetierSec = new JRadioButton("Secretariat");
			boutonMetierSec.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					Metier = "Sec"; 
					}
			});
		}
		return boutonMetierSec;
	}
	public JRadioButton getBoutonMetierVet() {
		if (boutonMetierVet == null){
			boutonMetierVet = new JRadioButton("Veterinaire");
			boutonMetierVet.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					Metier = "Vet"; 
					}
			});
		}
		return boutonMetierVet;
	}

	public JButton getBtnAjout(){
		if (btnAjout == null){
			btnAjout = new JButton("",new ImageIcon(this.getClass().getResource(".\\media\\Save24.gif")));
			btnAjout.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					nom = getTxtNom().getText();
					motDePasse = getTxtMotDePasse().getText();
					metier = getMetier();
					nouveauPersonnel = new Personnel (nom, motDePasse, metier, false);
					try {
						PersonnelManager.getInstance().ajouterPersonnel(nouveauPersonnel);
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AfficheAjoutPersonnel.this.dispose();
				}
			});
		}
		return btnAjout;
	}
	
	public JButton getBtnAnnule(){
		if (btnAnnule == null){
			btnAnnule = new JButton("",new ImageIcon(this.getClass().getResource(".\\media\\New24.gif")));
			btnAnnule.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					//remplir une donné
				}
			});
		}
		return btnAnnule;
	}


	public JPanel getPanneauAjoutPersonnel() { //gestion des 2 écrans en Y
		if (panneauAjoutPersonnel == null){
			panneauAjoutPersonnel = new JPanel();
			panneauAjoutPersonnel.setOpaque(true);
			panneauAjoutPersonnel.setLayout(new BoxLayout( panneauAjoutPersonnel, BoxLayout.Y_AXIS));
			panneauAjoutPersonnel.add(getEcranDonnee());
			panneauAjoutPersonnel.add(getEcranBouton());
		}
		return panneauAjoutPersonnel;
	}

	public JPanel getEcranDonnee() { //gestion du 1er ecran
		if (ecranDonnee == null){
			ecranDonnee = new JPanel();
			ecranDonnee.setLayout(new GridBagLayout());
			GridBagConstraints placement = new GridBagConstraints();

			//Ligne 1 
			placement.gridx = 0;
			placement.gridy = 0;
			placement.weightx = placement.weighty = 1;
			ecranDonnee.add( lblNom, placement);

			placement.gridx = 1;
			placement.gridy = 0;
			ecranDonnee.add( getTxtNom(), placement);

			//Ligne 2 
			placement.gridx = 0;
			placement.gridy = 1;
			ecranDonnee.add( lblMotDePasse, placement);

			placement.gridx = 1;
			placement.gridy = 1;
			ecranDonnee.add( getTxtMotDePasse(), placement);

			//Ligne 3
			placement.gridx = 0;
			placement.gridy = 2;
			placement.gridheight = 3;
			ecranDonnee.add( lblMetier, placement);

			placement.gridx = 1;
			placement.gridy = 2;
			placement.gridheight = 1;
			ecranDonnee.add( getBoutonMetierAdm(), placement);

			placement.gridx = 1;
			placement.gridy = 3;
			ecranDonnee.add( getBoutonMetierVet(), placement);

			placement.gridx = 1;
			placement.gridy = 4;
			ecranDonnee.add( getBoutonMetierSec(), placement);

		}return ecranDonnee;
	}

	public JPanel getEcranBouton() { // gestion du 2eme ecran
		if (ecranBouton == null){
			ecranBouton = new JPanel();
			ecranBouton.setLayout(new GridBagLayout());
			GridBagConstraints placement2 = new GridBagConstraints();


			placement2.gridx = 0;
			placement2.gridy = 0;
			ecranBouton.add( getBtnAjout(), placement2);

			placement2.gridx = 1;
			placement2.gridy = 0;
			ecranBouton.add( getBtnAnnule(),placement2);


		}return ecranBouton;
	}

	public String getMetier() {
		return Metier;
	}

	public void setMetier(String metier) {
		Metier = metier;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

