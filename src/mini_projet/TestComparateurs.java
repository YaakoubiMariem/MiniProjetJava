package mini_projet;
public class TestComparateurs {

    public static void main(String[] args) {
        // Exemple de chaînes à comparer
        String s1 = "chat";
        String s2 = "chat";

        // Test des comparateurs
        ComparateurChaine[] comparateurs = {
            new ComparateurLevenshtein(),
            new ComparateurHamming(),
            new ComparateurJaroWinkler(),
            new ComparateurJaccard(),
            new ComparateurCosinus(),
            new ComparateurLongestCommonSubsequenceDistance()
        };

        // Afficher le résultat de chaque comparateur
        for (ComparateurChaine comparateur : comparateurs) {
            double score = comparateur.comparer(s1, s2);
            System.out.println("Comparateur : " + comparateur.getClass().getSimpleName());
            System.out.println("Type de mesure : " + comparateur.getType());
            System.out.println("Score de comparaison entre \"" + s1 + "\" et \"" + s2 + "\": " + score);
            System.out.println("-----------------------------------------");
        }
    }
}
