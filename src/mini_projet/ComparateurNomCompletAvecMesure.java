package mini_projet;

public class ComparateurNomCompletAvecMesure implements ComparateurNom{

	 private ComparateurChaine comparateurChaine;
	    
	    public ComparateurNomCompletAvecMesure(ComparateurChaine comparateurChaine) {
	        this.comparateurChaine = comparateurChaine;
	    }
	    
	    public double comparer(Nom n1, Nom n2) {
	        if (n1 == null || n2 == null) {
	            return 0.0;
	        }
	        
	        String nomComplet1 = n1.getNomComplet();
	        String nomComplet2 = n2.getNomComplet();
	        
	        if (nomComplet1 == null || nomComplet2 == null) {
	            return 0.0;
	        }
	        
	        double score = comparateurChaine.comparer(nomComplet1, nomComplet2);
	        
	        // Si le comparateur retourne une distance, convertir en similarité
	        if (comparateurChaine.getType() == TypeMesure.DISTANCE) {
	            score = 1.0 - score;
	        }
	        
	        return score;
	    }
	}
