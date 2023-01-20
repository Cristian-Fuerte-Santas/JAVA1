package datos;

import java.time.LocalDate;

public class Datos {

	private LocalDate fecha;

	private String titulo;

	private String texto;

	private String autor;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Datos(LocalDate fecha, String titulo, String texto, String autor) {
		super();
		this.fecha = fecha;
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
	}

	@Override
	public String toString() {

		return "Noticia: \n" + "fecha= " + fecha + "\n" + "titulo= " + titulo + "\n" + "texto= " + texto + "\n"
				+ "autor= " + autor + "\n";
	}

}
