package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TestCasillero {
	
	@Test
	public void casilleroVacioDeberiaEstarVacio() {
		Casillero casillero = new Casillero();
		
		Assert.assertTrue(casillero.estaVacio());
	}
	
	@Test
	public void casilleroConBarcoNoDeberiaEstarVacio() {
		Casillero casillero = new Casillero();
		Barco barco = new Barco(23, 'V');
		
		casillero.ponerBarco(barco);
		
		Assert.assertFalse(casillero.estaVacio());
	}
}
