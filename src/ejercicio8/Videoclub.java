package ejercicio8;

import java.time.LocalDate;

public class Videoclub {
	public static void main(String[] args) {
		Pelicula poltergeist=new Pelicula(Genero.TERROR,"Poltergeist, juegos diabólicos",LocalDate.of(2015, 5, 22),LocalDate.of(2015, 9, 22));
		Pelicula escarlata=new Pelicula(Genero.TERROR,"La cumbre escarlata",LocalDate.of(2015, 10, 9),LocalDate.of(2016, 2, 12));
		Pelicula ochoapellidos=new Pelicula(Genero.COMEDIA,"Ocho apellidos catalanes",LocalDate.of(2015, 11, 20),LocalDate.of(2016, 3, 18));
		Pelicula padres=new Pelicula(Genero.COMEDIA,"Padres por desigual",LocalDate.of(2016, 1, 1),LocalDate.of(2016, 5, 11));
		Pelicula starwars=new Pelicula(Genero.FICCION,"Star Wars: El despertar",LocalDate.of(2016, 1, 1),LocalDate.of(2016, 4, 20));
		Pelicula madmax=new Pelicula(Genero.FICCION,"Mad Max: Furia en la carretera",LocalDate.of(2015, 5, 15),LocalDate.of(2015, 9, 1));
		Pelicula clonStar=new Pelicula(starwars);
		Pelicula clonMad=new Pelicula(madmax);
	}
}
