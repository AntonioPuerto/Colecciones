package ejercicio1y2;
public class Caja <T>{
	T elemento;
	public Caja(T elemento) {
		this.elemento = elemento;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return String.format("%s", elemento);
	}
	
	
}
