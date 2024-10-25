package Simulacion;

// 'implements java.io.Serializable' es para que el objeto sea serializable
// https://www.baeldung.com/java-serialization
public class Cliente implements java.io.Serializable {
	private static final long serialVersionUID = 1L; // Esto también es para la serialización
	private String dni;
	private String nombre;
	private double saldo;

	public Cliente(String dni, String nombre, double saldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public String getDni() {
		return (dni);
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return (nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return (saldo);
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void comprarProducto(Producto producto) {
		// Si no tiene saldo suficiente, muestra el error y se sale del método.
		if (saldo < producto.getPrecio()) {
			System.out.printf("ERROR: Saldo insuficiente. Tiene %.2f y el producto %s cuesta %.2f €%n", saldo,
					producto.getNombre(), producto.getPrecio());
			return;
		}

		saldo -= producto.getPrecio();
		System.out.printf("Ha realizado la compra satisfactoriamente, su saldo actual es %.2f €%n", saldo);
	}
}
