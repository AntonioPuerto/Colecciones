package ejercicio1;

import java.util.LinkedList;

public class Almacenmain {

	public static <T> void main(String[] args) {
		LinkedList<Caja<T>> cajas=new LinkedList<Caja<T>>();
		cajas.addLast((Caja<T>) new Caja<String>("string"));
		cajas.addLast(new Caja<Integer>(25));
	}

}
