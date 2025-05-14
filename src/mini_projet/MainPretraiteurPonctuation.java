package mini_projet;

import java.util.List;

public class MainPretraiteurPonctuation {
	 public static void main(String[] args) {
	        Pretraiteur pretraiteur = new PretraiteurPonctuation();

	        List<String> noms = List.of(
	            "Jean-Pierre O'Neill",
	            "Dr. María-Luisa de la Cruz",
	            "Ali ibn Abi-Talib",
	            "Müller, Hans",
	            ",á€¦á€¸á€±á€™á€¬á€„á€¹á€¦á€¸",
	            "ÃoldaÅ+Ÿ HallyÃ½ewiÃ§ Åžeripow",
	            "Rosanna GabaldÃ³n",
	            "a€¦a€¸a€za€\"a€¹a€¸a€'a€ 1/4a€\"a€¹a€¸"
	        );

	        List<String> resultat = pretraiteur.traiter(noms);

	        for (int i = 0; i < noms.size(); i++) {
	            System.out.println("Original : " + noms.get(i));
	            System.out.println("Nettoyé  : " + resultat.get(i));
	            System.out.println("-------------------------");
	        }
	    }
	}
