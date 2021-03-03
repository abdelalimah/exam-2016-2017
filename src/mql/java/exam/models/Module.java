package mql.java.exam.models;

import java.util.Hashtable;

public class Module {
	
	private int id;
	private String nom;
	private Hashtable<String,Note[]> notesEtudiant;
	private String nomProfesseur;
	private int nombreNotes;
	
	public Module(int id ,String nom,Hashtable<String,Note[]> notesEtudiant,String nomProfesseur,int nombreNotes) {
			
		this.id = id;
		this.notesEtudiant = notesEtudiant;
		this.nomProfesseur = nomProfesseur;
		this.nombreNotes = nombreNotes;
		this.nom = nom;
	
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomProfesseur() {
		return nomProfesseur;
	}

	public void setNomProfesseur(String nomProfesseur) {
		this.nomProfesseur = nomProfesseur;
	}

	public int getNombreNotes() {
		return nombreNotes;
	}

	public void setNombreNotes(int nombreNotes) {
		this.nombreNotes = nombreNotes; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hashtable<String, Note[]> getNotesEtudiant() {
		return notesEtudiant;
	}
	
	@Override
	public String toString() {
		System.out.println("Le module est : "+this.nom);
		System.out.println("Le nom du prof : "+this.nomProfesseur);
		System.out.println("Note list : ");
			System.out.println("-------------");
			this.getNotesEtudiant().forEach((cne,notes) -> {
				System.out.println(" notes de l'etudiant numero : "+cne);
				for (Note note : notes) {
					System.out.println(" la note : "+note + " la coefficient est : "+note.getCoefficient());
				}
			});
		System.out.println("-------------");
		return null;
	}
}
