package publicadores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuracion.WebServiceConfiguracion;
import datatypes.*;
import exepciones.CategoriaExcepcion;
import exepciones.InstitutoExcepcion;
import exepciones.UsuarioExcepcion;
import interfaces.*;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class controladorUsuarioPublish {
	private fabrica fab;
	private IcontroladorUsuario icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public controladorUsuarioPublish() {
		fab = fabrica.getInstancia();
		icon = fab.getIcontroladorUsuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	//se tiene que configurar para cada uno
	//TODO
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	
	//METODOS NORMALES
	
	@WebMethod
	public void AltaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, String instituto, String password, String url) throws UsuarioExcepcion{
		try {
			icon.AltaUsuario(nickname, nombre, apellido, correo, fechaNac, instituto, password, url);
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
			throw new UsuarioExcepcion("El usuario " + nickname + " ya esta en el sistema.");
		}
	}
	
	@WebMethod
	public DTUsuario verInfoUsuario(String nickname) throws UsuarioExcepcion{
		try {
			return icon.verInfoUsuario(nickname);
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
			throw new UsuarioExcepcion("El usuario " + nickname + " no existe en el sistema.");
		}
	}
	
	@WebMethod
	public DTDocente docente() {
		return null;
	}
	
	@WebMethod
	public DTEstudiante estudiante() {
		return null;
	}
	
	
	@WebMethod
	public void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci) throws UsuarioExcepcion{
		try {
			icon.nuevosDatos(nickname, nombre, apellido, fechaNaci);
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
			throw new UsuarioExcepcion("El usuario " + nickname + " no existe en el sistema."); 
		}
	}
	
	@WebMethod
	public void AltaInstituto(String nombre) throws InstitutoExcepcion {
		try {
			icon.AltaInstituto(nombre);
		} catch (InstitutoExcepcion e) {
			e.printStackTrace();
			throw new InstitutoExcepcion("El instituto " + nombre + " ya existe en el sistema.");
		}
	}
	
	@WebMethod
	public void AltaCategoria(String nombre) {
		try {
			icon.AltaCategoria(nombre);
		} catch (CategoriaExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public boolean validarUsuario(String nickname, String password) throws UsuarioExcepcion{
		try {
			return icon.validarUsuario(nickname, password);
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
			throw new UsuarioExcepcion("El usuario " + nickname + " no pudo se cambiado.");
		}
	}
	
	@WebMethod
	public void dejarDeSeguir(String nickname, String nicknameSeguido) {
		icon.dejarDeSeguir(nickname, nicknameSeguido);
	}
	
	@WebMethod
	public void comenazarSeguir(String nickname, String nicknameSeguir) {
		icon.comenzarSeguir(nickname, nicknameSeguir);
	}
	
	@WebMethod
	public boolean validarSigue(String nickname, String nicknameSigue) {
		return icon.validarSigue(nickname, nicknameSigue);
	}
	
	@WebMethod
	public boolean validarSeguidor(String nickname, String nicknameSeguidor) {
		return icon.validarSeguidor(nickname, nicknameSeguidor);
	}
	
	@WebMethod
	public boolean inscriptoPF(String nickname, String nomPrograma) {
		return icon.inscriptoPF(nickname, nomPrograma);
	}
	
	@WebMethod
	public String inscriptoED(String nickname, String nomEdicion) {
		return icon.inscriptoED(nickname, nomEdicion);
	}
	
	@WebMethod
	public void cambiarInscripcion(String cambio, String nomEdicion, String nomUsuario) {
		icon.cambiarInscripcion(cambio, nomEdicion, nomUsuario);
	}
	
	//METODOS LISTAS
	
	@WebMethod
	public String[] listarUsuarios() {
		ArrayList<String> retorno = icon.listarUsuarios();
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public DTUsuario[] listarDTUsuarios() {
		List<DTUsuario> usuarios = icon.listarDTUsuarios();
		int i = 0;
		DTUsuario[] ret = new DTUsuario[usuarios.size()];
		for(DTUsuario u: usuarios) {
			ret[i] = u;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public String[] listarInstituto() {
		return icon.listarInstituto();
	}
	
	@WebMethod
	public String[] listarEstudiantesAux() {
		return icon.listarEstudiantesAux();
	}
	
	@WebMethod
	public String[] listarSeguidores(String nickname) {
		ArrayList<String> retorno = icon.listarSeguidores(nickname);
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public String[] listarSeguidos(String nickname) {
		ArrayList<String> retorno = icon.listarSeguidos(nickname);
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public DTInscripcionED[] listarInscripcionesED(String nomEdicion) {
		List<DTInscripcionED> inscripciones = icon.listarInscripcionesED(nomEdicion);
		DTInscripcionED[] ret = new DTInscripcionED[inscripciones.size()];
		int i = 0;
		for(DTInscripcionED ins: inscripciones){
			ret[i] = ins;
			i++;
		}
		return ret;
	}
	
	//existeCorreoUsuario se usa para el controlador
	//por lo que no es necesario publicarla

}
