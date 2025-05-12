package model;

public class UsuarioModelo {
	private int id;
	private String nombre;
	private String rol;
	
	public UsuarioModelo(int id, String nombre, String rol) {
		setId(id);
		setNombre(nombre);
		setRol(rol);
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
