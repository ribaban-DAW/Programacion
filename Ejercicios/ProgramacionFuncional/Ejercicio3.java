package ProgramacionFuncional;

import java.util.*;
import java.util.function.*;

// Ejercicio 3: Referencias a Métodos
public class Ejercicio3 {
    public static void main(String[] args) {
        // Implementar el uso de referencias a métodos para imprimir una lista de palabras en mayúsculas
		List<String> palabras = new ArrayList<>();
		palabras.add("hola");
		palabras.add("mundo");
		palabras.add("adiós");
		palabras.add("mundo");
		palabras.replaceAll(String::toUpperCase);
		palabras.forEach(System.out::println);
    }
}
