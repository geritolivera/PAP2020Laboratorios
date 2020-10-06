package datatypes;

import clases.ProgramaFormacion;

import java.util.ArrayList;
import java.util.Date;

public class DTProgramaFormacion {
	private String nombre;
	private String descripcion;
	private Date fechaI;
	private Date fechaF;
	private Date fechaA;
	private String imagenURL;
	//private List<DTCurso> cursos = new ArrayList<>();
	private ArrayList<String> cursos = new ArrayList<>();
	private ArrayList<String> categorias = new ArrayList<>();
	
	public DTProgramaFormacion() {
		super();
	}
	public DTProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaA = fechaA;
	}
	
	public DTProgramaFormacion(ProgramaFormacion programa) {
		super();
		this.nombre = programa.getNombre();
		this.descripcion = programa.getDescripcion();
		this.fechaI = programa.getFechaI();
		this.fechaF = programa.getFechaF();
		this.fechaA = programa.getFechaA();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Date getFechaI() {
		return fechaI;
	}
	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}
	
	public Date getFechaF() {
		return fechaF;
	}
	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}
	
	public void agregarCurso(String curso) {
		cursos.add(curso);
	}
	public ArrayList<String> getCursos() {
		return cursos;
	}
	
	public void agregarCategoria(String categoria) {
		categorias.add(categoria);
	}
	public ArrayList<String> getCategorias() {
		return categorias;
	}
	public boolean existeCategoria(String categoria) {
		boolean existe = false;
		for(String s: categorias) {
			if(s.equals(categoria))
				existe = true;
		}
		return existe;
	}
	
	public Date getFechaA() {
		return fechaA;
	}
	public void setFechaA(Date fechaA) {
		this.fechaA = fechaA;
	}
	public String getImagenURL() {
		return imagenURL;
	}
	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
}
