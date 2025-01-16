package ExamenEmpleadoArrayList;

public class Tecnico extends Empleado {
	private int categoria;
	
	public Tecnico(String dni, String nombre, String apellidos, double sueldoBase, int categoria) throws IllegalArgumentException {
		super(dni, nombre, apellidos, sueldoBase);
		setCategoria(categoria);
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public double getSueldo() {
		return (super.getSueldoBase() + categoria * 100);
	}
	
}
