package ExamenSegundaEvaluacion;

public class Moto extends Vehiculo {
	private boolean tieneSidecar;

	
	public Moto(String matricula, String marca, int anioFabricacion, boolean tieneSidecar) {
		super(matricula, marca, anioFabricacion);
		setTieneSidecar(tieneSidecar);
	}
	
	public boolean getTieneSidecar() {
		return tieneSidecar;
	}

	public void setTieneSidecar(boolean tieneSidecar) {
		this.tieneSidecar = tieneSidecar;
	}
	
	@Override
	public double calcularPrecioAlquiler(int dias) {
		final double PRECIO_BASE = 50;
		final double MODIFICADOR = (tieneSidecar) ? 0.9 : 1; // Si tiene Sidecar, entonces el modificador es un 90% (0.9)
		
		return dias * (PRECIO_BASE * MODIFICADOR);
	}
	
	@Override
	public String toString() {
		return String.format("%s, tieneSidecar: %s", super.toString(), (tieneSidecar) ? "Sí" : "No");
	}
}
