package dz.Biskra.Info.exo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class EtudiantTest {

	@Test
	void testCalculerMoyenne() {
		fail("Not yet implemented");
	}
	
	@Test
	void test_calcul_moyenne_retourne_zero_Quand_Pas_De_Note() {
		Etudiant etud = new Etudiant(Collections.emptyList());
		assertEquals(0.0, etud.calculerMoyenne(), 0.0001);
	}
	
	@Test
	void test_calcul_moyenne_retourne_valeur_note_quand_une_seule_note() {
		Etudiant etud = new Etudiant(Arrays.asList(new Note(new Matiere("Math", 1),10.0)));
	    assertEquals(10.0, etud.calculerMoyenne(), 0.0001);	
	}
	
	@Test
	void test_calcul_moyenne_retourne_valeur_note_pondérée_quand_une_seule_note_avec_coefficient() {
		Etudiant etud = new Etudiant (Arrays.asList(new Note(new Matiere("Phizic", 2),15.0)));
		assertEquals(15.0, etud.calculerMoyenne(),0.001);
	}
	
	@Test
	void testCalculerMoyenne_retourneMoyenneQuandPlusieursNotesAvecDifferentsCoefficients() {
        Etudiant etudiant = new Etudiant(Arrays.asList(
                new Note(new Matiere("Science",3), 2),
                new Note(new Matiere("Sport",3), 3),
                new Note(new Matiere("Arabe",3), 5)
        ));
        assertEquals(15.0, etudiant.calculerMoyenne(), 0.0001);
    }
}
