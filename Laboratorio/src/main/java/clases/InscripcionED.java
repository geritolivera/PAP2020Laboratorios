package clases;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InscripcionED {
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	@ManyToOne
	@JoinColumn(insertable = true, updatable = true)
	private Estudiante estudiante;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal (TemporalType.DATE)
	private Date fecha;
	@ManyToOne
	@JoinColumn(insertable = true, updatable = true)
	private EdicionCurso edicion;
	
		
	public InscripcionED() {
		super();
	}
	public InscripcionED(Date fecha, Estudiante estudiante, EdicionCurso edicion) {
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
