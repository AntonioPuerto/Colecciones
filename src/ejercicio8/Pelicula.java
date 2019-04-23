package ejercicio8;

import java.time.LocalDate;

public class Pelicula {
	private Clave clave;
	private String nombre;
	private LocalDate fechaEstreno;
	private LocalDate fechaDVD;
	public Pelicula(Genero genero, String nombre, LocalDate fechaEstreno, LocalDate fechaDVD) {
		clave.setGenero(genero);
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.fechaDVD = fechaDVD;
	}
	public Pelicula(Pelicula pelicula) {
		this(pelicula.clave.genero,pelicula.nombre,pelicula.fechaEstreno,pelicula.fechaDVD);
	}
	public boolean equals(Object o) {
		return o instanceof Pelicula && nombre.equals(((Pelicula)o).nombre) && ((Pelicula)o).fechaEstreno.equals(fechaEstreno) && ((Pelicula)o).fechaDVD.equals(fechaDVD);
	}
	public void asignarClave() {
		clave.setNum(5);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public LocalDate getFechaDVD() {
		return fechaDVD;
	}
	public void setFechaDVD(LocalDate fechaDVD) {
		this.fechaDVD = fechaDVD;
	}
	
}
