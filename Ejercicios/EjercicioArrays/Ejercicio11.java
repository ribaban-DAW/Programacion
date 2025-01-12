package EjercicioArrays;

/**
 * 11. Crea un programa que cree dos arrays de enteros de tamaño 100.
 * Luego introducirá en el primer array todos los valores del 1 al 100.
 * Por último, deberá copiar todos los valores del primer array al segundo array en orden inverso, y mostrar ambos por pantalla.
 */

public class Ejercicio11 {

	public static void main(String[] args) {		

		final int SIZE = 100;
		int[] arr1 = new int[SIZE];
		int[] arr2 = new int[SIZE];
		
		// Rellenar el array
		for (int i = 0; i < SIZE; ++i) {
			arr1[i] = i + 1;
		}
		
		// Copiar del array 2 al 1
		for (int i = 0; i < SIZE; ++i) {
			arr2[i] = arr1[SIZE - i - 1]; // - 1 para que esté dentro del límite
		}
		
		// Imprimir los arrays
		for (int i = 0; i < SIZE; ++i) {
			System.out.printf("Posición %d: Array 1: %d Array 2: %d%n", i, arr1[i], arr2[i]);
		}
	}
}
