package mini_projet;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PretraiteurDecomposition implements Pretraiteur {

    public List<String> traiter(List<String> chaines) {
        List<String> resultat = new ArrayList<>();
        for (String chaine : chaines) {
            // Découpage par espace
            String[] mots = chaine.trim().split("\\s+");
            resultat.addAll(Arrays.asList(mots));
        }
        return resultat;
    }
}


