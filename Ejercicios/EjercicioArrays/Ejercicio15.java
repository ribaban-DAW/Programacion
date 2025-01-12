package EjercicioArrays;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 15. Crea un programa que pida la usuario dos valores N y M,
 * luego cree un array de tamaño N que contenga M en todas sus posiciones.
 * Luego muestra el array por pantalla.
 */

public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int n = sc.nextInt();
		System.out.print("Introduce otro número: ");
		int m = sc.nextInt();
		
		// Rellenar el array
		int[] arr = new int[n];
		Arrays.fill(arr, m);

		// Imprimir los números
		for (int i = 0; i < n; ++i) {
			System.out.printf("Array %d: %d%n", i, arr[i]);
		}
		sc.close();
	}

}
