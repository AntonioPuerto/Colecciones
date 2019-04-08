package ejercicio3;
import static ejercicio3.Keyboard.*;
import java.util.ArrayList;

public class Menu {
	private ArrayList<String> cadenas;
	
	public Menu() {
		cadenas=new ArrayList<>();
	}

	public void menu() {
		int option;
		do {
			System.out.printf(
					"\n1.Nueva lista\n2.Número de cadenas\n3.Añadir cadena\n4.Eliminar cadena\n5.Contiene cadena\n6.Mostrar lista entera\n7.Salir\nIntroduce: ");
			option = range(Range.BOTHIN, 7, 1);
			switch (option) {
			case 1: cadenas.clear();
				break;
			case 2: mostrarSize();
				break;
			case 3: cadenas.add(insertarCadena());
				break;
			case 4: eliminar();
				break;
			case 5: contiene();
				break;
			case 6: mostrarLista();
				break;
			case 7: System.exit(0);
				break;
			}
		} while (option!=7);
	}

	private void contiene() {
		if (!cadenas.isEmpty()) {
			System.out.printf("La lista %s contiene la cadena insertada.\n",
					cadenas.contains(insertarCadena()) ? "sí" : "no");
		}else {
			System.out.println("La lista está vacía");
		}
	}

	private void mostrarSize() {
		if (!cadenas.isEmpty()) {
			System.out.println(cadenas.size());
		}else {
			System.out.println("La lista está vacía");
		}
	}

	private void mostrarLista() {
		if (!cadenas.isEmpty()) {
			for (Object o : cadenas) {
				System.out.println(o);
			} 
		}else {
			System.out.println("La lista está vacía.");
		}
	}
	private String insertarCadena() {
		System.out.print("Introduce una cadena: ");
		return stringInput();
	}
	private void eliminar() {
		int cont=1, seleccion;
		if (!cadenas.isEmpty()) {
			for (String o : cadenas) {
				System.out.println(cont + ". " + o);
				cont++;
			}
			System.out.print("Selecciona la cadena deseada: ");
			seleccion = range(Range.BOTHIN, cadenas.size(), 1)-1;
			cadenas.remove(seleccion);
		}else {
			System.out.println("La lista está vacía.");
		}
	}

	@Override
	public String toString() {
		return String.format("Menu cadenas=%s", cadenas);
	}
	public static void main(String[] args) {
		Menu m=new Menu();
		m.menu();
	}
}
