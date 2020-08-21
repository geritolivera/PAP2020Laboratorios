package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EdicionCurso {
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;
	private Curso curso;
	private List<Estudiante> estudiantes = new ArrayList<>();
	private List<Docente> docentes = new ArrayList<>();
	
	public EdicionCurso() {
		super();
	}
	public EdicionCurso(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, Curso curso) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.cupo = cupo;
		this.fechaPub = fechaPub;
		this.curso = curso;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public Date getFechaPub() {
		return fechaPub;
	}
	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Curso getCurso() {
		return curso;
	}
	public String getNomCurso() {
		return curso.getNombre();
	}
	
	public void agregarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	public List<Docente> getDocentes() {
		return docentes;
	}

}
