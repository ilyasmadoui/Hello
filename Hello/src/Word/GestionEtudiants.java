package Word;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

class GestionEtudiants {
    public static void main(String[] args) {
        // Création d'une instance de la classe Etudiant
        LocalDate dateNaissance = LocalDate.of(2002, Month.SEPTEMBER, 9);
        Etudiant lolo = new Etudiant("ilyas", "madoui", dateNaissance, "ilyasmadoui@gmail.com", "Biskra");
        Etudiant toto = new Etudiant("ilyas", "madoui", dateNaissance, "ilyasmadoui@gmail.com", "Biskra");

        if (toto == lolo) {
            System.out.println("toto et lolo sont le même objet (==)");
        } else {
            System.out.println("toto et lolo sont des objets différents (==)");
        }
        toto = lolo;

        // Vérification 
        if (toto == lolo) {
            System.out.println("toto et lolo sont maintenant le même objet (==)");
        }

        // Affichage des informations de l'étudiant
        System.out.println(lolo.toString());
        lolo.setNom("malek");
        lolo.setPrenom("Merad");
        
     //  dans un fichier
        try (FileWriter writer = new FileWriter("etudiant.txt")) {
            writer.write(lolo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Création d'un département
        Departement informatique = new Departement("Informatique", "Biskra");

        // Ajout des étudiants au département
        informatique.ajouterEtudiant(lolo);
        informatique.ajouterEtudiant(toto);

        // Affichage des informations du département et des étudiants inscrits
        System.out.println(informatique);
    
        informatique.desinscrire(lolo);

        // Affichage des informations après désinscription
        System.out.println("Après désinscription :");
        System.out.println(informatique);
    
    }
    
}

