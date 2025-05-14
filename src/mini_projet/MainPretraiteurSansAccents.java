package mini_projet;
<<<<<<< HEAD
import java.util.List;

public class MainPretraiteurSansAccents {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurSansAccents();

        List<String> entree = List.of("René Prévert", "Hélène Müller", "François Cédille","ÃoldaÅŸ HallyÃ½ewiÃ§ Åžeripow","ဦးေဇတ္တြန္း ");
=======

import java.util.List;

public class MainPretraiteurSansAccents {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurSansAccents();

        List<String> entree = List.of("René Prévert", "Hélène Müller", "François Cédille");
>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
        List<String> sortie = pretraiteur.traiter(entree);

        System.out.println("Entrée : " + entree);
        System.out.println("Sortie (sans accents) : " + sortie);
    }
}


