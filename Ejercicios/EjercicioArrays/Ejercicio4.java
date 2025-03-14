package EjercicioArrays;
import java.util.Scanner;

/**
 * 4. Crea un programa que pida veinte números enteros por teclado, los almacene en un array
 * y luego muestre por separado la suma de todos los valores positivos y negativos.
 */

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[20];
		
		// Rellena el array
		for (int i = 0; i < numbers.length; ++i) {
			try {
				System.out.printf("Introduzca el número %d: ", i + 1);
				numbers[i] = sc.nextInt();
			}
			catch (Exception e) {
				System.err.println("No ha introducido un número correcto");
				--i; // Para que siga pidiendo el mismo número
			}
		}

		int posNum = 0;
		int negNum = 0;
		// Calcula la suma de todos los números positivos y negativos
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] > 0) {
				posNum += numbers[i];
			}
			else if (numbers[i] < 0) {
				negNum += numbers[i];
			}
		}
		System.out.printf("La suma de los positivos es: %d%n", posNum);
		System.out.printf("La suma de los negativos es: %d%n", negNum);
		sc.close();
	}
}
