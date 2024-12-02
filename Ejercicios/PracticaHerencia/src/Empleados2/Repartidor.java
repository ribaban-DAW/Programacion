package PracticaHerencia.src.Empleados2;

public class Repartidor extends Empleado {
	private String zona;
	
	Repartidor(String nombre, int edad, float salario, String zona) {
		super(zona, edad, salario);
		this.zona = zona;
	}
	
	@Override
	public double getSalario() {
		return salario + (plus() ? PLUS : 0);
	}
	
	public boolean plus() {
		return (edad < 25 && zona.equals("zona 3"));
	}
}
