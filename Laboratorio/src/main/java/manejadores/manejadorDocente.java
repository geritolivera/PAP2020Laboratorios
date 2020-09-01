package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Docente;
import conexion.Conexion;

public class manejadorDocente {
	private static manejadorDocente instancia = null;
	
	private manejadorDocente(){}
	
	public static manejadorDocente getInstancia() {
		if(instancia == null)
			instancia = new manejadorDocente();
		return instancia;
	}
	
	public void agregarDocente(Docente docente) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(docente);
		em.getTransaction().commit();
	}
	
	public Docente buscarDocente(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Docente.class, nombre);
	}
	
	public Docente buscarDocenteCorreo(String correo) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Docente.class, correo);
	}
	
	public boolean existeDocenteNick(String nick) {
		return this.buscarDocente(nick) instanceof Docente;
	}
	
	public boolean existeDocenteCorreo(String correo) {
		return this.buscarDocenteCorreo(correo) instanceof Docente;
	}
	
	public List<Docente> getUsuarios(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Docente> docentes = em.createQuery("SELECT u FROM Programa u", Docente.class).getResultList();
		return docentes;
	}
	
}
