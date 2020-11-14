package datatypes;

import clases.InscripcionED;
import clases.InscripcionEnum;
import manejadores.manejadorInscripcionED;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTInscripcionED {
	private String usuario;
	private String edicion;
	private String estado;
	private String fechaIns;
	private float prioridad;
	
	public DTInscripcionED() {
		super();
	}
	public DTInscripcionED(InscripcionED inscripcion) {
		super();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		this.usuario = inscripcion.getNickUsuario();
		this.edicion = inscripcion.getNombreEdicion();
		if(inscripcion.getEstado() == InscripcionEnum.PENDIENTE)
			this.estado = "PENDIENTE";
		else if (inscripcion.getEstado() == InscripcionEnum.ACEPTADO)
			this.estado = "ACEPTADO";
		else 
			this.estado = "RECHAZADO";
		this.fechaIns = format.format(inscripcion.getFecha());	
		//sacar la prioridad
		manejadorInscripcionED mIns = manejadorInscripcionED.getInstancia();
		float cont = 0;
		List<InscripcionED> inscripciones = mIns.getInscripciones();
		for(InscripcionED i: inscripciones) {
			if(i.getNickUsuario().equals(this.usuario) && i.getNombreEdicion().equals(this.edicion) && i.getEstado() == InscripcionEnum.RECHAZADO)
				cont++;
		}
		this.prioridad = (float) (cont*0.5);
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
	
	public float getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(float prioridad) {
		this.prioridad = prioridad;
	}
}
