package Examen1_Etiqueta;

public class Etiqueta {
	private static final String REGEX_TAG = "^\\d{4}\\-[a-zA-Z0-9]{5}/\\d{2}_\\d$";
	
	private String nombreArticulo;
	private String referenciaArticulo;
	private int inventario;
	private double precio;
	
	public Etiqueta(String nombreArticulo, String referenciaArticulo, int inventario, double precio) {
		setNombreArticulo(nombreArticulo);
		setReferenciaArticulo(referenciaArticulo);
		setInventario(inventario);
		setPrecio(precio);
	}
	
	// NOTA: Los setters en verdad no hacen falta porque no vamos a utilizar ningún Scanner, pero está bien tenerlos
	
	public String getNombreArticulo() {
		return (nombreArticulo);
	}
	
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	
	public String getReferenciaArticulo() {
		return (referenciaArticulo);
	}
	
	public void setReferenciaArticulo(String referenciaArticulo) {
		this.referenciaArticulo = referenciaArticulo;
	}
	
	public int getInventario() {
		return (inventario);
	}
	
	public void setInventario(int inventario) {
		this.inventario = inventario;
	}
	
	public double getPrecio() {
		return (precio);
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void mostrarArticulo() {
		System.out.printf("""
				Nombre: %s
				Referencia: %s
				Inventario: %d unidades
				Precio: %.2f €
				""", nombreArticulo, referenciaArticulo, inventario, precio);
	}
	
	public boolean validarEtiqueta() {
		return (referenciaArticulo.matches(REGEX_TAG));
	}
	
	public void agregarInventario(int cantidad) {
		if (cantidad < 1) {
			System.err.println("Error, la cantidad no puede ser menor que 1"); // Hago esta comprobación porque considero que reducir una cantidad de 0 no tiene sentido
			return;
		}
		System.out.printf("Incrementando el inventario %d%n", cantidad);
		inventario += cantidad;
	}
	
	public void reducirInventario(int cantidad) {
		if (cantidad < 1) {
			System.err.println("Error, la cantidad no puede ser menor que 1"); // Hago esta comprobación porque considero que reducir una cantidad de 0 no tiene sentido
			return;
		}
		if (inventario < cantidad) {
			System.err.println("No se puede reducir esa cantidad, porque no hay suficiente cantidad");
			return;
		}
		System.out.printf("Reduciendo el inventario %d%n", cantidad);
		inventario -= cantidad;
	}
	
	public void actualizarPrecio(double nuevoPrecio) {
		if (nuevoPrecio < 0) {
			System.err.println("Error, el precio no puede ser negativo"); // Aquí no compruebo que sea 0, porque sí que tiene sentido un precio sea de 0 €, es decir, que sea gratis.
			return;
		}
		System.out.printf("Actualizando el precio %.2f%n", nuevoPrecio);
		precio = nuevoPrecio;
	}
	
	// Este es mi método para probar la clase
	public static void test(Etiqueta[] etiquetas) {
		final int cantidad = 5;
		final double precio = 3.15;
		for (int i = 0; i < etiquetas.length; ++i) {
			System.out.printf("Test %d%n", i + 1);
			Etiqueta etiqueta = etiquetas[i];
			if (!etiqueta.validarEtiqueta()) {
				System.err.println("Esa etiqueta es inválida, pasando al siguiente test...");
				continue;
			}
			System.out.println("Etiqueta válida");
			etiqueta.mostrarArticulo();
			etiqueta.reducirInventario(cantidad * i);
			etiqueta.agregarInventario(cantidad * i);
			etiqueta.actualizarPrecio(precio * i);
			etiqueta.mostrarArticulo();
		}
	}
	
	public static void main(String[] args) {
		// Aquí creo un porrón de etiquetas para probarlo en el método test
		Etiqueta[] etiquetas = {
				new Etiqueta("1", "2022-xrFdS/25_1", 14, 25), // Válido
				new Etiqueta("2", "2022-aAaaa/1_1", 50, 25),  // Inválido
				new Etiqueta("3", "2022-FdS/25_1", 21, 5),   // Inválido
				new Etiqueta("4", "1-xrFdS/25_1", 24, 50),    // Inválido
				new Etiqueta("5", "2024-ribab/27_6", 24, 75), // Válido
				new Etiqueta("6", "202xrFdS/25_1", 5, 100),   // Inválido
				new Etiqueta("7", "2022-xrFdS25_1", 4, 25223),  // Inválido
				new Etiqueta("8", "1234-aBcDe/12_3", 242, 23.50), // Válido
		};
		test(etiquetas);
	}
}
