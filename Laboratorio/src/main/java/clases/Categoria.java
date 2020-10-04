package clases;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {
	
	@Id
	private String nombre;
	
	//Lista de cursos
	@ManyToMany
	private List<Curso> cursos = new ArrayList<>();

	public Categoria() {
		super();
	}
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setPassword(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}	
	
	public void agregarCurso(Curso c) {
		this.cursos.add(c);
	}
}
