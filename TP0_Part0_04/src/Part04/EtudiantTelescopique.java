package Part04;

import java.time.LocalDate;

public class EtudiantTelescopique {

	private String nom;
    private String prenom;
    private LocalDate dateN;
    private String email;
    
    public EtudiantTelescopique(String nom,String prenom) {
    	this.nom = nom;
    	this.prenom = prenom;
    }
    
    public EtudiantTelescopique(String nom ,String prenom, LocalDate dateN) {
    	this(nom,prenom);
    	this.dateN = dateN;
    }
    
    public EtudiantTelescopique(String nom, String prenom , String email) {
    	this(nom, prenom);
    	this.email = email;
    }
    
    public String toString() {
        return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", dateN=" + dateN + ", email=" + email + "]";
    }

}
