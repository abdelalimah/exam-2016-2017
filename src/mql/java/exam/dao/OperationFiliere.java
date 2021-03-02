package mql.java.exam.dao;
import java.util.Vector;

import mql.java.exam.models.Etudiant;
import mql.java.exam.models.Filiere;
import mql.java.exam.models.Note;
import mql.java.exam.models.Semestre;
import mql.java.exam.models.Module;

public class OperationFiliere {
	
	private Filiere filiere;
	private Semestre[] semestresFiliere;
	private FileComposer fileComposer;
	private FileParser fileParser;
	
	
	public OperationFiliere(Filiere filiere) {
		//this.filiere = filiere;
		//this.filiere = new parseFile("").getFiliere();
		this.semestresFiliere = this.filiere.getSemestres();
	}
	
	public Etudiant[] etudiants() {
		
		Vector<Etudiant> etudiants = new Vector<Etudiant>();
		for (Semestre semestre : semestresFiliere) {
			for (Etudiant etudiant : semestre.getEtudiants()) {
				etudiants.add(etudiant);
			}
		}
		
		Etudiant[] etudiantsFiliere = new Etudiant[etudiants.size()]; 
		etudiants.toArray(etudiantsFiliere);
		
		return etudiantsFiliere;
	}
	
	public Semestre[] semestres() {
		return filiere.getSemestres();
	}
	
	public Module[] modules() {
		
		Vector<Module> modules = new Vector<Module>();
		for (Semestre semestre : semestresFiliere) {
			for (Module module : semestre.getModules()) {
				modules.add(module);
			}
		}
		
		Module[] modulesSemestre = new Module[modules.size()]; 
		modules.toArray(modulesSemestre);
		
		return modulesSemestre;
	
	}
	
	public Note[] notes() {
		
		Vector<Note> notes = new Vector<Note>();
		for (Semestre semestre : semestresFiliere) {
			for (Module module : semestre.getModules()) {
				for (Note note : module.getNotes()) {
					notes.add(note);
				}
			}
		}
		
		Note[] noteFiliere = new Note[notes.size()];
		notes.toArray(noteFiliere);
		
		return noteFiliere;

	}
	
	public void ajouterEtudiants(Etudiant[] etudiants) {
		fileComposer.ajouterEtudiants(etudiants);
	}
	
	public void ajouterSemestres(Semestre[] semestres) {
		fileComposer.ajouterSemestres(semestres);
	}

				String value= "";
				while((value = br.readLine()) != null){
					System.out.println(value);
	
	public void ajouterModules(Module[] modules) {
		fileComposer.ajouterModules(modules);
	}
	
	public void ajouterNotes(Note[] notes) {
		fileComposer.ajouterNotes(notes);
	}

}
