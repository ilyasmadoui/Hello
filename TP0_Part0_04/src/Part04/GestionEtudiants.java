package Part04;

import java.time.LocalDate;
import java.time.Month;

public class GestionEtudiants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EtudiantTelescopique etd1 = new EtudiantTelescopique("ilyas", "madoui");
		EtudiantTelescopique etd2 = new EtudiantTelescopique("ilyas", "madoui",LocalDate.of(1999, Month.DECEMBER, 22));
		EtudiantTelescopique etd3 = new EtudiantTelescopique("ilyas", "madoui","ilyasmadoui@gmail.com");
		EtudiantJavaBeans toto = new EtudiantJavaBeans();
		//Etudiant lolo = new EtudiantBuilder();
		
		System.out.println(etd1);
		
		toto.setNom("Ben Ali");
		toto.setDateDeNaissance(LocalDate.of(2002,Month.DECEMBER, 11));
		toto.setPrenom("Anis");
		toto.setAdresse("99, av. Zaatcha, 07000 Biskra");
		toto.setEmail("AnisBenAli@gmail.com");
		
		
	

	}

}
