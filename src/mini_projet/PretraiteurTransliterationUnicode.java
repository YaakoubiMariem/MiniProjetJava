package mini_projet;

import com.ibm.icu.text.Transliterator;
import java.util.ArrayList;
import java.util.List;

public class PretraiteurTransliterationUnicode implements Pretraiteur {

    private static final Transliterator transliterator = Transliterator.getInstance("Any-Latin; Latin-ASCII");

    @Override
    public List<String> traiter(List<String> chaines) {
        List<String> resultat = new ArrayList<>();
        for (String chaine : chaines) {
            String translittere = transliterator.transliterate(chaine);
            resultat.add(translittere);
        }
        return resultat;
    }
}
