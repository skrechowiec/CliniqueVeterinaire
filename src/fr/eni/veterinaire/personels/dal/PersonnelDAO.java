// codé par kcc
// version 1
// permet d'effectuer la liaison entre PersonnelDAOJdbcImpl et PersonnelTestDAL;

package fr.eni.veterinaire.personels.dal;

import java.util.List;

import fr.eni.veterinaire.personels.bo.Personnel;

public interface PersonnelDAO {
	
	public abstract void  update(Personnel personnel) throws DALException ;

	public abstract List<Personnel> selectAll() throws DALException ;
	
	public abstract Personnel selectById(Integer codePers) throws DALException ;
		
	public abstract void insert(Personnel personnel) throws DALException ;
		
	public abstract void  delete(int codePers) throws DALException ;

	public abstract void  deleteParLeNom(String nom) throws DALException ;

	public abstract void  deleteArchive(int codePers) throws DALException ;
	
}
