package mini_projet;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectionneurNMeilleur implements Selectionneur {

	 private final int k;
	    
	    public SelectionneurNMeilleur(int k) {
	        this.k = k;
	    }
	       
	    public List<CoupleNomsAvecScore> selectionner(List<CoupleNomsAvecScore> resultats) {
	        resultats.sort(Comparator.comparingDouble(CoupleNomsAvecScore::getScore).reversed());
	        
	        List<CoupleNomsAvecScore> topK = new ArrayList<>();
	        for (int i = 0; i < Math.min(k, resultats.size()); i++) {
	            topK.add(resultats.get(i));
	        }         
	        return topK;
	    }
	}

