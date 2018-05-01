package ar.edu.untref.aydoo;

public class Elector {

	private Voto voto;
	
	public Elector() {
		this.voto = null;
	}
	
	public Voto votar(Candidato candidato) {
		this.voto = new Voto(candidato);
		return this.voto;
	}

}
