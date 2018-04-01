package ar.edu.untref.aydoo;

public class Vaso {

	private int cantidadDeAzucar;
	private boolean tieneCafe;
	private boolean tieneTe;
	private boolean tieneLeche;
	
	public Vaso() {
		this.cantidadDeAzucar = 0;
		this.tieneCafe = false;
		this.tieneTe = false;
		this.tieneLeche = false;
	}
	
	public int getCantidadDeAzucar() {
		return this.cantidadDeAzucar;
	}

	public boolean tieneCafe() {
		return this.tieneCafe;
	}

	public boolean tieneAzucar() {
		if 	(this.cantidadDeAzucar > 0) {
			return true;	
		} else {
			return false;
		}
	}

	public boolean tieneTe() {
		return this.tieneTe;
	}
	
	public boolean tieneLeche() {
		return this.tieneLeche;
	}
	
	public void cambiarContenidoACafe() {
		this.tieneCafe = true;
	}
	
	public void cambiarContenidoATe() {
		this.tieneTe = true;
	}
	
	public void ponerLeche() {
		this.tieneLeche = true;
	}
	
	public void ponerNCucharadasDeAzucar(int cucharadasDeAzucar) {
		this.cantidadDeAzucar = cucharadasDeAzucar;
	}
}
