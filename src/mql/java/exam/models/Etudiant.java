package mql.java.exam.models;

public class Etudiant {
	
	private int code;
	private String cne;
	private String nom;
	private String prenom;
	
	public Etudiant(int code,String cne,String nom,String prenom) {
		
		this.code = code;
		this.cne = cne;
		this.nom = nom;
		this.prenom = prenom;
	
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
}
