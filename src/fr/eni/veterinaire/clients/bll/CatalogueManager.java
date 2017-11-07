package fr.eni.veterinaire.clients.bll;


	import java.util.ArrayList;
	import java.util.List;

	import fr.eni.veterinaire.clients.bo.Clients;
	import fr.eni.veterinaire.clients.dal.ClientsDAO;
	import fr.eni.veterinaire.clients.dal.DALException;
	import fr.eni.veterinaire.clients.dal.FactoryDAO;

	public class CatalogueManager {
		
	//instantiation de CatalogueManager
		private static CatalogueManager instance;
		public static CatalogueManager getInstance(){
			if (instance == null){
				instance = new CatalogueManager();
			}
			return instance;
		}
		
	//création d'un catalogue avec des clients
		private ClientsDAO ClientsDAO = FactoryDAO.getClientsDAO();
		private List<Clients> catalogue = new ArrayList<>();
		private static boolean validation = true;

		private CatalogueManager(){ 
			try {
				catalogue= ClientsDAO.selectAll();
			} catch (DALException e) {
				e.printStackTrace();
			}
		}
		
	//sélection d'un client 
		public Clients selectionUnClient(int indexClients) throws BLLException {
			System.out.println("-----------------");
			System.out.println(indexClients - 1);
			System.out.println(catalogue.get(indexClients - 1));
			System.out.println("-----------------");
			System.out.println(indexClients);
			System.out.println(catalogue.get(indexClients));
			System.out.println("-----------------");
			System.out.println(indexClients +1 );
			System.out.println(catalogue.get(indexClients + 1));
			System.out.println("-----------------");

			return catalogue.get(indexClients) ;
		}

	//ajouter un client 	
		public  void ajouterClient(Clients clientAAjouter) throws BLLException {
			try {

				if (validationClient(clientAAjouter)){
					ClientsDAO.insert(clientAAjouter);
				}} catch (DALException e) {
					throw new BLLException("Erreur d'insertion", e);
				}
			try{
				catalogue = ClientsDAO.selectAll();
			}
			catch (DALException e) {
				throw new BLLException("Erreur de création de catalogue", e);
			}
		}
	
	//modifier un client
		public void modifierUnClient(Clients clientAModifier) throws BLLException {
			try {
				if (validationClient(clientAModifier)){
					ClientsDAO.update(clientAModifier);
				}
			} catch (DALException e) {
				throw new BLLException("Erreur de modification", e);
			}
			try{
				catalogue = ClientsDAO.selectAll();
			}
			catch (DALException e) {
				throw new BLLException("Erreur de création de catalogue", e);
			}
		}

	//supprimer un client	
		public void supprimerUnClient(int indexClientASupprimer) throws BLLException {
			try {
				ClientsDAO.delete(indexClientASupprimer);
			} catch (DALException e){
				throw new BLLException("Erreur de suppression", e);
			}
			try{
				catalogue = ClientsDAO.selectAll();
			}
			catch (DALException e) {
				throw new BLLException("Erreur de création de catalogue", e);
			}
		}
	
	//validation de client
		public boolean validationClient(Clients client) throws BLLException {
			if (client.getClient()== null || client.getClient().trim().length() == 0){
				System.out.println("Le nom est obligatoire");
				validation = false;
			}	
			if (client.getPrenomClient()== null || client.getPrenomClient().trim().length() == 0){
				System.out.println("Le prénom est obligatoire");
				validation = false;
			}
			if (client.getAdresse1()== null || client.getAdresse1().trim().length() == 0){
				System.out.println("L'adresse est obligatoire");
				validation = false;
			}
			if (client.getCodePostal()== null || client.getCodePostal().trim().length() == 0){
				System.out.println("Le code postal est obligatoire");
				validation = false;
			}
			if (client.getVille()== null || client.getVille().trim().length() == 0){
				System.out.println("La ville est obligatoire");
				validation = false;
			}
			if (client.getNumTel()== null || client.getNumTel().trim().length() == 0){
				System.out.println("Le numéro de téléphone est obligatoire");
				validation = false;
			}
		return validation;
		}
		
	//getter-setter
		public ClientsDAO getClientsDAO() {
			return ClientsDAO;
		}
		public void setClientsDAO(ClientsDAO ClientsDAO) {
			ClientsDAO = ClientsDAO;
		}

		public List<Clients> getCatalogue() {
			return catalogue;
		}
		public void setCatalogue(List<Clients> catalogue) {
			catalogue = catalogue;
		}

	//toString
		@Override
		public String toString() {
			return "CatalogueManager [ClientsDAO=" + ClientsDAO + ", catalogue=" + catalogue + "]";
		}
	}


