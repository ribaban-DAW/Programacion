package Calificaciones;

import java.util.*;

public class Calificaciones {
	// Para comprobar si es una letra (sin incluir tildes)
	public static boolean is_letter(char c) {
		return ((c >= 'a' && c <= 'z')
				|| (c >= 'A' && c <= 'Z')
				|| c == 'ñ' || c == 'Ñ');
	}

	// Para comprobar si un string es un nombre válido (compuesto por letras, sin contar tildes)
	public static boolean validate_name(String name) {
		for (char c : name.toCharArray()) {
			if (!is_letter(c) && c != ' ') {
				System.out.println("No es nombre válido, solo puede tener letras");
				return (false);
			}
		}
		return (true);
	}
	
	// Para comprobar si un carácter es un dígito
	public static boolean isDigit(char c) {
		return (c >= '0' && c <= '9');
	}
	
	// Para hacer una conversión de un string a un double
	public static double toDouble(String s) {
		int dotCounter = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (i == s.length() - 1 && c == 'f') {
				break;
			}
			if ((!isDigit(c) && c != '.') || dotCounter > 1)
				return (Double.NaN);
			if (c == '.') {
				++dotCounter;
			}
		}
		if (dotCounter > 1) {
			return (Double.NaN);
		}
		return (Double.parseDouble(s));
	}

	// Para calcular la media
	public static double calculate_average(double[] grades) {
		double average;

		average = 0;
		for (double grade : grades) {
			average += grade;
		}
		average /= grades.length;
		return (average);
	}

	// El método "principal", donde se ingresan las notas
	public static void califications() {
		Scanner sc = new Scanner(System.in);
		String name;
		double average;
		double[] grades = new double[3];
		
		// Mientras no sea un nombre válido, pide el nombre
		do {
			System.out.print("Introduce tu nombre: ");
			name = sc.nextLine();
		} while (!validate_name(name));
		
		// Almacena todas las notas, verificando que son válidas
		for (int i = 0; i < grades.length; ++i) {
			do {
				System.out.printf("Introduce la nota %d: ", i + 1);
				grades[i] = sc.nextDouble();
				if (Double.isNaN(grades[i]) || grades[i] < 0 || grades[i] > 10) {
					System.out.println("Nota inválida, tiene que ser una nota del 0 al 10");
				}
			} while (Double.isNaN(grades[i]) || grades[i] < 0 || grades[i] > 10);
		}
		
		// Calculo la media e imprimo si la media da aprobado o suspenso.
		average = calculate_average(grades);
		if (average >= 5) {
			System.out.printf("%s has aprobado porque tu nota media es %.2f", name, average);
		} else {
			System.out.printf("%s has suspendido porque tu nota media es %.2f", name, average);
		}
		sc.close();
	}

	public static void main(String[] args) {
		califications();
	}
}
