package mini_projet;

import java.util.ArrayList;
import java.util.List;


public class GenerateurCandidatsTous implements GenerateurCandidats {

    public List<Couple> generer(List<NomAvecId> liste1, List<NomAvecId> liste2) {
        List<Couple> couples = new ArrayList<>();
        
        for (NomAvecId p1 : liste1) {
            for (NomAvecId p2 : liste2) {
                couples.add(new Couple(p1, p2));
            }
        }
        
        return couples;
    }
   
}
