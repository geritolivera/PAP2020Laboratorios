package interfaces;

import datatypes.DTInscripcionED;
import datatypes.DTUsuario;
import exepciones.*;
import manejadores.manejadorUsuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clases.Estudiante;
import clases.InscripcionED;
import clases.InscripcionPF;
import clases.Usuario;

public interface IcontroladorUsuario {
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//1 - Alta Usuario
	public void AltaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, String instituto,String password) throws UsuarioExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario
	public ArrayList<String> listarUsuarios();
	public DTUsuario verInfoUsuario(String nickname) throws UsuarioExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//3 - Modificar Datos de Usuario
	public void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci) throws UsuarioExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
	public void AltaInstituto(String nombre) throws InstitutoExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares

	public List<DTUsuario> listarDTUsuarios();

	public boolean existeCorreoUsuario(String correo); // se fija si existe el correo en la lista de usuarios
	
	public String[] listarInstituto(); //Lista los nombres de los institutos

	public String[] listarEstudiantesAux(); //Lista los nicknames de los estudiantes
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//13 - Alta de Categoria
	public void AltaCategoria(String nombre) throws CategoriaExcepcion;

    //Validad login usuario
    boolean validarUsuario(String nickname, String password) throws UsuarioExcepcion;
    
	/*-------------------------------------------------------------------------------------------------------------*/
    //Currentuser deja de seguir a otro user, y al user que se deja de seguir se saca de seguidores al Currentuser
    public void dejarDeSeguir(String nickname, String nicknameSeguido);
    
    //Currentuser empieza a seguir a un user, y al user se le agrega a la lista de seguidores al Currentuser
    public void comenzarSeguir(String nickname, String nicknameSeguir);
    
    //Lista los seguidores de un user
    public ArrayList<String> listarSeguidores(String nickname);
    
    //Lista los seguidos de un user
    public ArrayList<String> listarSeguidos(String nickname);
    
    //Si un user sigue a otro
    public boolean validarSigue(String nickname, String nicknameSigue);
    
    //Si un user es seguidor de otro
    public boolean validarSeguidor(String nickname, String nicknameSguidor);
    
    public boolean inscriptoPF(String nickname, String nomPrograma);
    public String inscriptoED(String nickname, String nomEdicion);
    
    public List<DTInscripcionED> listarInscripcionesED(String nomEdicion);
    public void cambiarInscripcion(String cambio, String nomEdicion, String nomUsuario);
    
}
