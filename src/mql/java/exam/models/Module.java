package mql.java.exam.models;

public class Module {
	
	private String nom;
	private Note[] notes;
	private String nomProf;
	private int nombreNotes;
	private int[] coefficients;
	
	public Module(String nom,Note[] notes,String nomProf,int nombreNotes) {
			
		this.notes = notes;
		this.nomProf = nomProf;
		this.nombreNotes = nombreNotes;
		this.coefficients = new int[nombreNotes];
		this.nom = nom;
	
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Note[] getNotes() {
		return notes;
	}

	public void setNotes(Note[] notes) {
		this.notes = notes;
	}

	public String getNomProf() {
		return nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public int getNombreNotes() {
		return nombreNotes;
	}

	public void setNombreNotes(int nombreNotes) {
		this.nombreNotes = nombreNotes;
	}

	public int[] getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(int[] coefficients) {
		this.coefficients = coefficients;
	}
	
	
	
}
