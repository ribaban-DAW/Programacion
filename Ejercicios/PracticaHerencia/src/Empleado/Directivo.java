package PracticaHerencia.src.Empleado;

public class Directivo extends Empleado {
	Directivo(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return (super.toString() + " -> Directivo");
	}
}
