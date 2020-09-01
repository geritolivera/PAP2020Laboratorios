package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Estudiante;
import conexion.Conexion;

public class manejadorEstudiante {
	private static manejadorEstudiante instancia = null;
	
	private manejadorEstudiante(){}
	
	public static manejadorEstudiante getInstancia() {
		if(instancia == null)
			instancia = new manejadorEstudiante();
		return instancia;
	}
	
	public void agregarEstudiante(Estudiante estudiante) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(estudiante);
		em.getTransaction().commit();
	}
	
	public Estudiante buscarEstudiante(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Estudiante.class, nombre);
	}
	
	public Estudiante buscarEstudianteCorreo(String correo) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Estudiante.class, correo);
	}
	
	public boolean existeEstudianteNick(String nick) {
		return this.buscarEstudiante(nick) instanceof Estudiante;
	}
	
	public boolean existeDocenteCorreo(String correo) {
		return this.buscarEstudianteCorreo(correo) instanceof Estudiante;
	}
	
	public List<Estudiante> getUsuarios(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Estudiante> estudiantes = em.createQuery("SELECT u FROM Programa u", Estudiante.class).getResultList();
		return estudiantes;
	}
	
}
