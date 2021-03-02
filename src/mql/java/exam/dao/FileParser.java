package mql.java.exam.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

import mql.java.exam.models.Filiere;

public class FileParser {
	
	private Filiere filiere;
	
	public FileParser(String nomFiliere){
		
		String dossierFiliere = "resources/notes/"+nomFiliere;
		File file = new File(dossierFiliere);
		listFilesForFolders(file);
	
	}
	
	public void listFilesForFolders(File folder) {

		for (File file : folder.listFiles()) {
			
			if(file.isDirectory() && "Notes".equals(file.getName())) {
	
				parseNotes(file);

			}
			
			else if(file.isDirectory()) {
			
				listFilesForFolders(file);
			
			}
			
			else if("Etudiants.txt".equals(file.getName())) {
			
				parseEtudiant(file);
			
			}
			
		}
		
	}
	
	private void parseEtudiant(File file) {
		
		try(
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
		){
			
			System.out.println(br.readLine());
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private void parseNotes(File file) {
		
		File[] files = file.listFiles();
		
		for (File module : files) {
			
			try(
				FileReader fileReader = new FileReader(module);
				BufferedReader br = new BufferedReader(fileReader);
			){
		
				System.out.println(br.readLine());
		
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
			
			}
			
		}
		
	}

	public static void main(String[] args) {
		new FileParser("SMA");
	}
	
	public void notes() {
		
	}
	
	public void modules() {
		
	}
	
	public void semestres() {
		
	}
	
	public void etudiants() {
		
	}
}
