package fr.eni.veterinaire.clients.dal;

//import fr.eni.veterinaire.dal.jdbc.PersonnelDAOJdbcImpl;
import fr.eni.veterinaire.clients.dal.jdbc.*;

public class FactoryDAO {

	public static ClientsDAO getClientsDAO(){
		return new ClientsDAOJdbcImpl();
	}

}