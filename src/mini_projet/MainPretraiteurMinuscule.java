package mini_projet;


import java.util.List;

public class MainPretraiteurMinuscule {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurMinuscule();

        List<String> entree = List.of("Mariem YAAkoubI","ဦးေဇတ္တြန္း ");
        List<String> sortie = pretraiteur.traiter(entree);

        System.out.println("Entrée : " + entree);
        System.out.println("Sortie (minuscules) : " + sortie);
    }
}


