package fr.eni.veterinaire.dal;

//import fr.eni.veterinaire.dal.jdbc.PersonnelDAOJdbcImpl;
import fr.eni.veterinaire.dal.jdbc.*;

public class FactoryDAO {

	public static PersonnelDAO getPersonnelDAO(){

		return new PersonnelDAOJdbcImpl();
//		return new PersonnelDAOSerializationImpl();
	}
	
	public static ClientsDAO getClientsDAO(){
		return new ClientsDAOJdbcImpl();
	}

}