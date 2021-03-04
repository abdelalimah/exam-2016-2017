package mql.java.exam.models;

import java.util.Hashtable;
import java.util.Vector;

public class Module {
	
	private int id;
	private String nom;
	private Hashtable<String,Vector<Note>> notesEtudiant;
	private String nomProfesseur;
	private int nombreNotes;
	
	public Module(int id ,String nom,Hashtable<String,Vector<Note>> notesEtudiant,String nomProfesseur,int nombreNotes) {
			
		this.id = id;
		this.notesEtudiant = notesEtudiant;
		this.nomProfesseur = nomProfesseur;
		this.nombreNotes = nombreNotes;
		this.nom = nom;
	
	}

	public String getNom() {
		return nom;
	}

	public String getNomProfesseur() {
		return nomProfesseur;
	}

	public int getNombreNotes() {
		return nombreNotes;
	}

	public int getId() {
		return id;
	}

	public Hashtable<String, Vector<Note>> getNotesEtudiant() {
		return notesEtudiant;
	}
	
}
