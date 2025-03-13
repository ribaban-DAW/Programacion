package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 2. Tratamiento individual de elementos
// Modifica el código anterior para imprimir cada nombre en mayúsculas.

public class Ejercicio2 {
	public static void main(String[] args) {
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis");
		nombres.stream()
				.map(String::toUpperCase)
				.forEach(System.out::println);
	}
}
