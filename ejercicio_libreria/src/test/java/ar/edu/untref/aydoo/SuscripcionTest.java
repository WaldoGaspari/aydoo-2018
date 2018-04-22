package ar.edu.untref.aydoo;

import org.junit.Test;

import org.junit.Assert;

public class SuscripcionTest {
	
	@Test
	public void unaSuscripcionQueEsMensualNoDeberiaCalcularseElDescuento() {
		Publicacion diario = new Publicacion(45.0, Periodicidad.MENSUAL);
		Suscripcion nuevaSuscripcion = new Suscripcion(diario);
		
		nuevaSuscripcion.calcularSuscripcionAnual();
		
		Assert.assertEquals(45.0, diario.obtenerPrecio(), 0.0);
	}
	
	@Test
	public void unaSuscripcionQueEsAnualDeberiaCalcularseElDescuento() {
		Publicacion revistaHolaMundo = new Publicacion(135.0, Periodicidad.ANUAL);
		Suscripcion nuevaSuscripcion = new Suscripcion(revistaHolaMundo);
		
		nuevaSuscripcion.calcularSuscripcionAnual();
		
		Assert.assertEquals(108, revistaHolaMundo.obtenerPrecio(), 0.0);
	}

}
