package mini_projet;

import java.util.List;

public class MainPretraiteurDecomposition {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurDecomposition();

        List<String> entree = List.of("Mouhamed  Yassine Yaakoubi");
        List<String> sortie = pretraiteur.traiter(entree);

        System.out.println("Entrée : " + entree);
        System.out.println("Sortie (découpée) : " + sortie);
    }
}


