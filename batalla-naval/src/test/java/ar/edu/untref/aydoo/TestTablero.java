package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TestTablero {
	
	@Test
	public void alCrearUnTableroDeberiaTenerCasillerosVacios() {
		Tablero tablero = new Tablero();
		
		for(int fila = 0; fila < tablero.cantidadFilas(); fila++) {
			for(int columna = 0; columna < tablero.cantidadColumnas(); columna++) {
				Assert.assertTrue(tablero.noHayBarcoEnCasillero(fila, columna));
			}
		}
	}
	
	@Test
	public void alColocarUnBarcoEnElTableroDeberiaEstarEnDichoLugar() {
		Tablero tablero = new Tablero();
		Barco unBarco = new Barco(1);
		
		tablero.colocarBarco(1, 1, unBarco);
		
		Assert.assertFalse(tablero.noHayBarcoEnCasillero(1, 1));
	}
}
