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
	private InscripcionEnum estado;
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
	
	public void setEstado(String estado) {
		switch (estado){
			case "En_espera":
				this.estado = InscripcionEnum.EN_ESPERA;
			case "Aceptado":
				this.estado = InscripcionEnum.ACEPTADO;
			case "Rechazado":
				this.estado = InscripcionEnum.RECHAZADO;
		}
	}
	public InscripcionEnum getEstado() {
		return estado;
	}
}
