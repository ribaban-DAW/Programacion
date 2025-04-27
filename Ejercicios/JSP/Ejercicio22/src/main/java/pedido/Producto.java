package pedido;

public class Producto {
	private int id;
	private String nombre;
	private double precio;
	private String imagenURL;
	
	public Producto(int id, String nombre, double precio, String imagenURL) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setImagenURL(imagenURL);
	}
	
	public Producto(int id, String nombre, double precio) {
		this(id, nombre, precio, "unknown.png");
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getImagenURL() {
		return imagenURL;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
