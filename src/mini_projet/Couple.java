package mini_projet;

public class Couple {
    private final NomAvecId nomAvecId1;
    private final NomAvecId nomAvecId2;

    public Couple(NomAvecId nomAvecId1, NomAvecId nomAvecId2) {
        this.nomAvecId1 = nomAvecId1;
        this.nomAvecId2 = nomAvecId2;
    }

    public NomAvecId getNomAvecId1() { return nomAvecId1; }
    public NomAvecId getNomAvecId2() { return nomAvecId2; }
}
