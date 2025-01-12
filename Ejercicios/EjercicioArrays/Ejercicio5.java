package EjercicioArrays;
import java.util.Scanner;

/**
 * 5. Crea un programa que pida veinte números reales por teclado, los almacene en un array
 * y luego lo recorra para calcular y mostrar la media: (suma de valores) / nº de valores.
 */

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] numbers = new double[20];
		
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

		double average = 0;
		// Suma todos los números
		for (int i = 0; i < numbers.length; ++i) {
			average += numbers[i];
		}
		// Obtengo la media dividiendo entre la longitud
		average /= numbers.length;
		System.out.printf("La suma de los positivos es: %f%n", average);
		sc.close();
	}
}
