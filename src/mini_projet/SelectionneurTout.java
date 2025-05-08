package mini_projet;

import java.util.List;

/**
 * Une implémentation simple du Selectionneur qui retourne tous les résultats sans filtrage
 */
public class SelectionneurTout implements Selectionneur {

    @Override
    public List<ResultatComparaison> selectionner(List<ResultatComparaison> resultats) {
        // Retourne simplement la liste de résultats sans la modifier
        return resultats;
    }
}