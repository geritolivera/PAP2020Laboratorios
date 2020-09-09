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
public class EdicionCurso {
	@Id
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Curso curso;
	@ManyToMany (mappedBy ="ediciones")
	private List<Estudiante> estudiantes = new ArrayList<>();
	
	@ManyToMany (mappedBy ="ediciones")
	private List<Docente> docentes = new ArrayList<>();
	//private List<Inscripcion> inscripciones = new ArrayList<>();


	
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

	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> d) {
		this.docentes = d;
	}
	
//esto hay que cambiarlo
//	public void agregarInscripcion(Date fecha, Estudiante est) {
//		Inscripcion ins = new Inscripcion(fecha, est, this);
//		inscripciones.add(ins);
//	}
//	public List<Inscripcion> getInscripciones(){
//		return inscripciones;
//	}
//	//prototipo de borrado de inscripcion
//	public void borrarInscripcion(Date fecha) {
//		List<Inscripcion> list = this.getInscripciones();
//		for(Inscripcion i : list) {
//			if(i.getFecha() == fecha) {
//				list.remove(i);
//			}
//		}
//	}

}
