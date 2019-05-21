package ejercicio9;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

import ejercicio3.Keyboard.Range;

public class Main {

	public static void main(String[] args) {
		Asignatura prog=new Asignatura("Programación","Hernecia y Colecciones",LocalDate.of(2017, 6, 6),LocalTime.of(8, 15),LocalTime.of(13, 30));
		Asignatura bd=new Asignatura("Base de Datos","Disparadores y SQL",LocalDate.of(2017, 6, 15),LocalTime.of(11, 45),LocalTime.of(14, 30));
		Asignatura sis=new Asignatura("Sistemas informáticos","Sistemas en red",LocalDate.of(2017, 6, 20),LocalTime.of(10, 15),LocalTime.of(11, 15));
		Asignatura ed=new Asignatura("Entornos de desarrollo","Diagrama de clases",LocalDate.of(2017, 6, 19),LocalTime.of(9, 15),LocalTime.of(11, 15));
		Asignatura lm=new Asignatura("Lenguaje de marcas","Hojas de estilo",LocalDate.of(2017, 6, 14),LocalTime.of(8, 15),LocalTime.of(11, 15));
		Asignatura fol=new Asignatura("FOL","Derechos del trabajador",LocalDate.of(2017, 6, 13),LocalTime.of(10, 15),LocalTime.of(11, 15));
		Asignatura bd2=new Asignatura("Progrmación","Hernecia y Colecciones",LocalDate.of(2017, 6, 6),LocalTime.of(8, 15),LocalTime.of(13, 30));
		Asignatura clonProg=new Asignatura(prog);
		Asignatura clonLm=new Asignatura(lm);
		List<Asignatura> listaArray=new ArrayList<>();
		HashSet<Asignatura> sinDuplicados=new HashSet<>();
		TreeSet<Asignatura> arbol=new TreeSet<>();
		//List.of(prog,bd,sis,ed,lm,fol,bd2,clonProg,clonLm)
		ListIterator<Asignatura> it=((List<Asignatura>) sinDuplicados).listIterator(sinDuplicados.size());
		int pos1,pos2;
		for(Asignatura a:listaArray) {
			System.out.println(a);
		}
		
		for(Asignatura a: sinDuplicados) {
			System.out.println(a);
		}
		
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		System.out.print("Introduce la primera posición: ");
		pos1=ejercicio3.Keyboard.range(Range.BOTHIN, sinDuplicados.size(), 0);
		System.out.print("Introduce la segunda posición: ");
		pos2=ejercicio3.Keyboard.range(Range.BOTHIN, sinDuplicados.size(), 0);
		for(Asignatura a: ((List<Asignatura>) sinDuplicados).subList(pos1,pos2)) {
			System.out.println(a);
		}
		for(Asignatura a: arbol) {
			System.out.println(a);
		}
	}

}
