package mini_projet;
import java.util.ArrayList;
import java.util.List;

public class MainGenerateurParMotsCommunsSansIndex {
	
	 public static void main(String[] args) {
	        // Créer des instances de noms avec des tailles de noms traités
	        Nom nom1 = new Nom("1", "Juan Carlos Pérez García");
	        nom1.setNomTraite(List.of("Juan", "Carlos", "Pérez", "García"));
	        
	        Nom nom2 = new Nom("2", "Anna Marie Dubois");
	        nom2.setNomTraite(List.of("Anna", "Marie", "Dubois"));
	        
	        Nom nom3 = new Nom("3", "Mikhail Sergeyevich Gorbachev");
	        nom3.setNomTraite(List.of("Mikhail", "Sergeyevich", "Gorbachev"));
	        
	        Nom nom4 = new Nom("4", "Li Wei Zhang");
	        nom4.setNomTraite(List.of("Li", "Wei", "Zhang"));
	        
	        Nom nom5 = new Nom("5", "Mohammed  Jinnah");
	        nom5.setNomTraite(List.of("Mohammed", "Jinnah"));
	        
	        // Liste des noms pour chaque liste
	        List<Nom> liste1 = new ArrayList<>();
	        liste1.add(nom1);
	        liste1.add(nom2);
	        liste1.add(nom3);
	        
	        List<Nom> liste2 = new ArrayList<>();
	        liste2.add(nom3);
	        liste2.add(nom4);
	        liste2.add(nom5);
	        
	        // Créer le générateur avec un intervalle de 1
	        GenerateurParMotsCommunsSansIndex generateur = new GenerateurParMotsCommunsSansIndex(1);
	        
	        // Générer les couples
	        List<Couple> couples = generateur.generer(liste1, liste2);
	        
	        // Afficher les couples générés
	        System.out.println("Couples générés :");
	        for (Couple couple : couples) {
	            System.out.println("Couple: " + couple.getNom1().getNomComplet() + " - " + couple.getNom2().getNomComplet());
	        }
	    }
	}