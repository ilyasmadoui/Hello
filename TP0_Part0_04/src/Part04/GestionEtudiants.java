package Part04;

import java.time.LocalDate;
import java.time.Month;

import Part04.Etudiant.EtudiantBuilder;

public class GestionEtudiants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EtudiantTelescopique etd1 = new EtudiantTelescopique("ilyas", "madoui");
		EtudiantTelescopique etd2 = new EtudiantTelescopique("Malek", "Merad",LocalDate.of(1999, Month.DECEMBER, 22));
		EtudiantTelescopique etd3 = new EtudiantTelescopique("Mohamed", "Maklid","Mohamed22@gmail.com");
		EtudiantJavaBeans toto = new EtudiantJavaBeans();
		
		System.out.println(etd1);
	    System.out.println(etd2);
	    System.out.println(etd3);
		System.out.println("-----------------------------------------------------------------------------");
		toto.setNom("Ben Ali");
		toto.setDateDeNaissance(LocalDate.of(2002,Month.DECEMBER, 11));
		toto.setPrenom("Anis");
		toto.setAdresse("99, av. Zaatcha, 07000 Biskra");
		toto.setEmail("AnisBenAli@gmail.com");
		
		
		Etudiant etudiant1 = new Etudiant.EtudiantBuilder("ilyas", "madoui")
		 .age(22)
         .email("ilyasmadoui@gmail.com")
         .adresse("Biskra")
         .build();
         System.out.println(etudiant1);
         
         Etudiant etudiant2 = new Etudiant.EtudiantBuilder("Malek", "Merad")
                 .age(20)
                 .build();
         System.out.println(etudiant2);
         
         Etudiant etudiant3 = new Etudiant.EtudiantBuilder("Maklid ", "Mohamed")
                 .build();
         System.out.println(etudiant3);
		
	}

}
