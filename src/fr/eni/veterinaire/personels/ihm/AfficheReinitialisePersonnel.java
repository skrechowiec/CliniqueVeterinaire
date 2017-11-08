package fr.eni.veterinaire.personels.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.veterinaire.personels.bll.BLLException;
import fr.eni.veterinaire.personels.bll.PersonnelManager;
import fr.eni.veterinaire.personels.bo.Personnel;

public class AfficheReinitialisePersonnel extends JDialog{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//attribut

	private JPanel panneauModifierPersonnel, ecranDonnee, ecranBouton;
	private Personnel Personnel = null;
	private String nom, motDePasse, metier;
	private JTextField txtNom, txtMotDePasse;

	private ButtonGroup groupMetier;
	private JRadioButton boutonMetierAdm;
	private JRadioButton boutonMetierVet;
	private JRadioButton boutonMetierSec;

	private JButton btnModifie, btnAnnule;
	private String Metier = null;

	JLabel lblNom= new JLabel("Nom : ");
	JLabel lblMotDePasse= new JLabel("Mot de passe : ");
	JLabel lblMetier= new JLabel("Metier : ");

	JFrame parent;

	//ecran principal
	public AfficheReinitialisePersonnel(JFrame parent, Personnel perso) {
		this.parent = parent;
		this.Personnel = perso;
		this.setModal(true);
		setTitle("Modification du Personnel"); //le titre
		this.setSize(new Dimension(400, 400)); //la taille
		this.setResizable(true); //taille non modifiable
		this.setLocationRelativeTo(null);
		panneauModifierPersonnel = getPanneauModifierPersonnel(); //creation du panneau principal
		this.setContentPane(getPanneauModifierPersonnel()); 		//Ajouter le panel à la JFrame

	}	

	//Création des champs textes
	public JTextField getTxtNom() {
		if(txtNom == null){
			txtNom= new JTextField(Personnel.getNom(),20);
		}
		return txtNom;
	}


	public JTextField getTxtMotDePasse() {
		if(txtMotDePasse == null){
			txtMotDePasse= new JTextField(Personnel.getMotDePasse(),20);
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

	public JButton getBtnModifie(){
		if (btnModifie == null){
			btnModifie = new JButton("",new ImageIcon(this.getClass().getResource(".\\media\\Save24.gif")));
			btnModifie.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					int codePersonnel = Personnel.getCodePersonnel();
					nom = getTxtNom().getText();
					motDePasse = getTxtMotDePasse().getText();
					metier = getMetier();
					Personnel = new Personnel (codePersonnel, nom, motDePasse, metier, false);
					try {
						PersonnelManager.getInstance().modifierUnPersonnel(Personnel);
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AfficheReinitialisePersonnel.this.dispose();
				}
			});
		}
		return btnModifie;
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


	public JPanel getPanneauModifierPersonnel() { //gestion des 2 écrans en Y
		if (panneauModifierPersonnel == null){
			panneauModifierPersonnel = new JPanel();
			panneauModifierPersonnel.setOpaque(true);
			panneauModifierPersonnel.setLayout(new BoxLayout( panneauModifierPersonnel, BoxLayout.Y_AXIS));
			panneauModifierPersonnel.add(getEcranDonnee());
			panneauModifierPersonnel.add(getEcranBouton());
		}
		return panneauModifierPersonnel;
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

			switch ((Personnel.getMetier())) {
			case "Adm": boutonMetierAdm.setSelected(true);
			Metier = "Adm";
			break;
			case "Sec": boutonMetierSec.setSelected(true);
			Metier = "Sec";
			break;
			case "Vet": boutonMetierVet.setSelected(true);
			Metier = "Vet";
			break;
			}
		}return ecranDonnee;
	}

	public JPanel getEcranBouton() { // gestion du 2eme ecran
		if (ecranBouton == null){
			ecranBouton = new JPanel();
			ecranBouton.setLayout(new GridBagLayout());
			GridBagConstraints placement2 = new GridBagConstraints();


			placement2.gridx = 0;
			placement2.gridy = 0;
			ecranBouton.add( getBtnModifie(), placement2);

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

