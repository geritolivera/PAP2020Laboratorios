package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Usuario;
import conexion.Conexion;

public class manejadorUsuario {
	private static manejadorUsuario instancia = null;
	
	//private List<Usuario> usuarios = new ArrayList<>();
	
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
	
	public boolean existeNickUsuario(String nick) {
		return this.buscarUsuario(nick) instanceof Usuario;
	}
	
	public boolean existeCorreoUsuario(String correo) {
		return this.buscarUsuarioCorreo(correo) instanceof Usuario;
	}
	
	public List<Usuario> getUsuarios(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Usuario> usuarios = em.createQuery("SELECT u FROM Programa u", Usuario.class).getResultList();
		return usuarios;
	}
	
	/*public void addUsuario(Usuario u){
		usuarios.add(u);
	}
	
	public Usuario findUsuario(String nickname) {
		Usuario findU = null;
		for(Usuario u : usuarios) {
			if(u.getNick().equals(nickname)) {
				findU = u;
			}
		}
		return findU;
	}
	
	public boolean existeUsuario(String nickname) {
		boolean existe = false;
		for(Usuario u : usuarios) {
			if(u.getNick().equals(nickname)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public void deleteUsuario(String nickname) {
		Usuario usuBorrar = null;
		for(Usuario u : usuarios) {
			if(u.getNick().equals(nickname)) {
				usuBorrar = u;
			}
		}
		if(usuBorrar != null) {
			usuBorrar = null;
			System.gc();
		}
	}*/
}
