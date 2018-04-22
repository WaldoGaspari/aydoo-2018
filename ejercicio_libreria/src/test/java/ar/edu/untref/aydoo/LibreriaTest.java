package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {
	
	@Test
	public void calcularMontoACobrarDeunClienteQueNoComproNingunProductoEnFebreroDeberiaDarCero() {
		Libreria libreria = new Libreria();
		Cliente pedro = new Cliente("Pedro", "Suarez", "Rosas 1840");
		
		double resultado = libreria.calcularCobroDeUnClientPorMes(Mes.FEBRERO, pedro);
		
		Assert.assertEquals(0.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteQueComproUnSoloProductoEnElMesDeFebreroDeberiaDarDiez() {
		Libreria libreria = new Libreria();
		Cliente pedro = new Cliente("Pedro", "Suarez", "Rosas 1840");
		Producto lapicera = new Producto(10.0);
		Compra compra= new Compra(pedro, Mes.FEBRERO);
		
		compra.agregarProductoALaCompra(lapicera);
		pedro.agregarCompra(compra);
		double resultado = libreria.calcularCobroDeUnClientPorMes(Mes.FEBRERO, pedro);
		
		Assert.assertEquals(10.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteQueComproTresProductosEnElMesDeMarzoDeberiaDarOchenta() {
		Libreria libreria = new Libreria();
		Cliente lucas = new Cliente("Lucas", "Arce", "Calle 6 2100");
		Producto lapiz = new Producto(15.0);
		Producto goma = new Producto(10.0);
		Producto carpeta = new Producto(55.0);
		Compra compra = new Compra(lucas, Mes.MARZO);
		
		compra.agregarProductoALaCompra(lapiz);
		compra.agregarProductoALaCompra(goma);
		compra.agregarProductoALaCompra(carpeta);
		lucas.agregarCompra(compra);
		double resultado = libreria.calcularCobroDeUnClientPorMes(Mes.MARZO, lucas);
		
		Assert.assertEquals(80.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteQueComproDosProductosEnElMesDeOctubreDeberiaDarCincuenta() {
		Libreria libreria = new Libreria();
		Cliente juan = new Cliente("Juan", "Bogado", "9 de Julio 3480");
		Producto lapicera = new Producto(30.0);
		Producto goma = new Producto(20.0);
		Producto carpeta = new Producto(70.0);
		Compra unaCompraDeOctubre = new Compra(juan, Mes.OCTUBRE);
		Compra unaCompraDeNoviembre = new Compra(juan, Mes.NOVIEMBRE);
		
		unaCompraDeOctubre.agregarProductoALaCompra(lapicera);
		unaCompraDeOctubre.agregarProductoALaCompra(goma);
		unaCompraDeNoviembre.agregarProductoALaCompra(carpeta);
		juan.agregarCompra(unaCompraDeOctubre);
		juan.agregarCompra(unaCompraDeNoviembre);
		double resultado = libreria.calcularCobroDeUnClientPorMes(Mes.OCTUBRE, juan);
		
		Assert.assertEquals(50.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteRegistradoQueHizoUnaCompraEnElMesDeMayoDeberiaDar61Con75DebidoAlDescuentoAplicado() {
		Libreria libreria = new Libreria();
		Cliente agustina = new Cliente("Agustina", "Soto", "Magaldi 5512");
		Producto plasticola = new Producto(40.0);
		Producto voligoma = new Producto(25.0);
		Compra unaCompraDeMayo = new Compra(agustina, Mes.MAYO);
		
		unaCompraDeMayo.agregarProductoALaCompra(plasticola);
		unaCompraDeMayo.agregarProductoALaCompra(voligoma);
		agustina.agregarCompra(unaCompraDeMayo);
		libreria.agregarCliente(agustina);
		double resultado = libreria.calcularCobroDeUnClientPorMes(Mes.MAYO, agustina);
		
		Assert.assertEquals(61.75, resultado, 0.0);
	}
}
