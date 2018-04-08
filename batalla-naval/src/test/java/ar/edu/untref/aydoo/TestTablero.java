package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTablero {
	
	Tablero tablero;
	@Before
	public void crearTablero() {
		tablero = new Tablero();
	}
	
	@Test
	public void alCrearUnTableroDeberiaTenerCasillerosVacios() {
		for(int fila = 0; fila < tablero.cantidadFilas(); fila++) {
			for(int columna = 0; columna < tablero.cantidadColumnas(); columna++) {
				Assert.assertTrue(tablero.noHayBarcoEnCasillero(fila, columna));
			}
		}
	}
	
	@Test
	public void alColocarUnBarcoEnElTableroDeberiaEstarEnDichoLugar() {
		Barco unBarco = new Barco(1, 'V');
		
		tablero.colocarBarco(1, 1, unBarco);
		
		Assert.assertFalse(tablero.noHayBarcoEnCasillero(1, 1));
	}
	
	@Test
	public void alColocarUnBarcoDeTamanio2DeberiaEstarEnDichoLugar() {
		Barco unBarco = new Barco(2, 'H');
		
		tablero.colocarBarco(2, 1, unBarco);
		
		Assert.assertFalse(tablero.noHayBarcoEnCasillero(2, 1));
		Assert.assertFalse(tablero.noHayBarcoEnCasillero(2, 2));
	}
	
	@Test
	public void deberiaColocarseUnBarcoEnPosicionVertical() {
		Barco unBarco = new Barco(2, 'V');
		
		tablero.colocarBarco(4, 2, unBarco);
		
		Assert.assertFalse(tablero.noHayBarcoEnCasillero(4, 2));
		Assert.assertFalse(tablero.noHayBarcoEnCasillero(5, 2));
	}
	
	@Test
	public void colocarUnBoteYAtacarloDeberiaEstarHundido() {
		Barco barco = new Barco(1, 'H');
		
		tablero.colocarBarco(5, 3, barco);
		tablero.atacar(5, 3);
		
		Assert.assertTrue(barco.estaHundido());
	}
	
	@Test
	public void colocarUnCruzeroYAtacarloUnaSolaVezNoDeberiaEstarHundido() {
		Barco barco = new Barco(2, 'H');
		
		tablero.colocarBarco(5, 3, barco);
		tablero.atacar(5, 3);
		
		Assert.assertFalse(barco.estaHundido());
	}
	
	@Test
	public void colocarUnCruzeroYAtacarloDeberiaEstarHundido() {
		Barco barco = new Barco(2, 'V');
		
		tablero.colocarBarco(5, 3, barco);
		tablero.atacar(5, 3);
		tablero.atacar(6, 3);
		
		Assert.assertTrue(barco.estaHundido());
	}
	
	@Test
	public void atacarUnCasilleroVacioDeberiaDevolvermeAgua() {
		tablero.atacar(2, 1);
		
		Assert.assertTrue(tablero.noHayBarcoEnCasillero(2, 1));
	}
	
	@Test (expected = Error.class)
	public void alColocarUnBarcoNoDeberiaColocarseOtroEnElMismoLugar() {
		Barco unBarco = new Barco(1, 'V');
		Barco otroBarco = new Barco(1, 'H');
		
		tablero.colocarBarco(3, 1, unBarco);
		tablero.colocarBarco(3, 1, otroBarco);
		
		Assert.assertEquals(unBarco, tablero.obtenerCasillero(3, 1).obtenerBarco());
	}
	
}
