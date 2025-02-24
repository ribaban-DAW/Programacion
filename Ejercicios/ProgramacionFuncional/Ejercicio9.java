package ProgramacionFuncional;

import java.util.function.*;

// Ejercicio 9: Uso de Function para Transformar una Cadena
public class Ejercicio9 {
    public static void main(String[] args) {
        // Implementar una Function que reciba un nombre y devuelva un saludo personalizado
		Function<String, String> saludo = nombre -> String.format("Un saludazo a %s", nombre);

		System.out.println(saludo.apply("Mí"));
		System.out.println(saludo.apply("Ti"));
    }
}
