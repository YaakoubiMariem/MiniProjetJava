package mini_projet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Configuration configuration = new Configuration();

    public static void main(String[] args) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenuPrincipal();
            int choix = saisirEntier("Choisissez une option: ");

            switch (choix) {
                case 1:
                    effectuerRecherche();
                    break;
                case 2:
                    comparerDeuxListes();
                    break;
                case 3:
                    dedupliquerListe();
                    break;
                case 4:
                    configurerParametres();
                    break;
                case 5:
                    quitter = true;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        
        System.out.println("Au revoir!");
        scanner.close();
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n=== Application de Matching de Noms ===");
        System.out.println("1. Effectuer une recherche");
        System.out.println("2. Comparer deux listes");
        System.out.println("3. Dédupliquer une liste");
        System.out.println("4. Configurer les paramètres");
        System.out.println("5. Quitter");
        System.out.println("======================================");
    }

    private static void effectuerRecherche() {
        System.out.println("\n--- Recherche d'un nom ---");
        String nomRecherche = saisirTexte("Saisissez le nom à rechercher: ");
        String cheminFichier = saisirTexte("Chemin du fichier CSV contenant la liste: ");

        try {
            RecuperateurCSV recuperateur = new RecuperateurCSV(cheminFichier);
            List<Nom> noms = recuperateur.recupererNom();
            
            if (noms.isEmpty()) {
                System.out.println("Aucun nom trouvé dans le fichier.");
                return;
            }
            
            MoteurMatching moteur = configuration.creerMoteurMatching();
            List<CoupleNomsAvecScore> resultats = moteur.rechercher(noms, nomRecherche);
            
            afficherResultats(resultats);
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void comparerDeuxListes() {
        System.out.println("\n--- Comparaison de deux listes ---");
        String cheminFichier1 = saisirTexte("Chemin du premier fichier CSV: ");
        String cheminFichier2 = saisirTexte("Chemin du second fichier CSV: ");

        try {
            RecuperateurCSV recuperateur1 = new RecuperateurCSV(cheminFichier1);
            RecuperateurCSV recuperateur2 = new RecuperateurCSV(cheminFichier2);
            
            List<Nom> liste1 = recuperateur1.recupererNom();
            List<Nom> liste2 = recuperateur2.recupererNom();
            
            if (liste1.isEmpty() || liste2.isEmpty()) {
                System.out.println("Une des listes est vide.");
                return;
            }
            
            MoteurMatching moteur = configuration.creerMoteurMatching();
            List<CoupleNomsAvecScore> resultats = comparerListes(moteur, liste1, liste2);
            
            afficherResultats(resultats);
            
            String choixExport = saisirTexte("Souhaitez-vous exporter les résultats? (o/n): ");
            if (choixExport.equalsIgnoreCase("o")) {
                String cheminExport = saisirTexte("Chemin du fichier d'export: ");
                exporterResultats(resultats, cheminExport);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la comparaison: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<CoupleNomsAvecScore> comparerListes(MoteurMatching moteur, List<Nom> liste1, List<Nom> liste2) {
        List<CoupleNomsAvecScore> resultats = new ArrayList<>();
        
        for (Nom n1 : liste1) {
            // Prétraitement de la liste1
            List<String> nomTraite = List.of(n1.getNomComplet());
            for (Pretraiteur pretraiteur : configuration.getPretraiteurs()) {
                nomTraite = pretraiteur.traiter(nomTraite);
            }
            n1.setNomTraite(nomTraite);
        }
        
        for (Nom n2 : liste2) {
            // Prétraitement de la liste2
            List<String> nomTraite = List.of(n2.getNomComplet());
            for (Pretraiteur pretraiteur : configuration.getPretraiteurs()) {
                nomTraite = pretraiteur.traiter(nomTraite);
            }
            n2.setNomTraite(nomTraite);
        }
        
        // Génération des candidats
        List<Couple> couples = configuration.getGenerateurCandidats().generer(liste1, liste2);
        
        // Comparaison et calcul des scores
        for (Couple couple : couples) {
            double score = configuration.getComparateurNom().comparer(couple.getNom1(), couple.getNom2());
            resultats.add(new CoupleNomsAvecScore(score, couple.getNom1(), couple.getNom2()));
        }
        
        // Sélection des résultats
        return configuration.getSelectionneur().selectionner(resultats);
    }

    private static void dedupliquerListe() {
        System.out.println("\n--- Déduplication d'une liste ---");
        String cheminFichier = saisirTexte("Chemin du fichier CSV à dédupliquer: ");

        try {
            RecuperateurCSV recuperateur = new RecuperateurCSV(cheminFichier);
            List<Nom> noms = recuperateur.recupererNom();
            
            if (noms.isEmpty()) {
                System.out.println("Aucun nom trouvé dans le fichier.");
                return;
            }
            
            MoteurMatching moteur = configuration.creerMoteurMatching();
            List<CoupleNomsAvecScore> doublons = detecterDoublons(moteur, noms);
            
            System.out.println("\nDoublons détectés: " + doublons.size());
            afficherResultats(doublons);
            
            String choixExport = saisirTexte("Souhaitez-vous exporter les doublons? (o/n): ");
            if (choixExport.equalsIgnoreCase("o")) {
                String cheminExport = saisirTexte("Chemin du fichier d'export: ");
                exporterResultats(doublons, cheminExport);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la déduplication: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<CoupleNomsAvecScore> detecterDoublons(MoteurMatching moteur, List<Nom> noms) {
        List<CoupleNomsAvecScore> doublons = new ArrayList<>();
        
        // Prétraitement de la liste
        for (Nom n : noms) {
            List<String> nomTraite = List.of(n.getNomComplet());
            for (Pretraiteur pretraiteur : configuration.getPretraiteurs()) {
                nomTraite = pretraiteur.traiter(nomTraite);
            }
            n.setNomTraite(nomTraite);
        }
        
        // Génération de tous les couples possibles (sans comparer un nom avec lui-même)
        List<Couple> couples = new ArrayList<>();
        for (int i = 0; i < noms.size(); i++) {
            for (int j = i + 1; j < noms.size(); j++) {
                couples.add(new Couple(noms.get(i), noms.get(j)));
            }
        }
        
        // Comparaison et calcul des scores
        for (Couple couple : couples) {
            double score = configuration.getComparateurNom().comparer(couple.getNom1(), couple.getNom2());
            doublons.add(new CoupleNomsAvecScore(score, couple.getNom1(), couple.getNom2()));
        }
        
        // Sélection des résultats
        return configuration.getSelectionneur().selectionner(doublons);
    }

    private static void configurerParametres() {
        boolean retour = false;
        
        while (!retour) {
            afficherMenuConfiguration();
            int choix = saisirEntier("Choisissez une option: ");
            
            switch (choix) {
                case 1:
                    configurerPretraitements();
                    break;
                case 2:
                    configurerStructureIndex();
                    break;
                case 3:
                    configurerMesureComparaison();
                    break;
                case 4:
                    configurerParametresResultats();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenuConfiguration() {
        System.out.println("\n=== Configuration des paramètres ===");
        System.out.println("1. Choisir les prétraitements");
        System.out.println("2. Choisir une structure d'index");
        System.out.println("3. Choisir une mesure de comparaison");
        System.out.println("4. Définir le seuil ou nombre de résultats");
        System.out.println("5. Retour au menu principal");
        System.out.println("======================================");
    }

    private static void configurerPretraitements() {
        System.out.println("\n--- Configuration des prétraitements ---");
        
        List<Pretraiteur> pretraiteursActifs = new ArrayList<>();
        
        System.out.println("Choisissez les prétraitements à activer:");
        System.out.println("1. Conversion en minuscules");
        System.out.println("2. Décomposition (séparation des mots)");
        System.out.println("3. Suppression des accents");
        System.out.println("4. Tout sélectionner");
        System.out.println("5. Aucun prétraitement");
        
        String choix = saisirTexte("Entrez les numéros séparés par des espaces (ex: 1 3): ");
        String[] choixArray = choix.split(" ");
        
        boolean toutSelectionner = false;
        boolean aucunPretraitement = false;
        
        for (String c : choixArray) {
            switch (c.trim()) {
                case "1":
                    pretraiteursActifs.add(new PretraiteurMinuscule());
                    break;
                case "2":
                    pretraiteursActifs.add(new PretraiteurDecomposition());
                    break;
                case "3":
                    pretraiteursActifs.add(new PretraiteurSansAccents());
                    break;
                case "4":
                    toutSelectionner = true;
                    break;
                case "5":
                    aucunPretraitement = true;
                    break;
            }
        }
        
        if (toutSelectionner) {
            pretraiteursActifs.clear();
            pretraiteursActifs.add(new PretraiteurMinuscule());
            pretraiteursActifs.add(new PretraiteurDecomposition());
            pretraiteursActifs.add(new PretraiteurSansAccents());
        } else if (aucunPretraitement) {
            pretraiteursActifs.clear();
            pretraiteursActifs.add(new PretraiteurIdentite());
        }
        
        configuration.setPretraiteurs(pretraiteursActifs);
        System.out.println("Prétraitements configurés avec succès.");
    }

    private static void configurerStructureIndex() {
        System.out.println("\n--- Configuration de la structure d'index ---");
        
        System.out.println("Choisissez une structure d'index:");
        System.out.println("1. Sans index (tous les candidats)");
        System.out.println("2. Index par taille de nom (avec intervalle)");
        System.out.println("3. Index par nombre de mots (avec intervalle)");
        
        int choix = saisirEntier("Votre choix: ");
        
        switch (choix) {
            case 1:
                configuration.setGenerateurCandidats(new GenerateurCandidatsTous());
                System.out.println("Structure d'index: Sans index (tous les candidats)");
                break;
            case 2:
                int intervalleTaille = saisirEntier("Intervalle de taille: ");
                configuration.setGenerateurCandidats(new GenerateurParTailleNomAvecIndex(intervalleTaille));
                System.out.println("Structure d'index: Index par taille de nom (intervalle: " + intervalleTaille + ")");
                break;
            case 3:
                int intervalleMots = saisirEntier("Intervalle de nombre de mots: ");
                configuration.setGenerateurCandidats(new GenerateurParMotsCommunsAvecIndex(intervalleMots));
                System.out.println("Structure d'index: Index par nombre de mots (intervalle: " + intervalleMots + ")");
                break;
            default:
                System.out.println("Option invalide. Conserve la configuration actuelle.");
        }
    }

    private static void configurerMesureComparaison() {
        System.out.println("\n--- Configuration de la mesure de comparaison ---");
        
        System.out.println("Choisissez une mesure de comparaison:");
        System.out.println("1. Égalité exacte");
        System.out.println("2. Mots communs");
        System.out.println("3. Jaro-Winkler (similarité)");
        System.out.println("4. Levenshtein (distance)");
        System.out.println("5. Jaccard (similarité)");
        System.out.println("6. Cosinus (similarité)");
        
        int choix = saisirEntier("Votre choix: ");
        
        switch (choix) {
            case 1:
                configuration.setComparateurNom(new ComparateurNomEquals());
                System.out.println("Mesure de comparaison: Égalité exacte");
                break;
            case 2:
                configuration.setComparateurNom(new ComparateurNomParMotsCommuns());
                System.out.println("Mesure de comparaison: Mots communs");
                break;
            case 3:
                configuration.setComparateurNom(new ComparateurNomTraiteAvecMesure(new ComparateurJaroWinkler()));
                System.out.println("Mesure de comparaison: Jaro-Winkler (similarité)");
                break;
            case 4:
                configuration.setComparateurNom(new ComparateurNomTraiteAvecMesure(new ComparateurLevenshtein()));
                System.out.println("Mesure de comparaison: Levenshtein (distance)");
                break;
            case 5:
                configuration.setComparateurNom(new ComparateurNomTraiteAvecMesure(new ComparateurJaccard()));
                System.out.println("Mesure de comparaison: Jaccard (similarité)");
                break;
            case 6:
                configuration.setComparateurNom(new ComparateurNomTraiteAvecMesure(new ComparateurCosinus()));
                System.out.println("Mesure de comparaison: Cosinus (similarité)");
                break;
            default:
                System.out.println("Option invalide. Conserve la configuration actuelle.");
        }
    }

    private static void configurerParametresResultats() {
        System.out.println("\n--- Configuration des paramètres de résultats ---");
        
        System.out.println("Choisissez un mode de sélection:");
        System.out.println("1. Par seuil de similarité");
        System.out.println("2. Par nombre de meilleurs résultats");
        
        int choix = saisirEntier("Votre choix: ");
        
        switch (choix) {
            case 1:
                double seuil = saisirDouble("Seuil de similarité (entre 0 et 1): ");
                configuration.setSeuilSimilarite(seuil);
                configuration.changerModeSelectionSeuil();
                System.out.println("Mode de sélection: Par seuil de similarité (" + seuil + ")");
                break;
            case 2:
                int nombre = saisirEntier("Nombre de meilleurs résultats: ");
                configuration.setNombreResultats(nombre);
                configuration.changerModeSelectionNMeilleur();
                System.out.println("Mode de sélection: Par nombre de meilleurs résultats (" + nombre + ")");
                break;
            default:
                System.out.println("Option invalide. Conserve la configuration actuelle.");
        }
    }

    private static void afficherResultats(List<CoupleNomsAvecScore> resultats) {
        if (resultats.isEmpty()) {
            System.out.println("Aucun résultat trouvé.");
            return;
        }
        
        System.out.println("\n=== Résultats ===");
        System.out.println("Nombre de résultats: " + resultats.size());
        
        System.out.printf("%-5s %-30s %-30s %-10s%n", "N°", "Nom 1", "Nom 2", "Score");
        System.out.println("--------------------------------------------");
        
        int index = 1;
        for (CoupleNomsAvecScore couple : resultats) {
            System.out.printf("%-5d %-30s %-30s %-10.4f%n", 
                    index++, 
                    couple.getNom1().getNomComplet(), 
                    couple.getNom2().getNomComplet(), 
                    couple.getScore());
        }
    }
    
    private static void exporterResultats(List<CoupleNomsAvecScore> resultats, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            writer.write("Nom1,Nom2,Score\n");
            
            for (CoupleNomsAvecScore couple : resultats) {
                writer.write(String.format("%s,%s,%.4f\n", 
                        couple.getNom1().getNomComplet().replace(",", " "), 
                        couple.getNom2().getNomComplet().replace(",", " "), 
                        couple.getScore()));
            }
            
            System.out.println("Résultats exportés avec succès vers: " + cheminFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'export des résultats: " + e.getMessage());
        }
    }

    private static String saisirTexte(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int saisirEntier(String message) {
        while (true) {
            try {
                System.out.print(message);
                int valeur = Integer.parseInt(scanner.nextLine());
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre entier valide.");
            }
        }
    }

    private static double saisirDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double valeur = Double.parseDouble(scanner.nextLine());
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre décimal valide.");
            }
        }
    }
}