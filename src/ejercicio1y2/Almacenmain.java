package ejercicio1y2;

import java.util.LinkedList;

public class Almacenmain {

	public static <T> void main(String[] args) {
		LinkedList<Caja<T>> cajas=new LinkedList<Caja<T>>();
		Almacen almacen =new Almacen(cajas);
		cajas.addLast((Caja<T>) new Caja<String>("string"));
		cajas.addLast((Caja<T>) new Caja<Integer>(25));
		System.out.println(almacen.primerContenido()+"\n"+almacen.ultimoContenido());
		cajas.addFirst((Caja<T>) new Caja<String>("primero"));
		cajas.addLast((Caja<T>) new Caja<String>("ultimo"));
		System.out.println(almacen.primerContenido()+"\n"+almacen.ultimoContenido());
	}

}
