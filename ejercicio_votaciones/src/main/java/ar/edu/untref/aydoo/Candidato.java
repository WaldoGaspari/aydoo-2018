package ar.edu.untref.aydoo;

public class Candidato {
	
	private Provincia provincia;
	private String nombre;
	private boolean tieneUnPartido;
	
	public Candidato(String nombre, Provincia provincia) {
		this.provincia = provincia;
		this.nombre = nombre;
		this.tieneUnPartido = false;
	}
	
	public Provincia obtenerProvincia() {
		return this.provincia;
	}
	
	public boolean tieneUnPartidoAsignado() {
		return this.tieneUnPartido;
	}
	
	public void seLeAsignaUnPartido() {
		this.tieneUnPartido = true;
	}
}
