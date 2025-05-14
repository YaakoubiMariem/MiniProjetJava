package mini_projet;

import org.apache.commons.codec.language.Soundex;
import java.util.ArrayList;
import java.util.List;

public class PretraiteurSoundex implements Pretraiteur {
    private final Soundex soundex = new Soundex();

    @Override
    public List<String> traiter(List<String> chaines) {
        List<String> resultat = new ArrayList<>();
        for (String chaine : chaines) {
            resultat.add(soundex.encode(chaine));
        }
        return resultat;
    }
}
