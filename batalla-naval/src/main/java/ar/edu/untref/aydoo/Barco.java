package ar.edu.untref.aydoo;

public class Barco {

	private int tamanio;
	private int parteDaniada;
	private char orientacion;

	public Barco(int tamanioBarco, char orientacionDelBarco) {
		this.tamanio = tamanioBarco;
		this.parteDaniada = 0;
		this.orientacion = orientacionDelBarco;
	}

	public int obtenerTamanio() {		
		return this.tamanio;
	}
	
	public char obtenerOrientacion() {
		return this.orientacion;
	}

	public void tocado() {
		if(this.tamanio > this.parteDaniada) {
			this.parteDaniada++;
		}		
	}

	public boolean estaHundido() {
		return this.parteDaniada == this.tamanio;
	}
	
}
