package PracticaHerencia.src.Empleado;

public class Empleado {
	private String nombre;
	
	Empleado(String nombre) {
		setNombre(nombre);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return (nombre);
	}
	
	@Override
	public String toString() {
		return ("Empleado: " + nombre);
	}
}
