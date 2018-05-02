package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;



public class JuntaElectoralTest {
	
	@Test
	public void calcularCantidadDeVotosParaUnCandidatoQueFueVotadoSoloUnaVezDeberiaDarUno() {
		JuntaElectoral juntaDeLasPaso = new JuntaElectoral();
		Elector pedro = new Elector();
		Candidato martinPaz = new Candidato(Provincia.BUENOSAIRES);
		
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
		Candidato martinPaz = new Candidato(Provincia.BUENOSAIRES);
		
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
		Candidato martinPaz = new Candidato(Provincia.BUENOSAIRES);
		Candidato pedroMartinez = new Candidato(Provincia.BUENOSAIRES);
		
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
	
	@Test
	public void calcularCandidatoConMasVotosEnLaProvinciaDeBuenosAires() {
		JuntaElectoral juntaDeLasPaso = new JuntaElectoral();
		Elector maria = new Elector();
		Elector juana = new Elector();
		Elector lucas = new Elector();
		Elector juan = new Elector();
		Elector ezequiel = new Elector();
		Elector vanesa = new Elector();
		Candidato martinPaz = new Candidato(Provincia.BUENOSAIRES);
		Candidato pedroMartinez = new Candidato(Provincia.BUENOSAIRES);
		Candidato antonellaSuarez = new Candidato(Provincia.BUENOSAIRES);
		
		Voto unVoto = maria.votar(martinPaz);
		Voto segundoVoto = juana.votar(pedroMartinez);
		Voto tercerVoto = lucas.votar(martinPaz);
		Voto cuartoVoto = juan.votar(pedroMartinez);
		Voto quintoVoto = ezequiel.votar(pedroMartinez);
		Voto sextoVoto = vanesa.votar(antonellaSuarez);
		juntaDeLasPaso.agregarCandidato(martinPaz);
		juntaDeLasPaso.agregarCandidato(pedroMartinez);
		juntaDeLasPaso.agregarCandidato(antonellaSuarez);
		juntaDeLasPaso.guardarVoto(unVoto);
		juntaDeLasPaso.guardarVoto(segundoVoto);
		juntaDeLasPaso.guardarVoto(tercerVoto);
		juntaDeLasPaso.guardarVoto(cuartoVoto);
		juntaDeLasPaso.guardarVoto(quintoVoto);
		juntaDeLasPaso.guardarVoto(sextoVoto);
		Candidato candidatoGanador = juntaDeLasPaso.obtenerCandidatoConMasVotosDeUnaProvincia(Provincia.BUENOSAIRES);
		
		Assert.assertEquals(pedroMartinez, candidatoGanador);
	}

}
