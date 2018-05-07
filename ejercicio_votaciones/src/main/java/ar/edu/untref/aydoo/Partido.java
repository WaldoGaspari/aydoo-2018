package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {

	private List<Candidato> candidatos;
	private int votosTotales;
	
	public Partido() {
		this.candidatos = new LinkedList<Candidato>();
		this.votosTotales = 0;
	}
	
	public void agregarCandidato(Candidato candidato) throws CandidatoEnUnPartidoException {
		if (!candidato.tieneUnPartidoAsignado()) {
			this.candidatos.add(candidato);
			candidato.seLeAsignaUnPartido();
			
		} else {
			throw new CandidatoEnUnPartidoException();
		}
	}
	
	public void agregarVotos(int cantidad) {
		this.votosTotales += cantidad;
	}
	
	public List<Candidato> obtenerListaDeCandidatos() {
		return this.candidatos;
	}
	
	public int obtenerVotosTotales() {
		return this.votosTotales;
	}

}
