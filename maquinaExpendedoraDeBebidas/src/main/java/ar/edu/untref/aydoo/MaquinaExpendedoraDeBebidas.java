package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {

	private HacedorDeCafeConLeche hacedorDeCafeConLeche = new HacedorDeCafeConLeche();
	private Azucarero azucarero = new Azucarero();
	private HacedorDeTeConLeche hacedorDeTeConLeche = new HacedorDeTeConLeche();
	
	public void hacerCafeConLecheConNDeAzucar(Vaso vaso, int cantidadAzucar) {
		vaso = this.hacedorDeCafeConLeche.prepararUnCafeConLeche(vaso);
		vaso = this.azucarero.agregarNCucharadasDeAzucar(vaso, cantidadAzucar);
	}

	public void hacerTeConLecheConNDeAzucar(Vaso vaso, int cantidadAzucar) {
		vaso = this.hacedorDeTeConLeche.prepararUnTeConLeche(vaso);
		vaso = this.azucarero.agregarNCucharadasDeAzucar(vaso, cantidadAzucar);
	}
}
