package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	private List<Compra> comprasRealizadas;
	private List<Suscripcion> suscripcionesAdheridas;
	
	public Cliente(String nombre, String apellido, String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.comprasRealizadas = new LinkedList<Compra>();
		this.suscripcionesAdheridas = new LinkedList<Suscripcion>();
	}

	public void agregarCompra(Compra nuevaCompra) {
		this.comprasRealizadas.add(nuevaCompra);
	}
	
	public List<Compra> obtenerComprasRealizadas() {
		return this.comprasRealizadas;
	}

	public void agregarSuscripcion(Suscripcion suscripcion) {
		suscripcion.calcularSuscripcionAnual();
		this.suscripcionesAdheridas.add(suscripcion);
	}

}
