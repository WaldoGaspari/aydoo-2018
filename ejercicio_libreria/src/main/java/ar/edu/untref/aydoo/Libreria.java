package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {

	private List<Cliente> clientes;
	
	public Libreria() {
		this.clientes = new LinkedList<Cliente>();
	}
	
	public void agregarCliente(Cliente nuevoCliente) {
		this.clientes.add(nuevoCliente);
	}

	public double calcularCobroDeUnClientePorMes(Mes mes, Cliente cliente) {
		double resultado = 0;
		if (cliente.obtenerComprasRealizadas().isEmpty()) {
			return resultado;
			 
		} else {
			List<Compra> comprasDelCliente = cliente.obtenerComprasRealizadas();
			Iterator<Compra> iterador = comprasDelCliente.iterator();
			while (iterador.hasNext()) {
				Compra compra = iterador.next();
				if (compra.obtenerMesDeLaCompra() == mes) {
					if (this.clientes.contains(cliente) && !saberSiElClientePoseeUnaSuscripcionAnual(cliente)) {
						resultado = resultado + realizarDescuentoParaClienteRegistrado(compra);
						
					} else {
						resultado = resultado + compra.obtenerTotalDeLaCompra();
					}
				}
			}
			return resultado;
		}
	}
	
	private double realizarDescuentoParaClienteRegistrado(Compra compra) {
		double totalConDescuento = 0;
		totalConDescuento = compra.obtenerTotalDeLaCompra() - ((compra.obtenerTotalDeLaCompra() * 5) / 100);
		return totalConDescuento;
	}

	public double calcularCobroDeUnClientePorAño(Cliente cliente) {
		double resultado = 0;
		Mes[] meses = Mes.values();
		for (int i = 0; i < meses.length; i++) {
			resultado = resultado + calcularCobroDeUnClientePorMes(meses[i], cliente);
		}
		return resultado;
	}
	
	private boolean saberSiElClientePoseeUnaSuscripcionAnual(Cliente cliente) {
		boolean tieneUnaSuscripcionAnual = false;
		Iterator<Suscripcion> iterador = cliente.obtenerSuscripciones().iterator();
		while (iterador.hasNext()) {
			Suscripcion suscripcion = iterador.next();
			if (suscripcion.obtenerPublicacion().obtenerPeriodicidad() == Periodicidad.ANUAL) {
				tieneUnaSuscripcionAnual = true;
			}
		}
		return tieneUnaSuscripcionAnual;
	}
}