package PracticaHerencia.src.Empleados2;

public class Comercial extends Empleado {
	private double comision;
	
	Comercial(String nombre, int edad, float salario, double comision) {
		super(nombre, edad, salario);
		this.comision = comision;
	}
	
	@Override
	public double getSalario() {
		return salario + (plus() ? PLUS : 0);
	}
	
	public boolean plus() {
		return (edad > 30 && comision > 200);
	}
}
