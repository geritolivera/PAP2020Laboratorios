package clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.Date;

@Entity
@DiscriminatorValue("tipo_estudiante")
public class Estudiante extends Usuario{
	//programas a los cuales se anota
	@ManyToMany
	private List<ProgramaFormacion> programas = new ArrayList<>();
	//ediciones a las cuales se anota
	@ManyToMany
	private List<EdicionCurso> ediciones = new ArrayList<>();
	//inscripciones a las ediciones
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Inscripcion> inscripciones = new ArrayList<>();
	
	public Estudiante() {
		super();
	}
	public Estudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
	}
	
	public Estudiante(Usuario user) {
		super(user.getNick(), user.getNombre(), user.getApellido(), user.getCorreo(), user.getFechaNac());
	}
	
	public void agregarPrograma(ProgramaFormacion programa) {
		programas.add(programa);
	}
	public List<ProgramaFormacion> getProgramas(){
		return this.programas;
	}
	
	public void agregarEdicion(EdicionCurso edicion) {
		ediciones.add(edicion);
		edicion.agregarEstudiante(this);
		//esto agrega al estudiante a la edición a la cual se está inscribienedo
		//alternativamente, se puede descartar la función agregarEstudiante completamente y usar
		// - edicion.getEstudiantes().add(this) -
		//notar que cuando usamos "this", nos referimos al objeto donde estamos trabajando
		//en este caso, "this" se refiere a este estudiante específico
	}
	public List<EdicionCurso> getEdiciones(){
		return this.ediciones;
	}
	
	public void agregarInscripcion(Date fecha, EdicionCurso edicion) {
		Inscripcion ins = new Inscripcion(fecha, this, edicion);
		inscripciones.add(ins);
		edicion.agregarEstudiante(this);
	}
	public List<Inscripcion> getInscripciones(){
		return inscripciones;
	}
	//prototipo de borrado de inscripcion
	public void borrarInscripcion(Date fecha) {
		List<Inscripcion> list = this.getInscripciones();
		for(Inscripcion i : list) {
			if(i.getFecha() == fecha) {
				list.remove(i);
			}
		}
	}
	
}
