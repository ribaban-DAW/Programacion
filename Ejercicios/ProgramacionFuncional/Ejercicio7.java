package ProgramacionFuncional;

import java.util.function.*;

// Ejercicio 7: Uso de BiPredicate para Comparar Cadenas
public class Ejercicio7 {
    public static void main(String[] args) {
        // Implementar un BiPredicate que compare si dos cadenas tienen la misma longitud
		BiPredicate<String, String> mismaLongitud = (s1, s2) -> s1.length() == s2.length();

		System.out.println(mismaLongitud.test("hola", "mundo"));
		System.out.println(mismaLongitud.test("adiós", "mundo"));
    }
}
