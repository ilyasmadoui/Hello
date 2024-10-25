package dz.Biskra.Info.exo2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Etudiant {

	private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String adresseMail;
    private String adressePostale;
    private List<Note> notes = new ArrayList<>();

    // Constructeur 
    public Etudiant(String nom, String prenom, LocalDate dateNaissance, String adresseMail, String adressePostale) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresseMail = adresseMail;
        this.adressePostale = adressePostale;
    }
    
    //method noter 
    public void noter (Matiere matiere,double nombre) {
    	Note novelle = new Note(matiere, nombre);
    	notes.add(novelle);
    }
    
    public double calculerMoyenne(double moyenne) {
    	double sommefinal=0;
    	double sommeNotes = 0;
    	double sommecoefficient = 0 ;
    	for (Note note : notes) {
    		sommeNotes++;
    		sommeNotes += note.getNombre() * note.getMatiere().getCoefficient();
    		sommecoefficient += note.getMatiere().getCoefficient();
    	}
    	sommefinal = sommeNotes / sommecoefficient;
    	return sommefinal;
    }

    public List<Note> getNotes() {
		return notes;
	}

	// Getters et setters 
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    // Méthode pour afficher les informations 
    public String toString() {
        return "Nom : " + nom + "\n" +
               "Prénom : " + prenom + "\n" +
               "Date de Naissance : " + dateNaissance + "\n" +
               "Adresse Mail : " + adresseMail + "\n" +
               "Adresse Postale : " + adressePostale;
    }

}
