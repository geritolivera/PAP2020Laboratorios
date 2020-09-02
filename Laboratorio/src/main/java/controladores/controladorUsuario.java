package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import manejadores.*;
import datatypes.*;
import exepciones.*;
import clases.*;

import interfaces.IcontroladorUsuario;


public class controladorUsuario implements IcontroladorUsuario{
	public controladorUsuario() {
		super();
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//1 - Alta Usuarios
	@Override
	
	 public void AltaUsuario(DTUsuario usuario)throws UsuarioRepetidoExcepcion{
	 manejadorUsuario mU = manejadorUsuario.getInstancia();
	 Usuario u = null;
	 if (mU.existeUsuarioNick(usuario.getNick()))
		 throw new UsuarioRepetidoExcepcion("El usuario con nickname "+ usuario.getNick() + " ya existe en uso");
	 if (mU.existeUsuarioCorreo(usuario.getCorreo()))
		 throw new UsuarioRepetidoExcepcion("El usuario con el correo "+ usuario.getCorreo() + " ya existe en uso");
	 if (usuario instanceof DTDocente)
		 u = new Docente (usuario.getNick(),usuario.getNombre(),usuario.getApellido(),usuario.getCorreo(),usuario.getFechaNac());
	 if (usuario instanceof DTEstudiante)
		 u = new Estudiante (usuario.getNick(),usuario.getNombre(),usuario.getApellido(),usuario.getCorreo(),usuario.getFechaNac());
	 mU.agregarUsuario(u);
	}
	
	public String ingresarUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, boolean esDocente) {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		if(!mUsu.existeUsuarioNick(nickname) && !mUsu.existeUsuarioCorreo(correo)) {
			if(esDocente) {
				Docente doc = new Docente(nickname, nombre, apellido, correo, fechaNac);
				mUsu.agregarUsuario(doc);
			}
			else {
				Estudiante est = new Estudiante(nickname, nombre, apellido, correo, fechaNac);
				mUsu.agregarUsuario(est);
			}
			return "Usuario agregado";
		}
		return "Nick o Correo ya en uso.";
	}
	
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario
	@Override
	public List<DTUsuario> listarDTUsuarios(){
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		List<Usuario> usuarios = mUsu.getUsuarios();
		List<DTUsuario> listUsers = new ArrayList<DTUsuario>();  
		for(Usuario u: usuarios) {
			DTUsuario dt = new DTUsuario(u.getNick(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getFechaNac());
			listUsers.add(dt);
		}
		return listUsers;
	}
	
	public ArrayList<String> listarUsuarios(){
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		List<Usuario> usuarios = mUsu.getUsuarios();
		ArrayList<String> listUsers = new ArrayList<>();
		for(Usuario u: usuarios) {
			listUsers.add(u.getNombre());
		}
		return listUsers;
	}
	
	@Override
	public void verInfoUsuario(String nickname){
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		Usuario u = mUsu.buscarUsuario(nickname);
		List<EdicionCurso> edicionesDoc = new ArrayList<EdicionCurso>();
		List<ProgramaFormacion> programasDoc = new ArrayList<ProgramaFormacion>();
		List<EdicionCurso> edicionesEst = new ArrayList<EdicionCurso>();
		List<ProgramaFormacion> programasEst = new ArrayList<ProgramaFormacion>();
		//si el usuario es docente
		if(u instanceof Docente) {
			DTDocente dtd = new DTDocente(u.getNick(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getFechaNac());
			edicionesDoc = ((Docente) u).getEdiciones();
			for(EdicionCurso e: edicionesDoc) {
				DTEdicionCurso dted = new DTEdicionCurso(e);
				dtd.agregarEdicion(dted);
				Curso ec = e.getCurso();
				DTCurso dtcd = new DTCurso(ec);
				dtd.agregarCurso(dtcd);
				programasDoc = ec.getProgramas();
				for(ProgramaFormacion p: programasDoc) {
					DTProgramaFormacion dtpd = new DTProgramaFormacion(p);
					dtd.agregarPrograma(dtpd);
				}
			}
		}
		//si el usuario es estudiante
		else if (u instanceof Estudiante) {
			DTEstudiante dte = new DTEstudiante(u.getNick(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getFechaNac());
			edicionesEst = ((Estudiante) u).getEdiciones();
			for(EdicionCurso e: edicionesEst) {
				DTEdicionCurso dtee = new DTEdicionCurso(e);
				dte.agregarEdicion(dtee);
				programasEst = e.getCurso().getProgramas();
				for(ProgramaFormacion p: programasEst) {
					DTProgramaFormacion dtpe = new DTProgramaFormacion(p);
					dte.agregarPrograma(dtpe);
				}
			}
		}
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
