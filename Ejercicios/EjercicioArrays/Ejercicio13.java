package EjercicioArrays;

import java.util.Scanner;

public class Ejercicio13 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el valor inicial: ");
		int valorInicial = sc.nextInt();
		System.out.print("Introduce el incremento: ");
		int incremento = sc.nextInt();
		System.out.print("Introduce la cantidad de valores a crear: ");
		int cantidad = sc.nextInt();
		
		// Rellenar los valores
		int[] arr = new int[cantidad];
		for (int i = 0; i < cantidad; ++i) {
			arr[i] = valorInicial + i * incremento;
		}
		
		for (int i = 0; i < cantidad; ++i) {
			System.out.printf("Array %d: %d%n", i, arr[i]);
		}
		sc.close();
	}
}
