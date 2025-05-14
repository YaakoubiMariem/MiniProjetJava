package mini_projet;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
import java.util.ArrayList;
import java.util.List;


public class GenerateurCandidatsTous implements GenerateurCandidats {

    public List<Couple> generer(List<Nom> liste1, List<Nom> liste2) {
        List<Couple> couples = new ArrayList<>();
        
        for (Nom n1 : liste1) {
            for (Nom n2 : liste2) {
                couples.add(new Couple(n1, n2));
            }
        }
        
        return couples;
    }
   
}


