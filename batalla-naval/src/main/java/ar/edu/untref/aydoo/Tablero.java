package ar.edu.untref.aydoo;


public class Tablero {

	private final int ancho = 10;
	private final int largo = 10;
	private Casillero[][] casilleros;
	
	public Tablero() {
		casilleros = new Casillero[ancho][largo];
		for(int fila = 0; fila < this.ancho; fila++) {
			for(int columna = 0; columna < this.largo; columna++) {
				this.casilleros[fila][columna] = new Casillero();
			}
		}
	}
	
	public int cantidadColumnas() {
		return this.largo;
	}

	public int cantidadFilas() {
		return this.ancho;
	}

	public boolean noHayBarcoEnCasillero(int fila, int columna) {
		return this.casilleros[fila][columna].estaVacio();
	}

	public void colocarBarco(int fila, int columna, Barco barco) {
		this.casilleros[fila][columna].ponerBarco(barco);
	}

}
