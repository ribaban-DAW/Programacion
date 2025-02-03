package ClaseEmpleadoNueva;

import java.util.*;

public class Directivo extends Empleado {
	private String categoria;
	private List<Empleado> empleados;
	
	public Directivo(String nombre, int edad, double sueldo, String categoria) {
		super(nombre, edad, sueldo);
		setCategoria(categoria);
		empleados = new ArrayList<>();
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void agregarSubordinado(Empleado empleado) {
		empleados.add(empleado);
	}

	@Override
	public String toString() {
		return String.format("%s, Categoría: %s", super.toString(), categoria);
	}
	
	@Override
	public void mostrarDatos() {
		System.out.println(this);
		System.out.println("Lista de subordinados");
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
	}
}
