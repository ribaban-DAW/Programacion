package Horario;
import java.util.*;

public class Horario {
	// Utiliza el siguiente formato:
	//
	// | HORA | ASIGNATURA |
	//
	public static void	show_table(String[] subjects) {
		String[] times = new String[6];
		times[0] = "15:30 - 16:30";
		times[1] = "16:30 - 17:30";
		times[2] = "17:45 - 18:45";
		times[3] = "18:45 - 19:45";
		times[4] = "20:00 - 21:00";
		times[5] = "21:00 - 22:00";

		// Precalculo la longitud máxima del nombre de la asignatura más larga
		// para que la tabla quede ajustada
		int max = 0;
		for (String subject : subjects) {
			if (max < subject.length()) {
				max = subject.length();
			}
		}

		for (int i = 0; i < times.length; ++i) {
			int spaces = max - subjects[i].length();
			System.out.print("| " + times[i] + " | "); // Imprime la hora
			System.out.print(subjects[i]);
			for (int j = 0; j < spaces; ++j) {
				System.out.print(" "); // El padding derecho de la tabla
			}
			System.out.println(" |");
		}
	}

	public static void	show(char c) {
		switch (c) {
			case 'L': {
				System.out.println("El horario del lunes");
				String[] asignaturas = new String[6];
				asignaturas[0] = "Programación";
				asignaturas[1] = "Programación";
				asignaturas[2] = "Programación";
				asignaturas[3] = "Base de datos";
				asignaturas[4] = "Base de datos";
				asignaturas[5] = "Base de datos";
				show_table(asignaturas);
				break;
			}
			case 'M': {
				System.out.println("El horario del martes");
				String[] asignaturas = new String[6];
				asignaturas[0] = "Sistemas informáticos";
				asignaturas[1] = "Sistemas informáticos";
				asignaturas[2] = "Sistemas informáticos";
				asignaturas[3] = "Base de datos";
				asignaturas[4] = "Base de datos";
				asignaturas[5] = "Base de datos";
				show_table(asignaturas);
				break;
			}
			case 'X': {
				System.out.println("El horario del miércoles");
				String[] asignaturas = new String[6];
				asignaturas[0] = "Sistemas informáticos";
				asignaturas[1] = "Sistemas informáticos";
				asignaturas[2] = "Sostenibilidad Aplicada al Sistema Productivo";
				asignaturas[3] = "Itinerario Personal para la Empleabilidad";
				asignaturas[4] = "Itinerario Personal para la Empleabilidad";
				asignaturas[5] = "Itinerario Personal para la Empleabilidad";
				show_table(asignaturas);
				break;
			}
			case 'J': {
				System.out.println("El horario del jueves");
				String[] asignaturas = new String[6];
				asignaturas[0] = "Digitalización Aplicada a los Sectores Productivos";
				asignaturas[1] = "Programación";
				asignaturas[2] = "Programación";
				asignaturas[3] = "Programación";
				asignaturas[4] = "Programación";
				asignaturas[5] = "Programación";
				show_table(asignaturas);
				break;
			}
			case 'V': {
				System.out.println("El horario del viernes:");
				String[] asignaturas = new String[6];
				asignaturas[0] = "Entornos de desarrollo";
				asignaturas[1] = "Entornos de desarrollo";
				asignaturas[2] = "Entornos de desarrollo";
				asignaturas[3] = "Lenguajes de marcas y sistemas de gestión de información";
				asignaturas[4] = "Lenguajes de marcas y sistemas de gestión de información";
				asignaturas[5] = "Lenguajes de marcas y sistemas de gestión de información";
				show_table(asignaturas);
				break;
			}
			case 'S':
			case 'D':
				System.out.println("Los fines de semana no hay horario");
				break;
			default:
				System.err.println("Error: Esa letra no existe");
				break ;
		}
	}

	public static void	main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la primera letra de la semana (L, M, X, J, V, S, D): ");
		String s = sc.nextLine();
		if (s.length() != 1) {
			System.err.println("Error: No has introducido una letra");
			sc.close();
			return ;
		}
		show(s.toUpperCase().charAt(0));
		sc.close();
	}
}
