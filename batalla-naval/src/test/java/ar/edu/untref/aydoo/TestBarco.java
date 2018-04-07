package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;


public class TestBarco {
	
	@Test
	public void barcoDeberiaTenerTamanioAsignadoEnConstructor() {
		int tamanio = 3;
		Barco barco = new Barco(tamanio, 'H');
		
		Assert.assertEquals(tamanio, barco.obtenerTamanio());
	}
	
	@Test
	public void alTocarBarcoDeTamanio1DeberiaEstarHundido() {
		Barco barco = new Barco(1, 'V');
		barco.tocado();
		
		Assert.assertTrue(barco.estaHundido());
	}
	
	@Test
	public void barcoDeTamanioDosNoEstaHundidoSiSeLoTocaUnaVez() {
		Barco barco = new Barco(2, 'H');
		barco.tocado();
		
		Assert.assertFalse(barco.estaHundido());
	}
	
	@Test
	public void barcoDeberiaPoderTocarseMasVecesDeLasDeSuTamanioSinCambiarEstado() {
		Barco barco = new Barco(1, 'H');
		barco.tocado();
		barco.tocado();
		
		Assert.assertTrue(barco.estaHundido());
	}

}
