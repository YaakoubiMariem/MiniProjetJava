package mini_projet;
import java.util.List;

/**
 * Une implémentation simple des Pretraitements qui ne modifie pas les chaînes
 */
public class PretraitementsIdentite implements Pretraitements {

    @Override
    public List<String> traiter(List<String> chaines) {
        // Retourne les chaînes sans les modifier
        return chaines;
    }
}