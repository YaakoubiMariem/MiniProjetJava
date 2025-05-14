package mini_projet;
import java.util.ArrayList;
import java.util.List;


public class MainGenerateurParTailleNomSansIndex {

	 public static void main(String[] args) {
	        // Création des noms
	        Nom nom1 = new Nom("1", "Jean Dupont");
	        Nom nom2 = new Nom("2", "Juan Carlos García");
	        Nom nom3 = new Nom("3", "Li Wei");
	        Nom nom4 = new Nom("4", "Anna Marie Dubois");
	        Nom nom5 = new Nom("5", "Mikhail Gorbachev");

	        // Liste 1
	        List<Nom> liste1 = new ArrayList<>();
	        liste1.add(nom1);
	        liste1.add(nom2);

	        // Liste 2
	        List<Nom> liste2 = new ArrayList<>();
	        liste2.add(nom3);
	        liste2.add(nom4);
	        liste2.add(nom5);

	        // Générateur avec un intervalle de 5 caractères
	        GenerateurParTailleNomSansIndex generateur = new GenerateurParTailleNomSansIndex(5);

	        // Générer les couples
	        List<Couple> couples = generateur.generer(liste1, liste2);

	        // Afficher les couples générés
	        System.out.println("Couples générés :");
	        for (Couple couple : couples) {
	            System.out.println("Couple : " + couple.getNom1().getNomComplet() + " - " + couple.getNom2().getNomComplet());
	        }
	    }
	}
