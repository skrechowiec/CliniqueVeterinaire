package fr.eni.veterinaire.bo;

public class Personnel {

	//attributs
	private int CodePersonnel;
	private String Nom;
	private String MotDePasse;
	private String Role;
	private boolean Archive;

	// constructeurs
	public Personnel (){

	}
	public Personnel(String nom, String motDePasse, String role, boolean archive) {
		super();
		Nom = nom;
		MotDePasse = motDePasse;
		Role = role;
		Archive = archive;
	}
	
	public Personnel(int codePersonnel, String nom, String motDePasse, String role, boolean archive) {
		super();
		CodePersonnel = codePersonnel;
		Nom = nom;
		MotDePasse = motDePasse;
		Role = role;
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
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
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
		return "Personnel [CodePersonnel=" + CodePersonnel + ", Nom=" + Nom + ", MotDePasse=" + MotDePasse + ", Role="
				+ Role + ", Archive=" + Archive + "]";
	}


}
