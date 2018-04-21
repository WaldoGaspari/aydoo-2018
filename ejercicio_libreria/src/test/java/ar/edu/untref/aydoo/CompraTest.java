package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {
	
	@Test
	public void unaCompraSinProductosDeberiaDevolvermeCero() {
		Cliente juan = new Cliente("Juan", "Garcia", "Rosas 1200");
		Compra nuevaCompra = new Compra(juan, Mes.AGOSTO);
		
		Assert.assertEquals(0, nuevaCompra.obtenerTotalDeLaCompra(), 0.0);
	}
	
	@Test
	public void unaCompraDeTresProductosDeberiaDevolverme120() {
		Cliente juan = new Cliente("Juan", "Garcia", "Rosas 1200");
		Compra nuevaCompra = new Compra(juan, Mes.AGOSTO);
		Producto revista = new Producto(30.0);
		Producto cartuchera = new Producto(70.0);
		Producto diario = new Producto(20.0);
		
		nuevaCompra.agregarProductoALaCompra(revista);
		nuevaCompra.agregarProductoALaCompra(cartuchera);
		nuevaCompra.agregarProductoALaCompra(diario);
		
		Assert.assertEquals(120, nuevaCompra.obtenerTotalDeLaCompra(), 0.0);
	}

}
