package PracticaHerencia.src.Cuenta;

public class Main {
	public static void main(String[] args) {

		{ // Prueba de la creación de una Cuenta
			Cuenta c = new Cuenta(2500, 15);
			c.consignar(10500);
			c.consignar(5);
			c.consignar(-1);
			c.retirar(25);
			c.retirar(-1);
			c.retirar(100000);
			c.retirar(15);
			c.retirar(15);
			c.retirar(15);
			c.extractoMensual();
			c.imprimir();
		}

		{ // Prueba de la creación de una CuentaAhorro
			CuentaAhorro ca = new CuentaAhorro(15000, 23);
			ca.consignar(10500);
			ca.consignar(5);
			ca.consignar(-1);
			ca.retirar(25);
			ca.retirar(-1);
			ca.retirar(100000);
			ca.retirar(15);
			ca.retirar(15);
			ca.retirar(15);
			ca.extractoMensual();
			ca.imprimir();
		}

		{ // Prueba de la creación de una CuentaCorriente
			CuentaCorriente cc = new CuentaCorriente(1000, 10);
			cc.consignar(10500);
			cc.consignar(5);
			cc.consignar(-1);
			cc.retirar(25);
			cc.retirar(-1);
			cc.retirar(100000);
			cc.retirar(15);
			cc.retirar(15);
			cc.retirar(15);
			cc.extractoMensual();
			cc.imprimir();
		}
	}
}
