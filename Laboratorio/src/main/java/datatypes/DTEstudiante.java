package datatypes;

import clases.Usuario;

import java.util.ArrayList;
import java.util.Date;


public class DTEstudiante extends DTUsuario{
	private ArrayList<String> ediciones = new ArrayList<>();
	private ArrayList<String> programas = new ArrayList<>();
		
	public DTEstudiante() {
		super();
	}
	
	public DTEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick,nombre,apellido,correo,fechaNac);
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

	public void agregarEdicion(String edicion) {
		ediciones.add(edicion);
	}
	public ArrayList<String> getEdiciones(){
		return ediciones;
	}
	
	public void agregarPrograma(String programa) {
		programas.add(programa);
	}
	public ArrayList<String> getProgramas(){
		return programas;
	}
}
