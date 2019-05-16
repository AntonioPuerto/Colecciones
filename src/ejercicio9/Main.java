package ejercicio9;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
		List<Asignatura> listaArray=new ArrayList<>(List.of(prog,bd,sis,ed,lm,fol,bd2,clonProg,clonLm));
		for(Asignatura a:listaArray) {
			System.out.println(a);
		}
	
	}

}
