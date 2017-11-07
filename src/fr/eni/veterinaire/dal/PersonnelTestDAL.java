package fr.eni.veterinaire.dal;

import java.util.List;

import fr.eni.veterinaire.bo.Personnel;

public class PersonnelTestDAL {

	public static void main(String[] args) {

			PersonnelDAO personnelDAO = FactoryDAO.getPersonnelDAO();
			
			//création des personnels
			Personnel perso1 = new Personnel("Nom1", "MdP1","Adm", false);
			Personnel perso2 = new Personnel("Nom2", "MdP2","sec", false);
			Personnel perso3 = new Personnel("Nom3", "MdP3","vet", true);
			
			try{
				personnelDAO.insert(perso1);
				personnelDAO.insert(perso2);
				personnelDAO.insert(perso3);
				
//				Sélection de l'article par id
				System.out.println("Personnel test  : " + perso1.getNom() );
				Personnel p = personnelDAO.selectById(1);
				System.out.println("\n Sélection du personnel par son codeperso  : " + p.toString() );
				System.out.println("---------------------------------------------------------------");

//				//Sélection de tous les articles
				List<Personnel> personnels = personnelDAO.selectAll();
				System.out.println("\nSélection de tout le personnel  : "  );
				afficherPersonnels(personnels);
				System.out.println("---------------------------------------------------------------");

//				//Modification d'un article
				System.out.println("\n Modification d'un personnel  : " );
				System.out.println("Personnel avant modification : "  + perso1.toString());
				perso1.setNom("ChangeNom");
				perso1.setMotDePasse("123456");
				perso1.setRole("vet");
				perso1.setArchive(true);
				personnelDAO.update(perso1);
				System.out.println("Article après modification  : " + perso1.toString() );
				System.out.println("---------------------------------------------------------------");

//				//Suppression d'un article
				System.out.println("\nSuppression du personnel  : " + perso1.toString());
				personnelDAO.delete(perso1.getCodePersonnel());
				personnels = personnelDAO.selectAll();
				System.out.println("Liste du personnel après suppression : "  );
				afficherPersonnels(personnels);
				System.out.println("---------------------------------------------------------------");
	//
				} 
			catch (Exception e) {
		e.printStackTrace();
		}

	}

	private static void afficherPersonnels(List<Personnel> personnels){
		StringBuffer sb = new StringBuffer();
		for(Personnel pers: personnels){
			sb.append(pers.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	
}
