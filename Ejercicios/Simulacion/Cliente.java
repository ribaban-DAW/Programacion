package Simulacion;

// 'implements java.io.Serializable' es para que el objeto sea serializable
// https://www.baeldung.com/java-serialization
public class Cliente implements java.io.Serializable {
	private static final long serialVersionUID = 1L; // Esto también es para la serialización
	private String dni;
	private String nombre;
	private double saldo;
	private boolean esVip;
	private int contadorProducto;
	private final static int CANTIDADPARASERVIP = 10;

	public Cliente(String dni, String nombre, double saldo) {
		setDni(dni);
		setNombre(nombre);
		setSaldo(saldo);
		esVip = false;
		contadorProducto = 0;
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
		if (saldo < 0) {
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		}
		this.saldo = saldo;
	}

	public boolean getEsVip() {
		return esVip;
	}

	public void setEsVip(boolean isVip) {
		this.esVip = isVip;
	}

	public int getContadorProducto() {
		return contadorProducto;
	}

	public void setContadorProducto(int contadorProducto) {
		this.contadorProducto = contadorProducto;
	}

	public void comprarProducto(Producto producto) {
		// Si no tiene saldo suficiente, muestra el error y se sale del método.
		if (saldo < producto.getPrecio()) {
			System.err.printf("ERROR: Saldo insuficiente. Tiene %.2f € y el producto %s cuesta %.2f €%n", saldo,
					producto.getNombre(), producto.getPrecio());
			return;
		}

		if (esVip) {
			System.out.println("Como es un cliente VIP, tiene un descuento del 50%");
			setSaldo(saldo - producto.getPrecio() * 0.5);
		} else {
			setSaldo(saldo - producto.getPrecio());
		}

		setContadorProducto(contadorProducto + 1);

		if (!esVip && contadorProducto > CANTIDADPARASERVIP) {
			esVip = true;
			System.out.printf("Enhorabuena %s, te has convertido en un cliente VIP%n", nombre);
		}
		System.out.printf("Ha realizado la compra satisfactoriamente, su saldo actual es %.2f €%n", saldo);
	}

	// Sobrecargo el método para poder comprar una cantidad de productos
	public void comprarProducto(Producto producto, int cantidad) {
		// Si la cantidad es negativa, se sale del método
		if (cantidad < 0) {
			System.err.println("ERROR: La cantidad no puede ser negativa");
			return ;
		}
		// Si no tiene saldo suficiente, muestra el error y se sale del método.
		if (saldo < producto.getPrecio() * cantidad) {
			System.err.printf("ERROR: Saldo insuficiente. Tiene %.2f € y %d unidades del producto %s cuesta %.2f €%n",
					saldo, cantidad, producto.getNombre(), producto.getPrecio() * cantidad);
			return;
		}

		if (esVip) {
			System.out.println("Como es un cliente VIP, tiene un descuento del 50%");
			setSaldo(saldo - producto.getPrecio() * cantidad * 0.5);
		} else {
			setSaldo(saldo - producto.getPrecio() * cantidad);
		}

		setContadorProducto(contadorProducto + cantidad);

		if (!esVip && contadorProducto > CANTIDADPARASERVIP) {
			esVip = true;
			System.out.printf("Enhorabuena %s, te has convertido en un cliente VIP%n", nombre);
		}
		System.out.printf("Ha realizado la compra satisfactoriamente, su saldo actual es %.2f €%n", saldo);
	}

}
