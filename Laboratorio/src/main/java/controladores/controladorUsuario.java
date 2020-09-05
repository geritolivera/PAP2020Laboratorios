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
	public void AltaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, String instituto) throws UsuarioRepetidoExcepcion {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorInstituto mIns = manejadorInstituto.getInstancia();
		if(!mUsu.existeUsuarioNick(nickname) && !mUsu.existeUsuarioCorreo(correo)) {
			//si la string instituto no tiene nada
			if(instituto.isEmpty()) {
				Estudiante est = new Estudiante(nickname, nombre, apellido, correo, fechaNac);
				mUsu.agregarUsuario(est);
				
			}
			else {
				if(mIns.existeInstituto(instituto)) {
					Docente doc = new Docente(nickname, nombre, apellido, correo, fechaNac);
					Instituto ins = mIns.buscarInstituto(instituto);
					doc.setInstituto(ins);
					mUsu.agregarUsuario(doc);
				}
			}
		} else if(mUsu.existeUsuarioNick(nickname)){
			throw new UsuarioRepetidoExcepcion("El Usuario con el nickname " + nickname + " ya existe en el Sistema");
		}else if(mUsu.existeUsuarioNick(correo)){
			throw new UsuarioRepetidoExcepcion("El Usuario con el correo " + correo + " ya existe en el Sistema");
		}
	}
	
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario
	@Override
	public List<DTUsuario> listarDTUsuarios(){
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		List<Usuario> usuarios = mUsu.getUsuarios();
		List<DTUsuario> listUsers = new ArrayList<DTUsuario>();  
		for(Usuario u: usuarios) {
			DTUsuario dt = new DTUsuario(u);
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
		manejadorUsuario mu = manejadorUsuario.getInstancia();
		Usuario u = mu.buscarUsuario(nickname);
		if(u != null) {
			DTUsuario dtU = new DTUsuario(u);
			return dtU;
		} else {
		return null;
		}
	}
	
	@Override
	public void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci){
		manejadorUsuario mu = manejadorUsuario.getInstancia();
		Usuario u = mu.buscarUsuarioNickname(nickname);
		if(u != null) {
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setFechaNac(fechaNaci);
		}
	}
	
	
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
		public void AltaInstituto(String nombre) throws InstitutoRepetidoExcepcion{
			manejadorInstituto mi = manejadorInstituto.getInstancia();
			Instituto nuevoI = mi.buscarInstituto(nombre);
			if(nuevoI != null) {
				throw new InstitutoRepetidoExcepcion("El Instituto con el nombre " + nombre + " ya existe en el Sistema");
			} else {
				mi.agregarInstituto(nuevoI);
			}
		}
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares
		@Override
		public String[] listarInstituto() {
			manejadorInstituto mi = manejadorInstituto.getInstancia();
			List<Instituto> listIn = mi.getInstituto();
			String[] institutos = new String[listIn.size()];
			int i = 0;
			for(Instituto ins : listIn) {
				institutos[i] = ins.getNombre();
				i++;
			}
			return institutos;
		}
		
}
