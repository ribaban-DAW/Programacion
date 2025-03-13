package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 4. Ordenación
// Ordena los nombres alfabéticamente y muéstralos por pantalla.

public class Ejercicio4 {
	public static void main(String[] args) {
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		nombres.stream()
				.sorted()
				.forEach(System.out::println);
	}
}
