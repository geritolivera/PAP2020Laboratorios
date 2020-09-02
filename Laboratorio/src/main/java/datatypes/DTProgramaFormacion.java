package datatypes;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import clases.ProgramaFormacion;

public class DTProgramaFormacion {
	private String nombre;
	private String descripcion;
	private Date fechaI;
	private Date fechaF;
	//private List<DTCurso> cursos = new ArrayList<>();
	private ArrayList<String> cursos = new ArrayList<>();
	
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
	
	public DTProgramaFormacion(ProgramaFormacion programa) {
		super();
		this.nombre = programa.getNombre();
		this.descripcion = programa.getDescripcion();
		this.fechaI = programa.getFechaI();
		this.fechaF = programa.getFechaF();
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
	
	public void agregarCurso(String curso) {
		cursos.add(curso);
	}
	public ArrayList<String> getCursos() {
		return cursos;
	}
}
