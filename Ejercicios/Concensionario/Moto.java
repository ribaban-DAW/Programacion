package Concensionario;

public class Moto extends Vehiculo {
	private int cilindrada;
	
	public Moto(String marca, String modelo, int año, Combustible tipoCombustible, int cilindrada) throws IllegalArgumentException {
		super(marca, modelo, año, tipoCombustible);
		if (cilindrada < 1) {
			throw new IllegalArgumentException("La cilindrada no puede ser menor que 1");
		}
		this.cilindrada = cilindrada;
	}

	@Override
	public void mostrarInformacion() {
		System.out.printf("[MOTO] Marca: %s, Modelo: %s, Año: %d, Combustible: %s, Cilindrada: %dcc%n", super.getMarca(), super.getModelo(), super.getAño(), super.getTipoCombustible(), cilindrada);
	}
}
