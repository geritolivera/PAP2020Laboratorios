package clases;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InscripcionED {
	
	
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
	private EdicionCurso edicion;
	
		
	public InscripcionED() {
		super();
	}
	public InscripcionED(Date fecha, Estudiante estudiante, EdicionCurso edicion, InscripcionEnum estado) {
		this.fecha = fecha;
		this.estudiante = estudiante;
		this.edicion = edicion;
		this.estado = estado;
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
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
