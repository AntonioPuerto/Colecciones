package ejercicio1;

import java.util.ArrayList;

public class Cajamain {
	public static void main(String[] args) {
		ArrayList<Caja<String>> cadenas=new ArrayList<>();
		ArrayList<Caja<Long>> largos=new ArrayList<>();
		long total=0;
		rellenar(cadenas, largos);
		mostrar(cadenas);
		mostrar(largos);
		sumaLargos(largos, total);
		
	}

	private static void sumaLargos(ArrayList<Caja<Long>> largos, long total) {
		for(Caja<Long> o:largos) {
			total+=(long)Integer.parseInt(o.toString());
		}
		System.out.println(total);
	}

	private static <T> void rellenar(ArrayList<Caja<String>> cadenas, ArrayList<Caja<Long>> largos) {
		for (int i = 0; i < 10; i++) {
			cadenas.add(new Caja<String>("cadena"+i));
			largos.add(new Caja<Long>(Long.valueOf(i)));
		}
	}

	private static <T> void mostrar(ArrayList<T> cadenas) {
		for(T s:cadenas) {
			System.out.println(s);
		}
	}
}
