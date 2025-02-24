package ProgramacionFuncional;

import java.util.*;

// Ejercicio 5: Implementar un Comparator usando Expresiones Lambda
public class Ejercicio5 {
    public static void main(String[] args) {
        // Implementar un Comparator para ordenar palabras por su longitud usando una expresión lambda
		Comparator<String> compararLongitud = (s1, s2) -> Integer.compare(s1.length(), s2.length());

		List<String> palabras = new ArrayList<>();
		palabras.add("Hola");
		palabras.add("Hi");
		palabras.add("Alo");
		palabras.add("");
		palabras.add("Adiós mundo");
		palabras.sort(compararLongitud);
		palabras.forEach(System.out::println);
    }
}
