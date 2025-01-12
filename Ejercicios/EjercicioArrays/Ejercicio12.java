package EjercicioArrays;
import java.util.Scanner;

/**
 * 12. Crea un programa que cree un array de 10 enteros y luego muestre el siguiente menú con distintas opciones:
 *
 *     a. Mostrar valores.
 *     b. Introducir valor.
 *     c. Salir.
 *
 * La opción ‘a’ mostrará todos los valores por pantalla.
 * La opción ‘b’ pedirá un valor V y una posición P, luego escribirá V en la posición P del array.
 * El menú se repetirá indefinidamente hasta que el usuario elija la opción ‘c’ que terminará el programa.
 */

public class Ejercicio12 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		char opcion = 'z';
		Scanner sc = new Scanner(System.in);
		
		do {			
			System.out.println("""
					=======================================
					                  MENU
					
					  a. Mostrar valores
					  b. Introducir valor en una posición
					  c. Salir
					=======================================
					""");
			System.out.print("Introduce una opción: ");

			// Lo almaceno en una variable temporal, para poder verificar que introduce al menos un carácter
			String tmp = sc.nextLine();
			if (tmp.length() < 1) {
				continue;
			}

			opcion = tmp.charAt(0);
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
