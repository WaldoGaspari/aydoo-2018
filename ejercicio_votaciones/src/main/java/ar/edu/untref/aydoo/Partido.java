package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {

	private List<Candidato> candidatos;
	
	public Partido() {
		this.candidatos = new LinkedList<Candidato>();
	}
	
	public void agregarCandidato(Candidato candidato) throws CandidatoEnUnPartidoException {
		if (candidato.obtenerPartido() == null) {
			this.candidatos.add(candidato);
			candidato.asignarPartido(this);
			
		} else {
			throw new CandidatoEnUnPartidoException();
		}
	}
	
	public List<Candidato> obtenerListaDeCandidatos() {
		return this.candidatos;
	}

}
