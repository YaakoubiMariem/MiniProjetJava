package mini_projet;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;

public class ComparateurJaroWinkler implements ComparateurChaine {
    private final JaroWinklerSimilarity jw = new JaroWinklerSimilarity();

    @Override
    public double comparer(String s1, String s2) {
        return jw.apply(s1, s2);
    }

    @Override
    public TypeMesure getType() {
        return TypeMesure.SIMILARITE;
    }
}
