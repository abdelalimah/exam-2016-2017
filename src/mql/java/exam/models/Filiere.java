package mql.java.exam.models;

public class Filiere {
	
	private String nom;
	private Semestre[] semestres;
	
	public Filiere(String nom,Semestre[] semestres) {
		
		this.nom = nom;
		this.semestres = semestres;
	
	}
	
	public String getNom() {
		return nom;
	}
	
	public Semestre[] getSemestres() {
		return semestres;
	}

}
