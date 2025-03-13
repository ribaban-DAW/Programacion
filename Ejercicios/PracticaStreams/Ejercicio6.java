package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 6. Reducción pura

public class Ejercicio6 {

	// 6.1 Métodos estándar de reducción
	// Calcula la cantidad total de caracteres de todos los nombres.
	public static void metodoEstandar() {
		System.out.println("================");
		System.out.println("| Apartado 6.1 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		int numCaracteres = nombres.stream()
									.mapToInt(String::length)
									.sum();
		System.out.println(numCaracteres);
	}

	// 6.2 Método reduce
	// Une todos los nombres en una sola cadena separados por comas.
	public static void metodoReduce() {
		System.out.println("================");
		System.out.println("| Apartado 6.2 |");
		System.out.println("================");
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		nombres.stream()
				.reduce((a, b) -> a + ", " + b)
				.ifPresent(System.out::println);
	}

	public static void main(String[] args) {
		metodoEstandar();
		metodoReduce();
	}
}
