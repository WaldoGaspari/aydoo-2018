package ar.edu.untref.aydoo;

public class HacedorDeCafeConLeche {

	private Cafetero cafetero = new Cafetero();
	private Lechero lechero = new Lechero();
	
	public Vaso prepararUnCafeConLeche(Vaso vaso) {
		vaso = this.cafetero.llenarConCafe(vaso);
		vaso = this.lechero.llenarConLeche(vaso);
		return vaso;
	}
}
