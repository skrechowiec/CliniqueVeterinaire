package fr.eni.veterinaire.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.veterinaire.bo.Personnel;
import fr.eni.veterinaire.dal.DALException;
import fr.eni.veterinaire.dal.PersonnelDAO;
import fr.eni.veterinaire.dal.jdbc.JdbcTools;

public class PersonnelDAOJdbcImpl implements PersonnelDAO{

	//création des requetes
	public static final String requeteUpdate = " update Personels set nom = ?, MotPasse=?," +
			" Metiers =? , Archive = ? where CodePers = ? ";
	public static final String requeteSelectAll = " select CodePers, Nom, MotPasse, Metiers, " + 
			" Archive from Personels ";
	public static final String requeteSelectById = " select CodePers, Nom, MotPasse, Metiers, " +
			" Archive from Personels where Codepers  = ? ";
	public static final String requeteInsert = "insert into Personels(Nom, MotPasse, Metiers, " +
			" Archive) values ( ?,?,?,?)";
	public static final String requeteDelete = " delete from  Personels where CodePers = ? ";

	public Connection connexion = null;

	//fermeture de la connexion
	private void closeConnection() throws SQLException{
		if(connexion!=null){
			connexion.close() ;
		}
	}

	//methode pour modifier un personnel
	public void  update(Personnel personnel) throws DALException {

		PreparedStatement declaration = null;

		try {
			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteUpdate) ;
			declaration.setString(1, personnel.getNom());
			declaration.setString(2, personnel.getMotDePasse());
			declaration.setString(3, personnel.getRole());
			declaration.setBoolean(4, personnel.isArchive());
			declaration.setInt(5, personnel.getCodePersonnel());

			declaration .executeUpdate();

		}
		catch (SQLException e) 
		{
			throw new DALException("erreur d'update", e); 
		}
		finally 
		{
			try {
				closeConnection();
			} catch (SQLException e) {
				throw new DALException("erreur de déconnexion", e); 
			}
		} 
	}

	//selection pour la liste complete du personnel
	public List<Personnel> selectAll()  throws DALException {

		Connection connexion = null;
		PreparedStatement declaration = null;
		ResultSet resultat = null;
		Personnel resultatRequete = null;
		List<Personnel> listeDesPersonnels= new ArrayList<Personnel>();

		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteSelectAll);

			resultat = declaration.executeQuery();

			while (resultat.next()){
				resultatRequete = new Personnel(resultat.getInt("codePers"), resultat.getString("Nom"), resultat.getString("MotPasse"), resultat.getString ("Metiers"), resultat.getBoolean("Archive")); 
				listeDesPersonnels.add(resultatRequete);
			} 

		}
		catch (SQLException e) 
		{
			throw new DALException("erreur de select all typ", e); 
		}
		finally 
		{
			try {	
				if (connexion != null){
					connexion.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		} 

		return listeDesPersonnels;
	}

	//selection d'un personnel
	public Personnel selectById(Integer codePers){
		Connection connexion = null;
		PreparedStatement declaration = null;
		ResultSet resultat = null;
		Personnel resultatRequete = null;
		
		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteSelectById);
			declaration.setInt(1, codePers);

			resultat = declaration.executeQuery();
			
			resultat.next();
			resultatRequete = new Personnel(resultat.getInt("codePers"), resultat.getString("Nom"), resultat.getString("MotPasse"), resultat.getString ("Metiers"), resultat.getBoolean("Archive")); 
			
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {	
				if (connexion != null){
					connexion.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		} 

		return 	resultatRequete;
	}

	//insert d'un personnel
	public void insert(Personnel p1){
		Connection connexion = null;
		PreparedStatement declaration = null;

		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteInsert, Statement.RETURN_GENERATED_KEYS);
			declaration.setString(1, p1.getNom());
			declaration.setString(2, p1.getMotDePasse());
			declaration.setString(3, p1.getRole());
			declaration.setBoolean(4, p1.isArchive());

			int nbRows = declaration.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = declaration.getGeneratedKeys();
				if (rs.next()) {
					p1.setCodePersonnel(rs.getInt(1));
				}

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			try {	
				if (connexion != null){
					connexion.close();
				}
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		} 	
	}
	
	//suppression d'un personnel
	public void  delete(int codePers){

		Connection connexion = null;
		PreparedStatement declaration = null;

		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteDelete);
			declaration.setInt(1, codePers);

			declaration .executeUpdate();

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {	
				if (connexion != null){
					connexion.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}

}
