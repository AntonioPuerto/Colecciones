package ejercicio10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.time.LocalDate;
import java.util.TreeSet;

public class Arboles {

	public static void main(String[] args) {
		
		Empleado pepe=new Empleado("Pepe",Categoria.EMPLEADO,LocalDate.of(2011, 3, 21),LocalDate.of(2013, 4,24));
		Empleado juan=new Empleado("Juan",Categoria.ENCARGADO,LocalDate.of(2012, 2, 29),null);
		Empleado maria=new Empleado("María",Categoria.JEFE,LocalDate.of(2010, 4, 30),LocalDate.of(2014, 5,31));
		Empleado laura=new Empleado("Laura",Categoria.EMPLEADO,LocalDate.of(2011, 3, 21),LocalDate.of(2013, 4,24));
		Empleado esteban=new Empleado("Esteban",Categoria.ENCARGADO,LocalDate.of(2010, 11, 5),LocalDate.of(2015, 2,11));
		Empleado pedro=new Empleado("Pedro",Categoria.JEFE,LocalDate.of(2009, 8, 16),null);
		Empleado yolanda=new Empleado("Yolanda",Categoria.EMPLEADO,LocalDate.of(2012, 07, 27),LocalDate.of(2013, 10,1));
		Empleado nuria=new Empleado("Nuria",Categoria.JEFE,LocalDate.of(2009, 8, 31),null);
		Empleado antonio=new Empleado("Antonio",Categoria.ENCARGADO,LocalDate.of(2011, 1, 28),LocalDate.of(2014, 5,14));
		Empleado clonDePepe=new Empleado(pepe);
		Empleado clonDeEsteban=new Empleado(esteban);
		Empleado clonDePedro = new Empleado(pedro);
		List<Empleado> lista=new ArrayList<>(Arrays.asList(pepe,juan,maria,laura,esteban,pedro,yolanda,nuria,antonio,clonDePepe,clonDeEsteban,clonDePedro));
		TreeSet<Empleado> arbol1=new TreeSet<>(lista);
		for(Empleado e: arbol1) {
			System.out.println(e);
		}
		System.out.println();
	/*	TreeSet<Empleado> arbol2=new TreeSet<>(new Comparator<Empleado>() {
			@Override
			public int compare(Empleado e1, Empleado e2) {
				return e1.getNombre().compareTo(e2.getNombre());
			}
		});*/
		TreeSet<Empleado> arbol2=new TreeSet<>(Comparator.comparing(empleado -> empleado.getNombre()));
		arbol2.addAll(lista);
		for(Empleado e: arbol2) {
			System.out.println(e);
		}
		System.out.println();
		
		TreeMap<Clave,Empleado> arbol3=new TreeMap<>(Comparator.comparing(Clave::getCategoria).thenComparing(Clave::getClave));
		for(Empleado e: lista) {
			arbol3.put(e.getClave(), e);
		}
		for (Map.Entry<Clave, Empleado> entry : arbol3.entrySet()) {
		     System.out.println(entry.getValue());
		}
	}

}
