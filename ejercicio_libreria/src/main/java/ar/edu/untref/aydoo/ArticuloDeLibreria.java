package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	private final static double IVA = 0.21;
	
	public ArticuloDeLibreria(double precio) {
		super(calcularPrecioConIVA(precio));
	}
	
	private static double calcularPrecioConIVA(double precio) {
		double IvaDelProducto = precio * IVA; 
		return precio + IvaDelProducto;
	}
}
