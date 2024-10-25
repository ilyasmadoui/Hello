package dz.Biskra.Info.exo2;

public class Matiere {
	private String intitulé;
	private double coefficient;
	
	public Matiere (String intitulé,double coefficient) {
		this.intitulé = intitulé;
		this.coefficient = coefficient;
	}

	public String getIntitulé() {
		return intitulé;
	}


	public double getCoefficient() {
		return coefficient;
	}

}
