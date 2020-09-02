package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Curso {
	private String nombre;
	private String descripcion;
	private String duracion;
	private int cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	
	//lista de cursos previos
	private List<Curso> previas = new ArrayList<>();
	
	//lista de todos los programas de formacion
	private List<ProgramaFormacion> programas = new ArrayList<>();
	
	//lista de todos las ediciones
	private List<EdicionCurso> ediciones = new ArrayList<>();
	
	//el instituto donde reside el curso
	private Instituto instituto;
	
	public Curso() {
		super();
	}
	public Curso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, Instituto instituto) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.instituto = instituto;
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
	
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public int getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public Date getFechaR() {
		return fechaR;
	}
	public void setFechaR(Date fechaR) {
		this.fechaR = fechaR;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	//se retorna la clase instituto
	public Instituto getInstituto() {
		return instituto;
	}
	//se retorna solo el nombre del instituto
	public String getNomInstituto() {
		return instituto.getNombre();
	}
	
	public void agregarPrograma(ProgramaFormacion programa) {
		programas.add(programa); 
	}
	public List<ProgramaFormacion> getProgramas(){
		return this.programas;
	}
	
	public List<EdicionCurso> getEdiciones(){
		return this.ediciones;
	}
	
	public void agregarPrevias(Curso previa) {
		previas.add(previa);
	}
	
	public List<Curso> getPrevias(){
		return this.previas;
	}
}
