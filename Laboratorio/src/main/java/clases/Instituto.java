package clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instituto {
	@Id
	private String nombre;
	//Lista de docentes del instituto
	@OneToMany(mappedBy = "instituto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Docente> docentes = new ArrayList<>();
	@OneToMany(mappedBy = "instituto", cascade = CascadeType.ALL, orphanRemoval = true)
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
