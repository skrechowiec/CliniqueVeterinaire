package fr.eni.veterinaire.personels.dal;

import fr.eni.veterinaire.personels.dal.jdbc.*;

public class FactoryDAO {

	public static PersonnelDAO getPersonnelDAO(){

		return new PersonnelDAOJdbcImpl();
//		return new PersonnelDAOSerializationImpl();
	}
	

}