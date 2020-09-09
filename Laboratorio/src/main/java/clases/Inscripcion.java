package clases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Inscripcion {
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Estudiante estudiante;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal (TemporalType.DATE)
	private Date fecha;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private EdicionCurso edicion;
	
		
	public Inscripcion() {
		super();
	}
	public Inscripcion(Date fecha, Estudiante estudiante, EdicionCurso edicion) {
		this.fecha = fecha;
		this.estudiante = estudiante;
		this.edicion = edicion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombreUsuario() {
		return estudiante.getNombre();
	}

	public String getNombreEdicion() {
		return edicion.getNombre();
	}
	public EdicionCurso getEdicion() {
		return edicion;
	}
}
