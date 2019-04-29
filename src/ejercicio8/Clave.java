package ejercicio8;

public class Clave {	
	Genero genero;
	private int num;
	public Clave(int num,Genero genero) {
		this.num=num;
		this.genero = genero;
		
	}
	public Clave(Clave clave) {
		this(clave.num, clave.genero);
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object o) {
		return o instanceof Clave && num==((Clave)o).num && ((Clave)o).genero.equals(genero);
	}
	@Override
	public String toString() {
		return String.format("%s", genero.getCodigo()+String.valueOf(num));
	}
}
