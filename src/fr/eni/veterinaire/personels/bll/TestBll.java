// codé par kcc
// version 1
// permet le test de la BLL en utilisant le PersonnelManager

package fr.eni.veterinaire.personels.bll;


import fr.eni.veterinaire.personels.bo.Personnel;

public class TestBll {

	public static void main(String[] args) {

		PersonnelManager catalogueManager = PersonnelManager.getInstance();
		//Instanciation du jeu d'essai 
		Personnel p1 = new Personnel(  "Nomkcc", "MdPKCC","adm", false);
		Personnel p2 = new Personnel(  "Nomkcc2", "MdPKCC2","sec", false);
		Personnel p3 = new Personnel(  "Nomkcc3", "MdPKCC3","vet", true);
		Personnel p4 = new Personnel(  "Nomkcc4", "MdPKCC4","vet", false);


		//TODO...
		try {
			//Ajout d'un personnel
			System.out.println("Ajout des personnels... ");
			catalogueManager.ajouterPersonnel(p1);
			System.out.println("Personnel ajouté  : " + p1.toString() );
			catalogueManager.ajouterPersonnel(p2);
			System.out.println("Personnel ajouté  : " + p2.toString() );
			catalogueManager.ajouterPersonnel(p3);
			System.out.println("Personnel ajouté  : " + p3.toString() );
			catalogueManager.ajouterPersonnel(p4);
			System.out.println("Personnel ajouté  : " + p4.toString() );
			System.out.println("--------------------------------------------- ");

			//Modification d'un personnel
			System.out.println("\n Modification d'un personnel  : " );
			System.out.println("personnel avant modification : "  + p1.toString());
			(p1).setNom("kccNom");
			(p1).setMotDePasse("kccMdP");
			(p1).setMetier("vet");
			(p1).setArchive(true);
			catalogueManager.modifierUnPersonnel(p1);
			System.out.println("personnel après modification  : " + p1.toString() );
			System.out.println("--------------------------------------------- ");

			//selection d'un personnel
			System.out.println(catalogueManager.selectionUnPersonnel(5));
			System.out.println("--------------------------------------------- ");

			//Suppression d'un personnel
			System.out.println("\nSuppression du personnel  : " + p1.toString());
			catalogueManager.supprimerUnPersonnel(p1.getCodePersonnel());
			System.out.println("Liste des articles après suppression : "  );
			System.out.println(catalogueManager.getlisteDuPersonnel());
			System.out.println("--------------------------------------------- ");
			//

			//Suppression d'un personnel archivé
			System.out.println("\nSuppression du personnel  : " + p3.toString());
			catalogueManager.supprimerUnPersonnel(p3.getCodePersonnel());
			System.out.println("Liste des articles après suppression : "  );
			System.out.println(catalogueManager.getlisteDuPersonnel());
			System.out.println("--------------------------------------------- ");
			//

		} //catch (DALException e) {
		catch (Exception e) {
			e.printStackTrace();
		}

	}


}


