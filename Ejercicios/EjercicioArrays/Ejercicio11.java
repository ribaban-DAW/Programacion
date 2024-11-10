package EjercicioArrays2;

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
			arr2[i] = arr1[SIZE - i - 1]; // - 1 para que esté en el límite
		}
		
		// Imprimir los arrays
		for (int i = 0; i < SIZE; ++i) {
			System.out.printf("Posición %d: Array 1: %d Array 2: %d%n", i, arr1[i], arr2[i]);
		}
	}
}
