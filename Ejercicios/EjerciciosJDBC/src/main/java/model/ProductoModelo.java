package model;

public class ProductoModelo {
	private Integer id;
	private String nombre;
	private Double precio;
	private String imagenURL;
	
	public ProductoModelo(Integer id, String nombre, Double precio, String imagenURL) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setImagenURL(imagenURL);
	}
	
	public ProductoModelo(Integer id, String nombre, Double precio) {
		this(id, nombre, precio, "unknown.png");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagenURL() {
		return imagenURL;
	}

	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
}
