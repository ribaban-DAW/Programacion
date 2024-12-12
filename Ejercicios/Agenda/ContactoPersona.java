package Agenda;

public class ContactoPersona extends Contacto {
	private String cumple;
	
	public ContactoPersona(String nombre, String telefono, String cumple) {
		super(nombre, telefono);
		this.cumple = cumple;
	}
	
	@Override
	public String toString() {
		return (String.format("""
				%s
				Cumple: %s""", super.toString(), cumple));
	}
}
