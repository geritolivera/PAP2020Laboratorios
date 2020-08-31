package clases;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
	private String nombre;
	//Lista de docentes del instituto
	private List<Docente> docentes = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<>();
	
	public Instituto() {
		super();
	}
	public Instituto(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
	public List<Docente> getDocentes(){
		return docentes;
	}
	
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}
	public List<Curso> getCursos(){
		return cursos;
	}
}
