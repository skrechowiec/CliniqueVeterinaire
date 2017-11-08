package fr.eni.veterinaire.personels.ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.eni.veterinaire.personels.bll.BLLException;
import fr.eni.veterinaire.personels.bll.PersonnelManager;
import fr.eni.veterinaire.personels.bo.Personnel;

public class EcranListeDuPersonnel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListeDuPersonnelPourTableau modele = new ListeDuPersonnelPourTableau();
	private JTable tableau;
	private Personnel personelAModifier = null;

	public EcranListeDuPersonnel() {
		super();

		setTitle("Gestion du personnel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tableau = new JTable(modele);
		chargerPersonnels();

		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

		JPanel boutons = new JPanel();

		boutons.add(new JButton(new AjoutPersonnel()));
		boutons.add(new JButton(new SuppressionPersonnel()));
		boutons.add(new JButton(new ReinitialiseMotDePasse()));

		getContentPane().add(boutons, BorderLayout.NORTH);

		pack();
	}

	public static void main(String[] args) {
		new EcranListeDuPersonnel().setVisible(true);
	}

	public void chargerPersonnels() {
		ListeDuPersonnelPourTableau model = (ListeDuPersonnelPourTableau) tableau.getModel();
		List<Personnel> listeDuPersonnel = PersonnelManager.getInstance().listeDuPersonnel();
		model.setData(listeDuPersonnel);
		model.fireTableDataChanged();
		tableau.setModel(model);
		tableau.repaint();
		pack();

	}

	private class AjoutPersonnel extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private AjoutPersonnel() {
			super("Ajouter");
		}

		public void actionPerformed(ActionEvent e) {
			JDialog afficheAjoutPersonnel = new AfficheAjoutPersonnel(EcranListeDuPersonnel.this);
			afficheAjoutPersonnel.setVisible(true);

			chargerPersonnels();


		}


	}

	private class SuppressionPersonnel extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private SuppressionPersonnel() {
			super("Supprimer");
		}

		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();
			int ligne=tableau.getSelectedRow();
			String nom = (String) tableau.getValueAt(ligne,0);

			for(int i = selection.length - 1; i >= 0; i--){
				modele.removePersonnel(selection[i]);
				try {
					PersonnelManager.getInstance().supprimerUnPersonnelParLeNom(nom);
				}	catch (BLLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}


	}
	private class ReinitialiseMotDePasse extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private ReinitialiseMotDePasse() {
			super("Réinitialiser");
		}

		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();
			int ligne=tableau.getSelectedRow();
			int code = (int) tableau.getValueAt(ligne,0);

			for(int i = selection.length - 1; i >= 0; i--){
				try {
					personelAModifier = PersonnelManager.getInstance().selectionUnPersonnel(code);
				}	catch (BLLException e1) {
					e1.printStackTrace();
				}

			}
			JDialog AfficheReinitialisePersonnel = new AfficheReinitialisePersonnel(EcranListeDuPersonnel.this, personelAModifier);
			AfficheReinitialisePersonnel.setVisible(true);

			chargerPersonnels();


		}


	}

}
