package ProgramacionFuncional;

import java.util.*;

// Ejercicio 8: Implementar un Comparator Personalizado con una Expresión Lambda
public class Ejercicio8 {
    public static void main(String[] args) {
        // Implementar un Comparator que ordene una lista de nombres en orden descendente
		Comparator<String> reves = Comparator.reverseOrder();

		List<String> nombres = new ArrayList<>();
		nombres.add("a");
		nombres.add("Bc");
		nombres.add("de");
		nombres.add("F");
		nombres.add("Yo");
		nombres.sort(reves);
		nombres.forEach(System.out::println);
    }
}
