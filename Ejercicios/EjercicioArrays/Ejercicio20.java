package EjercicioArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[1000];
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = (int)(Math.random() * 100);
		}
		System.out.print("Introduce un número: ");
		int num = sc.nextInt();
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, num);
		if (index < 0) {
			System.out.printf("El número %d no se encuentra en el array%n", num);
		}
		else {
			int count = 0;
			// Para encontrar la primera posición, porque el binary search no te asegurar encontrar el primero
			while (index >= 0 && arr[index] == num) {
				--index;
			}
			
			// Para obtener el index correcto
			if (arr[index] != num) {
				++index;
			}
			
			// Aquí ya cuenta todos
			while (arr[index] == num) {
				++count;
				++index;
			}
			System.out.printf("El número %d se repite %d veces en el array%n", num, count);
		}
		sc.close();
	}

}
