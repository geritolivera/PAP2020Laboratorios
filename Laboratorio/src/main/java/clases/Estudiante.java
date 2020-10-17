package clases;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("tipo_estudiante")
public class Estudiante extends Usuario{
	//programas a los cuales se anota
	@ManyToMany
	private List<ProgramaFormacion> programas = new ArrayList<>();
	//ediciones a las cuales se anota
	//---
	//inscripciones a las ediciones
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InscripcionED> inscripcionesED = new ArrayList<>();
	//inscripciones a los programas -- no se usa todavia
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InscripcionPF> inscripcionesPF = new ArrayList<>();
	
	public Estudiante() {
		super();
	}
	public Estudiante(String nick, String nombre, String apellido, String correo, Date fechaNac, String password) {
		super(nick, nombre, apellido, correo, fechaNac, password);
	}
	
	public Estudiante(Usuario user) {
		super(user.getNick(), user.getNombre(), user.getApellido(), user.getCorreo(), user.getFechaNac(), user.getPassword());
	}
	
	public void setUserEstudiante(Usuario user) {
		this.setNick(user.getNick());
		this.setNombre(user.getNombre());
		this.setApellido(user.getApellido());
		this.setCorreo(user.getCorreo());
		this.setFechaNac(user.getFechaNac());
	}

	public void setEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		this.setNick(nick);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setFechaNac(fechaNac);
	}

	public void agregarPrograma(ProgramaFormacion programa) {
		programas.add(programa);
		programa.agregarEstudiante(this);
		
	}
	public List<ProgramaFormacion> getProgramas(){
		return this.programas;
	}
	
//	public void agregarEdicion(EdicionCurso edicion) {
//		ediciones.add(edicion);
//		edicion.agregarEstudiante(this);
//	}
//	public List<EdicionCurso> getEdiciones(){
//		return this.ediciones;
//	}
	
	//INSCRIPCIONES A EDICION DE CURSO
	public void agregarInscripcionED(Date fecha, EdicionCurso edicion) {
		InscripcionED ins = new InscripcionED(fecha, this, edicion);
		inscripcionesED.add(ins);
	}
	public List<InscripcionED> getInscripcionesED(){
		return inscripcionesED;
	}
	//prototipo de borrado de inscripcion
	public void borrarInscripcionED(Date fecha) {
		List<InscripcionED> list = this.getInscripcionesED();
		for(InscripcionED i : list) {
			if(i.getFecha() == fecha) {
				list.remove(i);
			}
		}
	}
	
	//INSCRIPCIONES A PROGRAMA DE FORMACION
	public void agregarInscripcionPF(Date fecha, ProgramaFormacion programa) {
		InscripcionPF ins = new InscripcionPF(fecha, this, programa);
		inscripcionesPF.add(ins);
	}
	public List<InscripcionPF> getInscripcionesPF(){
		return inscripcionesPF;
	}
	//prototipo de borrado de inscripcion
	public void borrarInscripcionPF(Date fecha) {
		List<InscripcionPF> list = this.getInscripcionesPF();
		for(InscripcionPF i : list) {
			if(i.getFecha() == fecha) {
				list.remove(i);
			}
		}
	}
}
