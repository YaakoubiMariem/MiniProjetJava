package mini_projet;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class PretraiteurSansAccents implements Pretraiteur {

    @Override
    public List<String> traiter(List<String> chaines) {
        List<String> resultat = new ArrayList<>();
        
        for (String chaine : chaines) {
            // Normalisation et suppression des accents
            String sansAccents = Normalizer.normalize(chaine, Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}", "");
            resultat.add(sansAccents);
        }
        
        return resultat;
    }
}


