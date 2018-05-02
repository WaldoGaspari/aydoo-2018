package ar.edu.untref.aydoo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class JuntaElectoral {

	private Set<Voto> votos;
	private List<Candidato> candidatos;
	
	public JuntaElectoral() {
		this.votos = new HashSet<Voto>();
		this.candidatos = new LinkedList<Candidato>();
	}
	
	public int contarVotosDeUnCandidato(Candidato candidato) {
		int total = 0;
		Iterator<Voto> iterador = this.votos.iterator();
		while (iterador.hasNext()) {
			Voto voto = iterador.next();
			if (voto.obtenerCandidato().equals(candidato)) {
				total++;
			}
		}
		return total;
	}

	public void guardarVoto(Voto voto) {
		this.votos.add(voto);
	}

	public void agregarCandidato(Candidato candidato) {
		this.candidatos.add(candidato);
	}

	public Candidato obtenerCandidatoConMasVotosDeUnaProvincia(Provincia provincia) {
		Candidato candidatoGanador = null;
		int cantidadDeVotos = 0;
		Iterator<Candidato> iterador = this.candidatos.iterator();
		while (iterador.hasNext()) {
			Candidato candidato = iterador.next();
			if (candidato.obtenerProvincia() == provincia) {
				int votos = contarVotosDeUnCandidato(candidato);
				if (votos > cantidadDeVotos) {
					cantidadDeVotos = votos;
					candidatoGanador = candidato;
				}
			}
		}
		return candidatoGanador;
	}

}
