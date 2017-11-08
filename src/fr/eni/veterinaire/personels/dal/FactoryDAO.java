// codé par kcc
// version 1
// permet de définir le lien entre SQL et JAVA

package fr.eni.veterinaire.personels.dal;

import fr.eni.veterinaire.personels.dal.jdbc.*;

public class FactoryDAO {

	public static PersonnelDAO getPersonnelDAO(){

		return new PersonnelDAOJdbcImpl(); // lien JDBC
//		return new PersonnelDAOSerializationImpl(); // lien sérialisation non utilisé
	}
	

}