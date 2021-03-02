package mql.java.exam.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import mql.java.exam.models.Etudiant;
import mql.java.exam.models.Filiere;
import mql.java.exam.models.Note;

public class FileParser {

	private Filiere filiere;
	private Vector<Etudiant> etudiants;
	private Vector<Note> notes;

	public FileParser(String nomFiliere) {

		String dossierFiliere = "resources/notes/" + nomFiliere;
		File file = new File(dossierFiliere);
		listFilesForFolders(file);
		etudiants = new Vector();
		notes = new Vector();

	}

	public void listFilesForFolders(File folder) {

		for (File file : folder.listFiles()) {

			if (file.isDirectory() && "Notes".equals(file.getName())) {

				parseNotes(file);

			}

			else if (file.isDirectory()) {

				listFilesForFolders(file);

			}

			else if ("Etudiants.txt".equals(file.getName())) {

				parseEtudiant(file);

			}

		}

	}

	private void parseEtudiant(File file) {

		try (FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		) {
			
			String value = "";
			while((value = br.readLine()) != null){
				String[] etudiant = value.split("\t");
				
				int code = Integer.parseInt(etudiant[0]);
				String cne = etudiant[1];
				String nom = etudiant[2];
				String prenom = etudiant[3];
				
				etudiants.add(new Etudiant(code,cne,nom,prenom));
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void parseNotes(File file) {

		File[] files = file.listFiles();

		for (File module : files) {

			try (FileReader fileReader = new FileReader(module);
			 BufferedReader br = new BufferedReader(fileReader);
			) {

				String nomProfesseur = br.readLine();
				int nombreNotes = Integer.parseInt(br.readLine());
				String[] coefficientStrings = br.readLine().split(",");
				int[] coefficient = new int[nombreNotes];
				
				for (int i = 0; i < coefficientStrings.length; i++) {
					
					coefficient[i] = Integer.parseInt(coefficientStrings[i]);
					
				}
				
				String value = "";
				while((value = br.readLine()) != null){
					
					String[] noteEtudiant = value.split(",");
					String cne = noteEtudiant[0];

					List<Double> noteList = new ArrayList<>();
					for (int i = 1; i <nombreNotes ; i++) {
						double note = Double.parseDouble(noteEtudiant[i]);
						noteList.add(note);
					}
					
					Etudiant etudiant = trouverEtudiant(cne);
					notes.add(new Note(noteList, coefficient, etudiant));
				};

			} catch (Exception e) {
				System.out.println(e.getMessage());
			};


			
		}

	}

	public static void main(String[] args) {
		new FileParser("SMA");
	}

	public Etudiant trouverEtudiant(String cne){
		for (int i = 0; i < etudiants.size(); i++) {
			if(etudiants.get(i).getCne() == cne){
				return etudiants.get(i);
			}
		}
		return null;
	}

	public void notes() {
		System.out.println("i am here");
		for (Note note : notes) {
			Etudiant etudiant = note.getEtudiant();
			System.out.println(etudiant.getCode());
			System.out.println(etudiant.getNom());
		}
	}
	
}
	// public void modules() {

	// }