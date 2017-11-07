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
import javax.swing.table.AbstractTableModel;

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
 
    public EcranListeDuPersonnel() {
        super();
 
        setTitle("Gestion du personnel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        tableau = new JTable(modele);
        chargerPersonnels();
 
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
 
        JPanel boutons = new JPanel();
 
        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));
 
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
    
    private class AddAction extends AbstractAction {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private AddAction() {
            super("Ajouter");
        }
 
        public void actionPerformed(ActionEvent e) {
        	JDialog afficheAjoutPersonnel = new AfficheAjoutPersonnel(EcranListeDuPersonnel.this);
        	afficheAjoutPersonnel.setVisible(true);
        	
        	chargerPersonnels();
        	System.out.println("test2");
        	
        	
        }


    }
 
    private class RemoveAction extends AbstractAction {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private RemoveAction() {
            super("Supprimmer");
        }
 
        public void actionPerformed(ActionEvent e) {
            int[] selection = tableau.getSelectedRows();
            int ligne=tableau.getSelectedRow();
            int code = (int) tableau.getValueAt(ligne,0);
            System.out.println(code);

            for(int i = selection.length - 1; i >= 0; i--){
                modele.removePersonnel(selection[i]);
                try {
					PersonnelManager.getInstance().supprimerUnPersonnel(code);
				} catch (BLLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }
    }
}