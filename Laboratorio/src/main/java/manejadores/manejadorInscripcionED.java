package manejadores;

import clases.InscripcionED;
import conexion.Conexion;

import javax.persistence.EntityManager;

import java.util.List;

public class manejadorInscripcionED {
	private static manejadorInscripcionED instancia = null;

	private manejadorInscripcionED() {
	}

	public static manejadorInscripcionED getInstancia() {
		if (instancia == null)
			instancia = new manejadorInscripcionED();
		return instancia;
	}

	public List<InscripcionED> getInscripciones() {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i", InscripcionED.class).getResultList();
	}
	
	public List<InscripcionED> getInscripcionesUsuario(String nickUsuario) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i where i.estudiante_nick LIKE", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.getResultList();
	}
	
	public List<InscripcionED> getInscripcionesEdicion(String nomEdicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i where i.edicion_nombre LIKE nomEdicion", InscripcionED.class)
				.setParameter("nomEdicion", nomEdicion)
				.getResultList();
	}
	
	public List<InscripcionED> getInscripcionesEstado(String nickUsuario, String estado) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i where i.estudiante_nick LIKE :userName and i.estado LIKE :estadoIns", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.setParameter("estadoIns", estado)
				.getResultList();
	}
	
	public List<InscripcionED> buscarInscripcion(String nickUsuario, String nomEdicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i where i.estudiante_nick LIKE :userName and i.edicion_nombre LIKE :nomEdicion", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.setParameter("nomEdicion", nomEdicion)
				.getResultList();
	}
}


