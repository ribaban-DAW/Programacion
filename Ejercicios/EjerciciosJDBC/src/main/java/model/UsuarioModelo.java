package model;

public class UsuarioModelo {
	private Integer id;
	private String nombre;
	private String rol;
	
	public UsuarioModelo(Integer id, String nombre, String rol) {
		setId(id);
		setNombre(nombre);
		setRol(rol);
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
