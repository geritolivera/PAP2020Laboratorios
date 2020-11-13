package manejadores;

import clases.EdicionCurso;
import clases.Estudiante;
import clases.InscripcionED;
import conexion.Conexion;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class manejadorEdicion {
	
	private static manejadorEdicion instancia = null;
		
	private manejadorEdicion() {}
	
	public static manejadorEdicion getInstancia() {
		if(instancia == null) {
			instancia = new manejadorEdicion();
		}
		return instancia;
	}
			
	public void agregarEdicion(EdicionCurso edicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(edicion);
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
		return em.createQuery("SELECT e FROM EdicionCurso e", EdicionCurso.class).getResultList();
	}
}
