package Word;

import java.util.ArrayList;

public class Departement {

    private String specialite;
    private String adresse;
    private ArrayList<Etudiant> etudiants;

    // Constructeur
    public Departement(String specialite, String adresse) {
        this.specialite = specialite;
        this.adresse = adresse;
        this.etudiants = new ArrayList<>();  // Initialisation de la liste des étudiants
    }

    // Méthode pour ajouter un étudiant au département
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }
    
    // Supprime l'étudiant de la liste
    public void desinscrire(Etudiant etudiant) {
        etudiants.remove(etudiant); 
    }

    // Méthode toString() 
    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        resultat.append("Spécialité : ").append(specialite).append("\n");
        resultat.append("Adresse : ").append(adresse).append("\n");
        resultat.append("Liste des étudiants inscrits : \n");

        for (Etudiant etudiant : etudiants) {
            resultat.append(etudiant).append("\n");
        }

        return resultat.toString();
    }
}
