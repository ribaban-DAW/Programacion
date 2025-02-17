package ProgramacionFuncional;

import java.util.*;
import java.util.function.*;

// Ejercicio 1: Uso de Predicate para Filtrar Números Pares
public class Ejercicio1 {
    public static void main(String[] args) {
        // Implementar el uso de Predicate para filtrar y mostrar solo los números pares de una lista
    	Predicate<Integer> esImpar = n -> n % 2 != 0;
    	
    	List<Integer> list = new ArrayList<>();
    	for (int i = 0; i < 100; ++i) {
    		list.add(i);
    	}
    	list.removeIf(esImpar);
    	list.forEach(System.out::println);
    }
}
