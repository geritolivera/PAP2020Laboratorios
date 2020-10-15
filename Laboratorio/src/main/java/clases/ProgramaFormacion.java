package clases;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ProgramaFormacion {
	@Id
	private String nombre;
	private String descripcion;
	private Date fechaI;
	private Date fechaF;
	private Date fechaA;
	private String imagenURL;
	@ManyToMany (mappedBy="programas")
	@Column(nullable = true)
	private List<Estudiante> estudiantes = new ArrayList<>();
	@ManyToMany (mappedBy= "programas")
	private List<Curso> cursos = new ArrayList<>();
	@OneToMany(mappedBy = "programa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InscripcionPF> inscripciones = new ArrayList<>();
	
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
	
	public void agregarEstudiante(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
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
	public String getImagenURL() {
		return imagenURL;
	}
	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
	
	public void agregarInscripcion(Date fecha, Estudiante est) {
		InscripcionPF ins = new InscripcionPF(fecha, est, this);
		this.inscripciones.add(ins);
	}
	public List<InscripcionPF> getInscripciones(){
		return this.inscripciones;
	}
	//prototipo de borrado de inscripcion
	public void borrarInscripcion(Date fecha) {
		List<InscripcionPF> list = this.getInscripciones();
		for(InscripcionPF i : list) {
			if(i.getFecha() == fecha) {
				list.remove(i);
			}
		}
	}
}
