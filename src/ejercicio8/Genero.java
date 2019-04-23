package ejercicio8;

public enum Genero {
	COMEDIA('C'), FICCION('F'), TERROR('T');
	private final char initial;
	Genero(char initial){
		this.initial=initial;
	}
	public char getCodigo() {
		return initial;
	}
}
