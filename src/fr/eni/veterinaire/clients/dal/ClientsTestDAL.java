package fr.eni.veterinaire.clients.dal;

import java.util.List;

import fr.eni.veterinaire.clients.bo.Clients;
import fr.eni.veterinaire.clients.dal.ClientsDAO;
import fr.eni.veterinaire.clients.dal.FactoryDAO;

public class ClientsTestDAL {
	
	public static void main(String[] args) {

		//Déclaration et instanciation de la DAO
		ClientsDAO clientsDAO =  FactoryDAO.getClientsDAO();

		//Instanciation du jeu d'essai 
		Clients c1 = new Clients ( "Suveges", "Judit", "Quelque part", "Quelque part2","44000", "Nantes", "0723334662" ,"Carte Vitale", "gmail@gmail.com", "rien", true);
		Clients c2 = new Clients ( "Furge", "Rokalab", "Erdo", "Odu"	,"1092", "Mucsarocsoge", "0612158094" ,"TB", "yahoo@yahoo.com", "no comment", false);
		Clients c3 = new Clients ( "MyLittle", "Pony", "Dreamland", "Alomfold","20455", "Tapioszecso", "09205308911" ,"Securité", "freemail@gmail.com", "tout va bien", true);
		
		System.out.println("Ajout des clients... ");
		
		try {
			//Ajouter un client
			clientsDAO.insert(c1);
			System.out.println("Client ajouté  : " + c1.toString() );
			clientsDAO.insert(c2);
			System.out.println("Client ajouté  : " + c2.toString() );
			clientsDAO.insert(c3);
			System.out.println("Client ajouté  : " + c3.toString() );
			
			
			//Sélection du client par id
			System.out.println("Client test  : " + c3.toString() );
			Clients c = clientsDAO.selectById(1);
			System.out.println("\nSélection du client par id  : " + c.toString() );

			//Sélection de tous les clients
			List<Clients> clients = clientsDAO.selectAll();
			System.out.println("\nSélection de tous les clients  : "  );
			afficherClients(clients);

			//Modification d'un client
			System.out.println("\nModification d'un client  : " );
			System.out.println("Client avant modification : "  + c1.toString());
			((Clients) c1).setVille("Budapest");
			((Clients) c1).setAdresse2("bille noir");
			((Clients) c1).setClient("Singe");
			clientsDAO.update(c1);
			System.out.println("Client après modification  : " + c1.toString() );
			
			//Suppression d'un client
			System.out.println("\nSuppression du client  : " + c1.toString());
			clientsDAO.delete(c1.getCodeClient());
			clients = clientsDAO.selectAll();
			System.out.println("Liste des clients après suppression : "  );
			afficherClients(clients);
			System.out.println("---------------------------------------------------------------");

			
		}catch (DALException e) {
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	//Affichage des clients
	private static void afficherClients(List<Clients> clients){
		StringBuffer sb = new StringBuffer();
		for(Clients art: clients){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}



