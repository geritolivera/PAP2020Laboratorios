package clases;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import java.util.Date;

@Entity
public class ProgramaFormacion {
	@Id
	private String nombre;
	private String descripcion;
	private Date fechaI;
	private Date fechaF;
	private Date fechaA;
	@ManyToMany (mappedBy="programas")
	private List<Estudiante> estudiantes = new ArrayList<>();
	@ManyToMany (mappedBy= "programas")
	private List<Curso> cursos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Docente docenteCreador;
	
	public ProgramaFormacion() {
		super();
	}
	public ProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fActual) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaA = fActual;
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
	/*
	public void agregarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	*/
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}
	public List<Curso> getCursos() {
		return cursos;
	}
}
