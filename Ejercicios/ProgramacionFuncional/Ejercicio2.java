package ProgramacionFuncional;

import java.util.function.*;

// Ejercicio 2: Uso de Consumer y BiConsumer
public class Ejercicio2 {
    public static void main(String[] args) {
        // Implementar un Consumer que imprima un texto en mayúsculas
    	Consumer<String> imprimirMayusculas = String::toUpperCase;
        // Implementar un BiConsumer que imprima un nombre y una edad formateados
    	BiConsumer<String, Integer> imprimirNombreEdad = (nombre, edad) -> System.out.printf("Nombre: %s, Edad: %d%n", nombre, edad);
    	
    }
}
