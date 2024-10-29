package dz.Biskra.Info.exo2;

import java.util.ArrayList;
import java.util.List;

public class Departement {
	
	private List<Etudiant> etudiants;
	  
	public Departement (List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	public double getMoyennePromo() {
		if(etudiants.isEmpty()) return 0.0;
		double some_moyene_Etud = 0;
		for(Etudiant etud :etudiants) {
			some_moyene_Etud += etud.calculerMoyenne();
		}
		
		return some_moyene_Etud/etudiants.size();
	}

}
