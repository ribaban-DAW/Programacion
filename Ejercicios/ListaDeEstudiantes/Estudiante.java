package ListaDeEstudiantes;

import java.util.Objects;

public class Estudiante {
	private String nombre;
	private int edad;
	
	public Estudiante(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public String toString() {
		return (String.format("Nombre: %s, Edad: %d", nombre, edad));
	}
}
