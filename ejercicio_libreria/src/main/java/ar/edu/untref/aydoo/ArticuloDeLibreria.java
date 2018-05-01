package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	private final double IVA = 0.21;
	
	public ArticuloDeLibreria(double precio) {
		super(precio);
		this.cambiarPrecio(this.obtenerPrecio() + calcularIVA(precio));
	}
	
	private double calcularIVA(double precio) {
		return precio * this.IVA;
	}
}
