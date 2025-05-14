package mini_projet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainGenerateurParTrigrammeAvecIndex {

    public static void main(String[] args) {
        // Création de noms avec ID et décomposition manuelle (nom traité)
        Nom nom1 = new Nom("1", "Jean Pierre Dupont");
        nom1.setNomTraite(Arrays.asList("Jean", "Pierre", "Dupont"));

        Nom nom2 = new Nom("2", "Marie Dubois");
        nom2.setNomTraite(Arrays.asList("Marie", "Dubois"));

        Nom nom3 = new Nom("3", "Pedro Gonzalez");
        nom3.setNomTraite(Arrays.asList("Pedro", "Gonzalez"));

        Nom nom4 = new Nom("4", "Anna Maria Rossi");
        nom4.setNomTraite(Arrays.asList("Anna", "Maria", "Rossi"));

        Nom nom5 = new Nom("5", "Luigi");
        nom5.setNomTraite(Collections.singletonList("Luigi"));

        Nom nom6 = new Nom("6", "Jean Claude Van Damme");
        nom6.setNomTraite(Arrays.asList("Jean", "Claude", "Van", "Damme"));

        // Listes
        List<Nom> liste1 = Arrays.asList(nom1, nom6);          // Liste à comparer
        List<Nom> liste2 = Arrays.asList(nom2, nom3, nom4, nom5); // Liste indexée

        // Création du générateur
        GenerateurParTrigrammeAvecIndex generateur = new GenerateurParTrigrammeAvecIndex(1);

        // Affichage de l'index
        System.out.println("Index des trigrammes :");
        for (Map.Entry<String, Set<Nom>> entry : generateur.getIndexTrigrammes().entrySet()) {
            System.out.print("Trigramme = " + entry.getKey() + " => ");
            for (Nom nom : entry.getValue()) {
                System.out.print("[ID " + nom.getId() + "] " + nom.getNomComplet() + " | ");
            }
            System.out.println();
        }

        // Génération des couples
        List<Couple> couples = generateur.generer(liste1, liste2);

        // Affichage des couples
        System.out.println("\nCouples générés (avec seuil de " + generateur.getSeuil() + " trigrammes communs) :");
        for (Couple c : couples) {
            System.out.println("- [" + c.getNom1().getId() + "] " + c.getNom1().getNomComplet() +
                               " <-> [" + c.getNom2().getId() + "] " + c.getNom2().getNomComplet());
        }
    }
}
