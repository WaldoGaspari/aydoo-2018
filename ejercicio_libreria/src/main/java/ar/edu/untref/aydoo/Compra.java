package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Compra {
	
	private Cliente cliente;
	private Mes mes;
	private List<Producto> productos;
	
	public Compra(Cliente cliente, Mes mes) {
		this.cliente = cliente;
		this.mes = mes;
		this.productos = new LinkedList<Producto>();
	}
	
	public void agregarProductoALaCompra(Producto producto) {
		this.productos.add(producto);
	}
	
	public Mes obtenerMesDeLaCompra() {
		return this.mes;
	}
	
	public List<Producto> obtenerProductosComprados() {
		return this.productos;
	}
	
	public double obtenerTotalDeLaCompra() {
		double resultado = 0;
		if (this.productos.isEmpty()) {
			return resultado;
			
		}else {
			Iterator<Producto> iterador = this.productos.iterator();
			while(iterador.hasNext()) {
				Producto producto = iterador.next();
				resultado = resultado + producto.obtenerPrecio();
			}
			return resultado;
		}
	}
}
