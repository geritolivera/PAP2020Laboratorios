package clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;

@Entity
@DiscriminatorValue("tipoDocente")
public class Docente extends Usuario{
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Instituto instituto;
	
	@OneToMany (mappedBy = "docenteCreador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursosRegistrados = new ArrayList<>();
	@OneToMany (mappedBy = "docenteCreador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EdicionCurso> edicionesRegistradas = new ArrayList<>();
	@OneToMany (mappedBy = "docenteCreador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProgramaFormacion> programasRegistrados = new ArrayList<>();
	
	public Docente() {
		super();
	}
	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
	}
	
	public Docente(Usuario user) {
		super(user.getNick(), user.getNombre(), user.getApellido(), user.getCorreo(), user.getFechaNac());
	}
	
	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	public Instituto getInstituto() {
		return instituto;
	}
	
	/*
	public void agregarEdicion(EdicionCurso edicion) {
		ediciones.add(edicion);
		edicion.agregarDocente(this);
		//esto agrega al docente a la edición a la cual se está inscribienedo
		//alternativamente, se puede descartar la función agregarDocente completamente y usar
		// - edicion.getDocentes().add(this) -
		//notar que cuando usamos "this", nos referimos al objeto donde estamos trabajando
		//en este caso, "this" se refiere a este docente específico
	}
	public List<EdicionCurso> getEdiciones(){
		return this.ediciones;
	}
	
	*/
	public List<EdicionCurso> getEdicionesRegistradas() {
		return edicionesRegistradas;
	}
	public List<ProgramaFormacion> getProgramasRegistrados() {
		return programasRegistrados;
	}
	public List<Curso> getCursosRegistrados() {
		return cursosRegistrados;
	}
	
	public void agregarCursoRegistrado(Curso c) {
		cursosRegistrados.add(c);
	}
	public void agregarEdicionRegistrada(EdicionCurso e) {
		edicionesRegistradas.add(e);
	}
	public void agregarCursoRegistrado(ProgramaFormacion p) {
		programasRegistrados.add(p);
	}
	
}
