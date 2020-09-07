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
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Estudiante estudiante;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal (TemporalType.DATE)
	private Date fecha;
	private Usuario usuario;
	private EdicionCurso edicion;
	
		
	public Inscripcion() {
		super();
	}
	public Inscripcion(Date fecha, Usuario usuario, EdicionCurso edicion) {
		this.fecha = fecha;
		this.usuario = usuario;
		this.edicion = edicion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombreUsuario() {
		return usuario.getNombre();
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNombreEdicion() {
		return edicion.getNombre();
	}
	public EdicionCurso getEdicion() {
		return edicion;
	}
}
