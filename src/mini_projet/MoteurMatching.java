package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class MoteurMatching {
    private List<Pretraiteur> pretraiteurs;
    private GenerateurCandidats generateurCandidats;
    private Selectionneur selectionneur;
    private ComparateurNom comparateurNom;


    public MoteurMatching(List<Pretraiteur> pretraiteurs, GenerateurCandidats generateurCandidats,
			Selectionneur selectionneur, ComparateurNom comparateurNom) {
		this.pretraiteurs = pretraiteurs= new ArrayList<>();
		this.generateurCandidats = generateurCandidats;
		this.selectionneur = selectionneur;
		this.comparateurNom = comparateurNom;
	}


	public List<CoupleNomsAvecScore> rechercher(List<Nom> noms, String nomRecherche) {
       
        for (Nom n : noms) {
        	List<String> nomTraite = List.of(n.getNomComplet());
            for (Pretraiteur pretraiteur : pretraiteurs) {
            	nomTraite = pretraiteur.traiter(nomTraite);
            }
            n.setNomTraite(nomTraite);
        }
 
        Nom nomARecherche = new Nom("recherche", nomRecherche);
        List<String> nomRechercheTraite = List.of(nomRecherche);
        for (Pretraiteur pretaiteur : pretraiteurs) {
        	nomRechercheTraite = pretaiteur.traiter(nomRechercheTraite);
        }
        nomARecherche.setNomTraite(nomRechercheTraite);

        
        List<Couple> couples = generateurCandidats.generer(List.of(nomARecherche), noms);

        List<CoupleNomsAvecScore> resultats = new ArrayList<>();
        for (Couple couple : couples) {
            double score = comparateurNom.comparer(couple.getNom1(), couple.getNom2());
            resultats.add(new CoupleNomsAvecScore(score, couple.getNom1(), couple.getNom2()));
        }

        return selectionneur.selectionner(resultats);
    }
	



}
