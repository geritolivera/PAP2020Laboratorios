package clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;

@Entity
@DiscriminatorValue("tipoDocente")
public class Docente extends Usuario{
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Instituto instituto;
	
	@ManyToMany
	private List<EdicionCurso> ediciones = new ArrayList<>();
	
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
	public void agregarEdicion(EdicionCurso edicion) {
		ediciones.add(edicion);
		//edicion.getDocentes().add(this);
	}
	
	 public void eliminarEdicion(EdicionCurso edicion) {
		this.ediciones.remove(edicion);
		//edicion.getDocentes().remove(this);
	 }
	public List<EdicionCurso> getEdiciones() {
		return this.ediciones;
	}
	
}
