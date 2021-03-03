package mql.java.exam.business;

import mql.java.exam.models.Etudiant;
import mql.java.exam.models.InformationEtudiant;

public interface FiliereService {
	void ajouterEtudiant(Etudiant etudiant);
	void ajouterNote(String cne,int note, String nomModule);
	InformationEtudiant informationEtudiant(String cne);
	int moyenne(String cne);
}
