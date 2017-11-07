package fr.eni.veterinaire.bo;

import java.util.ArrayList;
import java.util.List;

public class PersonnelTestBO {

	public static void main(String[] args) {

		// attributs
		List<Personnel> listeDesPersonnel = null;

		try {
			//initialisation de la liste du personnel
			listeDesPersonnel = new ArrayList<Personnel>();

			//création des personnels
			Personnel perso1 = new Personnel(1, "Nom1", "MdP1","Role1", false);
			Personnel perso2 = new Personnel(2, "Nom2", "MdP2","Role2", false);
			Personnel perso3 = new Personnel(3, "Nom3", "MdP3","Role3", false);
			Personnel perso4 = new Personnel(4, "Nom4", "MdP4","Role4", false);
			
			System.out.println("\n : Affichage d'un nouvel personnel");
			System.out.println(perso1.toString());
			System.out.println("---------------------------------------------------------------");

			// Ajout des personnels a la liste. 
			listeDesPersonnel.add(perso1);
			listeDesPersonnel.add(perso2);
			listeDesPersonnel.add(perso3);
			listeDesPersonnel.add(perso4);

			System.out.println("\n : Affichage de la liste des personnels");
			System.out.println(listeDesPersonnel.toString());
			System.out.println("---------------------------------------------------------------");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
