package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {
	
	@Test
	public void unaCompraSinProductosDeberiaDevolvermeCero() {
		Compra nuevaCompra = new Compra(Mes.AGOSTO, 2018);
		
		Assert.assertEquals(0, nuevaCompra.obtenerTotalDeLaCompra(), 0.0);
	}
	
	@Test
	public void unaCompraDeTresProductosSinIVAEnElMesDeAgostoDeberiaDevolvermeLaSumaDeLosPreciosDeLosMismos() {
		Compra nuevaCompra = new Compra(Mes.AGOSTO, 2018);
		Producto revista = new Producto(30.0);
		Producto cartuchera = new Producto(70.0);
		Producto diario = new Producto(20.0);
		
		nuevaCompra.agregarProductoALaCompra(revista);
		nuevaCompra.agregarProductoALaCompra(cartuchera);
		nuevaCompra.agregarProductoALaCompra(diario);
		
		Assert.assertEquals(120, nuevaCompra.obtenerTotalDeLaCompra(), 0.0);
	}
}
