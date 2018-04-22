package ar.edu.untref.aydoo;

public class Publicacion extends Producto {

	private Periodicidad periodicidad;
	
	public Publicacion(double precio, Periodicidad periodicidad) {
		super(precio);
		this.periodicidad = periodicidad;
	}
	
	public Periodicidad obtenerPeriodicidad() {
		return this.periodicidad;
	}

}
