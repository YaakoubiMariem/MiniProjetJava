package mini_projet;
import java.util.List;

public class ComparateurNomTraiteAvecMesure  implements ComparateurNom {

    private final ComparateurChaine comparateurChaine;
    
    public ComparateurNomTraiteAvecMesure(ComparateurChaine comparateurChaine) {
        this.comparateurChaine = comparateurChaine;
    }
    
    @Override
    public double comparer(Nom n1, Nom n2) {
        if (n1 == null || n2 == null) {
            return 0.0;
        }
        
        List<String> motsTraites1 = n1.getNomTraite();
        List<String> motsTraites2 = n2.getNomTraite();
        
        if (motsTraites1 == null || motsTraites2 == null || 
            motsTraites1.isEmpty() || motsTraites2.isEmpty()) {
            return 0.0;
        }
        
        // Calcul du score moyen entre tous les mots traités
        double scoreTotal = 0.0;
        int comparaisonsEffectuees = 0;
        
        for (String mot1 : motsTraites1) {
            for (String mot2 : motsTraites2) {
                double score = comparateurChaine.comparer(mot1, mot2);
                
                // Si le comparateur retourne une distance, convertir en similarité
                if (comparateurChaine.getType() == TypeMesure.DISTANCE) {
                    score = 1.0 - score;
                }
                
                scoreTotal += score;
                comparaisonsEffectuees++;
            }
        }
        
        return comparaisonsEffectuees > 0 ? scoreTotal / comparaisonsEffectuees : 0.0;
    }
}
