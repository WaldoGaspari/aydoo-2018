package ar.edu.untref.aydoo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JuntaElectoral {

	private Set<Voto> votos;
	
	public JuntaElectoral() {
		this.votos = new HashSet<Voto>();
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

}
