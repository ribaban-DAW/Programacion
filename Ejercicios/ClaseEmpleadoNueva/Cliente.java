package ClaseEmpleadoNueva;

public class Cliente extends Persona {
	private String numeroTelefono;
	
	public Cliente(String nombre, int edad, String numeroTelefono) {
		super(nombre, edad);
		setNumeroTelefono(numeroTelefono);
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	@Override
	public String toString() {
		return String.format("%s, Número de teléfono: %s", super.toString(), numeroTelefono);
	}
	
	// Realmente la implementación es la misma que en Persona, así que esto es redundante, porque utilizo el toString.
	@Override
	public void mostrarDatos() {
		System.out.println(this);
	}
}
