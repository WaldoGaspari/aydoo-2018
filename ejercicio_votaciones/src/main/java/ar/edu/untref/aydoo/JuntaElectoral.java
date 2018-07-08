package ar.edu.untref.aydoo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class JuntaElectoral {

	private Set<Voto> votos;
	private List<Candidato> candidatos;
	private List<Partido> partidos;
	
	public JuntaElectoral() {
		this.votos = new HashSet<Voto>();
		this.candidatos = new LinkedList<Candidato>();
		this.partidos = new LinkedList<Partido>();
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
	
	public void agregarPartido(Partido partido) {
		this.partidos.add(partido);
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

	public Partido obtenerPartidoConMasVotosANivelNacional() {
		Partido partidoGanador = null;
		int votosTotales = 0;
		Provincia[] provincias = Provincia.values();
		Iterator<Partido> iterador = this.partidos.iterator();
		while (iterador.hasNext()) {
			Partido partido = iterador.next();
			int votosDelPartido = 0;
			for (int posicion = 0; posicion < provincias.length; posicion++) {
				for (int posicionCandidato = 0; posicionCandidato < partido.obtenerListaDeCandidatos().size(); posicionCandidato++) {
					Candidato candidato = partido.obtenerListaDeCandidatos().get(posicionCandidato);
					if (candidato.obtenerProvincia() == provincias[posicion]) {
						votosDelPartido += contarVotosDeUnCandidato(candidato);
					}
				}
			}
			if (votosDelPartido > votosTotales) {
				votosTotales = votosDelPartido;
				partidoGanador = partido;
			}
		}
		return partidoGanador;
	}

}
