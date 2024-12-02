package Programador;

public class Programador extends Empleado {
	private String lenguaje;
	final private double INCREMENTO = 0.15;
	
	public Programador(String nombre, String dni, double salario, int retencion, String lenguaje) throws IllegalArgumentException {
		super(nombre, dni, salario, retencion);
		setLenguaje(lenguaje);
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	@Override
	public double getSalarioBruto() {
		return (super.getSalarioBase() + super.getSalarioBruto() * INCREMENTO);
	}
	
	@Override
	public double getSalarioNeto() {
		return (super.getSalarioBase() - this.getSalarioBruto() * super.getRetencion());
	}
	
	@Override
	public String toString() {
		return (String.format("%s, %s, %.2f", super.toString(), lenguaje, INCREMENTO));
	}

	public boolean tieneMismoLenguaje(Programador that) {
		return (lenguaje.equals(that.lenguaje));
	}
}
