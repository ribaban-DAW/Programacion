package Programador;

public class Empleado {
	private String nombre;
	private String dni;
	private double salarioBase;
	private double retencion;
	
	public Empleado(String nombre, String dni, double salarioBase, int retencion) throws IllegalArgumentException {
		setNombre(nombre);
		setDni(dni);
		setSalarioBase(salarioBase);
		setRetencion(retencion);
	}
	
	public double getSalarioBruto() {
		return (salarioBase);
	}
	
	public double getSalarioNeto() {
		return (salarioBase - salarioBase * retencion * 0.01);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws IllegalArgumentException {
		dni = dni.toUpperCase();
		if (!comprobarDni(dni)) {
			throw new IllegalArgumentException("El DNI es inválido");
		}
		this.dni = dni;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getRetencion() {
		return retencion;
	}

	public void setRetencion(double retencion) {
		this.retencion = retencion;
	}
	
	public void setRetencion(int retencion) throws IllegalArgumentException {
		if (retencion < 0 || retencion > 50) {
			throw new IllegalArgumentException("La retención está fuera del rango");
		}
		setRetencion(retencion * 0.01);
	}
	
	private boolean comprobarDni(String dni) {
		final String DNI_REGEX = "^\\d{8}\\w$";
		final String TABLA = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (dni.matches(DNI_REGEX)) {			
			int dniNum = Integer.parseInt(dni.substring(0, 8));
			if (dni.charAt(8) == TABLA.charAt(dniNum % 23) ) {
				return (true);
			}
		}
		return (false);
	}
	
	@Override
	public String toString() {
		return (String.format("%s, %s, %.2f, %.2f", nombre, dni, salarioBase, retencion));
	}
	
	public boolean equals(Empleado that) {
		return (that.dni.equals(this.dni));
	}
}
