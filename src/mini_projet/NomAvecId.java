package mini_projet;
public class NomAvecId {
	
	
    private String id;
    private Nom nom;

    public NomAvecId(String id, Nom nom) {
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
