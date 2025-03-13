package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 8. Reducción mutable con Collectors

public class Ejercicio8 {

	// 8.1 Recolectores a estructuras de datos clásicas
	// Convierte el stream en una lista.
	public static void recolectoresEstructurasDatosClasicas() {
		System.out.println("================");
		System.out.println("| Apartado 8.1 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		String tipoDeDato = nombres.stream()
									.collect(Collectors.toList())
									.getClass()
									.getSimpleName();
		System.out.println(tipoDeDato);
	}

	// 8.2 Recolectores de operaciones de reducción básicas
	// Encuentra el nombre más largo.
	public static void recolectoresOperacionesReduccionBasicas() {
		System.out.println("================");
		System.out.println("| Apartado 8.2 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");

		if (true) {
			nombres.stream()
					.collect(Collectors.maxBy(Comparator.comparingInt(String::length)))
					.ifPresent(System.out::println);
		}
		else {
			 // Considero que esto es más corto y más legible
			nombres.stream()
					.max(Comparator.comparingInt(String::length))
					.ifPresent(System.out::println);
		}
	}

	// 8.3 Recolectores de transformación
	// Convierte los nombres en una cadena separada por guiones.
	public static void recolectoresTransformacion() {
		System.out.println("================");
		System.out.println("| Apartado 8.3 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		String nombresSeparadosConGuiones = nombres.stream()
													.collect(Collectors.joining(" - "));
		System.out.println(nombresSeparadosConGuiones);
	}

	// 8.4 Recolectores de agrupación
	// Agrupa los nombres según su longitud.
	public static void recolectoresAgrupacion() {
		System.out.println("================");
		System.out.println("| Apartado 8.4 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		nombres.stream()
				.collect(Collectors.groupingBy(String::length))
				.forEach((k, v) -> System.out.printf("%d caracteres: %s%n", k, v));
	}

	// 8.5 Recolectores de particionado
	// Divide los nombres en dos listas: los que tienen más de 4 caracteres y los que no.
	public static void recolectoresParticionado() {
		System.out.println("================");
		System.out.println("| Apartado 8.5 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		nombres.stream()
				.collect(Collectors.partitioningBy(nombre -> nombre.length() > 4))
				.forEach((k, v) -> System.out.printf("%s caracteres: %s%n", (k) ? " > 4" : "<= 4", v));
	}

	// 8.6 Combinación de dos recolectores
	// Cuenta cuántos nombres hay de cada longitud y devuelve un mapa con la cantidad de nombres por longitud.
	public static void combinacionDosRecolectores() {
		System.out.println("================");
		System.out.println("| Apartado 8.6 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		switch (3) {
			case 1: // Usando el teeing y devolviendo un mapa <Longitud, Cantidad>
				nombres.stream()
						.collect(Collectors.teeing(
									Collectors.groupingBy(String::length),
									Collectors.groupingBy(String::length, Collectors.counting()),
									(k, v) -> v
						))
						.forEach((k, v) -> System.out.printf("%d caracteres: %d%n", k, v));
				break;
			case 2: // Como el anterior, pero sin usar el teeing
				nombres.stream()
					    .collect(Collectors.groupingBy(String::length, Collectors.counting()))
						.forEach((k, v) -> System.out.printf("%d caracteres: %d%n", k, v));
				break;
			case 3: // Como el primero, pero se parece más a los apuntes, devolviendo un Result <<Longitud, Nombre>, <Longitud, Cantidad>>
				Result resultado = nombres.stream()
											.collect(Collectors.teeing(
														Collectors.groupingBy(String::length),
														Collectors.groupingBy(String::length, Collectors.counting()),
														Result::new
											));
				System.out.print(resultado);
				break;
		}
	}

	private static class Result {
        private Map<Integer, List<String>> longitudNombre;
        private Map<Integer, Long> longitudCantidad;

        public Result(Map<Integer, List<String>> longitudNombre, Map<Integer, Long> longitudCantidad) {
            this.longitudNombre = longitudNombre;
            this.longitudCantidad = longitudCantidad;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            longitudNombre.forEach((k, v) -> {
				result.append(String.format("Longitud: %d { Cantidad: %d, Nombres: %s }%n", k, longitudCantidad.get(k), v));
            });
            return (result.toString());
        }
    }

	public static void main(String[] args) {
		recolectoresEstructurasDatosClasicas();
		recolectoresOperacionesReduccionBasicas();
		recolectoresTransformacion();
		recolectoresAgrupacion();
		recolectoresParticionado();
		combinacionDosRecolectores();
	}
}
