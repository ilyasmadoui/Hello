package Part04;

import java.time.LocalDate;

public class EtudiantJavaBeans {

	 private String nom;
	 private String prenom;
	 private LocalDate dateDeNaissance;
	 private String email;
	 private String adresse;
	    
    // Constructeur minimal sans paramètres
	
	public EtudiantJavaBeans() {}
	
	//setters

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
