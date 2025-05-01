package mini_projet;

import java.util.List;

public class Nom {
    private String nom;
    private List<String> mots;

    public Nom(String nom) {
        this.nom = nom;
    }

    public Nom(List<String> mots) {
		super();
		this.mots = mots;
	}

	public String getNom() {
        return nom;
    }

	public List<String> getMots() {
		return mots;
	}






}
