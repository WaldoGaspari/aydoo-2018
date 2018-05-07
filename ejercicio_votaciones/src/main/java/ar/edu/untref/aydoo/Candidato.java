package ar.edu.untref.aydoo;

public class Candidato {
	
	private Provincia provincia;
	private String nombre;
	
	public Candidato(String nombre, Provincia provincia) {
		this.provincia = provincia;
		this.nombre = nombre;
	}
	
	public Provincia obtenerProvincia() {
		return this.provincia;
	}
}
