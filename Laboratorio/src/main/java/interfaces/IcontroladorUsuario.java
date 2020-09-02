package interfaces;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import datatypes.DTUsuario;
import exepciones.UsuarioRepetidoExcepcion;
import clases.EdicionCurso;

public interface IcontroladorUsuario {
	
	//1 - Alta Usuario
	public String ingresarUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, boolean esDocente);
	public void AltaUsuario(DTUsuario usuario)throws UsuarioRepetidoExcepcion;
	
	//2 - Consulta de Usuario
	public ArrayList<String> listarUsuarios();
	public List<DTUsuario> listarDTUsuarios();
	public void verInfoUsuario(String nickname);
	
	//3 - Modificar Datos de Usuario
	//Se utiliza la misma funcion listarUsuario
	public DTUsuario seleccionarUsuario(String nickname);
	public void nuevosDatos(String nombre, String apellido, Date fechaNaci);
	
	//6 - Alta de Edicion de Curso
	public void ingresarDocente(String nomDoc);
	
	//8 - Inscripcion a Edicion de Curso
	public void seleccionarEstudiante(String nickname);
	public void confirmarInscripcion(String nickname, Date fechaInsc);
	public void cancelarInscripcion();
	public void agregarEdicionUsuario(EdicionCurso edV);
	
	//12 - Alta de Instituto
	public void ingresarNuevoInstituto(String nombre);
	public boolean confirmarAlta(String nombre);
	public void cancelarAltaInstituto();
	
}
