package EjercicioArrays;
import java.util.Scanner;

/**
 * 1. Crea un programa que pida diez números reales por teclado, los almacene en un array, y luego muestre todos sus valores.
 */

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] numbers = new double[10];
		
		// Rellenar el array
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

		// Imprime los números
		for (int i = 0; i < numbers.length; ++i) {
			System.out.printf("Número %d: %f%n", i + 1, numbers[i]);
		}
		sc.close();
	}
}
