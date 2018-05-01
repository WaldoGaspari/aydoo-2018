package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Compra {
	
	private Mes mes;
	private int anio;
	private List<Producto> productos;
	
	public Compra(Mes mes, int anio) {
		this.mes = mes;
		this.anio = anio;
		this.productos = new LinkedList<Producto>();
	}
	
	public void agregarProductoALaCompra(Producto producto) {
		this.productos.add(producto);
	}
	
	public Mes obtenerMesDeLaCompra() {
		return this.mes;
	}
	
	public int obtenerAnioDeLaCompra() {
		return this.anio;
	}
	
	public List<Producto> obtenerProductosComprados() {
		List<Producto> productosComprados = this.productos; 
		return productosComprados;
	}
	
	public double obtenerTotalDeLaCompra() {
		double resultado = 0;
		Iterator<Producto> iterador = this.productos.iterator();
		while (iterador.hasNext()) {
			Producto producto = iterador.next();
			resultado = resultado + producto.obtenerPrecio();
		}
		return resultado;
	}
}
