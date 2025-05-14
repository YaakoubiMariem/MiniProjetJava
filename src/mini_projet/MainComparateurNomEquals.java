package mini_projet;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
import java.util.List;

public class MainComparateurNomEquals {
    public static void main(String[] args) {
        ComparateurNom comparateur = new ComparateurNomEquals();
        Nom n1 = new Nom("1", "Jean Dupont");
        Nom n2 = new Nom("2", "Jean Dupont");

        n1.setNomTraite(List.of("Jean", "Dupont"));
        n2.setNomTraite(List.of("Jean", "Dupont"));

        double score = comparateur.comparer(n1, n2);
        System.out.println("Score de similarité : " + score);
    }
}


