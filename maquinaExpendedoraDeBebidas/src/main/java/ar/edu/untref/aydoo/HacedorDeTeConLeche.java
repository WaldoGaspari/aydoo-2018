package ar.edu.untref.aydoo;

public class HacedorDeTeConLeche {

	private HacedorDeTe hacedorDeTe = new HacedorDeTe();
	private Lechero lechero = new Lechero();
	
	public Vaso prepararUnTeConLeche(Vaso unVaso) {
		unVaso = this.hacedorDeTe.llenarConTe(unVaso);
		unVaso = this.lechero.llenarConLeche(unVaso);
		return unVaso;
	}

}
