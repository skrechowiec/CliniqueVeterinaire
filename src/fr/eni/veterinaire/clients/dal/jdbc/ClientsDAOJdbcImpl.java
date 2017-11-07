package fr.eni.veterinaire.clients.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.veterinaire.clients.dal.ClientsDAO;
import fr.eni.veterinaire.clients.dal.DALException;
import fr.eni.veterinaire.clients.dal.jdbc.JdbcTools;
import fr.eni.veterinaire.clients.bo.Clients;


public class ClientsDAOJdbcImpl implements ClientsDAO {

	public static final String TYPE_CLIENT = "CLIENTS";
	public static final String requeteUpdate = " update Clients set CodeClient=?, Client =?,PrenomClient=?, Adresse1=?, Adresse2=?,CodePostal=?,Ville=?,NumTel=?,Assurance=?,Email=?,Remarque=?,Archive=?";
	public static final String requeteSelectAll = " select CodeClient, Client, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive from Clients ";
	public static final String requeteSelectById = " select CodeClient, Client, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive from Clients where CodeClient =? ";
	public static final String requeteInsert = "insert into Clients(Client, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive) values (?,?,?,?,?,?,?,?,?,?,?)";
	public static final String requeteDelete = " delete from  Clients where CodeClient = ? ";

	public Connection connexion = null;


	private void closeConnection() throws SQLException{
		if(connexion!=null){
			connexion.close() ;
		}
	}

	// update Clients
	public void  update(Clients clients) throws DALException {

		PreparedStatement declaration = null;

		try {
			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteUpdate) ;

			declaration.setString(1, clients.getClient());
			declaration.setString(2, clients.getPrenomClient());
			declaration.setString(3, clients.getAdresse1());
			declaration.setString(4, clients.getAdresse2());
			declaration.setString(5, clients.getCodePostal());
			declaration.setString(6, clients.getVille());
			declaration.setString(7, clients.getNumTel());
			declaration.setString(8, clients.getAssurance());
			declaration.setString(9, clients.getEmail());
			declaration.setString(10, clients.getRemarque());
			declaration.setBoolean(11, clients.isArchive());
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
	
	//Select * From Clients
	public List<Clients> selectAll()  throws DALException {

		Connection connexion = null;
		PreparedStatement declaration = null;
		ResultSet resultat = null;
		Clients resultatRequete = null;
		List<Clients> listeDesClients= new ArrayList<Clients>();

		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteSelectAll);

			resultat = declaration.executeQuery();

			while (resultat.next()){
				//erreur typ
				if ( TYPE_CLIENT.equalsIgnoreCase(resultat.getString("type").trim())){
					//		resultatRequete = new Clients(resultat.getInt("CodeClient"), resultat.getString("Client"), resultat.getString("PrenomClient"), resultat.getString ("Adresse1"), resultat.getString("Adresse2"), resultat.getString("CodePostal"), resultat.getString("Ville"), resultat.getString("NumTel"), resultat.getString("Assurance"), resultat.getString("Remarque"), resultat.getBoolean("Archive")); 
				}	
				listeDesClients.add((Clients)resultatRequete);
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

		return listeDesClients;
	}
	
	//Sélection des clients par CodeClient
	public Clients selectById(Integer CodeClient){
		Connection connexion = null;
		PreparedStatement declaration = null;
		ResultSet resultat = null;
		Clients resultatRequete = null;

		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteSelectById);
			declaration.setInt(1, CodeClient);

			resultat = declaration.executeQuery();

			resultat.next();


			resultatRequete = new Clients(resultat.getInt("CodeClient"), resultat.getString("Client"), resultat.getString("PrenomClient"), resultat.getString ("Adresse1"), resultat.getString("Adresse2"), resultat.getString("CodePostal"), resultat.getString("Ville"),resultat.getString("NumTel"),resultat.getString("Assurance"),resultat.getString("Email"),resultat.getString("Remarque"),resultat.getBoolean("Archive")); 

//			resultatRequete = new Client(resultat.getString("CodeClient"), resultat.getString("reference"), resultat.getString("marque"), resultat.getString ("designation"), resultat.getInt("prixUnitaire"), resultat.getInt("qteStock"), resultat.getString("couleur")); 


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

	//Insert into Client
	public void insert(Clients c1){
		Connection connexion = null;
		PreparedStatement declaration = null;

		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteInsert);
			declaration.setString(1, c1.getClient());
			declaration.setString(2, c1.getPrenomClient());
			declaration.setString(3, c1.getAdresse1());
			declaration.setString(4, c1.getAdresse2());
			declaration.setString(5, c1.getCodePostal());
			declaration.setString(6, c1.getVille());
			declaration.setString(7, c1.getNumTel());
			declaration.setString(8, c1.getAssurance());
			declaration.setString(9, c1.getEmail());
			declaration.setString(10, c1.getRemarque());
			declaration.setBoolean(11, c1.isArchive());

			declaration.executeUpdate();


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
	public void  delete(int CodeClient){

		Connection connexion = null;
		PreparedStatement declaration = null;

		try {

			connexion = JdbcTools.getConnection();

			declaration = connexion.prepareStatement(requeteDelete);
			declaration.setInt(1, CodeClient);

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