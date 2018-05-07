package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JuntaElectoralTest {
	
	JuntaElectoral juntaDeLasPaso;
	@Before
	public void crearJuntaElectoral() {
		juntaDeLasPaso = new JuntaElectoral();
	}
	
	@Test
	public void calcularCantidadDeVotosParaUnCandidatoQueFueVotadoSoloUnaVezDeberiaDarUno() {
		Elector pedro = new Elector();
		Candidato martinPaz = new Candidato("Martin Paz",Provincia.BUENOSAIRES);
		
		Voto voto = pedro.votar(martinPaz);
		juntaDeLasPaso.guardarVoto(voto);
		
		Assert.assertEquals(1, juntaDeLasPaso.contarVotosDeUnCandidato(martinPaz));
	}
	
	@Test
	public void calcularCantidadDeVotosParaUnCandidatoQueFueVotadoTresVecesDeberiaDarTres() {
		Elector pedro = new Elector();
		Elector juan = new Elector();
		Elector manuel = new Elector();
		Candidato martinPaz = new Candidato("Martin Paz", Provincia.BUENOSAIRES);
		
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
		Elector maria = new Elector();
		Elector juana = new Elector();
		Elector lucas = new Elector();
		Elector juan = new Elector();
		Candidato martinPaz = new Candidato("Martin Paz", Provincia.BUENOSAIRES);
		Candidato pedroMartinez = new Candidato("Pedro Martinez", Provincia.BUENOSAIRES);
		
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
		Elector maria = new Elector();
		Elector juana = new Elector();
		Elector lucas = new Elector();
		Elector juan = new Elector();
		Elector ezequiel = new Elector();
		Elector vanesa = new Elector();
		Candidato martinPaz = new Candidato("Martin Paz", Provincia.BUENOSAIRES);
		Candidato pedroMartinez = new Candidato("Pedro Martinez", Provincia.BUENOSAIRES);
		Candidato antonellaSuarez = new Candidato("Antonella Suarez", Provincia.BUENOSAIRES);
		
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
	
	@Test
	public void calcularCandidatoConMasVotosEnLaProvinciaDeBuenosAiresHabiendoCandidatosEnOtrasProvincias() {
		Elector maria = new Elector();
		Elector juana = new Elector();
		Elector lucas = new Elector();
		Elector juan = new Elector();
		Elector ezequiel = new Elector();
		Elector vanesa = new Elector();
		Elector nahuel = new Elector();
		Elector marta = new Elector();
		Candidato martinPaz = new Candidato("Martin Paz", Provincia.BUENOSAIRES);
		Candidato pedroMartinez = new Candidato("Pedro Martinez", Provincia.BUENOSAIRES);
		Candidato antonellaSuarez = new Candidato("Antonella Suarez", Provincia.CATAMARCA);
		Candidato lorenaJimenez = new Candidato("Lorena Jimenez", Provincia.CHACO);
		
		Voto unVoto = maria.votar(martinPaz);
		Voto segundoVoto = juana.votar(pedroMartinez);
		Voto tercerVoto = lucas.votar(martinPaz);
		Voto cuartoVoto = juan.votar(pedroMartinez);
		Voto quintoVoto = ezequiel.votar(antonellaSuarez);
		Voto sextoVoto = vanesa.votar(lorenaJimenez);
		Voto septimoVoto = nahuel.votar(martinPaz);
		Voto octavoVoto = marta.votar(antonellaSuarez);
		juntaDeLasPaso.agregarCandidato(martinPaz);
		juntaDeLasPaso.agregarCandidato(pedroMartinez);
		juntaDeLasPaso.agregarCandidato(antonellaSuarez);
		juntaDeLasPaso.agregarCandidato(lorenaJimenez);
		juntaDeLasPaso.guardarVoto(unVoto);
		juntaDeLasPaso.guardarVoto(segundoVoto);
		juntaDeLasPaso.guardarVoto(tercerVoto);
		juntaDeLasPaso.guardarVoto(cuartoVoto);
		juntaDeLasPaso.guardarVoto(quintoVoto);
		juntaDeLasPaso.guardarVoto(sextoVoto);
		juntaDeLasPaso.guardarVoto(septimoVoto);
		juntaDeLasPaso.guardarVoto(octavoVoto);
		Candidato candidatoGanador = juntaDeLasPaso.obtenerCandidatoConMasVotosDeUnaProvincia(Provincia.BUENOSAIRES);
		
		Assert.assertEquals(martinPaz, candidatoGanador);
	}
	
	@Test
	public void calcularPartidoConMasVotosANivelNacionalDeberiaDarPartidoJusticialista() {
		Elector maria = new Elector();
		Elector juana = new Elector();
		Elector lucas = new Elector();
		Elector juan = new Elector();
		Elector ezequiel = new Elector();
		Elector vanesa = new Elector();
		Elector nahuel = new Elector();
		Elector marta = new Elector();
		Elector eduardo = new Elector();
		Elector isabel = new Elector();
		Candidato martinPaz = new Candidato("Martin Paz", Provincia.BUENOSAIRES);
		Candidato pedroMartinez = new Candidato("Pedro Martinez", Provincia.CORDOBA);
		Candidato antonellaSuarez = new Candidato("Antonella Suarez", Provincia.CATAMARCA);
		Candidato lorenaJimenez = new Candidato("Lorena Jimenez", Provincia.CHACO);
		Partido partidoJusticialista = new Partido();
		Partido partidoRadical = new Partido();
		
		partidoJusticialista.agregarCandidato(martinPaz);
		partidoJusticialista.agregarCandidato(antonellaSuarez);
		partidoRadical.agregarCandidato(pedroMartinez);
		partidoRadical.agregarCandidato(lorenaJimenez);
		Voto unVoto = maria.votar(antonellaSuarez);
		Voto segundoVoto = juana.votar(pedroMartinez);
		Voto tercerVoto = lucas.votar(martinPaz);
		Voto cuartoVoto = juan.votar(pedroMartinez);
		Voto quintoVoto = ezequiel.votar(antonellaSuarez);
		Voto sextoVoto = vanesa.votar(lorenaJimenez);
		Voto septimoVoto = nahuel.votar(martinPaz);
		Voto octavoVoto = marta.votar(antonellaSuarez);
		Voto novenoVoto = eduardo.votar(antonellaSuarez);
		Voto decimoVoto = isabel.votar(pedroMartinez);
		juntaDeLasPaso.agregarCandidato(martinPaz);
		juntaDeLasPaso.agregarCandidato(pedroMartinez);
		juntaDeLasPaso.agregarCandidato(antonellaSuarez);
		juntaDeLasPaso.agregarCandidato(lorenaJimenez);
		juntaDeLasPaso.agregarPartido(partidoJusticialista);
		juntaDeLasPaso.agregarPartido(partidoRadical);
		juntaDeLasPaso.guardarVoto(unVoto);
		juntaDeLasPaso.guardarVoto(segundoVoto);
		juntaDeLasPaso.guardarVoto(tercerVoto);
		juntaDeLasPaso.guardarVoto(cuartoVoto);
		juntaDeLasPaso.guardarVoto(quintoVoto);
		juntaDeLasPaso.guardarVoto(sextoVoto);
		juntaDeLasPaso.guardarVoto(septimoVoto);
		juntaDeLasPaso.guardarVoto(octavoVoto);
		juntaDeLasPaso.guardarVoto(novenoVoto);
		juntaDeLasPaso.guardarVoto(decimoVoto);
		Partido partidoGanador = juntaDeLasPaso.obtenerPartidoConMasVotosANivelNacional();
		
		Assert.assertEquals(partidoJusticialista, partidoGanador);
	}
	
	@Test
	public void calcularPartidoConMasVotosDeberiaDarPartidoRadicalHabiendoOtrosDosPartidos() {
		Elector maria = new Elector();
		Elector juana = new Elector();
		Elector lucas = new Elector();
		Elector juan = new Elector();
		Elector ezequiel = new Elector();
		Elector vanesa = new Elector();
		Elector nahuel = new Elector();
		Elector marta = new Elector();
		Elector eduardo = new Elector();
		Elector isabel = new Elector();
		Elector lorena = new Elector();
		Elector marcelo = new Elector();
		Candidato martinPaz = new Candidato("Martin Paz", Provincia.BUENOSAIRES);
		Candidato pedroMartinez = new Candidato("Pedro Martinez", Provincia.CORDOBA);
		Candidato antonellaSuarez = new Candidato("Antonella Suarez", Provincia.CATAMARCA);
		Candidato lorenaJimenez = new Candidato("Lorena Jimenez", Provincia.CHACO);
		Candidato augustoGarcia = new Candidato("Augusto Garcia", Provincia.CHACO);
		Partido partidoJusticialista = new Partido();
		Partido partidoRadical = new Partido();
		Partido partidoSocialista = new Partido();
		
		partidoJusticialista.agregarCandidato(martinPaz);
		partidoJusticialista.agregarCandidato(antonellaSuarez);
		partidoRadical.agregarCandidato(pedroMartinez);
		partidoRadical.agregarCandidato(lorenaJimenez);
		partidoSocialista.agregarCandidato(augustoGarcia);
		Voto unVoto = maria.votar(antonellaSuarez);
		Voto segundoVoto = juana.votar(pedroMartinez);
		Voto tercerVoto = lucas.votar(martinPaz);
		Voto cuartoVoto = juan.votar(antonellaSuarez);
		Voto quintoVoto = ezequiel.votar(pedroMartinez);
		Voto sextoVoto = vanesa.votar(lorenaJimenez);
		Voto septimoVoto = nahuel.votar(lorenaJimenez);
		Voto octavoVoto = marta.votar(antonellaSuarez);
		Voto novenoVoto = eduardo.votar(pedroMartinez);
		Voto decimoVoto = isabel.votar(pedroMartinez);
		Voto undecimoVoto = lorena.votar(augustoGarcia);
		Voto duodecimoVoto = marcelo.votar(augustoGarcia);
		juntaDeLasPaso.agregarCandidato(martinPaz);
		juntaDeLasPaso.agregarCandidato(pedroMartinez);
		juntaDeLasPaso.agregarCandidato(antonellaSuarez);
		juntaDeLasPaso.agregarCandidato(lorenaJimenez);
		juntaDeLasPaso.agregarCandidato(augustoGarcia);
		juntaDeLasPaso.agregarPartido(partidoJusticialista);
		juntaDeLasPaso.agregarPartido(partidoRadical);
		juntaDeLasPaso.agregarPartido(partidoSocialista);
		juntaDeLasPaso.guardarVoto(unVoto);
		juntaDeLasPaso.guardarVoto(segundoVoto);
		juntaDeLasPaso.guardarVoto(tercerVoto);
		juntaDeLasPaso.guardarVoto(cuartoVoto);
		juntaDeLasPaso.guardarVoto(quintoVoto);
		juntaDeLasPaso.guardarVoto(sextoVoto);
		juntaDeLasPaso.guardarVoto(septimoVoto);
		juntaDeLasPaso.guardarVoto(octavoVoto);
		juntaDeLasPaso.guardarVoto(novenoVoto);
		juntaDeLasPaso.guardarVoto(decimoVoto);
		juntaDeLasPaso.guardarVoto(undecimoVoto);
		juntaDeLasPaso.guardarVoto(duodecimoVoto);
		Partido partidoGanador = juntaDeLasPaso.obtenerPartidoConMasVotosANivelNacional();
		
		Assert.assertEquals(partidoRadical, partidoGanador);
	}
	
	@Test (expected = Error.class)
	public void unElectorSoloDeberiaPoderVotarUnaSolaVez(){
		Elector eduardo = new Elector();
		Candidato antonellaSuarez = new Candidato("Antonella Suarez", Provincia.CATAMARCA);
		Candidato lorenaJimenez = new Candidato("Lorena Jimenez", Provincia.CHACO);
		
		Voto unVoto = eduardo.votar(antonellaSuarez);
		Voto segundoVoto = eduardo.votar(lorenaJimenez);
		
		Assert.assertEquals(null, segundoVoto.obtenerCandidato());
		Assert.assertEquals(unVoto.obtenerCandidato(), antonellaSuarez);
	}

}
