package Calculadora;
import java.util.*;

public class Calculadora {

	// NOTA: Imprimo la operación realizada en lugar de devolver un resultado porque
	// como sé que solo hay dos números, me evito complejidad adicional para imprimir
	// después, porque necesitaría condiciones adicionales si quiero el formato actual.

	public static void sum(int n1, int n2) {
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
	}

	public static void sub(int n1, int n2) {
		System.out.printf("%d - %d = %d\n", n1, n2, n1 - n2);
	}

	public static void mul(int n1, int n2) {
		System.out.printf("%d * %d = %d\n", n1, n2, n1 * n2);
	}

	public static void div(int n1, int n2) {
		if (n2 == 0) {
			System.err.println("Error: No se puede dividir entre 0");
			return ;
		}

		// El casting a float es para que al hacer la división de un resultado
		// con decimales, en lugar de redondear
		//
		// Por ejemplo:
		// - Sin casting: 2 / 4 = 0
		// - Con casting: 2 / 4 = 0.5
		System.out.printf("%d / %d = %.1f\n", n1, n2, (float)n1 / (float)n2);
	}

	public static void show_menu() {
		System.out.println("---- Menú Calculadora ----");
		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		System.out.println("0. Salir");
	}

	public static void calculator() {
		Scanner sc = new Scanner(System.in);
		int option;
		int n1;
		int n2;

		do {
			show_menu();
			System.out.print("Elija una opción: ");
			option = sc.nextInt();

			// Verifico que es una opción válida antes de pedir números
			if (option < 0 || option > 4) {
				System.err.printf("Error: La opción '%d' es inválida\n", option);
				continue ;
			} else if (option == 0) {
				System.out.println("Saliendo...");
				sc.close();
				return ;
			}

			System.out.print("Ingrese el primer número: ");
			n1 = sc.nextInt();
			System.out.print("Ingrese el segundo número: ");
			n2 = sc.nextInt();

			switch (option) {
				case 1:
					sum(n1, n2);
					break;
				case 2:
					sub(n1, n2);
					break;
				case 3:
					mul(n1, n2);
					break;
				case 4:
					div(n1, n2);
					break;
			}
		} while (option != 0);

		// Para liberar los recursos del Scanner, no es obligatorio, pero es buena práctica
		sc.close();
	}

	public static void main(String[] args) {
		calculator();
	}
}
