package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class GenerateurParMotsCommunsSansIndex  implements GenerateurCandidats {


	  private int intervalle;

	    public GenerateurParMotsCommunsSansIndex(int intervalle) {
	        this.intervalle = intervalle;
	    }

	    @Override
	    public List<Couple> generer(List<Nom> liste1, List<Nom> liste2) {
	        List<Couple> couples = new ArrayList<>();

	        for (Nom n1 : liste1) {
	            int nombreMots1 = n1.getNomTraite().size();

	            for (Nom n2 : liste2) {
	                int nombreMots2 = n2.getNomTraite().size();
	                if (Math.abs(nombreMots1 - nombreMots2) <= intervalle) {
	                    couples.add(new Couple(n1, n2));
	                }
	            }
	        }

	        return couples;
	    }
	}