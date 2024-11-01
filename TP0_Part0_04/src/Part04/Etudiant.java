package Part04;

public class Etudiant {

	private final String nom;       
    private final String prenom;    
    private final int age;          
    private final String email;     
    private final String adresse;   

    private Etudiant(EtudiantBuilder builder) {
        this.nom = builder.nom;
        this.prenom = builder.prenom;
        this.age = builder.age;
        this.email = builder.email;
        this.adresse = builder.adresse;
    }

    // Classe interne  (builder)
    public static class EtudiantBuilder {
        private final String nom;
        private final String prenom;
        private int age;
        private String email;
        private String adresse;

        public EtudiantBuilder(String nom, String prenom) {
            this.nom = nom;
            this.prenom = prenom;
        }

        public EtudiantBuilder age(int age) {
            this.age = age;
            return this;
        }

        public EtudiantBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EtudiantBuilder adresse(String adresse) {
            this.adresse = adresse;
            return this;
        }

        // Retourne l'objet Etudiant final
        public Etudiant build() {
            Etudiant etudiant = new Etudiant(this);
            validateEtudiantObject(etudiant);
            return etudiant;
        }

        private void validateEtudiantObject(Etudiant etudiant) {

        }
    }

    @Override
    public String toString() {
        return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", email=" + email + ", adresse=" + adresse + "]";
    }
}