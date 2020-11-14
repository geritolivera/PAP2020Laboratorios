package datatypes;

import clases.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
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

	public DTDocente(DTUsuario dtu){
		this.setNick(dtu.getNick());
		this.setNombre(dtu.getNombre());
		this.setApellido(dtu.getApellido());
		this.setCorreo(dtu.getCorreo());
		this.setFechaNac(dtu.getFechaNac());
		this.setImage(dtu.getImage());
		this.seguidos = dtu.getSeguidos();
		this.seguidores = dtu.getSeguidores();
	}

	public void setUserDocente(Usuario user) {
		this.setNick(user.getNick());
		this.setNombre(user.getNombre());
		this.setApellido(user.getApellido());
		this.setCorreo(user.getCorreo());
		this.setFechaNac(user.getFechaNac());
		this.setImage(user.getImagenUrl());

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
