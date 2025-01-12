package Simulacion;

//'implements java.io.Serializable' es para que el objeto sea serializable
//https://www.baeldung.com/java-serialization
public class Producto implements java.io.Serializable {
	private static final long serialVersionUID = 1L; // Esto también es para la serialización
	private int codigo;
	private String nombre;
	private double precio;

	public Producto(int codigo, String nombre, double precio) {
		if (codigo < 0) {
			throw new IllegalArgumentException("El código no puede ser negativo");
		}
		if (precio < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getCodigo() {
		return (codigo);
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return (nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return (precio);
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void mostrarInformacion() {
		System.out.println("Información del producto");
		System.out.printf("Código: %d%n", codigo);
		System.out.printf("Nombre: %s%n", nombre);
		System.out.printf("Precio: %.2f€%n", precio);
	}
	
	public static void main(String[] a) {
		new Producto(5, "Hola", -1);
	}
}
