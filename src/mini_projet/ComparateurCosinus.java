package mini_projet;

import org.apache.commons.text.similarity.CosineSimilarity;

import java.util.HashMap;
import java.util.Map;

public class ComparateurCosinus implements ComparateurChaine {
    private final CosineSimilarity cosine = new CosineSimilarity();

    public double comparer(String s1, String s2) {
        Map<CharSequence, Integer> freq1 = getCharacterFrequencies(s1);
        Map<CharSequence, Integer> freq2 = getCharacterFrequencies(s2);
        return cosine.cosineSimilarity(freq1, freq2);
    }

    private Map<CharSequence, Integer> getCharacterFrequencies(String s) {
        Map<CharSequence, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(String.valueOf(c), freqMap.getOrDefault(String.valueOf(c), 0) + 1);
        }
        return freqMap;
    }

    public TypeMesure getType() {
        return TypeMesure.SIMILARITE;
    }
}
