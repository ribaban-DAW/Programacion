package PracticaStreams;

import java.util.*;
import java.util.stream.*;

// 7. Operaciones terminales de consulta
// Verifica si algún nombre tiene más de 5 caracteres.

public class Ejercicio7 {
	public static void main(String[] args) {
		List<String> nombres = List.of("Ana", "Pedro", "Maria", "Juan", "Luis", "Minerva");
		boolean existeNombreConCincoCaracteres = nombres.stream()
														.anyMatch(nombre -> nombre.length() > 5);
		System.out.println(existeNombreConCincoCaracteres);
	}
}
