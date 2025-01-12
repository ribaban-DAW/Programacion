package EjercicioArrays;
import java.util.Scanner;

/**
 * 3. Crea un programa que pida diez números reales por teclado, los almacene en un array,
 * y luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.
 */

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] numbers = new double[10];
		
		// Rellena el array
		for (int i = 0; i < numbers.length; ++i) {
			try {
				System.out.printf("Introduzca el número %d: ", i + 1);
				numbers[i] = sc.nextDouble();
			}
			catch (Exception e) {
				System.err.println("No ha introducido un número correcto");
				--i; // Para que siga pidiendo el mismo número
			}
		}

		double maxNum = Double.MAX_VALUE;
		double minNum = Double.MIN_VALUE;
		// Busca el mayor y el menor de todos los números
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] > maxNum) {
				maxNum = numbers[i];
			}
			else if (numbers[i] < minNum) {
				minNum = numbers[i];
			}
		}
		System.out.printf("El máximo es: %f%n", maxNum);
		System.out.printf("El mínimo es: %f%n", minNum);
		sc.close();
	}
}
