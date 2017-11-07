package fr.eni.veterinaire.bo;

import java.util.ArrayList;
import java.util.List;


public class ClientsTestBO {

	public static void main(String[] args) {
		List<Clients> clients=null;
		try {
			//Constituer une liste d'articles
			clients = new ArrayList<Clients>();
			
	        //********************************
	        // tester la gestion des articles
	        //********************************
			
			Clients client = new Clients(1, "Suveges", "Judit", "Quelque part", "Quelque part2"	,"44000", "Nantes", "0723334662" ,"Carte Vitale", "gmail@gmail.com", "rien", true);
			System.out.println("\nREM : Affichage d'un client");
			System.out.println(client.toString());
			System.out.println("---------------------------------------------------------------");
						
			// Ajout des articles Ã  la liste. 
//			clients.add(client);
//						
//			clients.add(new Clients(1, "Suveges", "Judit", "Quelque part", "Quelque part2", 
//			"44000", "Nantes", "0723334662" ,"Carte Vitale", "gmail@gmail.com", "rien", "vrai");
			
			
			System.out.println("\nREM : Affichage du catalogue");
			//on affiche la liste des clients
			afficherCatalogue(clients);
			System.out.println("---------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	private static void afficherCatalogue(List<Clients> clients) {
		for (Clients client : clients) {
			System.out.println(clients.toString());
		}
		
	}

}
