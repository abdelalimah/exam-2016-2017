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

	public String getCne() {
		return cne;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

}
