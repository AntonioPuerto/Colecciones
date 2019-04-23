package ejercicio8;

public class Clave {	
	Genero genero;
	private int num;
	public Clave(Genero genero, int num) {
		this.genero = genero;
		this.num = num;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return String.format("%s", genero+String.valueOf(num));
	}
}
