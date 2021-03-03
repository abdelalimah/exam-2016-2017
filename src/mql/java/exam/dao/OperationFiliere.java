package mql.java.exam.dao;
import java.util.Vector;

import mql.java.exam.models.Etudiant;
import mql.java.exam.models.Filiere;
import mql.java.exam.models.Note;
import mql.java.exam.models.Semestre;
import util.Helper;
import mql.java.exam.models.Module;

public class OperationFiliere {
	
	Filiere filiere;
	
	public OperationFiliere(String nomFiliere) {
		
		this.filiere = new FileParser(nomFiliere).getFiliere();
		notes();
	}
	
	public Semestre[] semestres() {
		
		return this.filiere.getSemestres();
		
	}
	
	public Etudiant[] etudiants() {
		
		Vector<Etudiant> etudiants = new Vector<>();
		for (Semestre semestre : this.filiere.getSemestres()) {
			for (Etudiant etudiant : semestre.getEtudiants()) {
				etudiants.add(etudiant);
			}
		}
		
		return Helper.convertVectorToArray(etudiants);
		
	}
	
	public Module[] modules() {
		
		Vector<Module> modules = new Vector<>();
		for (Semestre semestre : this.filiere.getSemestres()) {
			for (Module module : semestre.getModules()) {
				modules.add(module);
			}
		}
		
		return Helper.convertVectorToArray(modules);
		
	}
	
	public Note[] notes() {
		
		Vector<Note> notes = new Vector<>();
		for (Semestre semestre : this.filiere.getSemestres()) {
			for (Module module : semestre.getModules()) {
				module.getNotesEtudiant().forEach((cne,listeNotes) -> {
					for (Note note : listeNotes) {
						notes.add(note);
					}
				});
			}
		}
		
		return Helper.convertVectorToArray(notes);
	
	}
	
	public static void main(String[] args) {
		new OperationFiliere("SMI");
	}
	
	public Filiere getFiliere() {
		return filiere;
	}
}
