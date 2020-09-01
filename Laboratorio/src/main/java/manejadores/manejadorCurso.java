package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Curso;
import conexion.Conexion;

//todavia no sabemos como vamos a hacer docente/estudiantes
//por ahora queda asi el manejador

public class manejadorCurso {
	private static manejadorCurso instancia = null;
		
	private manejadorCurso() {}
	
	public static manejadorCurso getInstancia() {
		if(instancia == null) {
			instancia = new manejadorCurso();
		}
		return instancia;
	}
			
	public void agregarCurso(Curso nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(nombre);
		em.getTransaction().commit();
	}
	
	public Curso buscarCurso(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Curso.class, nombre);
	}
	
	public boolean existeCurso(String nombre) {
		return this.buscarCurso(nombre) instanceof Curso;
	}
	
	public List<Curso> getCursos(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Curso> cursos = em.createQuery("SELECT u FROM Programa u", Curso.class).getResultList();
		return cursos;
	}
}
