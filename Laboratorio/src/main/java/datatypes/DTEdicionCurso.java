package datatypes;

import clases.EdicionCurso;

import java.util.Date;

public class DTEdicionCurso {
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;
	private String curso;
	
	public DTEdicionCurso() {
		super();
	}
	
	public DTEdicionCurso(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String curso) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.cupo = cupo;
		this.fechaPub = fechaPub;
		this.curso = curso;
	}
	
	public DTEdicionCurso(EdicionCurso edicion) {
		super();
		this.nombre = edicion.getNombre();
		this.fechaI = edicion.getFechaI();
		this.fechaF = edicion.getFechaF();
		this.cupo = edicion.getCupo();
		this.fechaPub = edicion.getFechaPub();
		this.curso = edicion.getNomCurso();
	}
	
	public void setEdicionCurso(EdicionCurso edicion) {
		this.nombre = edicion.getNombre();
		this.fechaI = edicion.getFechaI();
		this.fechaF = edicion.getFechaF();
		this.cupo = edicion.getCupo();
		this.fechaPub = edicion.getFechaPub();
		this.curso = edicion.getNomCurso();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public Date getFechaPub() {
		return fechaPub;
	}
	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getNomCurso() {
		return curso;
	}

}
