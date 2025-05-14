package mini_projet;
import org.apache.commons.text.similarity.LongestCommonSubsequenceDistance;

public class ComparateurLongestCommonSubsequenceDistance implements ComparateurChaine {

	private final LongestCommonSubsequenceDistance lcs = new LongestCommonSubsequenceDistance();

    public double comparer(String s1, String s2) {
        int lcsLength = lcs.apply(s1, s2);
        int maxLength = Math.max(s1.length(), s2.length());
        return (double) lcsLength / maxLength; // Distance normalisée
    }

    public TypeMesure getType() {
        return TypeMesure.DISTANCE;
    }
}
