package model;

public class ProductoModelo {
	private int id;
	private String nombre;
	private double precio;
	private String imagenURL;
	
	public ProductoModelo(int id, String nombre, double precio, String imagenURL) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setImagenURL(imagenURL);
	}
	
	public ProductoModelo(int id, String nombre, double precio) {
		this(id, nombre, precio, "unknown.png");
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

	public String getImagenURL() {
		return imagenURL;
	}

	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
}
