package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 5. Transformación
// Transforma la lista de nombres en una lista de sus longitudes.

public class Ejercicio5 {
	public static void main(String[] args) {
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		nombres.stream()
				.mapToInt(nombre -> nombre.length())
				.forEach(System.out::println);
	}
}
