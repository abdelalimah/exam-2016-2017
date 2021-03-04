package mql.java.exam.dao;

import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import mql.java.exam.models.Semestre;
import org.w3c.dom.Document;
import mql.java.exam.models.*;
import mql.java.exam.dom.XMLNode;
import mql.java.exam.models.Etudiant;
import mql.java.exam.models.Module;

public class DaoXmlParser {

   private String dataSource;

   public DaoXmlParser(String dataSource) {
      this.dataSource = dataSource;
   }

   public void LoadXml() {
      String filiere = dataSource;

      String dataSource = "resources/filieres/" + filiere + ".xml";
      XMLNode node = new XMLNode(dataSource);
      Vector<Semestre> semestres = new Vector<Semestre>();
      for (XMLNode semestre : node.extractChild("semestres").extractChildren()) {

         // Etudiant Mapping
         Vector<Etudiant> Etudiants = new Vector<>();
         for (XMLNode etudiant : semestre.extractChild("etudiants").extractChildren()) {
            int code = etudiant.extractIntAttribute("code");
            String cne = etudiant.extractChild("cne").textValue();
            String nom = etudiant.extractChild("nom").textValue();
            String prenom = etudiant.extractChild("prenom").textValue();

            Etudiant e = new Etudiant(code, cne, nom, prenom);
            Etudiants.add(e);
         }

         // Module Mapping
         Vector<Module> ListModule = new Vector<>();
         for (XMLNode module : semestre.extractChild("modules").extractChildren()) {
            int id = module.extractIntAttribute("id");
            String nom = module.extractAttribute("name");
            String prof = module.extractChild("prof").textValue();
            int nb_notes = module.extractChild("nb_notes").intValue();
            Vector<Integer> coefs = new Vector<>();
            for (XMLNode coef : module.extractChild("coefs").extractChildren()) {

               coefs.add(coef.intValue());
            }
            Hashtable<String, Vector<Note>> notesEtudiant = new Hashtable<String, Vector<Note>>();

            for (XMLNode note : module.extractChild("notes").extractChildren()) {
               String codeE = String.valueOf(note.extractIntAttribute("codeE"));
               XMLNode[] values = note.extractChildren();
               Vector<Note> NoteList = new Vector<>();
               for (int i = 0; i < values.length; i++) {
                  NoteList.add(new Note(values[i].doubleValue(), coefs.get(i)));
               }

               notesEtudiant.put(codeE, NoteList);
               Module moduleeee = new Module(id, nom, notesEtudiant, prof, nb_notes);
               System.out.println(moduleeee);
               ListModule.add(moduleeee);

               System.out.println(moduleeee);
               ListModule.add(moduleeee);

               System.out.println(moduleeee);
               ListModule.add(moduleeee);

               System.out.println(moduleeee);
               ListModule.add(moduleeee);

               System.out.println(moduleeee);
               ListModule.add(moduleeee);

            }
         }

      }
   }
}








