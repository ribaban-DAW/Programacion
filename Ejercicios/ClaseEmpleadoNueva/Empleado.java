package ClaseEmpleadoNueva;

public class Empleado extends Persona {
	private double sueldoBruto;
	
	public Empleado(String nombre, int edad, double sueldoBruto) {
		super(nombre, edad);
		setSueldoBruto(sueldoBruto);
	}
	
	public double getSueldoBruto() {
		return sueldoBruto;
	}
	
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	
	@Override
	public String toString() {
		return String.format("%s, Sueldo bruto: %.2f €", super.toString(), sueldoBruto);
	}
	
	// Realmente la implementación es la misma que en Persona, así que esto es redundante, porque utilizo el toString.
	@Override
	public void mostrarDatos() {
		System.out.println(this);
	}
}