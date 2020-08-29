package datatypes;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;

public class DTDocente extends DTUsuario{
	private List<DTCurso> cursos = new ArrayList();
	private List<DTEdicionCurso> ediciones = new ArrayList();
	private List<DTProgramaFormacion> programas = new ArrayList();	
	
	public DTDocente(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick,nombre,apellido,correo,fechaNac);
	}
}
