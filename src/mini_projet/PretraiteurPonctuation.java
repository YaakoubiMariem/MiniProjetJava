package mini_projet;
import java.util.ArrayList;
import java.util.List;

public class PretraiteurPonctuation implements Pretraiteur {
    public List<String> traiter(List<String> chaines) {
        List<String> resultat = new ArrayList<>();
        for (String chaine : chaines) {
            // Remplace les caractères non-lettres/digits par des espaces
            String nettoye = chaine.replaceAll("[^\\p{L}\\p{Nd}]", " ");
            resultat.add(nettoye);
        }
        return resultat;
    }
}


