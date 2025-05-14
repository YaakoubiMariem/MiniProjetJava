package mini_projet;

import java.util.*;

public class GenerateurParTrigrammeAvecIndex implements GenerateurCandidats {

    private final int seuil; // nombre minimal de trigrammes communs
    private final Map<String, Set<Nom>> indexTrigrammes;
    public Map<String, Set<Nom>> getIndexTrigrammes() {
		return indexTrigrammes;
	}
    public int getSeuil() {
        return seuil;
    }

	public GenerateurParTrigrammeAvecIndex(int seuil) {
        this.seuil = seuil;
        this.indexTrigrammes = new HashMap<>();
    }

    private Set<String> extraireTrigrammesDepuisNomTraite(Nom nom) {
        Set<String> trigrammes = new HashSet<>();
        for (String token : nom.getNomTraite()) {
            String mot = token.toLowerCase().replaceAll("[^a-z]", " ");
            mot = "  " + mot + "  ";
            for (int i = 0; i < mot.length() - 2; i++) {
                trigrammes.add(mot.substring(i, i + 3));
            }
        }
        return trigrammes;
    }

    private void construireIndex(List<Nom> liste2) {
        indexTrigrammes.clear();
        for (Nom nom : liste2) {
            Set<String> trigrammes = extraireTrigrammesDepuisNomTraite(nom);
            for (String trig : trigrammes) {
                indexTrigrammes.computeIfAbsent(trig, k -> new HashSet<>()).add(nom);
            }
        }
    }

    @Override
    public List<Couple> generer(List<Nom> liste1, List<Nom> liste2) {
        construireIndex(liste2);
        Set<Couple> couples = new HashSet<>();

        for (Nom n1 : liste1) {
            Map<Nom, Integer> compteurs = new HashMap<>();
            Set<String> trigs1 = extraireTrigrammesDepuisNomTraite(n1);

            for (String trig : trigs1) {
                Set<Nom> candidats = indexTrigrammes.get(trig);
                if (candidats != null) {
                    for (Nom n2 : candidats) {
                        compteurs.put(n2, compteurs.getOrDefault(n2, 0) + 1);
                    }
                }
            }

            for (Map.Entry<Nom, Integer> entry : compteurs.entrySet()) {
                if (entry.getValue() >= seuil) {
                    couples.add(new Couple(n1, entry.getKey()));
                }
            }
        }

        return new ArrayList<>(couples);
    }
}
