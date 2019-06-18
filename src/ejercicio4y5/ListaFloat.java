package ejercicio4y5;

import java.util.LinkedList;
import java.util.ListIterator;

import static ejercicio3.Keyboard.*;
import ejercicio3.Keyboard.Range;

public class ListaFloat {
	private LinkedList<Float> lista;
	private ListIterator<Float> iterador;
	public ListaFloat() {
		lista=new LinkedList<>();
		rellenar();
		iterador=lista.listIterator();
	}
	public void menu() {
		int seleccion;
		boolean salir=false;
		do {
			System.out.print("1.Mostrar lista\n2.Mostrar siguiente\n3.Mostrar anterior\n4.Eliminar último mostrado.\n5.Salir\nIntroduce: ");
			seleccion = range(Range.BOTHIN, 5, 1);
			System.out.println();
			switch (seleccion) {
			case 1:
				mostrarLista();
				break;
			case 2:
				mostrarSiguiente();
				break;
			case 3:
				mostrarAnterior();
				break;
			case 4: 
				eliminar();
				break;
			case 5:
				salir=true;
				break;
			}
		} while (!salir);
	}
	private void mostrarLista() {
		if (!lista.isEmpty()) {
			for (Float f : lista) {
				System.out.println(f);
			}
			System.out.println();
		}else {
			System.out.println("La lista está vacía");
		}
	}
	private void mostrarSiguiente() {
		if (!lista.isEmpty()) {
			if (iterador.hasNext()) {
				System.out.println(iterador.next() + "\n");
			} else {
				iterador = lista.listIterator();
				System.out.println(iterador.next() + "\n");
			} 
		}else {
			System.out.println("La lista está vacía.");
		}
	}
	private void mostrarAnterior() {
		if (!lista.isEmpty()) {
			if (iterador.hasPrevious()) {
				System.out.println(iterador.previous() + "\n");
			} else {
				iterador = lista.listIterator(lista.size());
				System.out.println(iterador.previous() + "\n");
			} 
		}else {
			System.out.println("La lista está vacía.");
		}
	}
	private void eliminar() {
		if (!lista.isEmpty()) {
			try {
				iterador.remove();
				System.out.println("Elemento eliminado");
				if(!lista.isEmpty() && iterador.hasNext())
					iterador.next();
			} catch (IllegalStateException e) {
				System.out.println("Debes de mostrar algún elemento antes de eliminarlo.");
			}
		}else {
			System.out.println("La lista está vacía.");
		}
	}
	private void rellenar() {
		float value;
		System.out.println("Introduce un valor positivo; -1 para salir.");
		do {
			System.out.print("Introduce: ");
			value=valueGiven(Range.GREATEREQUAL, -1f);
			if(value!=-1){
				lista.add(value);
			}
		}while(value!=-1);
		System.out.println();
	}
	@Override
	public String toString() {
		return String.format("ListaFloat lista=%s \niterador=%s", lista, iterador);
	}
	public static void main(String[] args) {
		ListaFloat lista=new ListaFloat();
		lista.menu();
	}
}
