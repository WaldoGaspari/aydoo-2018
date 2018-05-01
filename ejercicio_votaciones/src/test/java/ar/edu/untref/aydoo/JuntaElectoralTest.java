package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;



public class JuntaElectoralTest {
	
	@Test
	public void sgsgsdgg() {
		JuntaElectoral juntaDeLasPaso = new JuntaElectoral();
		Elector pedro = new Elector();
		Candidato martinPaz = new Candidato();
		
		Voto voto = pedro.votar(martinPaz);
		juntaDeLasPaso.guardarVoto(voto);
		
		Assert.assertEquals(1, juntaDeLasPaso.contarVotosDeUnCandidato(martinPaz));
	}

}
