package ExamenSegundaEvaluacion;

// NOTA: Esta clase podría ser abstracta y evitar que se instancia,
// pero como no se especifica nada, lo voy a dejar como una clase normal.
public class Vehiculo {
	private String matricula;
	private String marca;
	private int anioFabricacion;
	
	public Vehiculo(String matricula, String marca, int anioFabricacion) throws IllegalArgumentException {
		setMatricula(matricula);
		setMarca(marca);
		setAnioFabricacion(anioFabricacion);
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) throws IllegalArgumentException {
		if (matricula == null || matricula.isEmpty()) {
			throw new IllegalArgumentException("La matrícula no puede estar vacía");
		}
		final String REGEX_MATRICULA = "^\\d{4}\\s[a-zA-Z]{3}$";
		if (!matricula.matches(REGEX_MATRICULA)) {
			throw new IllegalArgumentException("La matrícula no tiene el formato '1234 ABC'");
		}
		this.matricula = matricula;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) throws IllegalArgumentException {
		if (marca == null || marca.isEmpty()) {
			throw new IllegalArgumentException("La marca no puede estar vacía");
		}
		this.marca = marca;
	}
	
	public int getAnioFabricacion() {
		return anioFabricacion;
	}
	
	public void setAnioFabricacion(int anioFabricacion) {
		final int ANIO_VALIDO = 1800;
		if (anioFabricacion < ANIO_VALIDO) {
			throw new IllegalArgumentException("El año de fabricación no puede ser previo a " + ANIO_VALIDO);
		}
		this.anioFabricacion = anioFabricacion;
	}

	public double calcularPrecioAlquiler(int dias) {
		if (dias < 1) {
			System.err.println("El alquiler debe ser de al menos un día");
			return 0;
		}
		final double PRECIO_BASE = 50;
		return dias * PRECIO_BASE;
	}
	
	@Override
	public String toString() {
		return String.format("Matrícula: %s, Marca: %s, AñoFabricación: %d", matricula, marca, anioFabricacion);
	}
}
