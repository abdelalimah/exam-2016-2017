package mql.java.exam.dao;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.Vector;

import mql.java.exam.models.Etudiant;
import mql.java.exam.models.Filiere;
import mql.java.exam.models.Note;
import mql.java.exam.models.Semestre;
import mql.java.exam.util.*;
import mql.java.exam.models.Module;

public class OperationFiliere {

	private Filiere filiere;
	
	public OperationFiliere(String nomFiliere){
		FileParser parser = new FileParser(nomFiliere);
		this.filiere = parser.getFiliere();
	}

	public Filiere charger(){
		return this.filiere;
	}

	public void sauvegarder(){
		// TO-DO : hello world
	}

	public static void main(String[] args) {
		Filiere filiere = new OperationFiliere("SMI").charger();
		System.out.println(filiere.getNom());
	}
}
