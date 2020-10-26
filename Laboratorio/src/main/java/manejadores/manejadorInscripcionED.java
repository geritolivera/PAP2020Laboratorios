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
		@SuppressWarnings("unchecked")
		List<InscripcionED> inscrip = em.createQuery("select i from InscripcionED i", InscripcionED.class).getResultList();
		return inscrip;
	}
	
	public List<InscripcionED> getInscripcionesUsuario(String nickUsuario) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		@SuppressWarnings("unchecked")
		List<InscripcionED> userName = em.createQuery("select i from InscripcionED i where i.estudiante.nick = :userName", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.getResultList();
		return userName;
	}
	
	public List<InscripcionED> getInscripcionesEdicion(String nomEdicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		@SuppressWarnings("unchecked")
		List<InscripcionED> nomEdicion1 = em.createQuery("select i from InscripcionED i where i.edicion.nombre = :nomEdicion", InscripcionED.class)
				.setParameter("nomEdicion", nomEdicion)
				.getResultList();
		return nomEdicion1;
	}
	
	public List<InscripcionED> getInscripcionesEstado(String nickUsuario, String estado) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		@SuppressWarnings("unchecked")
		List<InscripcionED> resultList = em.createQuery("select i from InscripcionED i where i.estudiante.nick = :userName and i.estado = :estadoIns", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.setParameter("estadoIns", estado)
				.getResultList();
		return resultList;
	}
	
	public List<InscripcionED> buscarInscripcion(String nickUsuario, String nomEdicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		@SuppressWarnings("unchecked")
		List<InscripcionED> resultList = em.createQuery("select i from InscripcionED i where i.estudiante.nick = :userName and i.edicion.nombre = :nomEdicion", InscripcionED.class)
				.setParameter("userName", nickUsuario)
				.setParameter("nomEdicion", nomEdicion)
				.getResultList();
		return resultList;
	}
}


