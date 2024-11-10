package EjercicioArrays2;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		char opcion = 'z';
		Scanner sc = new Scanner(System.in);
		
		do {			
			System.out.println("""
					======================================
					MENU
					
					a. Mostrar valores
					b. Introducir valor en una posición
					c. Salir
					======================================
					""");
			System.out.print("Introduce una opción: ");
			opcion = sc.nextLine().charAt(0);
			
			switch (opcion) {
			case 'a': // Mostrar valores
				for (int i = 0; i < arr.length; ++i) {
					System.out.printf("Array %d: %d%n", i, arr[i]);
				}
				break;
			case 'b': // Introducir valor en una posición
				System.out.print("Introduce un valor: ");
				int valor = sc.nextInt();
				int posicion = -1;
				do {
					System.out.print("Introduce una posición: ");
					posicion = sc.nextInt();
					sc.nextLine(); // Para limpiar el buffer
					if (posicion < 0 || posicion >= arr.length) {
						System.err.println("Error, tiene que ser una posición del 0-9");
						continue;
					}
					arr[posicion] = valor;
				} while (posicion < 0 || posicion >= arr.length);
				break;
			case 'c':
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.err.println("Opción inválida");
					break;
			}
		} while (opcion != 'c');
		sc.close();
	}

}
