package mini_projet;
import java.util.ArrayList;
import java.util.List;

public class GenerateurParTailleNomSansIndex implements GenerateurCandidats{

	  private int intervalle;

	    public GenerateurParTailleNomSansIndex(int intervalle) {
	        this.intervalle = intervalle;
	    }

	    @Override
	    public List<Couple> generer(List<Nom> liste1, List<Nom> liste2) {
	        List<Couple> couples = new ArrayList<>();

	        for (Nom n1 : liste1) {
	            int taille1 = n1.getNomComplet().length();

	            for (Nom n2 : liste2) {
	                int taille2 = n2.getNomComplet().length();
	                if (Math.abs(taille1 - taille2) <= intervalle) {
	                    couples.add(new Couple(n1, n2));
	                }
	            }
	        }

	        return couples;
	    }
	}