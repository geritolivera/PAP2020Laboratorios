package manejadores;

import clases.InscripcionED;
import conexion.Conexion;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public List getInscripciones() {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i", InscripcionED.class).getResultList();
	}
	
	public List getInscripcionesUsuario(String nickUsuario) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i where i.estudiante_nick LIKE", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.getResultList();
	}
	
	public List getInscripcionesEstado(String nickUsuario, String estado) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i where i.estudiante_nick LIKE :userName and i.estado LIKE :estadoIns", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.setParameter("estadoIns", estado)
				.getResultList();
	}
	
	public List buscarInscripcion(String nickUsuario, String nomEdicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i where i.estudiante_nick LIKE :userName and i.edicion_nombre LIKE :nomEdicion", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.setParameter("nomEdicion", nomEdicion)
				.getResultList();
	}
	
	public Boolean existeInscripcion(String nickUsuario, String nomEdicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		Query query = em.createNativeQuery("select Count(*) from InscripcionED i where i.estudiante_nick LIKE :userName and i.edicion_nombre LIKE :nomEdicion", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.setParameter("nomEdicion", nomEdicion);
		return ((Number) query.getSingleResult()).intValue() > 0;
	}
}


