package datatypes;

import clases.InscripcionPF;
import clases.InscripcionEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DTInscripcionPF {
	private String usuario;
	private String programa;
	private String estado;
	private String fechaIns;
	
	public DTInscripcionPF() {
		super();
	}
	public DTInscripcionPF(InscripcionPF inscripcion) {
		super();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		this.usuario = inscripcion.getNombreUsuario();
		this.programa = inscripcion.getNombrePrograma();
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
	
	public void setPrograma(String nomPrograma) {
		this.programa = nomPrograma;
	}
	public String getPrograma() {
		return this.programa;
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
