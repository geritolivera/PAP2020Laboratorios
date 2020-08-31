package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Curso;
import conexion.Conexion;

//todavia no sabemos como vamos a hacer docente/estudiantes
//por ahora queda asi el manejador

public class manejadorCurso {
	private static manejadorCurso instancia = null;
	
	//private List<Curso> cursos = new ArrayList<>();
	
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
