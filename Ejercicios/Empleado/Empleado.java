package Empleado;
import java.util.Scanner;

public class Empleado {
	
	private String nif;
	private String nombre;
	private double sueldoBase;
	private int horasExtra;
	private int tipoIrpf;
	private boolean esCasado;
	private int numeroHijos;
	private static int importeHorasExtra = 0;
	
	public Empleado() {
		setNif("");
		nombre = "";
		sueldoBase = 0;
		horasExtra = 0;
		tipoIrpf = 0;
		esCasado = false;
		numeroHijos = 0;
		importeHorasExtra = 0;
	}

	public Empleado(String dni) {
		setNif(dni);
		nombre = "";
		sueldoBase = 0;
		horasExtra = 0;
		tipoIrpf = 0;
		esCasado = false;
		numeroHijos = 0;
		importeHorasExtra = 0;
	}
	
	public Empleado(String nif, String nombre, double sueldoBase, int horasExtra, int tipoIrpf, boolean esCasado, int numeroHijos) {
		this.setNif(nif);
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
		this.horasExtra = horasExtra;
		this.tipoIrpf = tipoIrpf;
		this.esCasado = esCasado;
		this.numeroHijos = numeroHijos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}

	public double getTipoIrpf() {
		return tipoIrpf;
	}

	public void setTipoIrpf(int tipoIrpf) {
		this.tipoIrpf = tipoIrpf;
	}

	public boolean isEsCasado() {
		return esCasado;
	}

	public void setEsCasado(boolean esCasado) {
		this.esCasado = esCasado;
	}

	public int getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public static int getImporteHorasExtra() {
		return importeHorasExtra;
	}

	public static void setImporteHorasExtra(int importeHorasExtra) {
		Empleado.importeHorasExtra = importeHorasExtra;
	}

	@Override
	public String toString() {
		return String.format("""
				%s %s
				Sueldo Base: %.2f
				Horas Extra: %d
				Tipo IRPF: %d
				Casado: %s
				Número de hijos: %d
				""", nif, nombre, sueldoBase, horasExtra, tipoIrpf, (esCasado) ? "Sí" : "No", numeroHijos);
	}
	
	public int calcularComplemento() {
		if (horasExtra < 1) {
			return (0);
		}
		return horasExtra * importeHorasExtra;
	}
	
	public double calcularSaldoBruto() {
		return sueldoBase + calcularComplemento();
	}

	public double calcularRetencion() {
		final int puntosPorCasado = 2;
		if (esCasado) {
			return calcularSaldoBruto() * (tipoIrpf - puntosPorCasado - numeroHijos) * 0.01;
		}
		return calcularSaldoBruto() * (tipoIrpf - numeroHijos) * 0.01;
	}
	
	public double calcularSaldoNeto() {
		return calcularSaldoBruto() - calcularRetencion();
	}
	
	public static void main(String[] args) {
		Empleado[] empleados = new Empleado[20];
		Scanner sc = new Scanner(System.in);
		
		// Para pedir el número de empleados
		int numeroEmpleados = 0;
		do {			
			try {
				System.out.print("Introduce el número de empleados: ");
				numeroEmpleados = sc.nextInt();
				if (numeroEmpleados < 1) {					
					System.err.println("Error, número inválido, tiene que ser un número entre 1 al 20");
				}
			}
			catch (Exception e) {
				System.err.println("Error, número inválido, tiene que ser un número entre 1 al 20");
			}
			finally {
				sc.nextLine(); // Para limpiar el buffer
			}
		} while (numeroEmpleados < 1 || numeroEmpleados > 20);
		
		// Para rellenar los datos de los empleados
		String nif;
		String nombre;
		double sueldoBase;
		int horasExtra;
		int tipoIrpf;
		boolean esCasado;
		int numeroHijos;
		int importeHorasExtra = -1;
		for (int i = 0; i < numeroEmpleados; ++i) {
			try {				
				System.out.printf("Introduce el NIF del empleado %d: ", i + 1);
				nif = sc.nextLine();
			}
			catch (Exception e) {
				System.err.println("Error en el NIF, saliendo del programa");
				return ;
			}
			try {				
				System.out.printf("Introduce el nombre del empleado %d: ", i + 1);
				nombre = sc.nextLine();
			}
			catch (Exception e) {
				System.err.println("Error en el nombre, saliendo del programa");
				return ;
			}
			try {				
				System.out.printf("Introduce el sueldo base del empleado %d: ", i + 1);
				sueldoBase = sc.nextDouble();
				sc.nextLine(); // Para limpiar el buffer, no lo pongo en el finally porque si falla se termina el programa
			}
			catch (Exception e) {
				System.err.println("Error en el sueldo base, saliendo del programa");
				return ;
			}
			try {				
				System.out.printf("Introduce las horas extra del empleado %d: ", i + 1);
				horasExtra = sc.nextInt();
				sc.nextLine(); // Para limpiar el buffer, no lo pongo en el finally porque si falla se termina el programa
			}
			catch (Exception e) {
				System.err.println("Error en las horas extra, saliendo del programa");
				return ;
			}
			try {				
				System.out.printf("Introduce el tipo IRPF del empleado %d: ", i + 1);
				tipoIrpf = sc.nextInt();
				sc.nextLine(); // Para limpiar el buffer, no lo pongo en el finally porque si falla se termina el programa
			}
			catch (Exception e) {
				System.err.println("Error en el tipo IRPF, saliendo del programa");
				return ;
			}
			try {				
				System.out.printf("Introduce si el empleado %d está casado o no (true o false): ", i + 1);
				esCasado = sc.nextBoolean();
				sc.nextLine(); // Para limpiar el buffer, no lo pongo en el finally porque si falla se termina el programa
			}
			catch (Exception e) {
				System.err.println("Error en saber si el empleado está casado o no, saliendo del programa");
				return ;
			}
			try {	
				System.out.printf("Introduce el número de hijos del empleado %d: ", i + 1);
				numeroHijos = sc.nextInt();
				sc.nextLine(); // Para limpiar el buffer, no lo pongo en el finally porque si falla se termina el programa
			}
			catch (Exception e) {
				System.err.println("Error en el número de hijos, saliendo del programa");
				return ;
			}
			empleados[i] = new Empleado(nif, nombre, sueldoBase, horasExtra, tipoIrpf, esCasado, numeroHijos);
		}
		
		// Para introducir el importe de horas extra
		do {			
			try {			
				System.out.print("Introduzca el importe correspondiente al pago por hora extra: ");
				importeHorasExtra = sc.nextInt();
			}
			catch (Exception e) {
				System.err.println("Error obteniendo el nombre");
			}
			finally {
				sc.nextLine(); // Para limpiar el buffer
			}
		} while (importeHorasExtra < 0);
		
		// Mostrar el saldo neto de los empleados
		for (int i = 0; i < numeroEmpleados; ++i) {
			System.out.printf("El sueldo neto del empleado %d es %.2f%n", i + 1, empleados[i].calcularSaldoNeto());
		}
	}
}