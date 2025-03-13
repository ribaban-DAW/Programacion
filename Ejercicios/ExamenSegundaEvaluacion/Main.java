package ExamenSegundaEvaluacion;

import java.util.*;

/**
 * TODO:
 * 
 * - [x] Agregar vehículos
 * - [x] Buscar vehículos
 * - [x] Eliminar vehículos
 * - [x] Calcular el precio medio del alquiler en X días
 * - [x] Mostrar lista de matrículas con el mismo año de fabricación
 * 
 * IMPORTANT: Los dos últimos me falta pasarlo a Streams.
 */

public class Main {
	
	public static void testGeneral() {
		Flota flota = new Flota();
		int anioFabricacion = 1990;
		
		// ======================================================
		// AGREGAR VEHÍCULOS
		// ======================================================
		
		for (int i = 0; i < 4; ++i) {
			boolean tieneSidecar = i % 2 == 0;
			String matricula = String.format("%d%d%d%d ABC", i%10, 0, (i+2)%10, (i+3)%10, null);
			flota.agregarVehiculo(new Moto(matricula,
											"marca" + i,
											++anioFabricacion,
											tieneSidecar));
		}
		
		for (int i = 4; i < 8; ++i) {
			String matricula = String.format("%d%d%d%d ABC", i%10, (i+1)%10, 1, (i+3)%10, null);
			flota.agregarVehiculo(new Coche(matricula,
											"marca" + i,
											++anioFabricacion,
											i));
		}
		
		// Empiezo en 7 intencionadamente para que salte un error
		for (int i = 7; i < 12; ++i) {
			String matricula = String.format("%d%d%d%d ABC", i%10, (i+1)%10, 1, (i+3)%10, null);
			flota.agregarVehiculo(new Vehiculo(matricula,
												"marca" + i,
												anioFabricacion));
		}
		
		// ======================================================
		// BUSCAR VEHÍCULOS
		// ======================================================
		
		flota.buscarVehiculo("7810 ABC");
		flota.buscarVehiculo("1214 ABC");
		flota.buscarVehiculo("3214 ABC");
		flota.buscarVehiculo("0023 ABC");
		flota.buscarVehiculo("9213 ABC");
		
		// ======================================================
		// ELIMINAR VEHÍCULOS
		// ======================================================

		flota.eliminarVehiculo("7810 ABC");
		flota.eliminarVehiculo("1214 ABC");
		flota.eliminarVehiculo("3214 ABC");
		flota.eliminarVehiculo("0023 ABC");
		flota.eliminarVehiculo("9213 ABC");

		// ======================================================
		// CALCULAR PRECIO MEDIO POR DÍAS
		// ======================================================
		
		for (int i = 0; i < 60; i += 7) {
			double precioMedio = flota.calcularPrecioMedioTotal(i);
			System.out.printf("El precio medio de todos los vehículos de la flota por %d días es de %.2f €%n", i, precioMedio);
		}
		
		// ======================================================
		// MOSTRAR LISTA DE MATRICULAS EN X AÑO
		// ======================================================
		
		for (int i = 0; i < 10; ++i) {
			int anio = anioFabricacion - i;
			System.out.printf("Lista de matrículas de vehículos fabricados en %d:%n", anio);
			List<String> matriculas = flota.obtenerMatriculasDeUnAnio(anio);
			matriculas.stream()
						.map(s -> "    " + s)
						.forEach(System.out::println);
		}
	}
	
	public static void testFlotaVacia() {
		Flota flota = new Flota();
		
		// ======================================================
		// BUSCAR VEHÍCULOS
		// ======================================================
		
		flota.buscarVehiculo("hola");
		flota.buscarVehiculo("mundo");
		flota.buscarVehiculo("adios");
		flota.buscarVehiculo("123askdj");

		// ======================================================
		// ELIMINAR VEHÍCULOS
		// ======================================================
		
		flota.eliminarVehiculo("hola");
		flota.eliminarVehiculo("mundo");
		flota.eliminarVehiculo("adios");
		flota.eliminarVehiculo("123askdj");
		
		// ======================================================
		// CALCULAR PRECIO MEDIO POR DÍAS
		// ======================================================
		
		for (int i = 0; i < 60; i += 7) {
			double precioMedio = flota.calcularPrecioMedioTotal(i);
			System.out.printf("El precio medio de todos los vehículos de la flota por %d días es de %.2f%n", i, precioMedio);
		}
	}
	
	public static void testFlotaUnVehiculo() {
		Flota flota = new Flota();
		int anioFabricacion = 2003;
		
		// ======================================================
		// AGREGAR VEHÍCULOS
		// ======================================================

		flota.agregarVehiculo(new Coche("2706 RIB", "Normalita", 2003, 4));
		
		// ======================================================
		// BUSCAR VEHÍCULOS
		// ======================================================

		flota.buscarVehiculo("hola");
		flota.buscarVehiculo("123askdj");
		flota.buscarVehiculo("2706 RIB");
		
		// ======================================================
		// ELIMINAR VEHÍCULOS
		// ======================================================
		
		flota.eliminarVehiculo("hola");
		flota.eliminarVehiculo("inexistente");
		
		// ======================================================
		// CALCULAR PRECIO MEDIO POR DÍAS
		// ======================================================
		for (int i = 0; i < 60; i += 7) {
			double precioMedio = flota.calcularPrecioMedioTotal(i);
			System.out.printf("El precio medio de todos los vehículos de la flota por %d días es de %.2f%n", i, precioMedio);
		}

		// ======================================================
		// MOSTRAR LISTA DE MATRICULAS EN X AÑO
		// ======================================================
		
		System.out.printf("Lista de matrículas de vehículos fabricados en %d:%n", anioFabricacion);
		List<String> matriculas = flota.obtenerMatriculasDeUnAnio(anioFabricacion);
		matriculas.stream()
					.map(s -> "    " + s)
					.forEach(System.out::println);
	}
	
	public static void testFlotaDosVehiculos() {
		Flota flota = new Flota();
		int anioFabricacion = 1999;
		
		// ======================================================
		// AGREGAR VEHÍCULOS
		// ======================================================
		
		flota.agregarVehiculo(new Vehiculo("2222 AAA", "a", anioFabricacion));
		flota.agregarVehiculo(new Vehiculo("3333 BBB", "a", anioFabricacion));

		// ======================================================
		// BUSCAR VEHÍCULOS
		// ======================================================
		flota.buscarVehiculo("2222 AAA");
		
		// ======================================================
		// CALCULAR PRECIO MEDIO POR DÍAS
		// ======================================================
		for (int i = 0; i < 60; i += 7) {
			double precioMedio = flota.calcularPrecioMedioTotal(i);
			System.out.printf("El precio medio de todos los vehículos de la flota por %d días es de %.2f%n", i, precioMedio);
		}
		
		// ======================================================
		// MOSTRAR LISTA DE MATRICULAS EN X AÑO
		// ======================================================
		
		System.out.printf("Lista de matrículas de vehículos fabricados en %d:%n", anioFabricacion);
		List<String> matriculas = flota.obtenerMatriculasDeUnAnio(anioFabricacion);
		matriculas.stream()
					.map(s -> "    " + s)
					.forEach(System.out::println);
		
		// ======================================================
		// ELIMINAR VEHÍCULOS
		// ======================================================
		
		flota.eliminarVehiculo("2222 AAA");
		flota.eliminarVehiculo("n");
	}
	
	public static void testInvalidoMatriculaErronea() {
		Flota flota = new Flota();
		
		// ======================================================
		// AGREGAR VEHÍCULOS
		// ======================================================
		
		flota.agregarVehiculo(new Vehiculo("1303 Mña", "a", 1));
	}
	
	public static void main(String[] args) {
		// NOTA: Modificar este número para probar diferentes test, para una mejor legibilidad porque hay mucho texto
		final int NUM_TEST = 1;
		try {			
			switch (NUM_TEST) {
			case 1:
				testGeneral();
				break;
			case 2:
				testFlotaVacia();
				break;
			case 3:
				testFlotaUnVehiculo();
				break;
			case 4:
				testFlotaDosVehiculos();
				break;
			case 5:
				testInvalidoMatriculaErronea();
				break;
			default:
				System.err.println("Este test no existe");
				break;
			}
		}
		catch (Exception e) {
			System.err.printf("Error en el test %d%n", NUM_TEST);
			System.err.println(e.getMessage());
		}
	}
}
