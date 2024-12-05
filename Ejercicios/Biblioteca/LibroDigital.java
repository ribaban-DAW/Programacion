package Biblioteca;

public class LibroDigital extends Libro {
	private double tamanoArchivo;
	
	public LibroDigital(String titulo, String autor, int anioPublicacion, String id, double tamanoArchivo) {
		super(titulo, autor, anioPublicacion, id);
		this.tamanoArchivo = tamanoArchivo;
	}
	
	@Override
	public String toString() {
		return (String.format("%s, Tamaño: %f", super.toString(), tamanoArchivo));
	}
}
