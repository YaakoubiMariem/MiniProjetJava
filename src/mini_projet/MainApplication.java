package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class MainApplication{
    public static void main(String[] args) {
    	 List<Personne> personnes = List.of(
    	            new Personne("1", new Nom("Ahmed Ben Salah")),
    	            new Personne("2", new Nom("Fatma Chaabane")),
    	            new Personne("3", new Nom("Hichem Trabelsi")),
    	            new Personne("4", new Nom("Sonia Bouzid"))
    	        );
    	        String nomRecherche = "Fatma Chaabane";
    	        Pretraitements pretraitementIdentite = new PretraitementsIdentite();
    	        GenerateurCandidats generateur = new GenerateurCandidatsTous();
    	        Selectionneur selectionneur = new SelectionneurTout();
    	        ComparateurNom comparateur = new ComparateurNomEquals();
    	        List<Pretraitements> pretraitements = new ArrayList<>();
    	        pretraitements.add(pretraitementIdentite);
    	        MoteurMatching moteur = new MoteurMatching(pretraitements, generateur, selectionneur, comparateur);
    	        List<ResultatComparaison> resultats = moteur.rechercher(personnes, nomRecherche);
    	        if (resultats.isEmpty()) {
    	            System.out.println("Aucun résultat trouvé.");
    	        } else {
    	            System.out.println("Résultats de la recherche pour '"+ nomRecherche + "':");
    	            for (ResultatComparaison resultat : resultats) {
    	                System.out.println("- " + resultat.getPersonne2().getNom().getNomComplet() + " (Score : " + resultat.getScore() + ")");
    	            }
    	        }

    }
}
