package fr.eni.veterinaire.clients.ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EcranAjouterUnClient extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private JPanel panelPrincipal;
	private JLabel lblCodeClient, lblClient, lblPrenomClient, lblAdresse1, lblAdresse2, lblCodePostal, lblVille, 
	lblNumTel, lblAssurance, lblEmail, lblRemarque, lblArchive; 
	private JTextField txtCodeClient, txtClient, txtPrenomClient, txtAdresse1, txtAdresse2,
	txtCodePostal, txtVille, txtNumTel, txtAssurance, txtEmail, txtRemarque, txtArchive;
	private JButton btnValider, btnAnnuler;
	
	//source code de JFrame + setTitle 
	public EcranAjouterUnClient() {
		setTitle("Ajouter un client");
		this.setSize(new Dimension(500, 500));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initIHM();
	}
	//création de panel et des lignes en utilisant x-y coordinates
	private void initIHM(){
		JPanel p = getPanelPrincipal();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Ligne 1 
		gbc.gridy = 0;
		gbc.gridx = 0;
		p.add( getLblCodeClient(), gbc);
		
		gbc.gridx = 1;		
		p.add( getTxtCodeClient(), gbc);
		
		//Ligne 2 
		gbc.gridy = 1;
		gbc.gridx = 0;
		p.add( getLblClient(), gbc);
		
		gbc.gridx = 1;		
		p.add( getTxtClient(), gbc);
		
		//Ligne 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		p.add( getLblPrenomClient(), gbc);

		gbc.gridx = 1;
		p.add( getTxtPrenomClient(), gbc);
		
		//Ligne 4
		gbc.gridy = 3;
		gbc.gridx = 0;
		p.add( getLblAdresse1(), gbc);

		gbc.gridx = 1;
		p.add( getTxtAdresse1(), gbc);
		
		//Ligne 5
		gbc.gridy = 4;
		gbc.gridx = 0;
		p.add( getLblAdresse2(), gbc);

		gbc.gridx = 1;
		p.add( getTxtAdresse2(), gbc);
		
		//Ligne 6
		gbc.gridy = 5;
		gbc.gridx = 0;
		p.add( getLblCodePostal(), gbc);

		gbc.gridx = 1;
		p.add( getTxtCodePostal(), gbc);
				
		//Ligne 7
		gbc.gridy = 6;
		gbc.gridx = 0;
		p.add( getLblVille(), gbc);

		gbc.gridx = 1;
		p.add( getTxtVille(), gbc);
		
		//Ligne 8
		gbc.gridy = 7;
		gbc.gridx = 0;
		p.add( getLblNumTel(), gbc);

		gbc.gridx = 1;
		p.add( getTxtNumTel(), gbc);
				
		//Ligne 9
		gbc.gridy = 8;
		gbc.gridx = 0;
		p.add( getLblAssurance(), gbc);

		gbc.gridx = 1;
		p.add( getTxtAssurance(), gbc);
		
		//Ligne 10
		gbc.gridy = 9;
		gbc.gridx = 0;
		p.add( getLblEmail(), gbc);

		gbc.gridx = 1;
		p.add( getTxtEmail(), gbc);
				
		//Ligne 11
		gbc.gridy = 10;
		gbc.gridx = 0;
		p.add( getLblRemarque(), gbc);

		gbc.gridx = 1;
		p.add( getTxtRemarque(), gbc);
		
		//Ligne 12
		gbc.gridy = 11;
		gbc.gridx = 0;
		gbc.gridheight = 2;
		p.add( getLblArchive(), gbc);

		gbc.gridx = 1;
		p.add( getTxtArchive(), gbc);
		
//		//Ligne 13
//		gbc.gridy = 12;
//		gbc.gridx = 0;
//		gbc.gridwidth = 2;
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//		p.add(getBtnValider(), gbc);

				
		
		
	//Ajouter le panel à la JFrame
	this.setContentPane(getPanelPrincipal());
	}

	//getter JPanel
	public JPanel getPanelPrincipal() {
		if (panelPrincipal == null){
			 panelPrincipal = new JPanel();
			 panelPrincipal.setOpaque(true);
			}
		return panelPrincipal;
	}
	
	//getters des JLabels
	public JLabel getLblCodeClient() {
		if(lblCodeClient == null){
			lblCodeClient= new JLabel("Code");
		}
		return lblCodeClient;
	}
	public JLabel getLblClient() {
		if(lblClient == null){
			lblClient= new JLabel("Nom");
		}
		return lblClient;
	}
	public JLabel getLblPrenomClient() {
		if(lblPrenomClient == null){
			lblPrenomClient= new JLabel("Prénom");
		}
		return lblPrenomClient;
	}
	public JLabel getLblAdresse1() {
		if(lblAdresse1 == null){
			lblAdresse1= new JLabel("Adresse");
		}
		return lblAdresse1;
	}
	public JLabel getLblAdresse2() {
		if(lblAdresse2 == null){
			lblAdresse2= new JLabel("");
		}
		return lblAdresse2;
	}
	public JLabel getLblCodePostal() {
		if(lblCodePostal == null){
			lblCodePostal= new JLabel("Code postal");
		}
		return lblCodePostal;
	}
	public JLabel getLblVille() {
		if(lblVille == null){
			lblVille= new JLabel("Ville");
		}
		return lblVille;
	}
	public JLabel getLblNumTel() {
		if(lblNumTel == null){
			lblNumTel= new JLabel("Num téléphone");
		}
		return lblNumTel;
	}
	public JLabel getLblAssurance() {
		if(lblAssurance == null){
			lblAssurance= new JLabel("Assurance");
		}
		return lblAssurance;
	}
	public JLabel getLblEmail() {
		if(lblEmail == null){
			lblEmail= new JLabel("E-mail");
		}
		return lblEmail;
	}
	public JLabel getLblRemarque() {
		if(lblRemarque == null){
			lblRemarque= new JLabel("Remarque");
		}
		return lblRemarque;
	}
	public JLabel getLblArchive() {
		if(lblArchive == null){
			lblArchive= new JLabel("Archive");
		}
		return lblArchive;
	}

	//getters des JTexts
	public JTextField getTxtCodeClient() {
		if(txtCodeClient==null){
			txtCodeClient = new JTextField(30);
		}
		return txtCodeClient;
	}
	public JTextField getTxtClient() {
		if(txtClient==null){
			txtClient = new JTextField(30);
		}
		return txtClient;
	}
	public JTextField getTxtPrenomClient() {
		if(txtPrenomClient==null){
			txtPrenomClient = new JTextField(30);
		}
		return txtPrenomClient;
	}
	public JTextField getTxtAdresse1() {
		if(txtAdresse1==null){
			txtAdresse1 = new JTextField(30);
		}
		return txtAdresse1;
	}
	public JTextField getTxtAdresse2() {
		if(txtAdresse2==null){
			txtAdresse2 = new JTextField(30);
		}
		return txtAdresse2;
	}
	public JTextField getTxtCodePostal() {
		if(txtCodePostal==null){
			txtCodePostal = new JTextField(30);
		}
		return txtCodePostal;
	}
	public JTextField getTxtVille() {
		if(txtVille==null){
			txtVille = new JTextField(30);
		}
		return txtVille;
	}
	public JTextField getTxtNumTel() {
		if(txtNumTel==null){
			txtNumTel = new JTextField(30);
		}
		return txtNumTel;
	}
	public JTextField getTxtAssurance() {
		if(txtAssurance==null){
			txtAssurance = new JTextField(30);
		}
		return txtAssurance;
	}
	public JTextField getTxtEmail() {
		if(txtEmail==null){
			txtEmail = new JTextField(30);
		}
		return txtEmail;
	}
	public JTextField getTxtRemarque() {
		if(txtRemarque==null){
			txtRemarque = new JTextField(30);
		}
		return txtRemarque;
	}
	public JTextField getTxtArchive() {
		if(txtArchive==null){
			txtArchive = new JTextField(30);
		}
		return txtArchive;
	}
	


	//getters des JButtons
	public JButton getBtnValider() {
		if(btnValider==null){
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e) {
	System.out.println("Click sur Valider");
	}
	});
	}
	return btnValider;
	}
	
	public JButton getBtnAnnuler() {
		if(btnAnnuler==null){
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e) {
	System.out.println("Click sur Annuler");
	}
	});
	}
	return btnAnnuler;
	}

}


