// codé par kcc
// version 1
// permet l'utilisation de paramètres pour la connexion SQL 

package fr.eni.veterinaire.personels.dal.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.veterinaire.Settings;

public class JdbcTools {

	private static String urldb;
	private static String userdb;
	private static String passworddb;

	//bloc d'initialisation statique
	static {
		try {
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
	}
	
	public static Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
		
		return connection;
	}
	
}


