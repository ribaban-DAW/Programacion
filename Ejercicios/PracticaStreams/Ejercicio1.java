package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 1. Creación de un Stream a partir de una fuente de datos
// Crea un programa en Java que genere un Stream a partir de una lista de nombres.

public class Ejercicio1 {
	public static void main(String[] args) {
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis");
		nombres.stream()
				.forEach(System.out::println);
	}
}
