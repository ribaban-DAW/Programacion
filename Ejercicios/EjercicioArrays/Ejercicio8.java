package EjercicioArrays;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		double[] randomNumbers = new double[100];
		
		for (int i = 0; i < randomNumbers.length; ++i) {
			randomNumbers[i] = Math.random();
		}
		System.out.print("Introduce un número entre el 0,0 y 1,0: ");
		double r = sc.nextDouble();
		int count = 0;
		for (double number : randomNumbers) {
			if (number >= r) {
				++count;
			}
		}
		System.out.printf("Hay %d valores mayores que %f", count, r);
		sc.close();
	}
}
