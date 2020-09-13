package datatypes;

import clases.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DTDocente extends DTUsuario{
	private List<DTCurso> cursos = new ArrayList<>();
	private List<DTEdicionCurso> ediciones = new ArrayList<>();
	private List<DTProgramaFormacion> programas = new ArrayList<>();
	
	public DTDocente() {
		super();
	}
	
	public DTDocente(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick,nombre,apellido,correo,fechaNac);
	}
	
	public void setUserDocente(Usuario user) {
		this.setNick(user.getNick());
		this.setNombre(user.getNombre());
		this.setApellido(user.getApellido());
		this.setCorreo(user.getCorreo());
		this.setFechaNac(user.getFechaNac());
	}

	public void setDocente(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		this.setNick(nick);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setFechaNac(fechaNac);
	}

	public void agregarCurso(DTCurso curso) {
		cursos.add(curso);
	}
	public List<DTCurso> getCursos(){
		return cursos;
	}
	
	public void agregarEdicion(DTEdicionCurso edicion) {
		ediciones.add(edicion);
	}
	public List<DTEdicionCurso> getEdiciones(){
		return ediciones;
	}
	
	public void agregarPrograma(DTProgramaFormacion programa) {
		programas.add(programa);
	}
	public List<DTProgramaFormacion> getProgramas(){
		return programas;
	}
}
