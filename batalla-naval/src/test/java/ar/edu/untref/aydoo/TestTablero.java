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
		Barco bote = new Barco(1, 'H');
		
		tablero.colocarBarco(5, 3, bote);
		tablero.atacar(5, 3);
		
		Assert.assertTrue(bote.estaHundido());
	}
	
	@Test
	public void colocarUnCruzeroYAtacarloUnaSolaVezNoDeberiaEstarHundido() {
		Barco cruzero = new Barco(2, 'H');
		
		tablero.colocarBarco(5, 3, cruzero);
		tablero.atacar(5, 3);
		
		Assert.assertFalse(cruzero.estaHundido());
	}
	
	@Test
	public void colocarUnCruzeroYAtacarloDeberiaEstarHundido() {
		Barco cruzero = new Barco(2, 'V');
		
		tablero.colocarBarco(5, 3, cruzero);
		tablero.atacar(5, 3);
		tablero.atacar(6, 3);
		
		Assert.assertTrue(cruzero.estaHundido());
	}
	
	@Test
	public void atacarUnCasilleroVacioDeberiaDevolvermeAgua() {
		tablero.atacar(2, 1);
		
		Assert.assertTrue(tablero.noHayBarcoEnCasillero(2, 1));
	}
	
	@Test (expected = Error.class)
	public void alColocarUnBoteNoDeberiaColocarseOtroEnElMismoLugar() {
		Barco unBote = new Barco(1, 'V');
		Barco otroBote = new Barco(1, 'H');
		
		tablero.colocarBarco(3, 1, unBote);
		tablero.colocarBarco(3, 1, otroBote);
		
		Assert.assertEquals(unBote, tablero.obtenerCasillero(3, 1).obtenerBarco());
	}
	
	@Test (expected = Error.class)
	public void alColocarUnCruzeroNoDeberiaColocarseOtro() {
		Barco unCruzero = new Barco(1, 'V');
		Barco otroCruzero = new Barco(1, 'H');
		
		tablero.colocarBarco(3, 1, unCruzero);
		tablero.colocarBarco(3, 1, otroCruzero);
		
		Assert.assertEquals(unCruzero, tablero.obtenerCasillero(3, 1).obtenerBarco());
	}
}
