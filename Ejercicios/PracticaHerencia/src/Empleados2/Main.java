package PracticaHerencia.src.Empleados2;

public class Main {
	public static void main(String[] args) {
		Repartidor[] rs = {
			new Repartidor("RA", 25, 500, "zona 1"),
			new Repartidor("RB", 18, 500, "zona 2"),
			new Repartidor("RC", 30, 500, "zona 3"),
			new Repartidor("RD", 23, 500, "zona 3"),
			new Repartidor("RE", 21, 500, "zona 1"),
		};
		Comercial[] cs = {
			new Comercial("CA", 18, 600, 100),	
			new Comercial("CB", 25, 600, 500),	
			new Comercial("CC", 28, 600, 300),	
			new Comercial("CD", 31, 600, 200),	
			new Comercial("CE", 36, 600, 300),	
		};

		for (Repartidor r : rs) {
			System.out.printf("Salario del repartidor %s: %f\n", r.getNombre(), r.getSalario());
		}
		
		for (Comercial c : cs) {
			System.out.printf("Salario del comercial %s: %f\n", c.getNombre(), c.getSalario());
		}
		
		// Esto da error porque es una clase abstracta
		// Empleado e = new Empleado("EA", 25, 500);
	}
}
