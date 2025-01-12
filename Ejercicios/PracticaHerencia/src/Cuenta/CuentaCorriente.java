package PracticaHerencia.src.Cuenta;

public class CuentaCorriente extends Cuenta{
	private float sobregiro;
	
	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		sobregiro = 0;
	}
	
	@Override
	public void retirar(float cantidad) {
		if (cantidad < 0) {
			System.err.println("No se puede retirar cantidad negativa");
			return;
		}

		// Si la cantidad es mayor al saldo, entonces significa que no hay saldo suficiente
		// entonces tiene que aumentar el sobregiro esa cantidad menos el saldo actual
		if (cantidad > saldo) {
			sobregiro += cantidad - saldo;
			setSaldo(0);
		}
		else {
			setSaldo(saldo - cantidad);
		}
	}
	
	@Override
	public void consignar(float cantidad) {
		if (cantidad < 0) {
			System.err.println("No se puede consignar una cantidad negativa");
			return;
		}

		float nuevaCantidad = cantidad - sobregiro;
		// Actualizo el sobregiro dependiendo de la nueva cantidad
		if (nuevaCantidad >= 0) {
			sobregiro = 0;
		}
		else {
			sobregiro -= cantidad;
			nuevaCantidad = 0;
		}
		super.consignar(nuevaCantidad);
	}
	
	@Override
	public String toString() {
		return (String.format("""
				Saldo: %f
				Comision mensual: %f
				Número de transacciones: %d
				Sobregiro: %f
				""", saldo, comisionMensual, numConsignacion + numRetiro, sobregiro));
	}
	
	@Override
	public void imprimir() {
		System.out.println(this.toString());
	}
}
