package mini_projet;
import java.util.Arrays;
import java.util.List;

public class MainGenerateurParTailleNomAvecIndex {
	 public static void main(String[] args) {
	        // Création de noms dans liste1
	        List<Nom> liste1 = Arrays.asList(
	            new Nom("1", "Jean Dupont"),
	            new Nom("2", "Ali Ben Ahmed"),
	            new Nom("3", "Maria de la Cruz")
	        );

	        // Création de noms dans liste2
	        List<Nom> liste2 = Arrays.asList(
	            new Nom("11", "John Smith"),
	            new Nom("22", "Ahmed El Mansouri"),
	            new Nom("33", "Maria Clara del Valle")
	        );

	        // Création du générateur avec intervalle de taille 3
	        GenerateurParTailleNomAvecIndex generateur = new GenerateurParTailleNomAvecIndex(3);

	        // Construction de l’index à partir de liste2
	        generateur.construireMap(liste2);

	        // Génération des couples
	        List<Couple> couples = generateur.generer(liste1, liste2);

	        // Affichage des résultats
	        for (Couple c : couples) {
	            System.out.println(c.getNom1().getNomComplet() + " <-> " + c.getNom2().getNomComplet());
	        }
	    }
	}