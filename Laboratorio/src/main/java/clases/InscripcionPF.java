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
public class InscripcionPF {
	
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
	private ProgramaFormacion programa;
	
		
	public InscripcionPF() {
		super();
	}
	public InscripcionPF(Date fecha, Estudiante estudiante, ProgramaFormacion programa) {
		this.fecha = fecha;
		this.estudiante = estudiante;
		this.programa = programa;
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

	public String getNombrePrograma() {
		return programa.getNombre();
	}
	public ProgramaFormacion getPrograma() {
		return programa;
	}
}
