package ar.edu.untref.aydoo;

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
		double resultado = cliente.obtenerProductosPorMes(mes);
		return resultado;
	}
	
}
