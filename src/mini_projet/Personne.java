package mini_projet;

public class Personne {
    private String id;
    private Nom nom;

    public Personne(String id, Nom nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public Nom getNom() {
        return nom;
    }
}
