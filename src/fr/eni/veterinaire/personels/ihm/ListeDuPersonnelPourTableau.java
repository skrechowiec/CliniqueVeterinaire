package fr.eni.veterinaire.personels.ihm;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.veterinaire.personels.bo.Personnel;


public class ListeDuPersonnelPourTableau extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Personnel> listeDuPersonnel = new ArrayList<Personnel>();
	private final String[] entetes = {"Nom", "Metier", "Mot de passe"};
 
    public ListeDuPersonnelPourTableau() {
        super();
       }
 
    public void setData(List<Personnel> personnels){
    	listeDuPersonnel = personnels;
    }
    
    public int getRowCount() {
        return listeDuPersonnel.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        	    return listeDuPersonnel.get(rowIndex).getNom();
            case 1:
                return listeDuPersonnel.get(rowIndex).getMetier();
            case 2:
                return listeDuPersonnel.get(rowIndex).getMotDePasse();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void addPersonnel(Personnel personnel) {
    	listeDuPersonnel.add(personnel);
 
        fireTableRowsInserted(listeDuPersonnel.size() -1, listeDuPersonnel.size() -1);
    }
 
    public void removePersonnel(int rowIndex) {
    	listeDuPersonnel.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}