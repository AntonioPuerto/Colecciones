package ejercicio9;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Asignatura {
	private String nombre;
	private String descripcion;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	public Asignatura(String nombre, String descripcion, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	public Asignatura(Asignatura clonable) {
		this(clonable.nombre,clonable.descripcion,clonable.fecha,clonable.horaInicio,clonable.horaFin);
	}
	public boolean equals(Object o) {
		return o instanceof Asignatura && nombre.equals(((Asignatura)o).nombre) && descripcion.equals(((Asignatura)o).descripcion) && fecha.equals(((Asignatura)o).fecha)
				&& horaInicio.equals(((Asignatura)o).horaInicio) && horaFin.equals(((Asignatura)o).horaFin);
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public String getClave() {
		return fecha.getDayOfMonth()+"-"+(String.valueOf(horaInicio));
	}
	public String formatear(LocalDate fecha) {
		return DateTimeFormatter.ofPattern("dd/LL/yyyy").format(fecha);
	}
	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %-10s",
				nombre, descripcion, formatear(fecha), horaInicio, horaFin);
	}
	
}
