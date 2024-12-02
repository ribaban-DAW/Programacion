package EjercicioArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		
		for (int i = 0; i < 20; ++i) {
			System.out.printf("Introduce el número %d: ", i + 1);
			int number = sc.nextInt();
			if (i < 10) {
				arr1[i] = number;
			}
			else {
				arr2[i - 10] = number;
			}
		}
		if (Arrays.equals(arr1, arr2)) {
			System.out.println("El Array 1 y el Array 2 son iguales");
		}
		else {
			System.out.println("El Array 1 y el Array 2 no son iguales");
		}
		sc.close();
	}
}
