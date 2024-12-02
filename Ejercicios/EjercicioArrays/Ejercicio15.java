package EjercicioArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int n = sc.nextInt();
		System.out.print("Introduce otro número: ");
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		Arrays.fill(arr, m);
		for (int i = 0; i < n; ++i) {
			System.out.printf("Array %d: %d%n", i, arr[i]);
		}
		sc.close();
	}

}
