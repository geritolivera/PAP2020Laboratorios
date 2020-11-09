package clases;

import manejadores.manejadorUsuario;

import java.util.*;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	private String nick;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNac;
	private String password;
	private String imagenUrl;

	//lista de usuarios a los que sigue

	@ManyToMany
	private List<Usuario> sigue = new ArrayList<>();

	public Usuario() {
		super();
	}
	public Usuario(String nick, String nombre, String apellido, String correo, Date fechaNac, String password) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 

	public void agregarSigue(Usuario usuario) {
		this.sigue.add(usuario);
	}
	public void removerSigue(Usuario usuario) {
		this.sigue.remove(usuario);
	}

	public List<Usuario> getSigue(){
		return this.sigue;
	}	

	public List<Usuario> getSeguidores(){
		manejadorUsuario mu = manejadorUsuario.getInstancia();
		List<Usuario> seguidoresRet = new ArrayList<>();
		List<Usuario> usuarios = mu.getUsuarios();
		for (Usuario u:usuarios) {
			for (Usuario seguidos:u.getSigue()) {
				if(seguidos.getNick().equals(this.nick)){
					seguidoresRet.add(u);
				}
			}
		}
		return seguidoresRet;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
}
