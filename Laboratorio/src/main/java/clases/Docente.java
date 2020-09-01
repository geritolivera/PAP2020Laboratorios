package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Docente extends Usuario{
	private Instituto instituto;
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
}
