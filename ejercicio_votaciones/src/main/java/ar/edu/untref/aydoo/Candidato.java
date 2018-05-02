package ar.edu.untref.aydoo;

public class Candidato {
	
	private Provincia provincia;
	
	public Candidato(Provincia provincia) {
		this.provincia = provincia;
	}
	
	public Provincia obtenerProvincia() {
		return this.provincia;
	}

}
