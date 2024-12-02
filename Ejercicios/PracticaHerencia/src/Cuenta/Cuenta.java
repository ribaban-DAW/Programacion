package PracticaHerencia.src.Cuenta;

public class Cuenta {
	protected float saldo;
	protected int numConsignacion;
	protected int numRetiro;
	protected float tasaAnual;
	protected float comisionMensual;
	
	public Cuenta(float saldo, float tasaAnual) {
		setSaldo(saldo);
		setNumConsignacion(0);
		setNumRetiro(0);
		setTasaAnual(tasaAnual);
		setComisionMensual(0);
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNumConsignacion() {
		return numConsignacion;
	}

	public void setNumConsignacion(int numConsignacion) {
		this.numConsignacion = numConsignacion;
	}

	public int getNumRetiro() {
		return numRetiro;
	}

	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisionMensual() {
		return comisionMensual;
	}

	public void setComisionMensual(float comisionMensual) {
		this.comisionMensual = comisionMensual;
	}
	
	@Override
	public String toString() {
		return (String.format("""
				saldo: %.2f
				numConsignacion: %d 
				numRetiro: %d
				tasaAnual: %.2f
				comisionMensual: %.2f
				""", saldo, numConsignacion, numRetiro, tasaAnual, comisionMensual));
	}
	
	public void consignar(float cantidad) {
		if (cantidad < 0) {
			System.err.println("No se puede consignar una cantidad negativa");
			return;
		}
		setSaldo(saldo + cantidad);
		setNumConsignacion(numConsignacion + 1);
	}
	
	public void retirar(float cantidad) {
		if (cantidad < 0) {
			System.err.println("No se puede retirar una cantidad negativa");
			return;
		}
		if (saldo - cantidad < 0) {
			System.err.println("No se puede retirar esa cantidad debido a un saldo insuficiente");
			return;
		}
		setSaldo(saldo - cantidad);
		setNumRetiro(numRetiro + 1);
	}
	
	public float calcularInteresMensual() {
		return (saldo * tasaAnual / (12 * 100));
	}
	
	public void extractoMensual() {
		setSaldo(saldo - comisionMensual);
		setSaldo(saldo + calcularInteresMensual());
	}
	
	public void imprimir() {
		System.out.println(this.toString());
	}
}
