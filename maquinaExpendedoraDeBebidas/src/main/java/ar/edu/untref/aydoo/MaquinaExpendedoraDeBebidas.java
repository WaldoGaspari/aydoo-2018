package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {

	private HacedorDeCafeConLeche hacedorDeCafeConLeche = new HacedorDeCafeConLeche();
	private Azucarero azucarero = new Azucarero();
	private HacedorDeTeConLeche hacedorDeTeConLeche = new HacedorDeTeConLeche();
	
	public void hacerCafeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
		unVaso = this.hacedorDeCafeConLeche.prepararUnCafeConLeche(unVaso);
		unVaso = this.azucarero.agregarNCucharadasDeAzucar(unVaso, cantidadAzucar);
	}

	public void hacerTeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
		unVaso = this.hacedorDeTeConLeche.prepararUnTeConLeche(unVaso);
		unVaso = this.azucarero.agregarNCucharadasDeAzucar(unVaso, cantidadAzucar);
	}
}
