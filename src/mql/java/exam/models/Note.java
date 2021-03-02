package mql.java.exam.models;

import java.util.List;

public class Note {
	
	private List<Double> notes;
	private int[] coefficient;
	private Etudiant etudiant;
	
	public Note(List<Double> notes,int[] coefficient,Etudiant etudiant) {
		this.notes = notes;
		this.coefficient = coefficient;
	}
	
	public List<Double> getNote() {
		return notes;
	}
	
	public int[] getCoefficient() {
		return coefficient;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

}
