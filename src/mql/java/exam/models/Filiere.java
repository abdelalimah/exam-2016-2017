package mql.java.exam.models;

import java.util.Vector;

import util.Helper;

public class Filiere {
	
	private String nom;
	private Vector<Semestre> semestres;
	
	public Filiere(String nom,Vector<Semestre> semestres) {
		
		this.nom = nom;
		this.semestres = semestres;
	
	}
	
	public String getNom() {
		return nom;
	}
	
	public Semestre[] getSemestres() {
		
		Semestre[] tableauSemestres = Helper.convertVectorToArray(this.semestres);
		return tableauSemestres;
	
	}

}
