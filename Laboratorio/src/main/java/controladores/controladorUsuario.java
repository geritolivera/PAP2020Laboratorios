package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import manejadores.*;
import datatypes.*;
import exepciones.*;
import clases.*;
import conexion.Conexion;
import interfaces.IcontroladorUsuario;


public class controladorUsuario implements IcontroladorUsuario{
	public controladorUsuario() {
		super();
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Alta de Usuario
	public void AltaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, String instituto) throws UsuarioExcepcion {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorInstituto mIns = manejadorInstituto.getInstancia();
		if(!mUsu.existeUsuarioNick(nickname) && !mUsu.existeUsuarioCorreo(correo)) {
			//si la string instituto no tiene nada
			if(instituto==null) {
				Estudiante est = new Estudiante(nickname, nombre, apellido, correo, fechaNac);
				mUsu.agregarUsuario(est);
				
			}else {
				if(mIns.existeInstituto(instituto)) {
					Docente doc = new Docente(nickname, nombre, apellido, correo, fechaNac);
					Instituto ins = mIns.buscarInstituto(instituto);
					doc.setInstituto(ins);
					mUsu.agregarUsuario(doc);
				}
			}
		} else {
			if(mUsu.existeUsuarioNick(nickname)) {
				throw new UsuarioExcepcion("El Nickname '" + nickname +"' ya existe en el sistema");
			}
			if(mUsu.existeUsuarioNick(correo)) {
				throw new UsuarioExcepcion("El Correo '" + correo +"' ya existe en el sistema");
			}
		}
	}
	
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario
	
	public ArrayList<String> listarUsuarios(){
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		List<Usuario> usuarios = mUsu.getUsuarios();
		ArrayList<String> listUsers = new ArrayList<>();
		for(Usuario u: usuarios) {
			listUsers.add(u.getNick());
		}
		return listUsers;
	}
	
	@Override
	public void verInfoUsuario(String nickname) throws UsuarioExcepcion{
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		if(mUsu.existeUsuarioNick(nickname)) {
			Usuario u = mUsu.buscarUsuario(nickname);
			List<EdicionCurso> edicionesDoc = new ArrayList<EdicionCurso>();
			List<EdicionCurso> edicionesEst = new ArrayList<EdicionCurso>();
			List<ProgramaFormacion> programasEst = new ArrayList<ProgramaFormacion>();
			//si el usuario es docente
			if(u instanceof Docente) {
				DTDocente dtd = new DTDocente(u.getNick(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getFechaNac());
				edicionesDoc = ((Docente) u).getEdiciones();
				for(EdicionCurso e: edicionesDoc) {
					DTEdicionCurso dted = new DTEdicionCurso(e);
					dtd.agregarEdicion(dted);
				}
			}
			//si el usuario es estudiante
			else if (u instanceof Estudiante) {
				DTEstudiante dte = new DTEstudiante(u.getNick(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getFechaNac());
				edicionesEst = ((Estudiante) u).getEdiciones();
				programasEst = ((Estudiante) u).getProgramas();
				for(EdicionCurso e: edicionesEst) {
					DTEdicionCurso dtee = new DTEdicionCurso(e);
					dte.agregarEdicion(dtee);
				}
				for(ProgramaFormacion p: programasEst) {
					DTProgramaFormacion dtpe = new DTProgramaFormacion(p);
					dte.agregarPrograma(dtpe);
				}
			}
		}
		else 
			throw new UsuarioExcepcion("El usuario " + nickname + " no existe.");
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//3 - Modificar Datos de Usuario
	
	//usa listarUsuarios
	//usa verInfoUsuario
	@Override
	public void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci) throws UsuarioExcepcion{
		manejadorUsuario mu = manejadorUsuario.getInstancia();
		if(mu.existeUsuarioNick(nickname)) {
			Conexion con = Conexion.getInstancia();
			EntityManager em = con.getEntityManager();
			if(mu.existeUsuarioNick(nickname)){
				Usuario u = mu.buscarUsuarioNickname(nickname);
				u.setNombre(nombre);
				u.setApellido(apellido);
				u.setFechaNac(fechaNaci);
				em.getTransaction().begin();
				em.persist(u);
				em.getTransaction().commit();
			}
		}
		else
			throw new UsuarioExcepcion("El usuario " + nickname + " no existe.");
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
		@Override
		public void AltaInstituto(String nombre) throws InstitutoExcepcion{
			manejadorInstituto mi = manejadorInstituto.getInstancia();
			boolean existe = mi.existeInstituto(nombre);
			if(existe) {
				throw new InstitutoExcepcion("El Instituto con el nombre " + nombre + " ya existe en el Sistema");
			} else {
				Instituto i  = new Instituto(nombre);
				mi.agregarInstituto(i);
			}
		}
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares
		
		@Override //Lista los DT Usuarios
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
		
		
		@Override //Lista los nombres de los institutos
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
		
		@Override //Lista los nicknames de los estudiantes
		public String[] listarEstudiantesAux(){
			manejadorUsuario mU = manejadorUsuario.getInstancia();
			List<Usuario> listUs = mU.getUsuarios();
			String[] estudiantes = new String[listUs.size()];//ver esta funcion
			int i=0;
			for(Usuario us:listUs) {
				if(us instanceof Estudiante) {
					estudiantes[i]= us.getNick();
					i++;
				}
			}
			return estudiantes;
		}
	
}
