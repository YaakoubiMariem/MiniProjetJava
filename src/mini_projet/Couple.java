package mini_projet;
public class Couple {
    private final Nom nom1;
    private final Nom nom2;

    public Couple(Nom nom1, Nom nom2) {
        this.nom1 = nom1;
        this.nom2 = nom2;
    }

    public Nom getNom1() { return nom1; }
    public Nom getNom2() { return nom2; }
}

