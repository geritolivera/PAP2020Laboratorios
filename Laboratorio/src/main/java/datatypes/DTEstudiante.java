package datatypes;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class DTEstudiante extends DTUsuario{
	private List<DTEdicionCurso> ediciones = new ArrayList<>();
	private List<DTProgramaFormacion> programas = new ArrayList<>();
		
	public DTEstudiante() {
		super();
	}
	
	public DTEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick,nombre,apellido,correo,fechaNac);
	}
		
	public void agregarEdicion(DTEdicionCurso edicion) {
		ediciones.add(edicion);
	}
	public List<DTEdicionCurso> getEdiciones(){
		return ediciones;
	}
	
	public void agregarPrograma(DTProgramaFormacion programa) {
		programas.add(programa);
	}
	public List<DTProgramaFormacion> getProgramas(){
		return programas;
	}
}
