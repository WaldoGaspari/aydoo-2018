package ar.edu.untref.aydoo;

public class VotoUnicoException extends Exception {
	
	public VotoUnicoException() {
		super("El elector ya vot�. No puede hacerlo de nuevo");
	}
}
