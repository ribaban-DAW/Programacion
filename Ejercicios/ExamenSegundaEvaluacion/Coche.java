package ExamenSegundaEvaluacion;

public class Coche extends Vehiculo {
	private int numPuertas;

	public Coche(String matricula, String marca, int anioFabricacion, int numPuertas) {
		super(matricula, marca, anioFabricacion);
		setNumPuertas(numPuertas);
	}
	
	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	
	@Override
	public double calcularPrecioAlquiler(int dias) {
		final double PRECIO_BASE = 50;
		final double PRECIO_POR_PUERTA = 5;
		final double MODIFICADOR = numPuertas * PRECIO_POR_PUERTA;
		
		return dias * (PRECIO_BASE + MODIFICADOR);
	}
	
	@Override
	public String toString() {
		return String.format("%s, NumPuertas: %d", super.toString(), numPuertas);
	}
}
