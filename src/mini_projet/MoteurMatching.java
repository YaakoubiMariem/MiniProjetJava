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
		this.pretraiteurs = pretraiteurs;
		this.generateurCandidats = generateurCandidats;
		this.selectionneur = selectionneur;
		this.comparateurNom = comparateurNom;
	}


	public List<CoupleNomsAvecScore> rechercher(List<NomAvecId> nomAvecIds, String nomRecherche) {
       
        List<NomAvecId> personnesTraitees = new ArrayList<>();
        for (NomAvecId p : nomAvecIds) {
            Nom nom = p.getNom();
            List<String> nomTraite = List.of(nom.getNomComplet());
            for (Pretraiteur pretraiteur : pretraiteurs) {
            	nomTraite = pretraiteur.traiter(nomTraite);
            }
            nom.setNomTraite(nomTraite);
            personnesTraitees.add(new NomAvecId(p.getId(), nom));
        }


        List<String> nomRechercheTraite = new ArrayList<>();
        for (Pretraiteur pretaiteur : pretraiteurs) {
        	nomRechercheTraite = pretaiteur.traiter(List.of(nomRecherche));
        }
        NomAvecId listNomRecherche = new NomAvecId("recherche", new Nom(nomRechercheTraite));
        List<Couple> couples = generateurCandidats.generer(List.of(listNomRecherche), personnesTraitees);

        List<CoupleNomsAvecScore> resultats = new ArrayList<>();
        for (Couple couple : couples) {
            double score = comparateurNom.comparer(couple.getNomAvecId1().getNom(), couple.getNomAvecId2().getNom());
            resultats.add(new CoupleNomsAvecScore(score, couple.getNomAvecId1(), couple.getNomAvecId2()));
        }

        return selectionneur.selectionner(resultats);
    }
	



}
