package datatypes;

import java.util.Date;

import clases.Curso;


public class DTCurso {
	private String nombre;
	private String descripcion;
	private String duracion;
	private int cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	private String instituto;
	
	public DTCurso() {
		super();
	}
	
	public DTCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.instituto = instituto;
	}
	
	public DTCurso(Curso curso) {
		super();
		this.nombre = curso.getNombre();
		this.descripcion = curso.getDescripcion();
		this.duracion = curso.getDuracion();
		this.cantHoras = curso.getCantHoras();
		this.creditos = curso.getCreditos();
		this.fechaR = curso.getFechaR();
		this.url = curso.getUrl();
		this.instituto = curso.getNomInstituto();
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
	
	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}
	public String getInstituto() {
		return instituto;
	}
}
