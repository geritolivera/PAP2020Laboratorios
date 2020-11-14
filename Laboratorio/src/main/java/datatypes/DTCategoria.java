package datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import clases.Categoria;

@XmlAccessorType(XmlAccessType.FIELD)
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
