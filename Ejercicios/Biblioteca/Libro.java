package Biblioteca;

public abstract class Libro {
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private String id;
	
	public Libro(String titulo, String autor, int anioPublicacion, String id) {
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return (String.format("Título: %s, Autor: %s, Año Publicación: %d, Id: %s", titulo, autor, anioPublicacion, id));
	}
	
}
