package interfaces;

import datatypes.DTUsuario;
import exepciones.InstitutoExcepcion;
import exepciones.UsuarioExcepcion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IcontroladorUsuario {
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//1 - Alta Usuario
	public void AltaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, String instituto) throws UsuarioExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario
	public ArrayList<String> listarUsuarios();
	public DTUsuario verInfoUsuario(String nickname) throws UsuarioExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//3 - Modificar Datos de Usuario
	public void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci);
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
	public void AltaInstituto(String nombre) throws InstitutoExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares

	public List<DTUsuario> listarDTUsuarios();

	public boolean existeCorreoUsuario(String correo); // se fija si existe el correo en la lista de usuarios
	
	public String[] listarInstituto(); //Lista los nombres de los institutos

	public String[] listarEstudiantesAux(); //Lista los nicknames de los estudiantes
	
}
