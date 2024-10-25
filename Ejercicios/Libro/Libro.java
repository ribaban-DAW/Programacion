package Libro;

public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private int numeroPaginas;
	
	public Libro(int isbn, String titulo, String autor, int numeroPaginas) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
	}

	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	@Override
	public String toString() {
		return String.format("El libro con ISBN %d creado por el autor %s tiene %d páginas", isbn, autor, numeroPaginas);
	}
}
