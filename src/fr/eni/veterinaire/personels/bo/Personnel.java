// codé par kcc 
// version 1
// défini la class personnel pour les utilisateurs

package fr.eni.veterinaire.personels.bo;

public class Personnel { //class personnel

	//attributs
	private int CodePersonnel;
	private String Nom;
	private String MotDePasse;
	private String Metier;
	private boolean Archive;

	// constructeurs
	public Personnel (){ //

	}
	public Personnel(String nom, String motDePasse, String metier, boolean archive) {
		super();
		Nom = nom;
		MotDePasse = motDePasse;
		Metier = metier;
		Archive = archive;
	}
	
	public Personnel(int codePersonnel, String nom, String motDePasse, String metier, boolean archive) {
		super();
		CodePersonnel = codePersonnel;
		Nom = nom;
		MotDePasse = motDePasse;
		Metier = metier;
		Archive = archive;
	}
	

	//getters et setters
	public int getCodePersonnel() {
		return CodePersonnel;
	}
	public void setCodePersonnel(int codePersonnel) {
		CodePersonnel = codePersonnel;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getMotDePasse() {
		return MotDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}
	public String getMetier() {
		return Metier;
	}
	public void setMetier(String metier) {
		Metier = metier;
	}
	public boolean isArchive() {
		return Archive;
	}
	public void setArchive(boolean archive) {
		Archive = archive;
	}

	//to_string
	@Override
	public String toString() {
		return "Personnel [CodePersonnel=" + CodePersonnel + ", Nom=" + Nom + ", MotDePasse=" 
				+ MotDePasse + ", Metier= "+ Metier + ", Archive=" + Archive + "]";
	}


}
