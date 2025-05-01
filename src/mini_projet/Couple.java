package mini_projet;


public class Couple {
    private final Personne p1;
    private final Personne p2;

    public Couple(Personne p1, Personne p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Personne getP1() { return p1; }
    public Personne getP2() { return p2; }
}
