package mini_projet;
import java.util.List;

public class MainPretraiteurSoundex {
    public static void main(String[] args) {
        // Create an instance of PretraiteurSoundex
        PretraiteurSoundex pretraiteur = new PretraiteurSoundex();
        // Create a list of test words
        List<String> mots = List.of("Robert", "Rupert", "Rubin", "hello", "hallo", "hollow");
        
        // Process the words
        List<String> motsSoundex = pretraiteur.traiter(mots);
        
        // Display the results
        System.out.println("Soundex Representations:");
        for (int i = 0; i < mots.size(); i++) {
            System.out.printf("%-8s -> %s%n", mots.get(i), motsSoundex.get(i));
        }
        

    }
}
