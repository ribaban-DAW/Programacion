package Biblioteca;

public class LibroFisico extends Libro {
	private int ejemplaresDisponibles;
	
	public LibroFisico(String titulo, String autor, int anioPublicacion, String id, int ejemplaresDisponibles) {
		super(titulo, autor, anioPublicacion, id);
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}
	
	public boolean prestarEjemplar() {
		if (ejemplaresDisponibles == 0) {
			return (false);
		}
		--ejemplaresDisponibles;
		return (true);
	}
	
	public void devolverEjemplar() {
		++ejemplaresDisponibles;
	}
	
	@Override
	public String toString() {
		return (String.format("%s, Ejemplares: %d", super.toString(), ejemplaresDisponibles));
	}
}
