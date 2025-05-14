package mini_projet;
import java.util.*;

public class GenerateurParMotsCommunsAvecIndex implements GenerateurCandidats {

    private final int intervalle;
    private final Map<Integer, List<Nom>> indexParNbMots;

    public GenerateurParMotsCommunsAvecIndex(int intervalle) {
        this.intervalle = intervalle;
        this.indexParNbMots = new HashMap<>();
    }
    public void construireIndex(List<Nom> liste2) {
        indexParNbMots.clear();
        for (Nom n : liste2) {
            int nbMots = n.getNomTraite().size();
            List<Nom> liste = indexParNbMots.get(nbMots);
            if (liste == null) {
                liste = new ArrayList<>();
                indexParNbMots.put(nbMots, liste);
            }
            liste.add(n);        }
    }

    @Override
    public List<Couple> generer(List<Nom> liste1, List<Nom> liste2) {
        if (indexParNbMots.isEmpty()) {
            construireIndex(liste2);
        }

        List<Couple> couples = new ArrayList<>();
        for (Nom n1 : liste1) {
            int nbMots1 = n1.getNomTraite().size();

            for (int k = nbMots1 - intervalle; k <= nbMots1 + intervalle; k++) {
                List<Nom> candidats = indexParNbMots.get(k);
                if (candidats != null) {
                    for (Nom n2 : candidats) {
                        couples.add(new Couple(n1, n2));
                    }
                }
            }
        }

        return couples;
    }
    public Map<Integer, List<Nom>> getIndex() {
        return indexParNbMots;
    }

}
