package mini_projet;
import java.util.ArrayList;
import java.util.List;

public class PretraiteurMinuscule implements Pretraiteur {

    public List<String> traiter(List<String> chaines) {
        List<String> nomTraite = new ArrayList<>();
        for (String chaine : chaines) {
        	nomTraite.add(chaine.toLowerCase());
        }
        return nomTraite;
    }
}


