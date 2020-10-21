package clases;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@JoinColumn(insertable = true, updatable = true)
	private Estudiante estudiante;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(name="estado")
	private InscripcionEnum estado;
	@Temporal (TemporalType.DATE)
	private Date fecha;
	@ManyToOne
	@JoinColumn(insertable = true, updatable = true)
	private ProgramaFormacion programa;
	
		
	public InscripcionPF() {
		super();
	}
	public InscripcionPF(Date fecha, Estudiante estudiante, ProgramaFormacion programa, InscripcionEnum estado) {
		this.fecha = fecha;
		this.estudiante = estudiante;
		this.programa = programa;
		this.estado = estado;
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
	
	public void setEstado(InscripcionEnum estado) {
		this.estado = estado;
	}
	public void setEstadoString(String estado) {
		switch (estado){
			case "PENDIENTE":
				this.estado = InscripcionEnum.PENDIENTE;
			case "ACEPTADO":
				this.estado = InscripcionEnum.ACEPTADO;
			case "RECHAZADO":
				this.estado = InscripcionEnum.RECHAZADO;
		}
	}
	public InscripcionEnum getEstado() {
		return estado;
	}
}
