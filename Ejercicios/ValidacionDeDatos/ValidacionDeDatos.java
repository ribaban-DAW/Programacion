package ValidacionDeDatos;

import java.util.Scanner;

public class ValidacionDeDatos {
	private static final String[] OPCIONES = {
			"Nombre",
			"Apellido",
			"Número de teléfono",
			"Correo electrónico",
			"DNI",
			"IBAN",
			"Fecha de nacimiento",
			"Código postal",
			"Número de tarjeta de crédito",
			"Placa de vehículo",
			"Número de la seguridad social",
			"URL",
			"Salir",
	};

	private static final String[] PATRONES = {
			"^[A-Za-zÁÉÍÓÚáéíóúñÑ]+(\\s[A-Za-zÁÉÍÓÚáéíóúñÑ]+)*$",                 // Nombre
			"^[A-Za-zÁÉÍÓÚáéíóúñÑ]+(\\s[A-Za-zÁÉÍÓÚáéíóúñÑ]+)*$",                 // Apellido
			"^((\\+34)?\\s?)[6-9]\\d{2}\\s?((\\d{3}\\s?){2}|(\\d{2}\\s?){3})$",   // Número de teléfono
			"^[\\w\\.]*@\\w*\\.(com|es)$",                                        // Correo electrónico
			"^\\d{8}[a-zA-Z]$",                                                   // DNI
			"^([eE][sS]\\d{2})\\s?(\\d{4}\\s?){5}$",                              // IBAN
			"^((0?[1-9])|([1-2][0-9])|(3[0-1]))/((0?[1-9])|1[0-2])/[1-9]\\d{3}$", // Fecha de nacimiento
			"^((0[1-9])|([1-4][1-9])|(5[0-2]))\\d{3}$",                           // Código postal
			"^(\\d{4}\\s?){4}$",                                                  // Número de tarjeta de crédito
			"^\\d{4}\\s?[a-zA-Z]{3}$",                                            // Placa de vehículo
			"^\\d{3}-\\d{2}-\\d{4}",                                              // Número de la seguridad social
			"^(http(s)?://)?(\\w{3}\\.)?[\\w]*\\.(com|es)$",                      // URL
	};

	private static final String[][] EJEMPLOS = {
			{ // Index 0, Nombre
				"Juan",
				"María Luisa",
				"Iñaki",
			},
			{ // Index 1, Apellido
				"Ibañez",
				"García Lorca",
				"Fernández de la Torre",
			},
			{ // Index 2, Número de teléfono
				"+34 612 345 678",
				"+34712345768",
				"812 34 56 78",
				"912 345 678",
				"612345768",
			},
			{ // Index 3, Correo electrónico
				"a@b.es",
				"a@b.com",
				"usuario@dominio.es",
				"nombre.apellido@ejemplo.es",
				"nombre_apellido1@dominio.com",
				"nombre123@dominio.com",
			},
			{ // Index 4, DNI
				"12345678Z",
				"19283746V",
				"79023803N",
				"00000000T",
				"99999999R",
			},
			{ // Index 5, IBAN
				"ES12 1234 1234 1234 1234 1234",
				"ES1212341234123412341234",
				"es12 1234 1234 1234 1234 1234",
				"es1212341234123412341234",
				"eS12 1234 1234 1234 1234 1234",
				"Es1212341234123412341234",
			},
			{ // Index 6, Fecha de nacimiento
				"27/6/2003",
				"27/06/2003",
				"1/1/1999",
				"01/01/1999",
				"1/01/1999",
				"01/1/1999",
			},
			{ // Index 7, Código postal
				"29670",
				"52005",
				"01000",
				"12005",
			},
			{ // Index 8, Número de tarjeta de crédito
				"1234 1234 1234 1234",
				"1234123412341234",
			},
			{ // Index 9, Placa de vehículo
				"1234 ABC",
				"1234ABC",
			},
			{ // Index 10, Número de la seguridad social
				"123-45-6789",
				"987-65-4321",
			},
			{ // Index 11, URL
				"http://www.ejemplo.es",
				"http://www.ejemplo.com",
				"http://ejemplo.es",
				"http://ejemplo.com",
				"https://www.ejemplo.es",
				"https://www.ejemplo.com",
				"https://ejemplo.es",
				"https://ejemplo.com",
				"www.ejemplo.es",
				"www.ejemplo.com",
				"ejemplo.es",
				"ejemplo.com",
			},
	};

	public static boolean validarNombre(String dato) {
		return (dato.matches(PATRONES[0]));
	}

	public static boolean validarApellidos(String dato) {
		return (dato.matches(PATRONES[1]));
	}

	public static boolean validarNumeroTelefono(String dato) {
		return (dato.matches(PATRONES[2]));
	}

	public static boolean validarCorreoElectronico(String dato) {
		return (dato.matches(PATRONES[3]));
	}

	public static boolean validarDni(String dato) {
		return (dato.matches(PATRONES[4]));
	}

	public static boolean validarIban(String dato) {
		return (dato.matches(PATRONES[5]));
	}

	public static boolean validarFechaNacimiento(String dato) {
		return (dato.matches(PATRONES[6]));
	}

	public static boolean validarCodigoPostal(String dato) {
		return (dato.matches(PATRONES[7]));
	}

	public static boolean validarNumeroTarjetaCredito(String dato) {
		return (dato.matches(PATRONES[8]));
	}

	public static boolean validarPlacaVehiculo(String dato) {
		return (dato.matches(PATRONES[9]));
	}

	public static boolean validarNumeroSeguridadSocial(String dato) {
		return (dato.matches(PATRONES[10]));
	}

	public static boolean validarUrl(String dato) {
		return (dato.matches(PATRONES[11]));
	}
	
	public static void mostrarEjemplos(int opcion) {
		System.out.println("Aquí hay algunos ejemplos:");
		for (String ejemplo : EJEMPLOS[opcion]) {
			System.out.printf("- %s%n", ejemplo);
		}
	}
	
	public static void verificarDato(int opcion, String dato) {
		boolean error = false;

		switch (opcion) {
		case 1:
			error = !validarNombre(dato);
			if (!validarNombre(dato)) {
				System.err.printf("%s no es un nombre válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un nombre válido%n", dato);
			}
			break;
		case 2:
			if (!validarApellidos(dato)) {
				System.err.printf("%s no son apellidos válidos%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s son apellidos válidos%n", dato);
			}
			break;
		case 3:
			if (!validarNumeroTelefono(dato)) {
				System.err.printf("%s no es un número de teléfono válido.%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un número de teléfono válido%n", dato);
			}
			break;
		case 4:
			if (!validarCorreoElectronico(dato)) {
				System.err.printf("%s no es un correo electrónico válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un correo electrónico válido%n", dato);
			}
			break;
		case 5:
			if (!validarDni(dato)) {
				System.err.printf("%s no es un DNI válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un DNI válido%n", dato);
			}
			break;
		case 6:
			if (!validarIban(dato)) {
				System.err.printf("%s no es un IBAN válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un IBAN válido%n", dato);
			}
			break;
		case 7:
			if (!validarFechaNacimiento(dato)) {
				System.err.printf("%s no es una fecha de nacimiento válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es una fecha de nacimiento válido%n", dato);
			}
			break;
		case 8:
			if (!validarCodigoPostal(dato)) {
				System.err.printf("%s no es un código postal válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un código postal valido%n", dato);
			}
			break;
		case 9:
			if (!validarNumeroTarjetaCredito(dato)) {
				System.err.printf("%s no es un número de tarjeta de crédito válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un número de tarjeta de crédito válido%n", dato);
			}
			break;
		case 10:
			if (!validarPlacaVehiculo(dato)) {
				System.err.printf("%s no es una placa de vehículo válida%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es una placa de vehículo válida%n", dato);
			}
			break;
		case 11:
			if (!validarNumeroSeguridadSocial(dato)) {
				System.err.printf("%s no es un número de seguridad social válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es un número de seguridad social válido%n", dato);
			}
			break;
		case 12:
			if (!validarUrl(dato)) {
				System.err.printf("%s no es una URL válido%n", dato);
				mostrarEjemplos(opcion - 1);
			} else {
				System.out.printf("%s es una URL válido%n", dato);
			}
			break;
		default:
			// Aquí en principio nunca debería llegar porque se valida previamente
			System.err.println("Esa opción no está implementada");
			break;
		}
		if (error) {
			System.err.printf("%s no es un %s válido%n", dato, OPCIONES[opcion - 1].toLowerCase());
			mostrarEjemplos(opcion - 1);
		}
		else {
			System.out.printf("%s es un %s válido%n", dato, OPCIONES[opcion - 1].toLowerCase());
		}
	}

	public static void mostrarMenu() {
		System.out.println("             Opciones");
		System.out.println("------------------------------------");
		for (int i = 0; i < OPCIONES.length; ++i) {
			if (i + 1 < 10) { // Para que las opciones estén bien tabuladas
				System.out.printf("%d.-  %s%n", i + 1, OPCIONES[i]);
			} else {
				System.out.printf("%d.- %s%n", i + 1, OPCIONES[i]);
			}
		}
		System.out.print("Selecciona una opción: ");
	}

	public static void main(String[] args) {
		int opcion = 0;
		String dato;
		Scanner sc = new Scanner(System.in);
		do {
			mostrarMenu();
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				System.err.printf("Opción inválida, tiene que estar del 1 al %d%n", OPCIONES.length);
				continue;
			} finally {
				sc.nextLine(); // Para limpiar el buffer, tanto si falla como si no
			}
			if (opcion < 1 || opcion > OPCIONES.length) {
				System.err.printf("Opción inválida, tiene que estar del 1 al %d%n", OPCIONES.length);
				continue;
			}
			if (opcion == OPCIONES.length) {
				break;
			}
			System.out.print("Introduzca el dato: ");
			dato = sc.nextLine();
			verificarDato(opcion, dato);
		} while (opcion != OPCIONES.length);
		System.out.println("Cerrando el programa...");
		sc.close();
	}
}
