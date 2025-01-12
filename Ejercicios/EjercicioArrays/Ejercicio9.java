package EjercicioArrays;
import java.util.Scanner;

/**
 * 9. Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10).
 * Luego pedirá un valor N y mostrará en qué posiciones del array aparece N.
 */

public class Ejercicio9 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int[] randomNumbers = new int[100];
		
		// Rellena el array
		for (int i = 0; i < randomNumbers.length; ++i) {
			randomNumbers[i] = 1 + (int)(Math.random() * 10);
		}

		System.out.print("Introduce un número: ");
		int n = sc.nextInt();

		// Imprime los números que coinciden con N
		for (int i = 0; i < randomNumbers.length; ++i) {
			if (n == randomNumbers[i]) {				
				System.out.printf("En la posición %d se ha encontrado el valor %d%n", i, n);
			}
		}

		sc.close();
	}

}
