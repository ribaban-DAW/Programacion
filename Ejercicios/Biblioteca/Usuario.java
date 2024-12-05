package Biblioteca;

public abstract class Usuario implements AccionesUsuario {
	private String nombre;
	private String id;
	private int librosPrestados;
	
	public Usuario(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
		librosPrestados = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getLibrosPrestados() {
		return librosPrestados;
	}
	
	public void incrementarLibrosPrestados() {
		++librosPrestados;
	}
	
	public void decrementarLibrosPrestados() {
		--librosPrestados;
	}
	
	@Override
	public String toString() {
		return (String.format("Nombre: %s, Id: %s Libros prestados: %d", nombre, id, librosPrestados));
	}
}
