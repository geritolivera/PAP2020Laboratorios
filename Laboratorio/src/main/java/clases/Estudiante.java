package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Estudiante extends Usuario{
	//programas a los cuales se anota
	private List<ProgramaFormacion> programas = new ArrayList<>();
	//ediciones a las cuales se anota
	private List<EdicionCurso> ediciones = new ArrayList<>();
	
	public Estudiante() {
		super();
	}
	public Estudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
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
	
}
