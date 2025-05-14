package mini_projet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fichier = "C:/Users/USER/Downloads/peps_names_200.csv";
        Recuperateur recuperateur = new RecuperateurCSV(fichier);
        List<Nom> noms = recuperateur.recupererNom();

        // Afficher chaque nom
        noms.forEach(n -> System.out.println("ID: " + n.getId() + ", Nom Complet: " + n.getNomComplet()));

        // Afficher le nombre total de noms
        System.out.println("Nombre total de noms importés : " + noms.size());
    }
    
}
