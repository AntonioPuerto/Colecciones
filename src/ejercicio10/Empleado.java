package ejercicio10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Empleado implements Comparable<Empleado>{
	private Clave clave;
	private String nombre;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	
	public Empleado(String nombre,Categoria categoria, LocalDate fechaAlta, LocalDate fechaBaja) {
		asignarClave(categoria);
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	public Empleado(Empleado copiar) {
		this(copiar.nombre,copiar.clave.getCategoria(),copiar.fechaAlta,copiar.fechaBaja);
	}
	
	protected Clave getClave() {
		return clave;
	}
	private void asignarClave(Categoria categoria){
		clave=new Clave(categoria);
	}
	protected String getNombre() {
		return nombre;
	}
	protected LocalDate getFechaAlta() {
		return fechaAlta;
	}
	protected LocalDate getFechaBaja() {
		return fechaBaja;
	}
	private long calcularDias() {
		if(fechaBaja==null) {
			return ChronoUnit.DAYS.between(fechaAlta,LocalDate.now());
		}else{
			return ChronoUnit.DAYS.between(fechaAlta,fechaBaja);
		}
	}
	@Override
	public String toString() {
		DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/LL/yyyy");
		return String.format("%-10s Nombre: %-8s Clave: %-5s Fecha alta: %-12s Fecha alta: %-12s Dias trabajados: %d", String.valueOf(clave.getCategoria()),nombre,clave,fechaAlta.format(dt),
				fechaBaja==null?"no tiene":fechaBaja.format(dt),calcularDias());
	}
	@Override
	public int compareTo(Empleado emp) {
		int comparacion=  (int) (emp.calcularDias()-this.calcularDias());
		if(comparacion==0) {
			return this.nombre.compareToIgnoreCase(emp.nombre);
		}else {
			return comparacion;
		}
	}

	
}
