package manejadores;

import clases.InscripcionPF;
import conexion.Conexion;

import javax.persistence.EntityManager;

import java.util.List;

public class manejadorInscripcionPF {
	private static manejadorInscripcionPF instancia = null;

	private manejadorInscripcionPF() {
	}

	public static manejadorInscripcionPF getInstancia() {
		if (instancia == null)
			instancia = new manejadorInscripcionPF();
		return instancia;
	}

	public List<InscripcionPF> getInscripciones() {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionED i", InscripcionPF.class).getResultList();
	}
	
	public List<InscripcionPF> getInscripcionesUsuario(String nickUsuario) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionPF i where i.estudiante.nick = :userName", InscripcionPF.class)
				.setParameter("userName", nickUsuario)
				.getResultList();
	}
	
	public List<InscripcionPF> getInscripcionesEstado(String nickUsuario, String estado) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionPF i where i.estudiante.nick = :userName and i.estado = :estadoIns", InscripcionPF.class)
				.setParameter("userName", nickUsuario)
				.setParameter("estadoIns", estado)
				.getResultList();
	}
	
	public List<InscripcionPF> buscarInscripcionPF(String nickUsuario, String nomPrograma) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.createQuery("select i from InscripcionPF i where i.estudiante.nick = :userName and i.programa.nombre = :nomProg", InscripcionPF.class)
				.setParameter("userName", nickUsuario)
				.setParameter("nomProg", nomPrograma)
				.getResultList();
	}
}


