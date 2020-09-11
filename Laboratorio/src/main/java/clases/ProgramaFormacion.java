package clases;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@ManyToMany (mappedBy="programas")
	private List<Estudiante> estudiantes = new ArrayList<>();
	@ManyToMany (mappedBy= "programas")
	private List<Curso> cursos = new ArrayList<>();

	//private List<InscripcionPF> inscripciones = new ArrayList<>();
	
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
	
//	public void agregarInscripcion(Date fecha, Estudiante est) {
//		InscripcionPF ins = new InscripcionPF(fecha, est, this);
//		inscripciones.add(ins);
//	}
//	public List<InscripcionPF> getInscripciones(){
//		return inscripciones;
//	}
//	//prototipo de borrado de inscripcion
//	public void borrarInscripcion(Date fecha) {
//		List<InscripcionPF> list = this.getInscripciones();
//		for(InscripcionPF i : list) {
//			if(i.getFecha() == fecha) {
//				list.remove(i);
//			}
//		}
//	}

}
