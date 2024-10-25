package Simulacion;

//'implements java.io.Serializable' es para que el objeto sea serializable
//https://www.baeldung.com/java-serialization
public class Videojuego extends Producto implements java.io.Serializable {
	private static final long serialVersionUID = 1L; // Esto también es para la serialización
	String genero;
	String plataforma;

	public Videojuego(int codigo, String nombre, double precio, String genero, String plataforma) {
		super(codigo, nombre, precio);
		this.genero = genero;
		this.plataforma = plataforma;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("Información del videojuego");
		System.out.printf("Código: %d%n", super.getCodigo());
		System.out.printf("Nombre: %s%n", super.getNombre());
		System.out.printf("Precio: %.2f €%n", super.getPrecio());
		System.out.printf("Género: %s%n", genero);
		System.out.printf("Plataforma: %s%n", plataforma);
	}
}
