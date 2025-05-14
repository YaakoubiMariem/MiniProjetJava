package mini_projet;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class ComparateurLevenshtein implements ComparateurChaine {

    private final LevenshteinDistance levenshtein = new LevenshteinDistance(100); // seuil large

    public double comparer(String s1, String s2) {
        if (s1 == null || s2 == null) return 1.0; // chaînes très différentes

        int maxLength = Math.max(s1.length(), s2.length());
        if (maxLength == 0) return 0.0; // deux chaînes vides = identiques
        Integer rawDistance = levenshtein.apply(s1, s2);
        if (rawDistance == -1) return 1.0; // trop différent, dépasse le seuil
        return (double) rawDistance / maxLength; // score entre 0.0 (identique) et 1.0 (différent)
    }

    public TypeMesure getType() {
        return TypeMesure.DISTANCE;
    }
}
