package PracticaHerencia.src.Empleados2;

public abstract class Empleado {
	protected String nombre;
	protected int edad;
	protected double salario;
	protected final float PLUS = 300;
	
	Empleado(String nombre, int edad, float salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
