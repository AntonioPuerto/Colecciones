 package ejercicio8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Videoclub {
	public static void main(String[] args) {
		
		HashSet<Pelicula> sinDuplicados=new HashSet<>();
		TreeSet<Pelicula> arbol1=new TreeSet<>();
		TreeSet<Pelicula> arbol2=new TreeSet<>(Comparator.comparing(pelicula -> pelicula.getFechaEstreno()));
		TreeMap<Clave,Pelicula> arbol3=new TreeMap<>(Comparator.comparing(Clave::getGenero).thenComparing(Clave::getNum));
		Pelicula poltergeist=new Pelicula(Genero.TERROR,"Poltergeist, juegos diabólicos",LocalDate.of(2015, 5, 22),LocalDate.of(2015, 9, 22));
		Pelicula escarlata=new Pelicula(Genero.TERROR,"La cumbre escarlata",LocalDate.of(2015, 10, 9),LocalDate.of(2016, 2, 12));
		Pelicula ochoapellidos=new Pelicula(Genero.COMEDIA,"Ocho apellidos catalanes",LocalDate.of(2015, 11, 20),LocalDate.of(2016, 3, 18));
		Pelicula padres=new Pelicula(Genero.COMEDIA,"Padres por desigual",LocalDate.of(2016, 1, 1),LocalDate.of(2016, 5, 11));
		Pelicula starwars=new Pelicula(Genero.FICCION,"Star Wars: El despertar",LocalDate.of(2016, 1, 1),LocalDate.of(2016, 4, 20));
		Pelicula madmax=new Pelicula(Genero.FICCION,"Mad Max: Furia en la carretera",LocalDate.of(2015, 5, 15),LocalDate.of(2015, 9, 1));
		Pelicula clonStar=new Pelicula(starwars);
		Pelicula clonMad=new Pelicula(madmax);
		List<Pelicula> lista=new ArrayList<>(List.of(poltergeist,escarlata,ochoapellidos,padres,starwars,madmax,clonStar,clonMad));
		sinDuplicados.addAll(lista);
		for(Pelicula p1:sinDuplicados) {
			System.out.println(p1);
		}
		System.out.println();
		arbol1.addAll(lista);
		for(Pelicula p1:arbol1) {
			System.out.println(p1+"Dias: "+ChronoUnit.DAYS.between(p1.getFechaEstreno(), p1.getFechaDVD()));
		}
		System.out.println();
		arbol2.addAll(lista);
		for(Pelicula p: arbol2) {
			System.out.println(p);
		}
		System.out.println();
		
		for(Pelicula p: lista) {
			arbol3.put(p.getClave(), p);
		}
		for (Map.Entry<Clave, Pelicula> entry : arbol3.entrySet()) {
		     System.out.println(entry.getValue());
		}
	
		
		
	}
}
