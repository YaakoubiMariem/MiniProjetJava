package mini_projet;
import java.util.ArrayList;
import java.util.List;

public class SelectionneurSeuil implements Selectionneur {
    private final double seuil;
    
    public SelectionneurSeuil(double seuil) {
        this.seuil = seuil;
    }
    
    public List<CoupleNomsAvecScore> selectionner(List<CoupleNomsAvecScore> resultats) {
        List<CoupleNomsAvecScore> resultatsFiltre = new ArrayList<>();
        
        for (CoupleNomsAvecScore couple : resultats) {
            if (couple.getScore() >= seuil) {
                resultatsFiltre.add(couple);
            }
        }    
        return resultatsFiltre;
    }
}
