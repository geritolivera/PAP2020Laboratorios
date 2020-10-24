package datatypes;

import java.util.Date;
import java.util.ArrayList;

import clases.Usuario;

public class DTUsuario {

	private String nick;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNac;
	private String password;
	private String image;

	ArrayList<String> seguidores = new ArrayList<>();
	ArrayList<String> seguidos = new ArrayList<>();
	
	public DTUsuario() {
		super();
	}
	public DTUsuario(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;

	}
	public DTUsuario(Usuario usuario) {
		super();
		this.nick = usuario.getNick();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.correo = usuario.getCorreo();
		this.fechaNac = usuario.getFechaNac();
		for (Usuario usu:usuario.getSeguidores()){
			this.seguidores.add(usu.getNick());
		}
		for (Usuario usu:usuario.getSigue()){
			this.seguidos.add(usu.getNick());
		}
		this.image = usuario.getImagenUrl();
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public void seguirUsuario(String usuario) {
		seguidos.add(usuario);
	}
	public ArrayList<String> getSeguidos(){
		return this.seguidos;
	}
	
	public void agregarSeguidor(String usuario) {
		seguidores.add(usuario);
	}
	public ArrayList<String> getSeguidores() {
		return this.seguidores;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
