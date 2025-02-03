package ClaseEmpleadoNueva;

public class Persona {
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return String.format("Nombre: %s, Edad: %d", nombre, edad);
	}
	
	public void mostrarDatos() {
		System.out.println(this);
	}
}
