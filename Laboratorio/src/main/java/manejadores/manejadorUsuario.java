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
	
	public void agregarUsuario(Usuario nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(nombre);
		em.getTransaction().commit();
	}
	
	public Usuario buscarUsuario(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Usuario.class, nombre);
	}
	
	public boolean existeUsuario(String nombre) {
		return this.buscarUsuario(nombre) instanceof Usuario;
	}
	
	public List<Usuario> getUsuarios(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Usuario> usuarios = em.createQuery("SELECT u FROM Programa u", Usuario.class).getResultList();
		return usuarios;
	}
}
