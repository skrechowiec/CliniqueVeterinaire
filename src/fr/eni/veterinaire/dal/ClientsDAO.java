package fr.eni.veterinaire.dal;

import java.util.List;

import fr.eni.veterinaire.bo.Clients;

public interface ClientsDAO {

	public abstract void  update(Clients clients) throws DALException ;

	public abstract List<Clients> selectAll() throws DALException ;
	
	public abstract Clients selectById(Integer Idarticle) throws DALException ;
		
	public abstract void insert(Clients c1) throws DALException ;
		
	public abstract void  delete(int codeclients) throws DALException ;
		
}	
