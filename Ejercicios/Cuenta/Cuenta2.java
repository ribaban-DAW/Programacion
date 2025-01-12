package Cuenta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * @NOTA: Se podría crear una clase Cajero que implemente:
 *
 *        - Crear cuenta
 *        - Inicio sesión y en caso de fallar dar la opción de crear una cuenta
 *        - Menú que se mostraría una vez inicias sesión
 *
 *        En lugar de tenerlo en la clase Cuenta.
 */

public class Cuenta2 {
	/**
	 * Este array contiene las OPCIONES que tiene la cuenta,
	 * lo guardo aquí porque así añadir más OPCIONES es más
	 * sencillo, solo habría que añadirlas antes de la
	 * opción "SALIR". Además, la longitud del array
	 * contendría siempre el número de operaciones existentes.
	 * 
	 * Lo ideal sería hacerlo con enum, pero no sé cómo se
	 * usan correctamente de momento.
	 */
	private static final String[] OPCIONES = {
			"INGRESO",
			"REINTEGRO",
			"TRANSFERENCIA",
			"SALIR",
	};

	// Este Scanner propio es para poder cerrar el scanner una vez se termine de
	// usar la clase, pero en realidad no sirve para nada actualmente.
	private static final Scanner SC = new Scanner(System.in);

	private String nombre;
	private String iban;
	private double interes;
	private double saldo;

	public Cuenta2() {
		setNombre("");
		setIban("");
		setInteres(0);
		setSaldo(0);
	}

	public Cuenta2(String nombre, String iban, double interes, double saldo) {
		setNombre(nombre);
		setIban(iban);
		setInteres(interes);
		setSaldo(saldo);
	}

	public Cuenta2(Cuenta2 that) throws IllegalArgumentException {
		setNombre(that.nombre);
		setIban(that.iban);
		setInteres(that.interes);
		setSaldo(that.saldo);
	}

	public String getNombre() {
		return (nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIban() {
		return (iban);
	}

	public void setIban(String iban) throws IllegalArgumentException {
		if (!iban.isEmpty() && !esIbanValido(iban)) {
			throw new IllegalArgumentException(
					"IBAN inválido, debe tener el siguiente formato: ESXXXXXXXXXXXXXXXXXXXXXX");
		}
		this.iban = iban;
	}

	public double getInteres() {
		return (interes);
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getSaldo() {
		return (saldo);
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return String.format("""
				=====================
				Estado de la cuenta
				
				Nombre: %s
				IBAN: %s
				Interés: %.2f %%
				Saldo: %.2f €
				=====================
				""", nombre, iban, interes, saldo);
	}

	public static String[] getOpciones() {
		return (OPCIONES);
	}

	private static boolean esIbanValido(String iban) {
		Pattern pattern = Pattern.compile("^[ES]+\\d{22}$"); // Que empiece por ES seguido de 22 dígitos
		Matcher matcher = pattern.matcher(iban);
		return (matcher.find());
	}

	public boolean ingreso(double cantidad) {
		if (cantidad < 0) {
			System.err.println("No se puede ingresar una cantidad negativa");
			return (false);
		}
		saldo += cantidad;
		System.out.printf("Se ha realizado un ingreso de %.2f €%n", cantidad);
		return (true);
	}

	public boolean reintegro(double cantidad) {
		if (cantidad < 0) {
			System.err.println("No se puede ingresar una cantidad negativa");
			return (false);
		}
		if (saldo < cantidad) {
			System.err.printf("No puedes hacer un reintegro de %.2f € porque la cuenta no tiene saldo suficiente%n",
					cantidad);
			return (false);
		}
		saldo -= cantidad;
		System.out.printf("Se ha hecho un reintegro de %.2f €%n", cantidad);
		return (true);
	}

	public boolean transferencia(Cuenta2 that, double cantidad) {
		if (!this.reintegro(cantidad)) {
			System.err.println("Como el reintegro no se ha realizado, no se ha realizado la transferencia");
			return (false);
		}
		return (that.ingreso(cantidad));
	}

	// Aquí empieza la parte que considero que podría ser parte de la clase Cajero
	// ===========================================================================

	public static void mostrarMenu() {
		System.out.println("¿Qué te gustaría hacer?");
		for (int i = 0; i < OPCIONES.length; ++i) {
			System.out.printf("%d. %s%n", i + 1, OPCIONES[i]);
		}
		System.out.print("> ");
	}

	public static boolean inicioSesion() {
		String iban;
		boolean success;

		System.out.println("Inicio de sesión");
		do {
			System.out.print("Introduce tu IBAN: ");
			iban = SC.nextLine();
			success = esIbanValido(iban);
			if (iban.equals("ES1212341234123412341234")) { // Un IBAN hardcodeado, se podría mejorar
				return (success);
			}
			if (!success) {
				System.err.println("IBAN inválido, debe tener el siguiente formato: ESXXXXXXXXXXXXXXXXXXXXXX");
			}
		} while (!success);
		return (!success);
	}

	private static String pedirStringConPatron(Pattern pattern) {
		String resultado;

		resultado = SC.nextLine();
		Matcher matcher = pattern.matcher(resultado);
		if (!matcher.find()) {
			return ("");
		}
		return (resultado);
	}

	public static Cuenta2 crearCuenta() {
		Cuenta2 cuenta = new Cuenta2();
		String temp = "";

		// Obtener el nombre
		while (temp.isEmpty()) {
			System.out.print("Introduce tu nombre: ");
			temp = pedirStringConPatron(Pattern.compile("^[a-zA-Z]+$"));
			if (temp.isEmpty()) {
				System.err.println("Nombre inválido, solo puede contener letras");
			}
		}
		cuenta.setNombre(temp);

		// Obtener el IBAN, aunque se podría generar automáticamente para evitar
		// colisiones
		temp = "";
		while (temp.isEmpty()) {
			System.out.print("Introduce tu IBAN: ");
			temp = pedirStringConPatron(Pattern.compile("^[ES]+\\d{22}$"));
			if (temp.isEmpty()) {
				System.err.println("IBAN inválido, debe tener el siguiente formato: ESXXXXXXXXXXXXXXXXXXXXXX");
			}
		}
		cuenta.setIban(temp);

		// Obtener el interés, aunque también se podría generar
		temp = "";
		while (temp.isEmpty()) {
			System.out.print("Introduce tu interés: ");
			temp = pedirStringConPatron(Pattern.compile("^(\\d+\\.\\d+|\\d+)$"));
			if (temp.isEmpty()) {
				System.err.println("Interés inválido, solo puede tener números positivos");
			}
		}
		cuenta.setInteres(Double.parseDouble(temp));

		// Obtener el saldo, aunque podría estar a 0 por defecto
		temp = "";
		while (temp.isEmpty()) {
			System.out.print("Introduce tu saldo: ");
			temp = pedirStringConPatron(Pattern.compile("^(\\d+\\.\\d+|\\d+)$"));
			if (temp.isEmpty()) {
				System.err.println("Saldo inválido, solo puede tener números positivos");
			}
		}
		cuenta.setSaldo(Double.parseDouble(temp));
		return (cuenta);
	}

	public static void cajero() {
		Cuenta2 cuentaExistente = new Cuenta2("Paco", "ES1212341234123412341234", 10, 10000);
		Cuenta2 cuentaParaTransferencias = new Cuenta2("Minerva", "ES4243214321432143214321", 5, 50000);
		Cuenta2 cuenta2ParaTransferencias = new Cuenta2("Einstein", "ES4242424242424242424242", 0, 300000);
		Cuenta2[] cuentasParaTransferencias = {
				cuentaParaTransferencias,
				cuenta2ParaTransferencias,
		};
		Cuenta2 cuenta = new Cuenta2(cuentaExistente);
		int opcion = -1;
		boolean loginSuccess = false;

		// Bucle para iniciar sesión
		while (!loginSuccess) {
			loginSuccess = inicioSesion();

			// Si falla el inicio de sesión, es decir, no existe el IBAN, permite crear una cuenta
			if (!loginSuccess) {
				System.out.println("Ha fallado el inicio de sesión, ¿te gustaría crear una cuenta? (s/n)");
				String temp = SC.nextLine();
				char opcion2 = temp.toLowerCase().charAt(0);

				if (temp.length() != 1 || opcion2 != 's') {
					if (opcion2 != 'n' || temp.length() != 1) {
						System.err.println("Opción inválida");
					}
					System.out.println("Volviendo al inicio...");
					continue;
				}

				cuenta = crearCuenta();
			}
		}

		// Bucle para las acciones una vez iniciado sesión
		do {

			do {
				System.out.printf("Hola %s%n", cuenta.getNombre());
				mostrarMenu();
				String temp = pedirStringConPatron(Pattern.compile(String.format("^[1-%d]$", OPCIONES.length)));
				if (temp.isEmpty()) {
					System.err.printf("Opción inválida, solo puede tener números del 1 al %d%n", OPCIONES.length);
					opcion = -1; // Reinicio para que siga en el bucle
					continue;
				}
				opcion = Integer.parseInt(temp);
				if (opcion < 1 || opcion > OPCIONES.length) {
					System.err.printf("Opción inválida, solo puede tener números del 1 al %d%n", OPCIONES.length);
				}
			} while (opcion < 1 || opcion > OPCIONES.length);

			// NOTA: Los case tienen scope (llaves {}), porque cada caso es igual, cambiando pequeños detalles
			// entonces me daba pereza crear una función para cada caso y lo más sencillo era copy paste y con
			// limitando el scope evito el conflicto de variables con el mismo nombre
			switch (opcion) {
				case 1: {
					System.out.println("Vas a realizar un integro...");
					String temp = "";
					while (temp.isEmpty()) {
						System.out.print("Introduce tu cantidad: ");
						temp = pedirStringConPatron(Pattern.compile("^(\\d+\\.\\d+|\\d+)$"));
						if (temp.isEmpty()) {
							System.err.println("Cantidad inválida, solo puede tener números positivos");
						}
					}
					cuenta.ingreso(Double.parseDouble(temp));
					System.out.println(cuenta);
					break;
				}
				case 2: {
					System.out.println("Vas a realizar un reintegro...");
					String temp = "";
					while (temp.isEmpty()) {
						System.out.print("Introduce tu cantidad: ");
						temp = pedirStringConPatron(Pattern.compile("^(\\d+\\.\\d+|\\d+)$"));
						if (temp.isEmpty()) {
							System.err.println("Cantidad inválida, solo puede tener números positivos");
						}
					}
					cuenta.reintegro(Double.parseDouble(temp));
					System.out.println(cuenta);
					break;
				}
				case 3: {
					System.out.println("Vas a realizar una transferencia...");
					int opcionCuenta = -1;
					do {
						System.out.println("Selecciona una cuenta");
						for (int i = 0; i < cuentasParaTransferencias.length; ++i) {
							System.out.printf("%d. %s%n", i + 1, cuentasParaTransferencias[i].getIban());
						}
						System.out.print("> ");
						String temp = pedirStringConPatron(Pattern.compile("^[1-2]$"));
						if (temp.isEmpty()) {
							System.err.printf("Opción inválida, debe ser un número del 1 al %d%n", cuentasParaTransferencias.length);
							continue;
						}
						opcionCuenta = Integer.parseInt(temp);
						if (opcionCuenta < 1 || opcionCuenta > cuentasParaTransferencias.length) {
							System.err.printf("Opción inválida, solo puede tener números del 1 al %d%n",
									cuentasParaTransferencias.length);
						}
					} while (opcionCuenta < 1 || opcionCuenta > cuentasParaTransferencias.length);
					--opcionCuenta;
					Cuenta2 destino = cuentasParaTransferencias[opcionCuenta];
					String temp = "";
					while (temp.isEmpty()) {
						System.out.print("Introduce tu cantidad: ");
						temp = pedirStringConPatron(Pattern.compile("^(\\d+\\.\\d+|\\d+)$"));
						if (temp.isEmpty()) {
							System.err.println("Cantidad inválida, solo puede tener números positivos");
						}
					}
					cuenta.transferencia(destino, Double.parseDouble(temp));
					System.out.println(cuenta);
					System.out.println(destino);
					break;
				}
				case 4:
					System.out.println("Cerrando sesión...");
					break;
				default:
					System.out.println("Esta funcionalidad aún no está implementada...");
					break;
			}
		} while (opcion != OPCIONES.length);
	}

	// Aquí termina la parte que considero que podría ser parte de la clase Cajero
	// ===========================================================================

	public static void main(String[] args) {
		cajero();
		SC.close();
	}
}
