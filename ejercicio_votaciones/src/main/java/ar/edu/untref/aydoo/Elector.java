package ar.edu.untref.aydoo;

public class Elector {

	private Voto voto;
	
	public Elector() {
		this.voto = null;
	}
	
	public Voto votar(Candidato candidato){
		if (this.voto == null) {
			this.voto = new Voto(candidato);
			return this.voto;
		} else {
			throw new Error("El elector ya votó. No puede hacerlo de nuevo");
		}
	}

}
