package ProgramacionFuncional;

import java.util.*;
import java.util.function.*;

// Ejercicio 4: Uso de Function y Optional
public class Ejercicio4 {
    public static void main(String[] args) {
        // Implementar una Function que reciba un String y devuelva un Optional con su longitud si no es vacío o null
		Function<String, Optional<Integer>> longitud = str -> Optional.ofNullable(str)
																		.filter(s -> !s.isEmpty())
																		.map(String::length);
		System.out.println(longitud.apply("Hola mundo"));
		System.out.println(longitud.apply(""));
		System.out.println(longitud.apply(null));
    }
}
