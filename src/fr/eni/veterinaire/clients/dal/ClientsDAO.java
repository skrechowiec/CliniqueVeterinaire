package fr.eni.veterinaire.clients.dal;

import java.util.List;

import fr.eni.veterinaire.clients.bo.Clients;

public interface ClientsDAO {

	public abstract void  update(Clients clients) throws DALException ;

	public abstract List<Clients> selectAll() throws DALException ;
	
	public abstract Clients selectById(Integer Idarticle) throws DALException ;
		
	public abstract void insert(Clients c1) throws DALException ;
		
	public abstract void  delete(int codeclients) throws DALException ;
		
}	
