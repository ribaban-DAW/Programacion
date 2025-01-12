package Libro;

public class Main {
	public static void main(String[] args) {
		Libro l1 = new Libro(1, "One Piece", "Eiichiro Oda", 1040);
		Libro l2 = new Libro(2, "Don Quijote de la Mancha", "Miguel de Cervantes", 462);

		System.out.println(l1);
		System.out.println(l2);

		if (l1.getNumeroPaginas() > l2.getNumeroPaginas()) {
			System.out.printf("El libro %s tiene más páginas que el libro %s%n", l1.getTitulo(), l2.getTitulo());
		}
		else if (l1.getNumeroPaginas() == l2.getNumeroPaginas()) {
			System.out.printf("El libro %s tiene el mismo número de páginas que el libro %s%n", l1.getTitulo(), l2.getTitulo());
		}
		else {
			System.out.printf("El libro %s tiene más páginas que el libro %s%n", l2.getTitulo(), l1.getTitulo());
		}
	}
}
