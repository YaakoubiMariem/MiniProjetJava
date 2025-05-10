package mini_projet;

import java.util.List;

public class MainPretraiteurSansAccents {
    public static void main(String[] args) {
        Pretraiteur pretraiteur = new PretraiteurSansAccents();

        List<String> entree = List.of("René Prévert", "Hélène Müller", "François Cédille");
        List<String> sortie = pretraiteur.traiter(entree);

        System.out.println("Entrée : " + entree);
        System.out.println("Sortie (sans accents) : " + sortie);
    }
}

