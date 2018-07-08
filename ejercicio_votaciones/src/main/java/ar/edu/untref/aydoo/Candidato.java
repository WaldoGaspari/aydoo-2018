package ar.edu.untref.aydoo;

public class Candidato {
	
	private Provincia provincia;
	private String nombre;
	private Partido partido;
	
	public Candidato(String nombre, Provincia provincia) {
		this.provincia = provincia;
		this.nombre = nombre;
		this.partido = null;
	}
	
	public Provincia obtenerProvincia() {
		return this.provincia;
	}
	
	public Partido obtenerPartido() {
		return this.partido;
	}
	
	public void asignarPartido(Partido partido) {
		this.partido = partido;
	}
}
