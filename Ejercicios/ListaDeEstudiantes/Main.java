package ListaDeEstudiantes;

import java.util.*;

public class Main {
	
	public static LinkedHashSet<Estudiante> estudiantes = new LinkedHashSet<>();

	public static void agregarEstudiante() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce una edad");
		String edadCadena = sc.nextLine();
		try {			
			int edad = Integer.parseInt(edadCadena);
			if (edad < 0) {
				throw new Exception();
			}
			if (!estudiantes.add(new Estudiante(nombre, edad)))
			{
				System.err.println("Ya existe un estudiante con ese nombre y edad");
			}
		}
		catch (Exception e) {
			System.err.println("Error en la edad");
			return;
		}
		System.out.println("Estudiante añadido");
	}
	
	public static void eliminarEstudiante() {
		if (estudiantes.size() == 0) {
			System.err.println("No se puede eliminar nada porque no hay estudiantes");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce una edad");
		String edadCadena = sc.nextLine();
		try {			
			int edad = Integer.parseInt(edadCadena);
			if (edad < 0) {
				throw new Exception();
			}
			if (!estudiantes.remove(new Estudiante(nombre, edad)))
			{
				System.err.println("No existe un estudiante con ese nombre y edad");
			}
		}
		catch (Exception e) {
			System.err.println("Error en la edad");
			return;
		}
		System.out.println("Estudiante eliminado");
	}
	
	public static void mostrarEstudiantes() {
		for (Estudiante e: estudiantes) {
			System.out.println(e);
		}
	}
	
	public static void mostrarMenu() {
		System.out.println("""
				1. Agregar estudiante
				2. Eliminar un estudiante
				3. Mostrar todos los estudiantes
				4. Salir
				""");
	}

	
	
	
	public static void main(String[] args) {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			mostrarMenu();			
			System.out.println("Introduce una opción");
			String opcionCadena = sc.nextLine();
			try {
				opcion = Integer.parseInt(opcionCadena);
				if (opcion < 1 || opcion > 4) {
					throw new Exception();
				}
			}
			catch (Exception e) {
				System.err.println("Opción inválida");
				continue;
			}
			switch (opcion) {
			case 1:
				agregarEstudiante();
				break;
			case 2:
				eliminarEstudiante();
				break;
			case 3:
				mostrarEstudiantes();
				break;
			case 4:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.err.println("Aquí nunca debería llegar");
				break;
			}
		} while(opcion != 4);
	}
}
