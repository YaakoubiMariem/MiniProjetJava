package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class MainApplication{
    public static void main(String[] args) {
    	 List<NomAvecId> nomAvecIds = List.of(
    	            new NomAvecId("1", new Nom("Ahmed Ben Salah")),
    	            new NomAvecId("2", new Nom("Fatma Chaabane")),
    	            new NomAvecId("3", new Nom("Hichem Trabelsi")),
    	            new NomAvecId("4", new Nom("Sonia Bouzid"))
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
    	                System.out.println("- " + resultat.getPersonne2().getNom().getNomComplet() + " (Score : " + resultat.getScore() + ")");
    	            }
    	        }

    }
}
