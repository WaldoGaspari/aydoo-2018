package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibreriaTest {
	
	Libreria libreria;
	@Before
	public void crearLibreria() {
		libreria = new Libreria();
	}
	
	@Test
	public void calcularMontoACobrarDeunClienteQueNoComproNingunProductoEnFebreroDeberiaDarCero() {
		Cliente pedro = new Cliente("Pedro", "Suarez", "Rosas 1840");
		
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.FEBRERO, pedro);
		
		Assert.assertEquals(0.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteQueComproUnSoloProductoEnElMesDeFebreroDeberiaDarDiez() {
		Cliente pedro = new Cliente("Pedro", "Suarez", "Rosas 1840");
		Producto lapicera = new Producto(10.0);
		Compra compra= new Compra(Mes.FEBRERO);
		
		compra.agregarProductoALaCompra(lapicera);
		pedro.agregarCompra(compra);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.FEBRERO, pedro);
		
		Assert.assertEquals(10.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteQueComproTresProductosEnElMesDeMarzoDeberiaDarOchenta() {
		Cliente lucas = new Cliente("Lucas", "Arce", "Calle 6 2100");
		Producto lapiz = new Producto(15.0);
		Producto goma = new Producto(10.0);
		Producto carpeta = new Producto(55.0);
		Compra compra = new Compra(Mes.MARZO);
		
		compra.agregarProductoALaCompra(lapiz);
		compra.agregarProductoALaCompra(goma);
		compra.agregarProductoALaCompra(carpeta);
		lucas.agregarCompra(compra);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.MARZO, lucas);
		
		Assert.assertEquals(80.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteQueComproDosProductosEnElMesDeOctubreDeberiaDarCincuenta() {
		Cliente juan = new Cliente("Juan", "Bogado", "9 de Julio 3480");
		Producto lapicera = new Producto(30.0);
		Producto goma = new Producto(20.0);
		Producto carpeta = new Producto(70.0);
		Compra unaCompraDeOctubre = new Compra(Mes.OCTUBRE);
		Compra unaCompraDeNoviembre = new Compra(Mes.NOVIEMBRE);
		
		unaCompraDeOctubre.agregarProductoALaCompra(lapicera);
		unaCompraDeOctubre.agregarProductoALaCompra(goma);
		unaCompraDeNoviembre.agregarProductoALaCompra(carpeta);
		juan.agregarCompra(unaCompraDeOctubre);
		juan.agregarCompra(unaCompraDeNoviembre);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.OCTUBRE, juan);
		
		Assert.assertEquals(50.0, resultado, 0.0);
	}
	
	@Test 
	public void calcularMontoACobrarDeUnClienteRegistradoQueHizoUnaCompraEnElMesDeMayoDeberiaDar61Con75DebidoAlDescuentoAplicado() {
		Cliente agustina = new Cliente("Agustina", "Soto", "Magaldi 5512");
		Producto plasticola = new Producto(40.0);
		Producto voligoma = new Producto(25.0);
		Compra unaCompraDeMayo = new Compra(Mes.MAYO);
		
		unaCompraDeMayo.agregarProductoALaCompra(plasticola);
		unaCompraDeMayo.agregarProductoALaCompra(voligoma);
		agustina.agregarCompra(unaCompraDeMayo);
		libreria.agregarCliente(agustina);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.MAYO, agustina);
		
		Assert.assertEquals(61.75, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteQueComproArticulosDeLibreriaEnElMesDeEneroDeberiaDar64Con13() {
		Cliente josefina = new Cliente("Josefina", "Marquez", "3 de Febrero 6732");
		ArticuloDeLibreria marcadorPermanente = new ArticuloDeLibreria(38.0);
		ArticuloDeLibreria papelGlase = new ArticuloDeLibreria(15.0);
		Compra unaCompraDeEnero = new Compra(Mes.ENERO);
		
		unaCompraDeEnero.agregarProductoALaCompra(marcadorPermanente);
		unaCompraDeEnero.agregarProductoALaCompra(papelGlase);
		josefina.agregarCompra(unaCompraDeEnero);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.ENERO, josefina);
		
		Assert.assertEquals(64.13, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteQueComproUnDiarioYUnaRevistaEnElMesDeMarzoDeberiaDar60() {
		Cliente martin = new Cliente("Martin", "Cavallaro", "Juan B Justo 8154");
		Publicacion diarioLaNacion = new Publicacion(25.0, Periodicidad.DIARIA);
		Publicacion revistaGranPesca = new Publicacion(35.0, Periodicidad.MENSUAL);
		Compra unaCompraDeMarzo = new Compra(Mes.MARZO);
		
		unaCompraDeMarzo.agregarProductoALaCompra(diarioLaNacion);
		unaCompraDeMarzo.agregarProductoALaCompra(revistaGranPesca);
		martin.agregarCompra(unaCompraDeMarzo);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.MARZO, martin);
		
		Assert.assertEquals(60.0, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteQuePoseeUnaSuscripcionAnualDeberiaDar76() {
		Cliente eduardo = new Cliente("Eduardo", "Pallares", "Mitre 3311");
		Publicacion diarioCronica = new Publicacion(20.0, Periodicidad.DIARIA);
		Publicacion revistaTodoMotor = new Publicacion(70.0, Periodicidad.ANUAL);
		Suscripcion suscripcion = new Suscripcion(revistaTodoMotor);
		Compra unaCompraDeEnero = new Compra(Mes.ENERO);
		
		unaCompraDeEnero.agregarProductoALaCompra(diarioCronica);
		unaCompraDeEnero.agregarProductoALaCompra(revistaTodoMotor);
		eduardo.agregarCompra(unaCompraDeEnero);
		eduardo.agregarSuscripcion(suscripcion);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.ENERO, eduardo);
		
		Assert.assertEquals(76.0, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteNoRegistradoQueNoComproNadaDeberiaDar0() {
		Cliente mauro = new Cliente("Mauro", "Suarez", "Solis 3333");
		
		double resultado = libreria.calcularCobroDeUnClientePorAnio(mauro);
		
		Assert.assertEquals(0.0, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteNoRegistradoEnUnAnioDeberiaDar479Con25() {
		Cliente vanesa = new Cliente("Vanesa", "Magallanes", "Alberdi 1190");
		ArticuloDeLibreria fibrasx12 = new ArticuloDeLibreria(57.0);
		ArticuloDeLibreria crayonesx12 = new ArticuloDeLibreria(43.0);
		ArticuloDeLibreria hojasCansonNro5 = new ArticuloDeLibreria(25.0);
		Publicacion diarioClarin = new Publicacion(27.0, Periodicidad.DIARIA);
		Publicacion revistaHolaArgentina = new Publicacion(55.0, Periodicidad.MENSUAL);
		Producto cajaFuerte = new Producto(246.0);
		Compra compraDeMarzo = new Compra(Mes.MARZO);
		Compra compraDeJunio = new Compra(Mes.JUNIO);
		Compra compraDeSeptiembre = new Compra(Mes.SEPTIEMBRE);
		
		compraDeMarzo.agregarProductoALaCompra(fibrasx12);
		compraDeMarzo.agregarProductoALaCompra(crayonesx12);
		compraDeMarzo.agregarProductoALaCompra(hojasCansonNro5);
		compraDeJunio.agregarProductoALaCompra(diarioClarin);
		compraDeJunio.agregarProductoALaCompra(revistaHolaArgentina);
		compraDeSeptiembre.agregarProductoALaCompra(cajaFuerte);
		vanesa.agregarCompra(compraDeMarzo);
		vanesa.agregarCompra(compraDeJunio);
		vanesa.agregarCompra(compraDeSeptiembre);
		double resultado = libreria.calcularCobroDeUnClientePorAnio(vanesa);
		
		Assert.assertEquals(479.25, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteRegistradoEnUnAnioDeberiaDar416Con05() {
		Cliente maximiliano = new Cliente("Maximiliano", "Juarez", "Cochabamba 5186");
		ArticuloDeLibreria correctorLiquido = new ArticuloDeLibreria(50.0);
		ArticuloDeLibreria biromeAzul = new ArticuloDeLibreria(10.0);
		Publicacion diarioPopular = new Publicacion(22.0, Periodicidad.DIARIA);
		Publicacion revistaHolaArgentina = new Publicacion(55.0, Periodicidad.MENSUAL);
		Producto cajaFuerte = new Producto(246.0);
		ArticuloDeLibreria goma = new ArticuloDeLibreria(10.0);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria(25.0);
		Compra compraDeMarzo = new Compra(Mes.MARZO);
		Compra compraDeJulio = new Compra(Mes.JULIO);
		Compra compraDeSeptiembre = new Compra(Mes.SEPTIEMBRE);
		Compra compraDeOctubre = new Compra(Mes.OCTUBRE);
		
		compraDeMarzo.agregarProductoALaCompra(correctorLiquido);
		compraDeMarzo.agregarProductoALaCompra(biromeAzul);
		compraDeJulio.agregarProductoALaCompra(diarioPopular);
		compraDeJulio.agregarProductoALaCompra(revistaHolaArgentina);
		compraDeSeptiembre.agregarProductoALaCompra(cajaFuerte);
		compraDeOctubre.agregarProductoALaCompra(goma);
		compraDeOctubre.agregarProductoALaCompra(lapiz);
		maximiliano.agregarCompra(compraDeMarzo);
		maximiliano.agregarCompra(compraDeJulio);
		maximiliano.agregarCompra(compraDeSeptiembre);
		maximiliano.agregarCompra(compraDeOctubre);
		libreria.agregarCliente(maximiliano);
		double resultado = libreria.calcularCobroDeUnClientePorAnio(maximiliano);
		
		Assert.assertEquals(416.05, resultado, 0.0025);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteRegistradoQuePoseeUnaSuscripcionAnualNoDeberiaAplicarseElDescuentoDe5PorcentajeEnSusCompras() {
		Cliente natalia = new Cliente("Natalia", "Villalba", "Honduras 2977");
		Publicacion diarioLaNacion = new Publicacion(25.0, Periodicidad.DIARIA);
		Publicacion revistaTodoModa = new Publicacion(95.0, Periodicidad.ANUAL);
		Suscripcion suscripcion = new Suscripcion(revistaTodoModa);
		Compra unaCompraDeEnero = new Compra(Mes.ENERO);
		
		unaCompraDeEnero.agregarProductoALaCompra(diarioLaNacion);
		unaCompraDeEnero.agregarProductoALaCompra(revistaTodoModa);
		natalia.agregarCompra(unaCompraDeEnero);
		natalia.agregarSuscripcion(suscripcion);
		libreria.agregarCliente(natalia);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.ENERO, natalia);
		
		Assert.assertEquals(101.0, resultado, 0.0);
	}
	
	@Test
	public void calcularImporteTotalACobrarDeTodosLosClientesRegistradosParaMarzoDeberiaDar162Con75() {
		Cliente agustina = new Cliente("Agustina", "Soto", "Magaldi 5512");
		Cliente natalia = new Cliente("Natalia", "Villalba", "Honduras 2977");
		Producto plasticola = new Producto(40.0);
		Producto voligoma = new Producto(25.0);
		Publicacion diarioLaNacion = new Publicacion(25.0, Periodicidad.DIARIA);
		Publicacion revistaTodoModa = new Publicacion(95.0, Periodicidad.ANUAL);
		Suscripcion suscripcion = new Suscripcion(revistaTodoModa);
		Compra unaCompraDeMarzoDeNatalia = new Compra(Mes.MARZO);
		Compra unaCompraDeMarzoDeAgustina = new Compra(Mes.MARZO);
		
		unaCompraDeMarzoDeAgustina.agregarProductoALaCompra(plasticola);
		unaCompraDeMarzoDeAgustina.agregarProductoALaCompra(voligoma);
		unaCompraDeMarzoDeNatalia.agregarProductoALaCompra(diarioLaNacion);
		unaCompraDeMarzoDeNatalia.agregarProductoALaCompra(revistaTodoModa);
		agustina.agregarCompra(unaCompraDeMarzoDeAgustina);
		natalia.agregarCompra(unaCompraDeMarzoDeNatalia);
		natalia.agregarSuscripcion(suscripcion);
		libreria.agregarCliente(natalia);
		libreria.agregarCliente(agustina);
		double resultado = libreria.calcularTotalACobrarDeLosClientesRegistradosPorMes(Mes.MARZO);
		
		Assert.assertEquals(162.75, resultado, 0.0);
	}
}
