package ar.edu.untref.aydoo;

public class VotoUnicoException extends Exception {
	
	public VotoUnicoException() {
		super("El elector ya votó. No puede hacerlo de nuevo");
	}
}
