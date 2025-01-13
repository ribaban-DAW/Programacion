package AgendaArrayList;

public abstract class Contacto {
	protected String nombre;
	protected String telefono;
	
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return (String.format("""
				Nombre: %s
				Teléfono: %s""", nombre, telefono));
	}
}
