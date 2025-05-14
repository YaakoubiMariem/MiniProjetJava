package mini_projet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class RecuperateurCSV implements Recuperateur {

    private String cheminFichier;

    public RecuperateurCSV(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    @Override
    public List<Nom> recupererNom() {
        try (Stream<String> lignes = Files.lines(Paths.get(cheminFichier))) {
            return lignes.skip(1) // Sauter l'en-tête
                         .map(ligne -> ligne.split(","))
                         .filter(donnees -> donnees.length >= 2)
                         .map(donnees -> new Nom(donnees[0].trim(), donnees[1].trim()))
                         .toList();
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Liste vide en cas d'erreur
        }
    }
}