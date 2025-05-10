package mini_projet;

import java.util.List;

public class MainGenerateurCandidatsTous {

    public static void main(String[] args) {
        GenerateurCandidats generateur = new GenerateurCandidatsTous();
        Nom n1 = new Nom("1", "Jean Dupont");
        Nom n2 = new Nom("2", "Paul Martin");

        List<Couple> couples = generateur.generer(List.of(n1), List.of(n1, n2));
        System.out.println("Couples générés : ");
        for (Couple c : couples) {
            System.out.println(c.getNom1().getNomComplet() + " - " + c.getNom2().getNomComplet());
        }
    }
}

