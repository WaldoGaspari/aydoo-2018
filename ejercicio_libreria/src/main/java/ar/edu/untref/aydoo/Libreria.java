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

	public double calcularCobroDeUnClientPorMes(Mes mes, Cliente cliente) {
		double resultado = 0;
		if (cliente.obtenerComprasRealizadas().isEmpty()) {
			return resultado;
			 
		} else {
			List<Compra> comprasDelCliente = cliente.obtenerComprasRealizadas();
			Iterator<Compra> iterador = comprasDelCliente.iterator();
			while(iterador.hasNext()) {
				Compra compra = iterador.next();
				if (compra.obtenerMesDeLaCompra() == mes) {
					resultado = resultado + compra.obtenerTotalDeLaCompra();
				}
			}
			return resultado;
		}
	}
	
}
