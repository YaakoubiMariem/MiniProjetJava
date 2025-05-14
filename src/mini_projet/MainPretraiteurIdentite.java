package mini_projet;
import java.util.List;

public class MainPretraiteurIdentite {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurIdentite();
        List<String> input = List.of("Jean Dupont");
        List<String> output = pretraiteur.traiter(input);

        System.out.println("Entrée : " + input);
        System.out.println("Sortie : " + output);
    }
}



