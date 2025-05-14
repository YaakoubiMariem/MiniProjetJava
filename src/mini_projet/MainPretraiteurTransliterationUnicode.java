package mini_projet;

import java.util.List;

public class MainPretraiteurTransliterationUnicode {
	public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurTransliterationUnicode();

        List<String> noms = List.of(
            "ဦးေဇတ္တြန္း",           // birman
            "محمد علي",               // arabe
            "Жан-Пьер",               // russe/cyrillique
            "张伟",                   // chinois
            "Αριστοτέλης" ,           // grec
            "á€¦á€¸á€žá€”á€¹á€¸á€‘á€¼á€”á€¹á€¸"
            
        );

        List<String> resultat = pretraiteur.traiter(noms);

        for (int i = 0; i < noms.size(); i++) {
            System.out.println("Original : " + noms.get(i));
            System.out.println("Translit : " + resultat.get(i));
            System.out.println("-------------------------");
        }
    }
}
