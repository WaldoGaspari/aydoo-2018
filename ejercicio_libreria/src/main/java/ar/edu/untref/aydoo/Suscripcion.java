package ar.edu.untref.aydoo;

public class Suscripcion {

	private Publicacion publicacion;
	
	public Suscripcion(Publicacion publicacion) {
		this.publicacion = publicacion;
		calcularSuscripcionAnual();
	}
	
	private void calcularSuscripcionAnual() {
		double resultado;
		if (this.publicacion.obtenerPeriodicidad() == Periodicidad.ANUAL) {
			resultado = this.publicacion.obtenerPrecio() - ((this.publicacion.obtenerPrecio() * 20) / 100);
			this.publicacion.cambiarPrecio(resultado);
		}
	}
	
	public Publicacion obtenerPublicacion() {
		return this.publicacion;
	}
}
