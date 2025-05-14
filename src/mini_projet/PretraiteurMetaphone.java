package mini_projet;

import org.apache.commons.codec.language.Metaphone;
import java.util.ArrayList;
import java.util.List;

public class PretraiteurMetaphone implements Pretraiteur {
    private final Metaphone metaphone = new Metaphone();

    @Override
    public List<String> traiter(List<String> chaines) {
        List<String> resultat = new ArrayList<>();
        for (String chaine : chaines) {
            resultat.add(metaphone.encode(chaine));
        }
        return resultat;
    }
}