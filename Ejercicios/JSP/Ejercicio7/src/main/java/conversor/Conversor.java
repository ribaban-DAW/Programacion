package conversor;

public class Conversor {
	private static final double RATIO = 166.0;
	
	public static double aPesetas(double precio) {
		return precio * RATIO;
	}
	
	public static double aEuros(double precio) {
		return precio / RATIO;
	}
}
