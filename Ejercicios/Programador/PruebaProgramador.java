package Programador;

public class PruebaProgramador {
	public static void main(String[] args) {
		Empleado e = new Empleado("E1", "12345678Z", 1500, 3);
		Programador[] ps = {
			new Programador("P1", "12578213L", 1500, 3, "C"),	
			new Programador("P2", "12345678Z", 1500, 3, "Java"),
			new Programador("P3", "24879123T", 2156, 10, "C"),
		};
		
		System.out.println(e);
		for (Programador p : ps) {
			System.out.println(p);
		}
		
		if (ps[0].tieneMismoLenguaje(ps[1])) {
			System.out.printf("%s y %s tienen el mismo lenguaje (%s)%n", ps[0].getNombre(), ps[2].getNombre(), ps[0].getLenguaje());
		}
		else {
			System.out.printf("%s y %s tienen lenguajes diferentes%n", ps[0].getNombre(), ps[2].getNombre());
		}
		
		if (ps[0].tieneMismoLenguaje(ps[2])) {
			System.out.printf("%s y %s tienen el mismo lenguaje (%s)%n", ps[0].getNombre(), ps[2].getNombre(), ps[0].getLenguaje());
		}
		else {
			System.out.printf("%s y %s tienen lenguajes diferentes%n", ps[0].getNombre(), ps[2].getNombre());
		}
		
		if (e.equals(ps[1])) {
			System.out.printf("%s y %s son el mismo empleado%n", e.getNombre(), ps[2].getNombre());
		}
		
		// Casos inválidos
		try { // Dni inválido porque solo tiene 4 números y le falta la letra
			Empleado ei = new Empleado("E1", "1123", 52, 0);
		}
		catch (IllegalArgumentException exception) {
			System.err.println(exception.getMessage());
		}
		
		try { // Dni inválido porque la letra es incorrecta
			Empleado ei = new Empleado("E1", "12345678A", 52, 0);
		}
		catch (IllegalArgumentException exception) {
			System.err.println(exception.getMessage());
		}
		
		try { // Dni inválido porque la retención está fuera del rango
			Empleado ei = new Empleado("E1", "12345678Z", 52, 51);
		}
		catch (IllegalArgumentException exception) {
			System.err.println(exception.getMessage());
		}
	}
}
