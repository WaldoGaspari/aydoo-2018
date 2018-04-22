package ar.edu.untref.aydoo;

public class Producto {

	private double precio;
	
	public Producto(double precio) {
		this.precio = precio;
	}
	
	public double obtenerPrecio() {
		return this.precio;
	}
	
	public void cambiarPrecio(double nuevoPrecio){
		this.precio = nuevoPrecio;
	}

}
