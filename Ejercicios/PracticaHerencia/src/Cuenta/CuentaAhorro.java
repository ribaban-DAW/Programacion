package PracticaHerencia.src.Cuenta;

public class CuentaAhorro extends Cuenta {
	protected boolean activa;
	
	public CuentaAhorro(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		activa = saldo >= 10000;
	}
	
	@Override
	public void consignar(float cantidad) {
		if (!activa) {
			System.err.println("La cuenta no está activa, no se puede consignar");
			return;
		}
		super.consignar(cantidad);
		activa = saldo >= 10000;
	}
	
	@Override
	public void retirar(float cantidad) {
		if (activa) {
			super.retirar(cantidad);
		}
		activa = saldo >= 10000;
	}
	
	@Override
	public void extractoMensual() {
		if (numRetiro > 4) {
			comisionMensual += (numRetiro - 4) * 1000;
		}
		super.extractoMensual();
		activa = saldo >= 10000;
		if (activa) {
			System.out.println("La cuenta está activa");
		}
		else {
			System.out.println("La cuenta está inactiva");
		}
	}
	
	@Override
	public String toString() {
		return (String.format("""
				Saldo: %f
				Comision mensual: %f
				Número de transacciones: %d
				""", saldo, comisionMensual, numConsignacion + numRetiro));
	}
	
	@Override
	public void imprimir() {
		System.out.println(this.toString());
	}
}
