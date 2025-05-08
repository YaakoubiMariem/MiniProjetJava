package mini_projet;


public class CoupleNomsAvecScore {
    private final double score;
    private final NomAvecId personne1;
    private final NomAvecId personne2;

    public CoupleNomsAvecScore(double score, NomAvecId p1, NomAvecId p2) {
        this.score = score;
        this.personne1 = p1;
        this.personne2 = p2;
    }

    public double getScore() { return score; }
    public NomAvecId getPersonne1() { return personne1; }
    public NomAvecId getPersonne2() { return personne2; }

}
