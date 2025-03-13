package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 3. Filtrado
// Filtra los nombres que comiencen con "M" y muéstralos por pantalla.

public class Ejercicio3 {
	public static void main(String[] args) {
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		nombres.stream()
				.filter(nombre -> nombre.startsWith("M"))
				.forEach(System.out::println);
	}
}
