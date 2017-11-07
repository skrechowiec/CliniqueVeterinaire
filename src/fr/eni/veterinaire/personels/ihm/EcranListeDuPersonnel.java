package fr.eni.veterinaire.personels.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
 
    private class AddAction extends AbstractAction {
        private AddAction() {
            super("Ajouter");
        }
 
        public void actionPerformed(ActionEvent e) {
            modele.addPersonnel(new Personnel("testAjout", "adm", "adm" , false));
        }
    }
 
    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimmer");
        }
 
        public void actionPerformed(ActionEvent e) {
            int[] selection = tableau.getSelectedRows();
 
            for(int i = selection.length - 1; i >= 0; i--){
                modele.removePersonnel(selection[i]);
            }
        }
    }
}