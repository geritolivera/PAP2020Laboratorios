package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.EdicionCurso;
import conexion.Conexion;

public class manejadorEdicion {
	
	private static manejadorEdicion instancia = null;
		
	private manejadorEdicion() {}
	
	public static manejadorEdicion getInstancia() {
		if(instancia == null) {
			instancia = new manejadorEdicion();
		}
		return instancia;
	}
			
	public void agregarEdicion(EdicionCurso nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(nombre);
		em.getTransaction().commit();
	}
	
	public EdicionCurso buscarEdicion(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(EdicionCurso.class, nombre);
	}
	
	public boolean existeEdicion(String nombre) {
		return this.buscarEdicion(nombre) instanceof EdicionCurso;
	}
	
	public List<EdicionCurso> getEdiciones(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<EdicionCurso> ediciones = em.createQuery("SELECT u FROM Programa u", EdicionCurso.class).getResultList();
		return ediciones;
	}
}
