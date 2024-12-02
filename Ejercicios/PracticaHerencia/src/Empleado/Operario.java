package PracticaHerencia.src.Empleado;

public class Operario extends Empleado {
	Operario(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return (super.toString() + " -> Operario");
	}
}
