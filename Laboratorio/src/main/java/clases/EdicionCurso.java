package clases;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class EdicionCurso {
	@Id
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;

	private String imagenURL;

	@ManyToOne
	@JoinColumn(insertable = true, updatable = true)
	private Curso curso;
	/*@ManyToMany (mappedBy ="ediciones")
	@Column(nullable = true)
	private List<Estudiante> estudiantes = new ArrayList<>();*/
	@ManyToMany (mappedBy ="ediciones")
	private List<Docente> docentes = new ArrayList<>();

	@OneToMany(mappedBy = "edicion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InscripcionED> inscripciones = new ArrayList<>();


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

//	public void agregarEstudiante(Estudiante estudiante) {
//		estudiantes.add(estudiante);
//	}
//	public List<Estudiante> getEstudiantes() {
//		return estudiantes;
//	}
	public List<Docente> getDocentes() {
		return docentes;
	}

	public void agregarDocente(Docente docente) {
		docentes.add(docente);
		docente.agregarEdicion(this);
	}

	public void agregarInscripcion(Date fecha, Estudiante est) {
		InscripcionED ins = new InscripcionED(fecha, est, this, InscripcionEnum.PENDIENTE);
		inscripciones.add(ins);
	}

	public List<InscripcionED> getInscripciones(){
		return inscripciones;
	}
	//prototipo de borrado de inscripcion
	public void borrarInscripcion(Date fecha) {
		List<InscripcionED> list = this.getInscripciones();
		for(InscripcionED i : list) {
			if(i.getFecha() == fecha) {
				list.remove(i);
			}
		}
	}

	public String getImagenURL() {
		return imagenURL;
	}

	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
}
