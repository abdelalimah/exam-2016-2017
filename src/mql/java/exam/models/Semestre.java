package mql.java.exam.models;

public class Semestre {
	
	private String nom;
	private Etudiant[] etudiants;
	private Module[] modules;
	
	public Semestre(String nom,Etudiant[] etudiants,Module[] modules) {
		
		this.nom = nom;
		this.etudiants = etudiants;
		this.modules = modules;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Etudiant[] getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Etudiant[] etudiants) {
		this.etudiants = etudiants;
	}

	public Module[] getModules() {
		return modules;
	}
	
	public void setModules(Module[] modules) {
		this.modules = modules;
	}
	
	
}
