package EjercicioArrays;
import java.util.Scanner;

/**
 * 2. Crea un programa que pida diez números reales por teclado, los almacene en un array,
 * y luego muestre la suma de todos los valores.
 */

public class Ejercicio2 {
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

		double sum = 0;
		// Calcula la suma de todos los números
		for (int i = 0; i < numbers.length; ++i) {
			sum += numbers[i];
		}
		System.out.printf("La suma es: %f%n", sum);
		sc.close();
	}
}
