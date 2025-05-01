package mini_projet;

public class ResultatComparaison {
    private final double score;
    private final Personne personne1;
    private final Personne personne2;

    public ResultatComparaison(double score, Personne p1, Personne p2) {
        this.score = score;
        this.personne1 = p1;
        this.personne2 = p2;
    }

    // Getters
    public double getScore() { return score; }
    public Personne getPersonne1() { return personne1; }
    public Personne getPersonne2() { return personne2; }

}
