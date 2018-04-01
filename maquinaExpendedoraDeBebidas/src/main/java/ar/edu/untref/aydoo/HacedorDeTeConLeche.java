package ar.edu.untref.aydoo;

public class HacedorDeTeConLeche {

	private HacedorDeTe hacedorDeTe = new HacedorDeTe();
	private Lechero lechero = new Lechero();
	
	public Vaso prepararUnTeConLeche(Vaso vaso) {
		vaso = this.hacedorDeTe.llenarConTe(vaso);
		vaso = this.lechero.llenarConLeche(vaso);
		return vaso;
	}
}
