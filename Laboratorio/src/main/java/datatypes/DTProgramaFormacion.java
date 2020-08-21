package datatypes;

import java.util.Date;

public class DTProgramaFormacion {
	private String nombre;
	private String descripcion;
	private Date fechaI;
	private Date fechaF;
	
	public DTProgramaFormacion() {
		super();
	}
	public DTProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFechaI() {
		return fechaI;
	}
	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}
	
	public Date getFechaF() {
		return fechaF;
	}
	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}
}
