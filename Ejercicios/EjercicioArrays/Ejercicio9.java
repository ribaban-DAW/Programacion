package EjercicioArrays2;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int[] randomNumbers = new int[100];
		
		for (int i = 0; i < randomNumbers.length; ++i) {
			randomNumbers[i] = 1 + (int)(Math.random() * 10);
		}
		System.out.print("Introduce un número: ");
		int n = sc.nextInt();
		for (int i = 0; i < randomNumbers.length; ++i) {
			if (n == randomNumbers[i]) {				
				System.out.printf("En la posición %d se ha encontrado el valor %d%n", i, n);
			}
		}
		sc.close();
	}

}
