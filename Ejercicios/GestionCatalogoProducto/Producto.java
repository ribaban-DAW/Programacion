package GestionCatalogoProducto;

public class Producto {
	private int id;
	private String nombre;
	private double precio;
	
	public Producto(int id, String nombre, double precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return (String.format("Producto ID: %d, Nombre %s, Precio: %.2f", id, nombre, precio));
	}
	
}
