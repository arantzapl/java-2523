package examen.uf2216.pojos;

public class Libro {
	private Long id;
    private String titulo;
    private int isbn;
    private int numeroPaginas;
    private boolean formatoDigital;

    // Constructor
    public Libro(Long id, String titulo, int isbn, int numeroPaginas, boolean formatoDigital) {
    	setId(id);
		setTitulo(titulo);
		setIsbn(isbn);
		setNumeroPaginas(numeroPaginas);
		setFormatoDigital(formatoDigital);
	}

    public Libro(String titulo, int isbn, int numeroPaginas, boolean formatoDigital) {
    	this(null, titulo, isbn, numeroPaginas, formatoDigital);
	}

	// Getters y Setters
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public boolean isFormatoDigital() {
		return formatoDigital;
	}

	public void setFormatoDigital(boolean formatoDigital) {
		this.formatoDigital = formatoDigital;
	}

    // Método para mostrar un resumen del libro
    public void mostrarResumen() {
        System.out.println("\nResumen del libro:");
        System.out.println("Título: " + titulo);
        System.out.println("ISBN: " + isbn);
        System.out.println("Número de páginas: " + numeroPaginas);
        System.out.println("Formato: " + (formatoDigital ? "Digital" : "Papel"));
    }
	
}