package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;



public class JuntaElectoralTest {
	
	@Test
	public void calcularCantidadDeVotosParaUnCandidatoQueFueVotadoSoloUnaVezDeberiaDarUno() {
		JuntaElectoral juntaDeLasPaso = new JuntaElectoral();
		Elector pedro = new Elector();
		Candidato martinPaz = new Candidato();
		
		Voto voto = pedro.votar(martinPaz);
		juntaDeLasPaso.guardarVoto(voto);
		
		Assert.assertEquals(1, juntaDeLasPaso.contarVotosDeUnCandidato(martinPaz));
	}
	
	@Test
	public void calcularCantidadDeVotosParaUnCandidatoQueFueVotadoTresVecesDeberiaDarTres() {
		JuntaElectoral juntaDeLasPaso = new JuntaElectoral();
		Elector pedro = new Elector();
		Elector juan = new Elector();
		Elector manuel = new Elector();
		Candidato martinPaz = new Candidato();
		
		Voto unVoto = pedro.votar(martinPaz);
		Voto segundoVoto = juan.votar(martinPaz);
		Voto tercerVoto = manuel.votar(martinPaz);
		juntaDeLasPaso.guardarVoto(unVoto);
		juntaDeLasPaso.guardarVoto(segundoVoto);
		juntaDeLasPaso.guardarVoto(tercerVoto);
		
		Assert.assertEquals(3, juntaDeLasPaso.contarVotosDeUnCandidato(martinPaz));
	}
	
	@Test
	public void calcularCantidadDeVotosParaUnCandidatoQueFueVotadoDosVecesHabiendoOtroCandidatoDeberiaDarDos() {
		JuntaElectoral juntaDeLasPaso = new JuntaElectoral();
		Elector maria = new Elector();
		Elector juana = new Elector();
		Elector lucas = new Elector();
		Elector juan = new Elector();
		Candidato martinPaz = new Candidato();
		Candidato pedroMartinez = new Candidato();
		
		Voto unVoto = maria.votar(martinPaz);
		Voto segundoVoto = juana.votar(pedroMartinez);
		Voto tercerVoto = lucas.votar(martinPaz);
		Voto cuartoVoto = juan.votar(pedroMartinez);
		juntaDeLasPaso.guardarVoto(unVoto);
		juntaDeLasPaso.guardarVoto(segundoVoto);
		juntaDeLasPaso.guardarVoto(tercerVoto);
		juntaDeLasPaso.guardarVoto(cuartoVoto);
		
		Assert.assertEquals(2, juntaDeLasPaso.contarVotosDeUnCandidato(martinPaz));
	}

}
