package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class BarcoTest {
	
	@Test
	public void barcoDeberiaTenerTamanioAsignadoEnConstructor() {
		int tamanio = 3;
		Barco barco = new Barco(tamanio, 'H');
		
		Assert.assertEquals(tamanio, barco.obtenerTamanio());
	}
	
	@Test
	public void alTocarBarcoDeTamanio1DeberiaEstarHundido() {
		Barco bote = new Barco(1, 'V');

		bote.tocado();
		
		Assert.assertTrue(bote.estaHundido());
	}
	
	@Test
	public void barcoDeTamanioDosNoEstaHundidoSiSeLoTocaUnaVez() {
		Barco cruzero = new Barco(2, 'H');
		
		cruzero.tocado();
		
		Assert.assertFalse(cruzero.estaHundido());
	}
	
	@Test
	public void barcoDeberiaPoderTocarseMasVecesDeLasDeSuTamanioSinCambiarEstado() {
		Barco barco = new Barco(1, 'H');
		
		barco.tocado();
		barco.tocado();
		
		Assert.assertTrue(barco.estaHundido());
	}
}
