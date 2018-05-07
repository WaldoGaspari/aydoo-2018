package ar.edu.untref.aydoo;

public class CandidatoEnUnPartidoException extends Exception {
	
	public CandidatoEnUnPartidoException() {
		super("El candidato ya se encuentra asignado a un partido.");
	}
}
