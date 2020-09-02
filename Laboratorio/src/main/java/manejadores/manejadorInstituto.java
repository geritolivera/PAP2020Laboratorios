package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Instituto;
import conexion.Conexion;

public class manejadorInstituto {
	
private static manejadorInstituto instancia = null;

	private manejadorInstituto() {}
	
	public static manejadorInstituto getInstancia() {
		if(instancia == null) {
			instancia = new manejadorInstituto();
		}
		return instancia;
	}
	
	public void agregarInstituto(Instituto instituto) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(instituto);
		em.getTransaction().commit();
	}
	
	public Instituto buscarInstituto(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Instituto.class, nombre);
	}
	
	public boolean existeInstituto(String nombre) {
		return this.buscarInstituto(nombre) instanceof Instituto;
	}
	
	public List<Instituto> getInstituto(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Instituto> institutos = em.createQuery("SELECT u FROM Instituto i", Instituto.class).getResultList();
		return institutos;
	}
}
