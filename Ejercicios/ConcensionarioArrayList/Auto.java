package ConcensionarioArrayList;

public class Auto extends Vehiculo {
	private int cantidadPuertas;
	
	public Auto(String marca, String modelo, int año, Combustible tipoCombustible, int cantidadPuertas) throws IllegalArgumentException {
		super(marca, modelo, año, tipoCombustible);
		if (cantidadPuertas < 2) {
			throw new IllegalArgumentException("No puede tener menos de 2 puertas");
		}
		this.cantidadPuertas = cantidadPuertas;
	}

	@Override
	public void mostrarInformacion() {
		System.out.printf("[AUTO] Marca: %s, Modelo: %s, Año: %d, Combustible: %s, Puertas: %d%n", super.getMarca(), super.getModelo(), super.getAño(), super.getTipoCombustible(), cantidadPuertas);
	}
}
