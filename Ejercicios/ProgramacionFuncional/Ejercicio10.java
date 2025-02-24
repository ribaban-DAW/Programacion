package ProgramacionFuncional;

import java.util.*;

// Ejercicio 10: Uso de Optional para Evitar NullPointerException
public class Ejercicio10 {
    public static void main(String[] args) {
        // Implementar un método que reciba un String y devuelva un Optional con la versión en mayúsculas

		System.out.println(mayusculas("hola"));
		System.out.println(mayusculas(""));
		System.out.println(mayusculas(null));
		System.out.println(mayusculas("Adiós"));
    }

	public static Optional<String> mayusculas(String str) {
		return Optional.ofNullable(str)
						.filter(t -> !t.isEmpty())
						.map(String::toUpperCase);
	}
}
