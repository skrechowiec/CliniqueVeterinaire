// codé par kcc
// version 1
// permet la liaison entre l'IHM et la BLL

package fr.eni.veterinaire.personels.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.veterinaire.personels.dal.PersonnelDAO;
import fr.eni.veterinaire.personels.bo.Personnel;
import fr.eni.veterinaire.personels.dal.DALException;
import fr.eni.veterinaire.personels.dal.FactoryDAO;

public class PersonnelManager {

	private static PersonnelManager instance;

	public static PersonnelManager getInstance(){
		if (instance == null){
			instance = new PersonnelManager();
		}
		return instance;
	}

	private List<Personnel> listeDuPersonnel = new ArrayList<>();
	private static boolean validation = true;
	private PersonnelDAO personnelDAO = FactoryDAO.getPersonnelDAO();

	//Selection du personnel
	public List<Personnel> listeDuPersonnel(){ 
  		try {
  			listeDuPersonnel= personnelDAO.selectAll();
  		} catch (DALException e) {
 			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
 		return listeDuPersonnel;
  	}
	//Selection d'un personnel
	public Personnel selectionUnPersonnel(int codePerso) throws BLLException {
//		System.out.println("***************");
//		System.out.println(codePerso - 1);
//		System.out.println(listeDuPersonnel.get(codePerso - 2));
//		System.out.println("***************");
//		System.out.println(codePerso);
//		System.out.println(listeDuPersonnel.get(codePerso -1));
//		System.out.println("***************");
//		System.out.println(codePerso +1 );
//		System.out.println(listeDuPersonnel.get(codePerso));
//		System.out.println("***************");

		return listeDuPersonnel.get(codePerso -1) ;
	}

	
	
	//ajouter un personnel
	public  void ajouterPersonnel(Personnel personnelAAjouter) throws BLLException {
		try {

			if (validationPersonnel(personnelAAjouter)){
				personnelDAO.insert(personnelAAjouter);
			}} catch (DALException e) {
				throw new BLLException("Erreur d'insertion", e);
			}
		try{
			listeDuPersonnel = personnelDAO.selectAll();
		}
		catch (DALException e) {
			throw new BLLException("Erreur de création de catalogue", e);
		}
	}

	public void modifierUnPersonnel(Personnel personnelAModifier) throws BLLException {
		try {
			if (validationPersonnel(personnelAModifier)){
				personnelDAO.update(personnelAModifier);
			}
		} catch (DALException e) {
			throw new BLLException("Erreur de modification", e);
		}
		try{
			listeDuPersonnel = personnelDAO.selectAll();
		}
		catch (DALException e) {
			throw new BLLException("Erreur de création de catalogue", e);
		}
	}

	//supprimer un article
	public void supprimerUnPersonnel(int codePersoDuPersonnelASupprimer) throws BLLException {
		try {
			personnelDAO.delete(codePersoDuPersonnelASupprimer);
		} catch (DALException e){
			throw new BLLException("Erreur de suppression", e);
		}
		try{
			listeDuPersonnel = personnelDAO.selectAll();
		}
		catch (DALException e) {
			throw new BLLException("Erreur de création de catalogue", e);
		}
	}

	public void supprimerUnPersonnelParLeNom(String nomDuPersonnelASupprimer) throws BLLException {
		try {
			personnelDAO.deleteParLeNom(nomDuPersonnelASupprimer);
		} catch (DALException e){
			throw new BLLException("Erreur de suppression", e);
		}
		try{
			listeDuPersonnel = personnelDAO.selectAll();
		}
		catch (DALException e) {
			throw new BLLException("Erreur de création de catalogue", e);
		}
	}

	
	public boolean validationPersonnel(Personnel personnel) throws BLLException {
		if (personnel.getNom()== null || personnel.getNom().trim().length() == 0){
			System.out.println("Le nom est obligatoire");
			validation = false;
		}
		if (personnel.getMotDePasse()== null || personnel.getMotDePasse().trim().length() == 0){
			System.out.println("Le mot de passe est obligatoire");
			validation = false;
		}
		if (personnel.getMetier()== null || personnel.getMetier().trim().length() == 0){
			System.out.println("Le métier est obligatoire");
			validation = false;
		}

		return validation;
	}

	public PersonnelDAO getPersonnelDAO() {
		return personnelDAO;
	}

//	public void setArticleDAO(PersonnelDAO personnelDAO) {
//		personnelDAO = personnelDAO;
//	}

	public List<Personnel> getlisteDuPersonnel() {
		return listeDuPersonnel;
	}

//	public void setlisteDuPersonnel(List<Personnel> getlisteDuPersonnel) {
//		listeDuPersonnel = listeDuPersonnel;
//	}

	@Override
	public String toString() {
		return "CatalogueManager [personnelDAO=" + personnelDAO + ", Liste du personnel=" + listeDuPersonnel + "]";
	}



}

