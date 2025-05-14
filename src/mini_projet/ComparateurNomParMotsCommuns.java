package mini_projet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComparateurNomParMotsCommuns implements ComparateurNom {
 
    public double comparer(Nom n1, Nom n2) {
        List<String> mots1 = n1.getNomTraite();
        List<String> mots2 = n2.getNomTraite();

        if (mots1 == null || mots2 == null || mots1.isEmpty() || mots2.isEmpty()) {
            return 0.0;
        }
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
        Set<String> set1 = new HashSet<>(mots1);
        Set<String> set2 = new HashSet<>(mots2);
        set1.retainAll(set2);
        int motsCommuns = set1.size();
        double tailleMoyenne = (mots1.size() + mots2.size()) / 2.0;
        return motsCommuns / tailleMoyenne;
    }
}