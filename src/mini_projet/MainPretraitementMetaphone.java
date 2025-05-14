package mini_projet;
import java.util.List;

public class MainPretraitementMetaphone {
	 public static void main(String[] args) {
	        PretraiteurMetaphone pretraiteur = new PretraiteurMetaphone();
	        List<String> mots = List.of("hello", "hallo", "smith", "smythe", "knight", "night");
	        List<String> codes = pretraiteur.traiter(mots);
	        
	        for (int i = 0; i < mots.size(); i++) {
	            System.out.println(mots.get(i) + " -> " + codes.get(i));
	        }
	    }
	}
