package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LibreriaTest {
	
	@Test
	public void calcularMontoACobrarDeunClienteSinProductosDeberiaDarCero() {
		Libreria libreria = new Libreria();
		Cliente pedro = new Cliente("Pedro", "Suarez", "Rosas 1840");
		
		double resultado = libreria.calcularCobroDeUnClientPorMes(Mes.FEBRERO, pedro);
		
		Assert.assertEquals(0.0, resultado, 0.0);
	}
	
	@Ignore
	@Test 
	public void calcularMontoACobrarDeUnClienteQueComproUnSoloProductoDeberiaDarDiez() {
		Libreria libreria = new Libreria();
		Cliente pedro = new Cliente("Pedro", "Suarez", "Rosas 1840");
		Producto lapicera = new Producto(10.0);
		
		pedro.agregarProducto(lapicera);
		double resultado = libreria.calcularCobroDeUnClientPorMes(Mes.FEBRERO, pedro);
		
		Assert.assertEquals(10.0, resultado, 0.0);
	}

}
