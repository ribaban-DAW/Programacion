package EjercicioArrays;

import java.util.Scanner;

/**
 * 13. Crea un programa que permita al usuario almacenar una secuencia aritmética en un array y luego mostrarla.
 * Una secuencia aritmética es una serie de números que comienza por un valor inicial V, y continúa con incrementos de I.
 * Por ejemplo:
 *
 * - Con V=1 e I=2, la secuencia sería 1, 3, 5, 7, 9…
 * - Con V=7 e I=10, la secuencia sería 7, 17, 27, 37…
 *
 * El programa solicitará al usuario V, I además de N (nº de valores a crear).
 */

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
