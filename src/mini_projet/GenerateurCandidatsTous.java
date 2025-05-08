package mini_projet;

import java.util.ArrayList;
import java.util.List;

/**
 * Une implémentation simple du GenerateurCandidats qui génère tous les couples possibles
 * entre les éléments des deux listes.
 */
public class GenerateurCandidatsTous implements GenerateurCandidats {

    @Override
    public List<Couple> generer(List<Personne> liste1, List<Personne> liste2) {
        List<Couple> couples = new ArrayList<>();
        
        // Pour chaque personne de la liste1, on l'associe avec chaque personne de la liste2
        for (Personne p1 : liste1) {
            for (Personne p2 : liste2) {
                couples.add(new Couple(p1, p2));
            }
        }
        
        return couples;
    }
}
