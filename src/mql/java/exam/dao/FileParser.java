package mql.java.exam.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import mql.java.exam.models.Etudiant;
import mql.java.exam.models.Filiere;
import mql.java.exam.models.Module;
import mql.java.exam.models.Note;
import mql.java.exam.models.Semestre;
import util.Helper;

public class FileParser {

	private Filiere filiere;
	private Vector<Etudiant> etudiants;
	private Vector<Module> modules;
	private Vector<Semestre> semestres;

	public FileParser(String nomFiliere) {

		semestres = new Vector<Semestre>();

		String dossierFiliere = "resources/notes/" + nomFiliere;
		
		File file = new File(dossierFiliere);
		
		listAndParseFiles(file);
		
		this.filiere = new Filiere(nomFiliere, semestres);

	}

	private void listAndParseFiles(File folder) {

		for (File file : folder.listFiles()) {

			if (file.isDirectory() && "Notes".equals(file.getName())) {
			
				modules = new Vector<Module>();
				
				parseNotes(file);
			
			}

			else if (file.isDirectory()) {

				listAndParseFiles(file);

			}

			else if ("Etudiants.txt".equals(file.getName())) {
				
				etudiants = new Vector<Etudiant>();
				
				parseEtudiant(file);
				
				/*
				 * after the parsing of the student file and the modules files we start the construction
				 * of the semesters object
				*/
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
			
			//parsing the data needed for the student construction
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

		// parsing the data needed for the module construction
		for (File module : files) {

			try (FileReader fileReader = new FileReader(module); BufferedReader br = new BufferedReader(fileReader);) {

				String nomProfesseur = br.readLine();
				int nombreNotes = Integer.parseInt(br.readLine());
				String[] informationsModule = module.getName().split("-");
				int idModule = Integer.parseInt(informationsModule[0]);
				
				// removing the '.txt' suffix
				String nomModule = informationsModule[1].substring(0, informationsModule[1].length() - 4);

				String[] coefficients = br.readLine().split(",");

				String value = "";
				Hashtable<String, Vector<Note>> notesEtudiant = new Hashtable<String, Vector<Note>>();
				while ((value = br.readLine()) != null) {
					Vector<Note> notesListe = new Vector<Note>();

					String[] informationsNote = value.split(",");
					String cne = informationsNote[0];

					for (int i = 0; i < nombreNotes; i++) {
						
						//i+1 because the first index refers to the student's 'cne'
						double noteEtudiant = Double.parseDouble(informationsNote[i + 1]);
						Note note = new Note(noteEtudiant, Integer.parseInt(coefficients[i]));
						notesListe.add(note);
					}

					notesEtudiant.put(cne, notesListe);

				}

				modules.add(new Module(idModule, nomModule, notesEtudiant, nomProfesseur, nombreNotes));

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
	
	public Filiere getFiliere() {
		return filiere;
	}

}
