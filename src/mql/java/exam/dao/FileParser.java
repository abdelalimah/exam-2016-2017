package mql.java.exam.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import mql.java.exam.models.Etudiant;
import mql.java.exam.models.Filiere;
import mql.java.exam.models.Module;
import mql.java.exam.models.Note;
import mql.java.exam.models.Semestre;

public class FileParser {

	private Filiere filiere;
	private Vector<Etudiant> etudiants;
	private Vector<Module> modules;
	private Vector<Semestre> semestres;

	public FileParser(String nomFiliere) {

		semestres = new Vector<Semestre>();

		String dossierFiliere = "resources/notes/" + nomFiliere;
		File file = new File(dossierFiliere);
		listFilesForFolders(file);
		semestres();

	}

	public void listFilesForFolders(File folder) {

		for (File file : folder.listFiles()) {
			
			if (file.isDirectory() && "Notes".equals(file.getName())) {
				modules = new Vector<Module>();
				parseNotes(file);
			}

			else if (file.isDirectory()) {

				listFilesForFolders(file);

			}

			else if ("Etudiants.txt".equals(file.getName())) {
				etudiants = new Vector<Etudiant>();
				parseEtudiant(file);
				
				String nomSemestre = file.getParentFile().getName();
				Etudiant[] tableauEtudiants = new Etudiant[this.etudiants.size()];
				Module[] tableauModules = new Module[this.modules.size()];
				this.etudiants.toArray(tableauEtudiants);
				this.modules.toArray(tableauModules);
				
				Semestre semestre = new Semestre(nomSemestre, tableauEtudiants, tableauModules);
				semestres.add(semestre);

			}

		}

	}
	

	private void parseEtudiant(File file) {
		try (FileReader fileReader = new FileReader(file); BufferedReader br = new BufferedReader(fileReader);) {

			String value = "";
			while ((value = br.readLine()) != null) {

				String[] informationsEtudiant = value.split("\t");

				int code = Integer.parseInt(informationsEtudiant[0]);
				String cne = informationsEtudiant[1];
				String nom = informationsEtudiant[2];
				String prenom = informationsEtudiant[3];
				Etudiant etudiant = new Etudiant(code, cne, nom, prenom);
				etudiants.add(etudiant);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void parseNotes(File file) {
		
		File[] files = file.listFiles();

		for (File module : files) {

			try (FileReader fileReader = new FileReader(module); BufferedReader br = new BufferedReader(fileReader);) {

				String nomProfesseur = br.readLine();
				int nombreNotes = Integer.parseInt(br.readLine());
				String[] informationsModule = module.getName().split("-");
				int idModule = Integer.parseInt(informationsModule[0]);
				String nomModule = informationsModule[1].substring(0,informationsModule[1].length() - 4);

				String[] coefficients = br.readLine().split(",");

				String value = "";
				Hashtable<String,Note[]> notesEtudiant = new Hashtable();
				while((value = br.readLine()) != null){
					Vector<Note> noteList = new Vector();

					String[] informationsNote = value.split(",");
					String cne = informationsNote[0];
					
					for (int i = 0; i <nombreNotes ; i++) {
						double noteEtudiant = Double.parseDouble(informationsNote[i+1]);
						Note note = new Note(noteEtudiant, Integer.parseInt(coefficients[i]));
						noteList.add(note);
					}
					
					Note[] tableauNotes = new Note[noteList.size()];
					noteList.toArray(tableauNotes);

					notesEtudiant.put(cne, tableauNotes);

				};

				modules.add(new Module(idModule,nomModule,notesEtudiant,nomProfesseur,nombreNotes));

			} catch (Exception e) {
				System.out.println(e.getMessage());
			};

		}


	}

	public static void main(String[] args) {
		new FileParser("SMA");
	}

	public Etudiant trouverEtudiant(String cne) {
		for (int i = 0; i < etudiants.size(); i++) {

			if (cne.equals(etudiants.get(i).getCne())) {
				return etudiants.get(i);
			}

		}
		return null;
	}

	// public void notes() {
	// for (Note note : notes) {
	// Etudiant etudiant = note.getEtudiant();
	// System.out.println(etudiant.getCode());
	// System.out.println(etudiant.getNom());
	// }
	// }

	public void etudiants() {
		for (Etudiant etudiant : etudiants) {
			System.out.println("---------------------");
			System.err.println(etudiant.getCode());
			System.err.println(etudiant.getCne());
			System.err.println(etudiant.getNom());
			System.err.println(etudiant.getPrenom());
			System.out.println("---------------------");
		}
	}

	public void modules() {
		for (Module module : modules) {
			System.out.println(module);

		}
	}
	
	public void semestres() {
		for (Semestre semestre : semestres) {
			System.out.println(semestre);
		}
	}

	public Object[] vectorToArray(Vector vector){
		Object[] array = vector.toArray();
		return array;
	}
}
