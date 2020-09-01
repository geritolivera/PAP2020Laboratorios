package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manejadores.*;
import datatypes.*;
import clases.*;

import interfaces.IcontroladorUsuario;


public class controladorUsuario implements IcontroladorUsuario{
	public controladorUsuario() {
		super();
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//1 - Alta Usuario
	@Override
	//por ahora funciona a base de 3 fabricas: una para usuarios, otra para docentes, y otra para estudiantes
	//esto quiere decir que se repiten valores, ya que el usuario se registra dos veces, pero se puede cambiar despues
	//es mas bien un prototipo que otra cosa
	public String ingresarUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, boolean esDocente) {
		/*manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		if(!mUsu.existeNickUsuario(nickname) && !mUsu.existeCorreoUsuario(correo)) {
			Usuario user = new Usuario(nickname, nombre, apellido, correo, fechaNac);
			mUsu.agregarUsuario(user);
			if(esDocente) {
				manejadorDocente mDoc = manejadorDocente.getInstancia();
				Docente doc = new Docente(user);
				mDoc.agregarDocente(doc);
			}
			else {
				manejadorEstudiante mEst = manejadorEstudiante.getInstancia();
				Estudiante est = new Estudiante(user);
				mEst.agregarEstudiante(est);
			}
			return "Usuario creado!";
		}
		return "Nick o Email ya en uso. No se puede crear usuario";*/
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		if(!mUsu.existeNickUsuario(nickname) && !mUsu.existeCorreoUsuario(correo)) {
			if(esDocente) {
				Docente doc = new Docente(nickname, nombre, apellido, correo, fechaNac);
				mUsu.agregarUsuario(doc);
			}
			else {
				Estudiante est = new Estudiante(nickname, nombre, apellido, correo, fechaNac);
				mUsu.agregarUsuario(est);
			}
			return "Usuario creado.";
		}
		return "Nick o Correo ya en uso.";
		
	}
	
	/*@Override
	public boolean confirmarAltaUsuario(String nickname, String correo){
		return true;
	}
	
	@Override
	public void cancelarAlta(){}*/
	
	
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
