package publicadores;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuracion.WebServiceConfiguracion;
import interfaces.*;
import datatypes.*;
import exepciones.CategoriaExcepcion;
import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
import exepciones.InstitutoExcepcion;
import exepciones.ProgramaFormacionExcepcion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class controladorCursoPublish {
	private fabrica fab;
	private IcontroladorCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public controladorCursoPublish() {
		fab = fabrica.getInstancia();
		icon = fab.getIcontroladorCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	//se tiene que configurar para cada uno
	//TODO
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	
	//METODOS NORMALES
	
	//TODO 
	//esperando respuesta del profe acerca de las listas
	@WebMethod
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto, ArrayList<String> previas,  ArrayList<String> cats, String imagen) {
		try {
			icon.AltaCurso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, url, instituto, previas, cats, imagen);
		} catch (CursoExcepcion e) {
			e.printStackTrace();
		} catch (InstitutoExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void verInfo(String nomCurso) {
		try {
			icon.verInfo(nomCurso);
		} catch (CursoExcepcion e) {
			e.printStackTrace();
		}
	}
	
	//TODO
	//esperando respuesta del profe acerca de las listas
	@WebMethod
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String nomCurso, ArrayList<String> docentes, String url) {
		try {
			icon.nuevosDatosEdicion(nombre, fechaI, fechaF, cupo, fechaPub, nomCurso, docentes, url);
		} catch (EdicionExcepcion e) {
			e.printStackTrace();
		} catch (CursoExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public DTEdicionCurso verInfoEdicion(String nomEdicion) {
		try {
			return icon.verInfoEdicion(nomEdicion);
		} catch (EdicionExcepcion e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) {
		try {
			return icon.mostrarEdicionVigente(nomCurso);
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) {
		try {
			icon.inscribirEstudianteEdicion(nomEdicion, nickUsuario, fecha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void inscribirEstudiantePrograma(String nomPrograma, String nickUsuario, Date fecha){
		try {
			icon.inscribirEstudiantePrograma(nomPrograma, nickUsuario, fecha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fActual, String url){
		try {
			icon.crearProgramaFormacion(nombre, descripcion, fechaI, fechaF, fActual, url);
		} catch (ProgramaFormacionExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void agregarCursoPrograma(String nomCur, String nomP) {
		try {
			icon.agregarCursoPrograma(nomCur, nomP);
		} catch (ProgramaFormacionExcepcion e) {
			e.printStackTrace();
		} catch (CursoExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public DTProgramaFormacion verInfoPrograma(String nombreProg) {
		try {
			return icon.verInfoPrograma(nombreProg);
		} catch (ProgramaFormacionExcepcion e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//METODOS LISTAS
	
	@WebMethod
	public String[] listarCursosInst(String nombreInstituto) {
		return icon.listarInstitutos();
	}
	
	@WebMethod
	public String[] listarCursosCat(String nomCategoria) {
		try {
			return icon.listarCursosCat(nomCategoria);
		} catch (CategoriaExcepcion e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public String[] listarEdiciones(String nomCurso) {
		try {
			return icon.listarEdiciones(nomCurso);
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public String[] listarProgramas() {
		return icon.listarProgramas();
	}
	
	@WebMethod
	public String[] listarCursos() {
		return icon.listarCursos();
	}
	
	@WebMethod
	public String[] getCategoriasPrograma(String nomPrograma) {
		ArrayList<String> retorno = icon.getCategoriasPrograma(nomPrograma);
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public String[] listarCursosAux(String nombreInstituto) {
		return icon.listarCursosAux(nombreInstituto);
	}
	
	//listarEdicionesAux no se deberia usar porque esta repetida
	
	//no se si se usa
	@WebMethod
	public String[] listarDocentesInstituto(String nomInstituto) {
		return icon.listarDocentesInstituto(nomInstituto);
	}
	
	@WebMethod
	public String[] listarInstitutos() {
		return icon.listarInstitutos();
	}
	
	//no se si se usa
	@WebMethod
	public String[] listarDocentesAux(String nomEdicion) {
		return icon.listarDocentesAux(nomEdicion);
	}
	
	//no se si se usa
	@WebMethod
	public String[] listarEstudiantes() {
		return icon.listarEstudiantes();
	}
	
	//no se si se usa
	@WebMethod
	public String[] listarCategorias() {
		return icon.listarCategorias();
	}
	
	//no se si se usa
	@WebMethod
	public DTCurso[] listaDTCurso() {
		return icon.listaDTCurso();
	}
	
	//no se si se usa
	@WebMethod
	public DTProgramaFormacion[] listaDTPrograma() {
		return icon.listaDTPrograma();
	}
	
	
	
	
	

}
