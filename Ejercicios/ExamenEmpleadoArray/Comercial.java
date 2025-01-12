package ExamenEmpleadoArray;

public class Comercial extends Empleado {
	private double ventas;

	public Comercial(String dni, String nombre, String apellidos, double sueldoBase) throws IllegalArgumentException {
		super(dni, nombre, apellidos, sueldoBase);
		setVentas(0);
	}

	public double getVentas() {
		return ventas;
	}

	public void setVentas(double ventas) {
		this.ventas = ventas;
	}

	@Override
	public double getSueldo() {
		final double PORCENTAJE = 0.1;
		return (super.getSueldoBase() + ventas * PORCENTAJE);
	}
}
