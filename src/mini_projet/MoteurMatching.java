package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class MoteurMatching {
    private final List<Pretraitements> pretraitements;
    private GenerateurCandidats generateurCandidats;
    private Selectionneur selectionneur;
    private ComparateurNom comparateurNom;



    public MoteurMatching(List<Pretraitements> pretraitements, GenerateurCandidats generateurCandidats,
			Selectionneur selectionneur, ComparateurNom comparateurNom) {
		this.pretraitements = pretraitements;
		this.generateurCandidats = generateurCandidats;
		this.selectionneur = selectionneur;
		this.comparateurNom = comparateurNom;
	}



	public List<ResultatComparaison> rechercher(List<Personne> personnes, String nomRecherche) {
       
        List<Personne> personnesTraitees = new ArrayList<>();
        for (Personne p : personnes) {
            Nom nom = p.getNom();
            List<String> nomTraite = List.of(nom.getNomComplet());
            for (Pretraitements pretraitement : pretraitements) {
            	nomTraite = pretraitement.traiter(nomTraite);
            }
            nom.setNomTraite(nomTraite);
            personnesTraitees.add(new Personne(p.getId(), nom));
        }


        List<String> nomRechercheTraite = new ArrayList<>();
        for (Pretraitements pretraitement : pretraitements) {
        	nomRechercheTraite = pretraitement.traiter(List.of(nomRecherche));
        }
        Personne listNomRecherche = new Personne("recherche", new Nom(nomRechercheTraite));
        List<Couple> couples = generateurCandidats.generer(List.of(listNomRecherche), personnesTraitees);

        List<ResultatComparaison> resultats = new ArrayList<>();
        for (Couple couple : couples) {
            double score = comparateurNom.comparer(couple.getP1().getNom(), couple.getP2().getNom());
            resultats.add(new ResultatComparaison(score, couple.getP1(), couple.getP2()));
        }

        return selectionneur.selectionner(resultats);
    }
	



}
