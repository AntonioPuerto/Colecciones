package ejercicio1;
import java.util.LinkedList;

public class Almacen<T> implements Contenido<T>{
	LinkedList<T> almacen;
	public Almacen(LinkedList<T> almacen) {
		this.almacen = almacen;
	}
	public T primerContenido() {
		return almacen.getFirst();
	}

	public T ultimoContenido() {
		return almacen.getLast();
	}

	public String toString(int pos) {
		return String.format("Almacen caja=%s", almacen.get(pos).toString());
	}

}
