package datatypes;

import clases.Docente;
import clases.EdicionCurso;
import clases.InscripcionED;
import manejadores.manejadorInscripcionED;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class DTEdicionCurso {
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;
	private String curso;
	
	ArrayList<String> docentes = new ArrayList<>();
	
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
		//cuenta la cantidad de inscripciones antes de asignar el cupo
		int cont = 0;
		manejadorInscripcionED mIns = manejadorInscripcionED.getInstancia();
		List<InscripcionED> inscripciones = mIns.getInscripciones();
		for(InscripcionED i: inscripciones) {
			if(i.getNombreEdicion().equals(this.nombre))
				cont++;
		}
		this.cupo = edicion.getCupo() - cont;
		this.fechaPub = edicion.getFechaPub();
		this.curso = edicion.getNomCurso();
		for (Docente d:edicion.getDocentes()) {
			this.docentes.add(d.getNick());
		}
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
	
	public void agregarDocente(String docente) {
		docentes.add(docente);
	}
	public ArrayList<String> getDocentes(){
		return this.docentes;
	}

}
