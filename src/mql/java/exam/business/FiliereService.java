package mql.java.exam.business;

import mql.java.exam.models.Etudiant;

public interface FiliereService {
	void AjouterEtudiant();
	void ajouterNote(int note);
	Etudiant informationEtudiant();
	int moyenne();
}
