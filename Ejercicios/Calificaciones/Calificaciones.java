package calificaciones;
import java.util.*;

public class Calificaciones {
	public static double calculate_average(double[] grades) {
		double average;
		
		average = 0;
		for (double grade : grades) {
			average += grade;
		}
		average /= grades.length;
		return (average);
	}
	public static void califications() {
		Scanner sc = new Scanner(System.in);
		String name;
		double average;
		double[] grades = new double[3];
		System.out.print("Introduce tu nombre: ");
		name = sc.nextLine();
		for (int i = 0; i < grades.length; ++i) {
			do
			{				
				System.out.printf("Introduce la nota %d: ", i + 1);
				grades[i] = sc.nextDouble();
				if (grades[i] < 0 || grades[i] > 10) {
					System.out.println("Nota inválida, tiene que ser una nota del 0 al 10");
				}
			} while (grades[i] < 0 || grades[i] > 10);
		}
		average = calculate_average(grades);
		if (average >= 5) {
			System.out.printf("%s has aprobado porque tu nota media es %.2f", name, average);
		} else {
			System.out.printf("%s has suspendido porque tu nota media es %.2f", name, average);
		}
		sc.close();
	}
	public static void main(String[] args) {
		califications();
	}
}
