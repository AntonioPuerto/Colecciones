package ejercicio7;

import static ejercicio3.Keyboard.range;

import java.util.LinkedList;

import ejercicio3.Keyboard;
import ejercicio3.Keyboard.Range;
import ejercicio6.Pila;

public class Cola {
	private LinkedList<String> cola;
	public Cola(){
		cola=new LinkedList<>();
	}
	public void menu() {
		int seleccion;
		do {
			System.out.print("1.Nueva pila\n2.Consultar elemento\n3.Añadir elemento\n4.Eliminar elemento.\n5.Consultar toda la pila\n6.Salir\nIntroduce: ");
			seleccion = range(Range.BOTHIN, 6, 1);
			System.out.println();
			switch (seleccion) {
			case 1:
				cola.clear();
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
				System.exit(0);
				break;
			}
		} while (seleccion!=6);
	}
	private void mostrarPila() {
		for(String s: cola) {
			System.out.println(s);
		}
	}
	private void consultar() {
		if (!cola.isEmpty()) {
			System.out.println(cola.getFirst());
			eliminar();
		}else {
			System.out.println("La cola está vacía");
		}
	}
	private void añadir() {
		System.out.print("introduce la cadena deseada: ");
		cola.addLast(Keyboard.stringInput());
	}
	private void eliminar() {
		if(!cola.isEmpty()) {
			cola.removeFirst();
		}else {
			System.out.println("La cola está vacía.");
		}
	}
	public static void main(String[] args) {
		Cola cola=new Cola();
		cola.menu();
	}
}
