package mini_projet;
import java.util.List;


public class Nom {
	private String id;
    private String nomComplet;
    private List<String> nomTraite;

    public Nom(String id,String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
		this.nomTraite = null;

    }

    public Nom(List<String> nomTraite) {
		super();
		this.nomTraite = nomTraite;
	}


	public String getNomComplet() {
        return nomComplet;
    }

	public List<String> getNomTraite() {
		return nomTraite;
	}



	public void setNomTraite(List<String> nomTraite) {
		this.nomTraite = nomTraite;
	}

	public String getId() {
		return id;
	}







}
