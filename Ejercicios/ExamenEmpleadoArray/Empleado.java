package ExamenEmpleadoArray;

public abstract class Empleado {
	private String dni;
	private String nombre;
	private String apellidos;
	private double sueldoBase;

	public Empleado(String dni, String nombre, String apellidos, double sueldoBase) throws IllegalArgumentException {
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		setSueldoBase(sueldoBase);
	}

	public void setDni(String dni) throws IllegalArgumentException {
		/** Explicación del REGEX
		 * ^                Comienzo del regex
		 * \\d{8}           8 dígitos
		 * [a-z]            Una letra de la a la z
		 * $                Fin del regex
		 */
		final String REGEX_DNI = "^\\d{8}[a-z]$";
		if (!dni.toLowerCase().matches(REGEX_DNI)) {
			throw new IllegalArgumentException(
					"Error en la aplicación: El DNI debe tener 8 números seguidos de una letra.");
		}
		this.dni = dni.toUpperCase();
	}
	
	public void setNombre(String nombre) throws IllegalArgumentException {
		/** Explicación del REGEX
		 * ^                Comienzo del regex
		 * (                Abro grupo
		 * \\d{8}           8 dígitos
		 * [a-zñáéíóú]+     Contenga al menos una letra de la a-z y caracteres especiales como ñ y vocales con tilde
		 * \\s*             Que tenga espacios o no
		 * )+               El grupo se repite al menos una vez
		 * $                Fin del regex
		 */
		final String REGEX_NOMBRE = "^([a-zñáéíóú]+\\s*)+$";
		if (!nombre.toLowerCase().matches(REGEX_NOMBRE)) {
			throw new IllegalArgumentException("Error en la aplicación: El nombre solo pueden tener letras.");
		}
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) throws IllegalArgumentException {
		/** Explicación del REGEX
		 * ^                Comienzo del regex
		 * (                Abro grupo
		 * \\d{8}           8 dígitos
		 * [a-zñáéíóú]+     Contenga al menos una letra de la a-z y caracteres especiales como ñ y vocales con tilde
		 * \\s*             Que tenga espacios o no
		 * )+               El grupo se repite al menos una vez
		 * $                Fin del regex
		 */
		final String REGEX_APELLIDOS = "^([a-zñáéíóú]+\\s*)+$";
		if (!apellidos.toLowerCase().matches(REGEX_APELLIDOS)) {
			throw new IllegalArgumentException("Error en la aplicación: Los apellidos solo pueden tener letras.");
		}
		this.apellidos = apellidos;
	}

	public void setSueldoBase(double sueldoBase) throws IllegalArgumentException {
		if (sueldoBase < 0) {
			throw new IllegalArgumentException("Error en la aplicación: El sueldo base no puede ser negativo.");
		}
		this.sueldoBase = sueldoBase;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public abstract double getSueldo();

	@Override
	public String toString() {
		return (String.format("Dni: %s, Nombre: %s, Apellidos: %s, SueldoBase: %.2f", dni, nombre, apellidos,
				sueldoBase));
	}
}
