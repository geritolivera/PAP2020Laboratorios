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
    void AltaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, String instituto) throws UsuarioExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario
    ArrayList<String> listarUsuarios();
	void verInfoUsuario(String nickname) throws UsuarioExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//3 - Modificar Datos de Usuario
    void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci);
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
    void AltaInstituto(String nombre) throws InstitutoExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares

	List<DTUsuario> listarDTUsuarios();
	
	String[] listarInstituto(); //Lista los nombres de los institutos

	String[] listarEstudiantesAux(); //Lista los nicknames de los estudiantes
	
}
