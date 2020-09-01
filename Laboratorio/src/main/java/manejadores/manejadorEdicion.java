package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.EdicionCurso;
import conexion.Conexion;

public class manejadorEdicion {
	private static manejadorEdicion instancia = null;
	
	//private List<Curso> cursos = new ArrayList<>();
	
	private manejadorEdicion() {}
	
	public static manejadorEdicion getInstancia() {
		if(instancia == null) {
			instancia = new manejadorEdicion();
		}
		return instancia;
	}
			
	public void agregarEdicion(EdicionCurso edicion) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(edicion);
		em.getTransaction().commit();
	}
	
	public EdicionCurso buscarEdicion(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(EdicionCurso.class, nombre);
	}
	
	public boolean existeEdicion(String nombre) {
		return this.buscarEdicion(nombre) instanceof EdicionCurso;
	}
	
	public List<EdicionCurso> getEdiciones(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<EdicionCurso> ediciones = em.createQuery("SELECT u FROM Programa u", EdicionCurso.class).getResultList();
		return ediciones;
	}
	
	//Metodos Edicion de Curso
	
	/*public void addEdicion(EdicionCurso edc) {
		edicionesCurso.add(edc);
	}
	
	public EdicionCurso findEdicion(String nombreEdi) {
		EdicionCurso edc = null;
		for(EdicionCurso edi : edicionesCurso) {
			if(edi.getNombre().equals(nombreEdi)) {
				edc = edi;
			}
		}
		return edc;
	}
	
	public boolean existeEdicion(String nombreEdi) {
		boolean existe = false;
		for(EdicionCurso edi : edicionesCurso) {
			if(edi.getNombre().equals(nombreEdi)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public void deleteEdicion(String nombreEdi) {
		EdicionCurso ediDelete = null;
		for(EdicionCurso edi : edicionesCurso) {
			if(edi.getNombre().equals(nombreEdi)) {
				ediDelete = edi;
			}
		}
		if(ediDelete != null) {
			ediDelete = null;
			System.gc();
		}
	}
	
	//Metodos Curso
	
	public void addCurso(Curso cur) {
		cursos.add(cur);
	}
	
	public Curso findCurso(String nombreCur) {
		Curso c = null;
		for(Curso cur : cursos) {
			if(cur.getNombre().equals(nombreCur)) {
				c = cur;
			}
		}
		return c;
	}
	
	public boolean existeCurso(String nombreCur) {
		boolean existe = false;
		for(Curso cur : cursos) {
			if(cur.getNombre().equals(nombreCur)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public void deleteCurso(String nombreCur) {
		Curso curDelete = null;
		for(Curso cur : cursos) {
			if(cur.getNombre().equals(nombreCur)) {
				curDelete = cur;
			}
		}
		if(curDelete != null) {
			curDelete = null;
			System.gc();
		}
	}*/
}
