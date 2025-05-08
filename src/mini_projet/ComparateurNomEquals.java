package mini_projet;

import java.util.List;

/**
 * Une implémentation simple du ComparateurNom qui utilise equals pour comparer les noms
 */
public class ComparateurNomEquals implements ComparateurNom {


	    public double comparer(Nom n1, Nom n2) {
	        List<String> mots1 = n1.getNomTraite();
	        List<String> mots2 = n2.getNomTraite();

	        if (mots1 != null && mots2 != null) {
	            return mots1.equals(mots2) ? 1.0 : 0.0;
	        } else {
	            String s1 = n1.getNomComplet();
	            String s2 = n2.getNomComplet();
	            return s1 != null && s1.equalsIgnoreCase(s2) ? 1.0 : 0.0;
	        }
	    }
	}
