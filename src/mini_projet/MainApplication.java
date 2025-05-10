package mini_projet;

import java.util.ArrayList;
import java.util.List;


public class MainApplication{
    public static void main(String[] args) {
    	 List<Nom> nomAvecIds = List.of(
    	            new Nom("1", "Ahmed Ben Salah"),
    	            new Nom("2", "Fatma Chaabane"),
    	            new Nom("3", "Hichem Trabelsi"),
    	            new Nom("4",  "Sonia Bouzid")
    	        );
    	        String nomRecherche = "Fatma Chaabane";
    	        Pretraiteur pretraitementIdentite = new PretraiteurIdentite();
    	        GenerateurCandidats generateur = new GenerateurCandidatsTous();
    	        Selectionneur selectionneur = new SelectionneurTout();
    	        ComparateurNom comparateur = new ComparateurNomEquals();
    	        List<Pretraiteur> pretraiteur = new ArrayList<>();
    	        pretraiteur.add(pretraitementIdentite);
    	        MoteurMatching moteur = new MoteurMatching(pretraiteur, generateur, selectionneur, comparateur);
    	        List<CoupleNomsAvecScore> resultats = moteur.rechercher(nomAvecIds, nomRecherche);
    	        if (resultats.isEmpty()) {
    	            System.out.println("Aucun résultat trouvé.");
    	        } else {
    	            System.out.println("Résultats de la recherche pour '"+ nomRecherche + "':");
    	            for (CoupleNomsAvecScore resultat : resultats) {
    	                System.out.println("- " + resultat.getNom2().getNomComplet() + " (Score : " + resultat.getScore() + ")");
    	            }
    	        }

    }
}
