package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class MoteurMatching {
    private final static int NBMAXPRETRAITEMENTS = 100;
    private Pretraitements[] pretraitements = new Pretraitements[NBMAXPRETRAITEMENTS];
    private GenerateurCandidats generateurCandidats;
    private Selectionneur selectionneur;
    private ComparateurNom comparateurNom;

    public MoteurMatching(ComparateurNom comparateurNom, Selectionneur selectionneur, GenerateurCandidats generateurCandidats) {
        this.comparateurNom = comparateurNom;
        this.selectionneur = selectionneur;
        this.generateurCandidats = generateurCandidats;
    }

    public List<ResultatComparaison> rechercher(List<Personne> personnes, String nomRecherche) {
       
    	List<Personne> personnesTraitees = new ArrayList<>();
        for (Personne personne : personnes) {
            List<String> nomTraite = personne.getNom().getMots();
            for (Pretraitements p : pretraitements) {
                if (p != null) {
                    nomTraite = p.traiter(nomTraite);
                }
            }
            personnesTraitees.add(new Personne(personne.getId(), new Nom(nomTraite)));
        }


        List<String> nomRechercheListe = List.of(nomRecherche);
        for (Pretraitements p : pretraitements) {
            if (p != null) {
                nomRechercheListe = p.traiter(nomRechercheListe);
            }
        }
        Personne cible = new Personne("recherche", new Nom(nomRechercheListe));

        List<Personne> cibleList = List.of(cible);
        List<Couple> couples = generateurCandidats.generer(cibleList, personnesTraitees);

        List<ResultatComparaison> resultats = new ArrayList<>();
        for (Couple couple : couples) {
            double score = comparateurNom.comparer(couple.getP1().getNom(), couple.getP2().getNom());
            resultats.add(new ResultatComparaison(score, couple.getP1(), couple.getP2()));
        }

        return selectionneur.selectionner(resultats);
    }


}
