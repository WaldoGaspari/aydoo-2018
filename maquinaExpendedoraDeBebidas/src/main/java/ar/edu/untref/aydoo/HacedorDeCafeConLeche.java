package ar.edu.untref.aydoo;

public class HacedorDeCafeConLeche {

	private Cafetero cafetero = new Cafetero();
	private Lechero lechero = new Lechero();
	
	public Vaso prepararUnVaso(Vaso unVaso) {
		unVaso = this.cafetero.llenarConCafe(unVaso);
		unVaso = this.lechero.llenarConLeche(unVaso);
		return unVaso;
	}
}
