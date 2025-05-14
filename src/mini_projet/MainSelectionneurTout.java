package mini_projet;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/YaakoubiMariem/MiniProjetJava.git
import java.util.List;

public class MainSelectionneurTout {

    public static void main(String[] args) {
        Selectionneur selectionneur = new SelectionneurTout();
        Nom n1 = new Nom("1", "Jean Dupont");
        Nom n2 = new Nom("2", "Paul Martin");

        CoupleNomsAvecScore c1 = new CoupleNomsAvecScore(0.8, n1, n2);
        CoupleNomsAvecScore c2 = new CoupleNomsAvecScore(1.0, n1, n1);

        List<CoupleNomsAvecScore> resultats = selectionneur.selectionner(List.of(c1, c2));
        for (CoupleNomsAvecScore c : resultats) {
            System.out.println(c.getNom1().getNomComplet() + " - " +
                               c.getNom2().getNomComplet() + " => score: " + c.getScore());
        }
    }
}


