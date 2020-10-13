package manejadores;

import clases.Usuario;
import conexion.Conexion;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class manejadorUsuario {
	private static manejadorUsuario instancia = null;

	private manejadorUsuario() {
	}

	public static manejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new manejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario usuario) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	public Usuario buscarUsuarioNickname(String nickname) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Usuario.class, nickname);
	}

	public Usuario buscarUsuario(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Usuario.class, nombre);
	}

	public Usuario buscarUsuarioCorreo(String correo) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Usuario.class, correo);
	}

	public boolean existeUsuarioNick(String nick) {
		return this.buscarUsuarioNickname(nick) instanceof Usuario;
	}

	public boolean existeUsuarioCorreo(String correo) {
		return this.buscarUsuarioCorreo(correo) instanceof Usuario;
	}

	public List getUsuarios() {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}

	public void modificarUsuario(String nickname, String nombre, String apellido, Date fechaNaci) {
		Usuario usu = this.buscarUsuarioNickname(nickname);
		usu.setApellido(apellido);
		usu.setNombre(nombre);
		usu.setFechaNac(fechaNaci);
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.refresh(usu);
		em.getTransaction().commit();

	}
}


