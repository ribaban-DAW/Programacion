package Biblioteca;

public class Estudiante extends Usuario {
	private final int LIMITE_LIBROS = 5;
	
	public Estudiante(String nombre, String id) {
		super(nombre, id);
	}
	
	@Override
	public boolean prestarLibro(LibroFisico libro) {
		if (super.getLibrosPrestados() < LIMITE_LIBROS && libro.prestarEjemplar()) {
			super.incrementarLibrosPrestados();
			return (true);
		}
		return (false);
	}
	
	@Override
	public void descargarLibro(LibroDigital libro) {
		if (super.getLibrosPrestados() < LIMITE_LIBROS) {			
			super.incrementarLibrosPrestados();
			System.out.println("Se ha descargado el libro");
			return;
		}
		System.err.println("No se ha podido descargar el libro");
	}
}
