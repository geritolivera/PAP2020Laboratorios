package manejadores;

import java.util.List;
import java.util.ArrayList;

import clases.Curso;
import clases.EdicionCurso;

public class manejadorCursoYEdicionCurso {
	private static manejadorCursoYEdicionCurso instancia = null;
	
	private List<Curso> cursos = new ArrayList<>();

	private List<EdicionCurso> edicionesCurso = new ArrayList<>();
	
	private manejadorCursoYEdicionCurso() {}
	
	public static manejadorCursoYEdicionCurso getInstancia() {
		if(instancia == null) {
			instancia = new manejadorCursoYEdicionCurso();
		}
		return instancia;
	}
	
	//Metodos Edicion de Curso
	
	public void addEdicion(EdicionCurso edc) {
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
	}
}
