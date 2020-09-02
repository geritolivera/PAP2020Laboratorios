package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manejadores.*;
import datatypes.*;
import exepciones.UsuarioRepetidoExcepcion;
import clases.*;

import interfaces.IcontroladorUsuario;


public class controladorUsuario implements IcontroladorUsuario{
	public controladorUsuario() {
		super();
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//1 - Alta Usuarios
	@Override
	public void ingresarUsuario(DTUsuario usuario) throws UsuarioRepetidoExcepcion{
	
	
	}
	
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario
	@Override
	public List<DTUsuario> listarUsuario(){
		//depende de como hacemos los usuarios
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		List<DTUsuario> list = new ArrayList<DTUsuario>();  
		return list;
	}
	
	@Override
	public DTUsuario verInfoUsuario(String nickname){
		DTUsuario a = null;
		return a;
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//3 - Modificar Datos de Usuario
	//Se utiliza la misma funcion listarUsuario
	@Override
	public DTUsuario seleccionarUsuario(String nickname){
		DTUsuario a = null;
		return a;
	}
	
	@Override
	public void nuevosDatos(String nombre, String apellido, Date fechaNaci){}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	@Override
	public void ingresarDocente(String nomDoc){}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//8 - Inscripcion a Edicion de Curso
	@Override
	public void seleccionarEstudiante(String nickname){}
	
	@Override
	public void confirmarInscripcion(String nickname, Date fechaInsc){}
	
	@Override
	public void cancelarInscripcion(){}
	
	@Override
	public void agregarEdicionUsuario(EdicionCurso edV){}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
	@Override
	public void ingresarNuevoInstituto(String nombre){}
	
	@Override
	public boolean confirmarAlta(String nombre){
		return true;
	}
	
	@Override
	public void cancelarAltaInstituto(){}
	
}
