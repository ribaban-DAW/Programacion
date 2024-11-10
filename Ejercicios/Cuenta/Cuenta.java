package Cuenta;

public class Cuenta {
	private String nombre;
	private String iban;
	private double interes;
	private double saldo;

	public Cuenta() {
		setNombre("");
		setIban("");
		setInteres(0);
		setSaldo(0);
	}

	public Cuenta(String nombre, String iban, double interes, double saldo) {
		setNombre(nombre);
		setIban(iban);
		setInteres(interes);
		setSaldo(saldo);
	}

	public Cuenta(Cuenta that) {
		setNombre(that.nombre);
		setIban(that.iban);
		setInteres(that.interes);
		setSaldo(that.saldo);
	}

	public String getNombre() {
		return (nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIban() {
		return (iban);
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getInteres() {
		return (interes);
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getSaldo() {
		return (saldo);
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return String.format("""
				Nombre: %s
				IBAN: %s
				Interés: %.2f %%
				Saldo: %.2f €
				""", nombre, iban, interes, saldo);
	}

	public boolean ingreso(double cantidad) {
		if (cantidad < 0) {
			System.out.println("No se puede ingresar una cantidad negativa");
			return (false);
		}
		saldo += cantidad;
		System.out.printf("Se ha realizado un ingreso de %.2f €%n", cantidad);
		return (true);
	}

	public boolean reintegro(double cantidad) {
		if (cantidad < 0) {
			System.out.println("No se puede ingresar una cantidad negativa");
			return (false);
		}
		if (saldo < cantidad) {
			System.out.printf("No puedes hacer un reintegro de %.2f € porque la cuenta no tiene saldo suficiente%n",
					cantidad);
			return (false);
		}
		saldo -= cantidad;
		System.out.printf("Se ha hecho un reintegro de %.2f €%n", cantidad);
		return (true);
	}

	public boolean transferencia(Cuenta that, double cantidad) {
		if (!this.reintegro(cantidad)) {
			System.out.println("Como el reintegro no se ha realizado, no se ha realizado la transferencia");
			return (false);
		}
		return (that.ingreso(cantidad));
	}

	public static void main(String[] args) {
		Cuenta c1 = new Cuenta();
		Cuenta c2 = new Cuenta("Paco", "ES121234123412341234", 2, 418924);
		Cuenta c3 = new Cuenta(c1);
		c1.setNombre("Si");
		c1.setIban("ES434321432143214321");
		c1.setInteres(0.25);
		c1.setSaldo(2525);
		c2.transferencia(c1, 25829132);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
