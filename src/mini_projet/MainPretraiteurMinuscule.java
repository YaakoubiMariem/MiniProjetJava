package mini_projet;
<<<<<<< HEAD
import java.util.List;

public class MainPretraiteurMinuscule {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurMinuscule();

        List<String> entree = List.of("Mariem YAAkoubI","ဦးေဇတ္တြန္း ");
=======


import java.util.List;

public class MainPretraiteurMinuscule {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurMinuscule();

        List<String> entree = List.of("Mariem YAAkoubI");
>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
        List<String> sortie = pretraiteur.traiter(entree);

        System.out.println("Entrée : " + entree);
        System.out.println("Sortie (minuscules) : " + sortie);
    }
}


