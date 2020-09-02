package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.ProgramaFormacion;
import conexion.Conexion;

public class manejadorPrograma {
private static manejadorPrograma instancia = null;
		
	private manejadorPrograma() {}
	
	public static manejadorPrograma getInstancia() {
		if(instancia == null) {
			instancia = new manejadorPrograma();
		}
		return instancia;
	}
	
	public void agregarPrograma(ProgramaFormacion programa) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(programa);
		em.getTransaction().commit();
	}
	
	public ProgramaFormacion buscarPrograma(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(ProgramaFormacion.class, nombre);
	}
	
	public boolean existePrograma(String nombre) {
		return this.buscarPrograma(nombre) instanceof ProgramaFormacion;
	}
	
	public List<ProgramaFormacion> getProgramas(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<ProgramaFormacion> programas = em.createQuery("SELECT u FROM ProgramaFormacion p", ProgramaFormacion.class).getResultList();
		return programas;
	}
}
