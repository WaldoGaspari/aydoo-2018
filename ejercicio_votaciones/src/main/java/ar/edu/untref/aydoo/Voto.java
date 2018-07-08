package ar.edu.untref.aydoo;

public class Voto {

	private Candidato candidato;
	
	public Voto(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public Candidato obtenerCandidato() {
		return this.candidato;
	}

}
