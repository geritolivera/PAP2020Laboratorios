package datatypes;

import clases.Instituto;

public class DTInstituto {
	private String nombre;
	
	public DTInstituto() {
		super();
	}
	public DTInstituto(Instituto instituto) {
		super();
		this.nombre = instituto.getNombre();
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
}
