package ejercicio10;

public enum Categoria {
	JEFE('J'), ENCARGADO('E'), EMPLEADO('D');
	private char initial;
	Categoria(char initial){
		this.initial=initial;
	}
	public char getCodigo() {
		return initial;
	}
}
