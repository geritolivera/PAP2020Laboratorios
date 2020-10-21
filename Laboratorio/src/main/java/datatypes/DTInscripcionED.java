package datatypes;

import clases.InscripcionED;
import clases.InscripcionEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DTInscripcionED {
	private String usuario;
	private String edicion;
	private String estado;
	private String fechaIns;
	
	public DTInscripcionED() {
		super();
	}
	public DTInscripcionED(InscripcionED inscripcion) {
		super();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		this.usuario = inscripcion.getNombreUsuario();
		this.edicion = inscripcion.getNombreEdicion();
		if(inscripcion.getEstado() == InscripcionEnum.PENDIENTE)
			this.estado = "PENDIENTE";
		else if (inscripcion.getEstado() == InscripcionEnum.ACEPTADO)
			this.estado = "ACEPTADO";
		else 
			this.estado = "RECHAZADO";
		this.fechaIns = format.format(inscripcion.getFecha());	
	}
	
	public void setUsuario(String nickUsuario) {
		this.usuario = nickUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	
	public void setEdicion(String nomEdicion) {
		this.edicion = nomEdicion;
	}
	public String getEdicion() {
		return this.edicion;
	}
	
	public void setEstado(InscripcionEnum estado) {
		if(estado == InscripcionEnum.PENDIENTE)
			this.estado = "PENDIENTE";
		else if (estado == InscripcionEnum.ACEPTADO)
			this.estado = "ACEPTADO";
		else 
			this.estado = "RECHAZADO";
	}
	public String getEstado() {
		return estado;
	}
	
	public void setFecha(Date fecha) {
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		this.fechaIns = format.format(fecha);
	}
	public String getFecha() {
		return fechaIns;
	}
}
