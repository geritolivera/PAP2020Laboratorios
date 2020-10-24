package datatypes;

import clases.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DTEstudiante extends DTUsuario{
	private List<DTEdicionCurso> ediciones = new ArrayList<>();
	private List<DTProgramaFormacion> programas = new ArrayList<>();
		
	public DTEstudiante() {
		super();
	}
	
	public DTEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick,nombre,apellido,correo,fechaNac);
	}
	public DTEstudiante(DTUsuario dtu){
		this.setNick(dtu.getNick());
		this.setNombre(dtu.getNombre());
		this.setApellido(dtu.getApellido());
		this.setCorreo(dtu.getCorreo());
		this.setFechaNac(dtu.getFechaNac());
		this.setImage(dtu.getImage());
		this.seguidos = dtu.getSeguidos();
		this.seguidores = dtu.getSeguidores();
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
