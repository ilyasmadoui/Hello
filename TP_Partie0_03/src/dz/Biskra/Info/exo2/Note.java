package dz.Biskra.Info.exo2;

public class Note {
	private Matiere matiere;
	private double nombre;
	
	public Note (Matiere matiere,double nombre) {
		this.matiere = matiere;
		this.nombre = nombre;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public double getNombre() {
		return nombre;
	}

}
