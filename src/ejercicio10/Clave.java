package ejercicio10;

public class Clave {
	private static int jefes=0;
	private static int encargados=0;
	private static int empleados=0;
	private int clave;
	private Categoria categoria;
	public Clave(Categoria categoria) {
		this.categoria = categoria;
		numClave();
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public int getClave() {
		return clave;
	}
	private void numClave() {
		if(categoria == Categoria.JEFE) {
			clave=++jefes;
		}else if(categoria == Categoria.ENCARGADO) {
			clave=++encargados;
		}else {
			clave=++empleados;
		}
	}
	@Override
	public String toString() {
		return String.format("%c%s",categoria.getCodigo(),clave);
	}

}
