package mini_projet;


import java.util.List;

public class MainComparateurNomParMotsCommuns {
    public static void main(String[] args) {
        Nom nom1 = new Nom("1", "mouhamed yassine yaakoubi");
        Nom nom2 = new Nom("2", "mouhamed yassine ");

        // Simulation d'un prétraitement : décomposition + minuscule
        nom1.setNomTraite(List.of("mouhamed", "yassine","yaakoubi"));
        nom2.setNomTraite(List.of("mouhamed", "yassine"));

        ComparateurNom comparateur = new ComparateurNomParMotsCommuns();
        double score = comparateur.comparer(nom1, nom2);

        System.out.println("Score de similarité : " + score);
    }
}


