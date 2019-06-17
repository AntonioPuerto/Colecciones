package ejercicio8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pelicula implements Comparable<Pelicula>{
	private Clave clave;
	private String nombre;
	private LocalDate fechaEstreno;
	private LocalDate fechaDVD;
	private static int comedias=0;
	private static int ficcion=0;
	private static int terror=0;
	public Pelicula(Genero genero, String nombre, LocalDate fechaEstreno, LocalDate fechaDVD) {
		asignarClave(genero);
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.fechaDVD = fechaDVD;
	}
	public Pelicula(Pelicula pelicula) {
		this(pelicula.clave.genero,pelicula.nombre,pelicula.fechaEstreno,pelicula.fechaDVD);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((fechaDVD == null) ? 0 : fechaDVD.hashCode());
		result = prime * result + ((fechaEstreno == null) ? 0 : fechaEstreno.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object o) {
		return o instanceof Pelicula && nombre.equals(((Pelicula)o).nombre) && ((Pelicula)o).fechaEstreno.equals(fechaEstreno) && ((Pelicula)o).fechaDVD.equals(fechaDVD) && 
				((Pelicula)o).clave.equals(clave);
	}
	public void asignarClave(Genero genero) {
		if(genero==Genero.TERROR) {
			terror++;
			clave=new Clave(terror,Genero.TERROR);
		}else if(genero==Genero.COMEDIA) {
			comedias++;
			clave=new Clave(comedias,Genero.COMEDIA);
		}else {
			ficcion++;
			clave=new Clave(ficcion,Genero.FICCION);
		}
	}
	public String getNombre() {
		return nombre;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public LocalDate getFechaDVD() {
		return fechaDVD;
	}
	public Clave getClave() {
		return clave;
	}
	@Override
	public int compareTo(Pelicula o) {
		int comparacion=(int) ChronoUnit.DAYS.between(fechaDVD, o.fechaDVD);
		if(comparacion==0) {
			return nombre.compareToIgnoreCase(o.nombre);
		}else {
			return comparacion;
		}
	}
	@Override
	public String toString() {
		return String.format("%-10s %-35s Clave: %-5s Fecha estreno: %-12s Fecha DVD: %-12s",clave.genero, nombre,clave,
				fechaEstreno, fechaDVD);
	}
	
}
