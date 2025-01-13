package AgendaArrayList;

public class ContactoEmpresa extends Contacto {
	private String paginaWeb;
	
	public ContactoEmpresa(String nombre, String telefono, String paginaWeb) {
		super(nombre, telefono);
		this.paginaWeb = paginaWeb;
	}
	
	@Override
	public String toString() {
		return (String.format("""
				%s
				Página Web: %s""", super.toString(), paginaWeb));
	}
}
