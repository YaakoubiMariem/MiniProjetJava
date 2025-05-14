package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private List<Pretraiteur> pretraiteurs;
    private GenerateurCandidats generateurCandidats;
    private ComparateurNom comparateurNom;
    private Selectionneur selectionneur;
    private double seuilSimilarite;
    private int nombreResultats;
    
    public Configuration() {
        // Valeurs par défaut
        this.pretraiteurs = new ArrayList<>();
        this.pretraiteurs.add(new PretraiteurMinuscule());
        this.pretraiteurs.add(new PretraiteurDecomposition());
        this.pretraiteurs.add(new PretraiteurSansAccents());
        
        this.generateurCandidats = new GenerateurCandidatsTous();
        
        // Par défaut, on utilise Jaro-Winkler comme mesure de similarité
        ComparateurJaroWinkler comparateurChaine = new ComparateurJaroWinkler();
        this.comparateurNom = new ComparateurNomTraiteAvecMesure(comparateurChaine);
        
        this.seuilSimilarite = 0.8; // Seuil de similarité par défaut
        this.nombreResultats = 10;  // Nombre de résultats par défaut
        
        // Par défaut, on utilise un sélectionneur de seuil
        this.selectionneur = new SelectionneurSeuil(seuilSimilarite);
    }
    
    public List<Pretraiteur> getPretraiteurs() {
        return pretraiteurs;
    }
    
    public void setPretraiteurs(List<Pretraiteur> pretraiteurs) {
        this.pretraiteurs = pretraiteurs;
    }
    
    public GenerateurCandidats getGenerateurCandidats() {
        return generateurCandidats;
    }
    
    public void setGenerateurCandidats(GenerateurCandidats generateurCandidats) {
        this.generateurCandidats = generateurCandidats;
    }
    
    public ComparateurNom getComparateurNom() {
        return comparateurNom;
    }
    
    public void setComparateurNom(ComparateurNom comparateurNom) {
        this.comparateurNom = comparateurNom;
    }
    
    public Selectionneur getSelectionneur() {
        return selectionneur;
    }
    
    public void setSelectionneur(Selectionneur selectionneur) {
        this.selectionneur = selectionneur;
    }
    
    public double getSeuilSimilarite() {
        return seuilSimilarite;
    }
    
    public void setSeuilSimilarite(double seuilSimilarite) {
        this.seuilSimilarite = seuilSimilarite;
        // Mettre à jour le sélectionneur si c'est un SelectionneurSeuil
        if (this.selectionneur instanceof SelectionneurSeuil) {
            this.selectionneur = new SelectionneurSeuil(seuilSimilarite);
        }
    }
    
    public int getNombreResultats() {
        return nombreResultats;
    }
    
    public void setNombreResultats(int nombreResultats) {
        this.nombreResultats = nombreResultats;
        // Mettre à jour le sélectionneur si c'est un SelectionneurNMeilleur
        if (this.selectionneur instanceof SelectionneurNMeilleur) {
            this.selectionneur = new SelectionneurNMeilleur(nombreResultats);
        }
    }
    
    public void changerModeSelectionSeuil() {
        this.selectionneur = new SelectionneurSeuil(seuilSimilarite);
    }
    
    public void changerModeSelectionNMeilleur() {
        this.selectionneur = new SelectionneurNMeilleur(nombreResultats);
    }
    
    public MoteurMatching creerMoteurMatching() {
        return new MoteurMatching(pretraiteurs, generateurCandidats, selectionneur, comparateurNom);
    }
}