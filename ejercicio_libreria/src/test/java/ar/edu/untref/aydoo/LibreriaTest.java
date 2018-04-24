package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {
	
	@Test
	public void calcularMontoACobrarDeunClienteQueNoComproNingunProductoEnFebreroDeberiaDarCero() {
		Libreria libreria = new Libreria();
		Cliente pedro = new Cliente("Pedro", "Suarez", "Rosas 1840");
		
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.FEBRERO, pedro);
		
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
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.FEBRERO, pedro);
		
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
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.MARZO, lucas);
		
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
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.OCTUBRE, juan);
		
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
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.MAYO, agustina);
		
		Assert.assertEquals(61.75, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteQueComproArticulosDeLibreriaEnElMesDeEneroDeberiaDar64Con13() {
		Libreria libreria = new Libreria();
		Cliente josefina = new Cliente("Josefina", "Marquez", "3 de Febrero 6732");
		ArticuloDeLibreria marcadorPermanente = new ArticuloDeLibreria(38.0);
		ArticuloDeLibreria papelGlase = new ArticuloDeLibreria(15.0);
		Compra unaCompraDeEnero = new Compra(josefina, Mes.ENERO);
		
		unaCompraDeEnero.agregarProductoALaCompra(marcadorPermanente);
		unaCompraDeEnero.agregarProductoALaCompra(papelGlase);
		josefina.agregarCompra(unaCompraDeEnero);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.ENERO, josefina);
		
		Assert.assertEquals(64.13, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteQueComproUnDiarioYUnaRevistaEnElMesDeMarzoDeberiaDar60() {
		Libreria libreria = new Libreria();
		Cliente martin = new Cliente("Martin", "Cavallaro", "Juan B Justo 8154");
		Publicacion diarioLaNacion = new Publicacion(25.0, Periodicidad.DIARIA);
		Publicacion revistaGranPesca = new Publicacion(35.0, Periodicidad.MENSUAL);
		Compra unaCompraDeMarzo = new Compra(martin, Mes.MARZO);
		
		unaCompraDeMarzo.agregarProductoALaCompra(diarioLaNacion);
		unaCompraDeMarzo.agregarProductoALaCompra(revistaGranPesca);
		martin.agregarCompra(unaCompraDeMarzo);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.MARZO, martin);
		
		Assert.assertEquals(60.0, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteQuePoseeUnaSuscripcionAnualDeberiaDar76() {
		Libreria libreria = new Libreria();
		Cliente eduardo = new Cliente("Eduardo", "Pallares", "Mitre 3311");
		Publicacion diarioCronica = new Publicacion(20.0, Periodicidad.DIARIA);
		Publicacion revistaTodoMotor = new Publicacion(70.0, Periodicidad.ANUAL);
		Suscripcion suscripcion = new Suscripcion(revistaTodoMotor);
		Compra unaCompraDeEnero = new Compra(eduardo, Mes.ENERO);
		
		unaCompraDeEnero.agregarProductoALaCompra(diarioCronica);
		unaCompraDeEnero.agregarProductoALaCompra(revistaTodoMotor);
		eduardo.agregarCompra(unaCompraDeEnero);
		eduardo.agregarSuscripcion(suscripcion);
		double resultado = libreria.calcularCobroDeUnClientePorMes(Mes.ENERO, eduardo);
		
		Assert.assertEquals(76.0, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteNoRegistradoQueNoComproNadaDeberiaDar0() {
		Libreria libreria = new Libreria();
		Cliente mauro = new Cliente("Mauro", "Suarez", "Solis 3333");
		
		double resultado = libreria.calcularCobroDeUnClientePorAño(mauro);
		
		Assert.assertEquals(0.0, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteNoRegistradoEnUnAñoDeberiaDar479Con25() {
		Libreria libreria = new Libreria();
		Cliente vanesa = new Cliente("Vanesa", "Magallanes", "Alberdi 1190");
		ArticuloDeLibreria fibrasx12 = new ArticuloDeLibreria(57.0);
		ArticuloDeLibreria crayonesx12 = new ArticuloDeLibreria(43.0);
		ArticuloDeLibreria hojasCansonNro5 = new ArticuloDeLibreria(25.0);
		Publicacion diarioClarin = new Publicacion(27.0, Periodicidad.DIARIA);
		Publicacion revistaHolaArgentina = new Publicacion(55.0, Periodicidad.MENSUAL);
		Producto cajaFuerte = new Producto(246.0);
		Compra compraDeMarzo = new Compra(vanesa, Mes.MARZO);
		Compra compraDeJunio = new Compra(vanesa, Mes.JUNIO);
		Compra compraDeSeptiembre = new Compra(vanesa, Mes.SEPTIEMBRE);
		
		compraDeMarzo.agregarProductoALaCompra(fibrasx12);
		compraDeMarzo.agregarProductoALaCompra(crayonesx12);
		compraDeMarzo.agregarProductoALaCompra(hojasCansonNro5);
		compraDeJunio.agregarProductoALaCompra(diarioClarin);
		compraDeJunio.agregarProductoALaCompra(revistaHolaArgentina);
		compraDeSeptiembre.agregarProductoALaCompra(cajaFuerte);
		vanesa.agregarCompra(compraDeMarzo);
		vanesa.agregarCompra(compraDeJunio);
		vanesa.agregarCompra(compraDeSeptiembre);
		double resultado = libreria.calcularCobroDeUnClientePorAño(vanesa);
		
		Assert.assertEquals(479.25, resultado, 0.0);
	}
	
	@Test
	public void calcularMontoACobrarDeUnClienteRegistradoEnUnAñoDeberiaDar479Con25() {
		Libreria libreria = new Libreria();
		Cliente maximiliano = new Cliente("Maximiliano", "Juarez", "Cochabamba 5186");
		ArticuloDeLibreria correctorLiquido = new ArticuloDeLibreria(50.0);
		ArticuloDeLibreria biromeAzul = new ArticuloDeLibreria(10.0);
		Publicacion diarioPopular = new Publicacion(22.0, Periodicidad.DIARIA);
		Publicacion revistaHolaArgentina = new Publicacion(55.0, Periodicidad.MENSUAL);
		Producto cajaFuerte = new Producto(246.0);
		ArticuloDeLibreria goma = new ArticuloDeLibreria(10.0);
		ArticuloDeLibreria lapiz = new ArticuloDeLibreria(25.0);
		Compra compraDeMarzo = new Compra(maximiliano, Mes.MARZO);
		Compra compraDeJulio = new Compra(maximiliano, Mes.JULIO);
		Compra compraDeSeptiembre = new Compra(maximiliano, Mes.SEPTIEMBRE);
		Compra compraDeOctubre = new Compra(maximiliano, Mes.OCTUBRE);
		
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
		double resultado = libreria.calcularCobroDeUnClientePorAño(maximiliano);
		
		Assert.assertEquals(416.05, resultado, 0.0025);
	}
}
