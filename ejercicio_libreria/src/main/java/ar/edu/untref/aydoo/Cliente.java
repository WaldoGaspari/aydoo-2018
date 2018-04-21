package ar.edu.untref.aydoo;

import java.util.HashMap;

public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	private HashMap<Mes, Producto> productosComprados;
	
	public Cliente(String nombre, String apellido, String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.productosComprados = new HashMap<Mes, Producto>();
	}

	public void agregarProducto(Producto producto, Mes mes) {
		this.productosComprados.put(mes, producto);
	}

	public double obtenerProductosPorMes(Mes mes) {
		if (this.productosComprados.get(mes) != null) {
			return this.productosComprados.get(mes).obtenerPrecio();
			
		} else {
			return 0;
		}
	}

}
