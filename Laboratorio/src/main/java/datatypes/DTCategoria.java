package datatypes;

import clases.Categoria;

public class DTCategoria {
	private String nombre;
	
	public DTCategoria() {
		super();
	}
	public DTCategoria(Categoria categoria) {
		super();
		this.nombre = categoria.getNombre();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
}
