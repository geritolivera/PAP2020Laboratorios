package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ProgramaFormacion {
	private String nombre;
	private String descripcion;
	private Date fechaI;
	private Date fechaF;
	private Date fechaA;
	private List<Estudiante> estudiantes = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<>();
	
	public ProgramaFormacion() {
		super();
	}
	public ProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaA = fechaA;
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
	
	public Date getFechaA() {
		return fechaA;
	}
	public void setFechaA(Date fechaA) {
		this.fechaA = fechaA;
	}
	
	public void agregarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}
	public List<Curso> getCursos() {
		return cursos;
	}
}
