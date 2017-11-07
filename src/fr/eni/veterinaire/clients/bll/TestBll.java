package fr.eni.veterinaire.clients.bll;

	
	import java.util.List;

import fr.eni.veterinaire.clients.bo.Clients;

	public class TestBll {

		public static void main(String[] args) {

		CatalogueManager catalogueManager = CatalogueManager.getInstance();
		//Instanciation du jeu d'essai 
		Clients c1 = new Clients ( "Suveges", "Judit", "Quelque part", "Quelque part2","44000", "Nantes", "0723334662" ,"Carte Vitale", "gmail@gmail.com", "rien", true);
		Clients c2 = new Clients ( "Furge", "Rokalab", "Erdo", "Odu"	,"1092", "Mucsarocsoge", "0612158094" ,"TB", "yahoo@yahoo.com", "no comment", false);
		Clients c3 = new Clients ( "MyLittle", "Pony", "Dreamland", "Alomfold","20455", "Tapioszecso", "09205308911" ,"Securité", "freemail@gmail.com", "tout va bien", true);


			System.out.println("Ajout des clients... ");
			//Ajouter un client
			try {
				System.out.println("test client ajouté  : " + c1.toString() );

				catalogueManager.ajouterClient(c1);
				System.out.println("Client ajouté  : " + c1.toString() );
				catalogueManager.ajouterClient(c2);
				System.out.println("Client ajouté  : " + c2.toString() );
				catalogueManager.ajouterClient(c3);
				System.out.println("Client ajouté  : " + c3.toString() );
				
			//Modification d'un client
				System.out.println("\nModification d'un client  : " );
				System.out.println("Client avant modification : "  + c1.toString());
				(c1).setVille("Budapest");
				(c1).setPrenomClient("Lilla");
				(c1).setCodePostal("20550");
				catalogueManager.modifierUnClient(c1);
				System.out.println("Client après modification  : " + c1.toString() );

			//selection d'un client
				System.out.println(catalogueManager.selectionUnClient(2));

			//Suppression d'un client
				System.out.println("\nSuppression du client  : " + c1.toString());
				catalogueManager.supprimerUnClient(c1.getCodeClient());
				System.out.println("Liste des clients après suppression : "  );
				System.out.println(catalogueManager.getCatalogue());
				System.out.println("---------------------------------------------------------------");

			}catch (Exception e) {
				e.printStackTrace();
			
	}
	}
	}
