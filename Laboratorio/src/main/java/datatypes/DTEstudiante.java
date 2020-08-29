package datatypes;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;

public class DTEstudiante extends DTUsuario{
	private List<DTEdicionCurso> ediciones = new ArrayList();
	private List<DTProgramaFormacion> programas = new ArrayList();
		
	public DTEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick,nombre,apellido,correo,fechaNac);
	}
}
