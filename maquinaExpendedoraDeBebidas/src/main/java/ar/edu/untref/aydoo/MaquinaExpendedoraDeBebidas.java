package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {

	private HacedorDeCafeConLeche hacedorDeCafeConLeche = new HacedorDeCafeConLeche();
	private Azucarero azucarero = new Azucarero();
	
	public void hacerCafeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
		unVaso = this.hacedorDeCafeConLeche.prepararUnVaso(unVaso);
		unVaso = this.azucarero.agregarNCucharadasDeAzucar(unVaso, cantidadAzucar);
	}

	public void hacerTeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
		// TODO Auto-generated method stub
		
	}

}
