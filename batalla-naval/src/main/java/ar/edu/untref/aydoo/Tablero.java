package ar.edu.untref.aydoo;

public class Tablero {

	private final int ancho = 10;
	private final int largo = 10;
	private Casillero[][] casilleros;
	
	public Tablero() {
		casilleros = new Casillero[ancho][largo];
		for (int fila = 0; fila < this.ancho; fila++) {
			for (int columna = 0; columna < this.largo; columna++) {
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
		try {
			if (noHayBarcoEnCasillero(fila, columna)) {
				if (barco.obtenerTamanio() == 2) {
					colocarBarcoDeTamanioDos(fila, columna, barco);
					
				} else {
					this.casilleros[fila][columna].ponerBarco(barco);
				}
				
			} else {
				throw new Error("No se puede colocar el barco. Ya hay otro");
			}
			
		} catch (ArrayIndexOutOfBoundsException exception) {
			
		}
	}

	public void atacar(int fila, int columna) {
		if (!this.casilleros[fila][columna].estaVacio()) {
			this.casilleros[fila][columna].obtenerBarco().tocado();
		}
	}

	public Casillero obtenerCasillero(int fila, int columna) {
		return this.casilleros[fila][columna];
	}
	
	public void colocarBarcoDeTamanioDos(int fila, int columna, Barco barco) {
		if (fila + 1 < this.ancho && columna + 1 < this.largo) {
			if (barco.obtenerOrientacion() == 'H') {
				this.casilleros[fila][columna].ponerBarco(barco);
				this.casilleros[fila][columna + 1].ponerBarco(barco);
				
			} else {
				this.casilleros[fila][columna].ponerBarco(barco);
				this.casilleros[fila + 1][columna].ponerBarco(barco);
			}
			
		} else {
			throw new Error("No se puede colocar el barco. Parte del mismo se encuentra fuera de los limites del tablero");
		}
	}
}
