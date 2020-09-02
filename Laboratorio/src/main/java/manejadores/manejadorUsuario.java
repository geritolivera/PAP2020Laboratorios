package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Usuario;
import conexion.Conexion;

public class manejadorUsuario {
	private static manejadorUsuario instancia = null;
		
	private manejadorUsuario(){}
	
	public static manejadorUsuario getInstancia() {
		if(instancia == null)
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
<<<<<<< HEAD
	
	public boolean existeUsuarioNick(String nick) {
		return this.buscarUsuario(nick) instanceof Usuario;
	}
	
	public boolean existeUsuarioCorreo(String correo) {
		return this.buscarUsuarioCorreo(correo) instanceof Usuario;
	}
	
	public List<Usuario> getUsuarios(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
		return usuarios;
	}
=======
>>>>>>> GeroBranch
}
