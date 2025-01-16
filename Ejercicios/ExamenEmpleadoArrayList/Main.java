package ExamenEmpleadoArrayList;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// Constantes necesarias para hacer pruebas de una manera "sencilla"
		final int N_TEST = 10;
		final String[] DNIS = {
				"12345678Z", // Válido
				"58238129L", // Válido
				"12839123A", // Válido
				"12345678z", // Válido
				"98998249L", // Válido
				
				"12312595j", // Válido
				"a12832132", // Inválido
				"58923992l", // Válido
				"",          // Inválido
				"47281832n", // Válido
		};
		
		final String[] NOMBRES = {
				"Paco",                                 // Válido
				"Rojohn",                               // Válido
				"",                                     // Inválido
				"Minerva",                              // Válido
				"Sandra",                               // Válido
				
				"Georgina",                             // Válido
				"123",                                  // Inválido
				"Cándido",                              // Válido
				"Juan Miguel",                          // Válido
				"Un Nombre Demasiado Largo Pero Válido" // Válido
		};
		
		final String[] APELLIDOS = {
				"Fernández",      // Válido
				"Ibana Bañares",  // Válido
				"Torres",         // Válido
				"Estévez",        // Válido
				"",               // Inválido
				
				"Gutiérrez",      // Válido
				"McClaire",       // Válido
				"Añil",           // Válido
				"Sin Apellido",   // Válido
				"Silvino Campos", // Válido
		};

		final double[] SUELDOS = {
			25,    // Válido
			100,   // Válido
			3,     // Válido
			54,    // Válido
			-1,    // Inválido
			
			-200,  // Inválido
			2492,  // Válido
			21930, // Válido
			25,    // Válido
			21839, // Válido
		};
		
		
		// Aquí empiezo a crear los empleados, la mitad de los tests serán para empleados técnicos y la mitad empleados comerciales
		Tecnico[] ts = new Tecnico[N_TEST / 2];
		Comercial[] cs = new Comercial[N_TEST / 2];
		for (int i = 0; i < N_TEST / 2; ++i) {
			try {				
				ts[i] = new Tecnico(DNIS[i], NOMBRES[i], APELLIDOS[i], SUELDOS[i], i);
			}
			catch (Exception e) {
				System.err.printf("Técnico %d: %s%n", i + 1, e.getMessage());
			}
			
			// N_TEST / 2 + i porque quiero asignar de la mitad en adelante
			int j = N_TEST / 2 + i;
			try {				
				cs[i] = new Comercial(DNIS[j], NOMBRES[j], APELLIDOS[j], SUELDOS[j]);
			}
			catch (Exception e) {
				System.err.printf("Comercial %d: %s%n", i + 1, e.getMessage());
			}
		}
		
		// Creo la plantilla y contrato empleados
		Plantilla p = new Plantilla();

		// Contrato los Técnicos
		for (int i = 0; i < ts.length; ++i) {
			// Solo contrato Técnicos que sé existen, es decir que en esa posición no es null,
			// caso que solo sucede cuando se falla al crear un técnico (alguno de sus parámetros era inválido)
			if (ts[i] != null) {				
				p.contratarEmpleado(ts[i]);
			}
		}
		
		// Contrato los Comerciales
		for (int i = 0; i < cs.length; ++i) {
			// Solo contrato Comerciales que sé existen, es decir que en esa posición no es null,
			// caso que solo sucede cuando se falla al crear un técnico (alguno de sus parámetros era inválido)
			if (cs[i] != null) {				
				p.contratarEmpleado(cs[i]);
			}
		}		
		
		{ // Creo un scope para ir copiando y pegando diferentes pruebas con diferentes filtros			
			String filtroNombre = "Esto no lo encuentra";
			List<Empleado> empleados = p.getEmpleadoPorNombre(filtroNombre);
			if (empleados.size() > 0) {
				System.out.printf("El listado de empleados con '%s' en su nombre o apellidos:%n", filtroNombre);
				for (Empleado empleado : empleados) {
					if (empleado instanceof Tecnico) {
						System.out.print("Técnico [");
					}
					else {					
						System.out.print("Comercial [");
					}
					System.out.print(empleado);
					System.out.println("]");
				}
			}
			else {
				System.err.printf("No se ha encontrado ningún empleado con '%s'%n", filtroNombre);
			}
		}
		
		{ // Creo un scope para ir copiando y pegando diferentes pruebas con diferentes filtros			
			String filtroNombre = "á";
			List<Empleado> empleados = p.getEmpleadoPorNombre(filtroNombre);
			if (empleados.size() > 0) {
				System.out.printf("El listado de empleados con '%s' en su nombre o apellidos:%n", filtroNombre);
				for (Empleado empleado : empleados) {
					if (empleado instanceof Tecnico) {
						System.out.print("Técnico [");
					}
					else {					
						System.out.print("Comercial [");
					}
					System.out.print(empleado);
					System.out.println("]");
				}
			}
			else {
				System.err.printf("No se ha encontrado ningún empleado con '%s'%n", filtroNombre);
			}
		}
		
		{ // Creo un scope para ir copiando y pegando diferentes pruebas con diferentes filtros			
			String filtroNombre = "ez";
			List<Empleado> empleados = p.getEmpleadoPorNombre(filtroNombre);
			if (empleados.size() > 0) {
				System.out.printf("El listado de empleados con '%s' en su nombre o apellidos:%n", filtroNombre);
				for (Empleado empleado : empleados) {
					if (empleado instanceof Tecnico) {
						System.out.print("Técnico [");
					}
					else {					
						System.out.print("Comercial [");
					}
					System.out.print(empleado);
					System.out.println("]");
				}
			}
			else {
				System.err.printf("No se ha encontrado ningún empleado con '%s'%n", filtroNombre);
			}
		}
		
		{ // Creo un scope para ir copiando y pegando diferentes pruebas con diferentes filtros			
			String filtroNombre = "o";
			List<Empleado> empleados = p.getEmpleadoPorNombre(filtroNombre);
			if (empleados.size() > 0) {
				System.out.printf("El listado de empleados con '%s' en su nombre o apellidos:%n", filtroNombre);
				for (Empleado empleado : empleados) {
					if (empleado instanceof Tecnico) {
						System.out.print("Técnico [");
					}
					else {					
						System.out.print("Comercial [");
					}
					System.out.print(empleado);
					System.out.println("]");
				}
			}
			else {
				System.err.printf("No se ha encontrado ningún empleado con '%s'%n", filtroNombre);
			}
		}
	}
}
