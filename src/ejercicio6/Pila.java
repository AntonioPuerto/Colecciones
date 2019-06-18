package ejercicio6;

import static ejercicio3.Keyboard.range;

import java.util.LinkedList;

import ejercicio3.Keyboard;
import ejercicio3.Keyboard.Range;

public class Pila {
	private LinkedList<String> pila;
	public Pila(){
		pila=new LinkedList<>();
	}
	public void menu() {
		int seleccion;
		boolean salir=false;
		do {
			System.out.print("1.Nueva pila\n2.Consultar elemento\n3.Añadir elemento\n4.Eliminar elemento.\n5.Consultar toda la pila\n6.Salir\nIntroduce: ");
			seleccion = range(Range.BOTHIN, 6, 1);
			System.out.println();
			switch (seleccion) {
			case 1:
				pila.clear();
				break;
			case 2:
				consultar();
				break;
			case 3:
				añadir();
				break;
			case 4: 
				eliminar();
				break;
			case 5:
				mostrarPila();
				break;
			case 6:
				salir=true;
				break;
			}
		} while (!salir);
	}
	private void mostrarPila() {
		if (!pila.isEmpty()) {
			for (String s : pila) 
				System.out.println(s);
		}else {
			System.out.println("La pila está vacía.");
		}
	}
	private void consultar() {
		if (!pila.isEmpty()) {
			System.out.println(pila.getLast());
			eliminar();
		}else {
			System.out.println("La pila está vacía");
		}
	}
	private void añadir() {
		System.out.print("introduce la cadena deseada: ");
		pila.addLast(Keyboard.stringInput());
	}
	private void eliminar() {
		if(!pila.isEmpty()) {
			pila.removeLast();
		}else {
			System.out.println("La pila está vacía.");
		}
	}
	public static void main(String[] args) {
		Pila pila=new Pila();
		pila.menu();
	}
}
