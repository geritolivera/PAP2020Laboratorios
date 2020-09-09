package manejadores;

import clases.Instituto;
import conexion.Conexion;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class manejadorInstituto {
	
	private static manejadorInstituto instancia = null;
	private List<Instituto> institutos = new ArrayList<>();
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
		@SuppressWarnings("unchecked")
		List<Instituto> institutos = em.createQuery("FROM Instituto").getResultList();
		return institutos;
	}
	
	public ArrayList<String> obtenerInstitutos(){
		ArrayList<String> ret = new ArrayList<>();
		for(Instituto i: institutos) {
			ret.add(i.getNombre());
		}
		return ret;
	}
	
	
}
