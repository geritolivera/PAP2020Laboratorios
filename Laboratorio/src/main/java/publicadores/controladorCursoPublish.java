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
			System.out.println("Empece configuracion");
		} catch (Exception ex) {
			System.out.println("No pude empezar configuracion");
		}
	}
	
	//se tiene que configurar para cada uno
	//TODO
	@WebMethod(exclude = true)
	public void publicar() {
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorCurso");
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT")+ "/controladorCurso" , this);
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//METODOS A PUBLICAR
	
	//METODOS NORMALES
	
	@WebMethod
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto, String[] previas,  String[] cats, String imagen) throws CursoExcepcion, InstitutoExcepcion{
		ArrayList<String> listPrevias = new ArrayList<>();
		for(int i = 0; i < previas.length; i++) {
			listPrevias.add(previas[i]);
		}
		ArrayList<String> listCategorias = new ArrayList<>();
		for(int i = 0; i < cats.length; i++) {
			listCategorias.add(cats[i]);
		}
		try {
			icon.AltaCurso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, url, instituto, listPrevias, listCategorias, imagen);
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			throw new CursoExcepcion("El curso " + nombre + " ya existe en el sistema");
		} catch (InstitutoExcepcion e) {
			e.printStackTrace();
			throw new InstitutoExcepcion("El instituto " + instituto + " no existe en el sistema");
		}
	}
	
	@WebMethod
	public DTCurso verInfo(String nomCurso) throws CursoExcepcion{
		try {
			return icon.verInfo(nomCurso);
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			throw new CursoExcepcion("El curso " + nomCurso + " no existe en el sistema.");
		}
	}
	
	@WebMethod
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String nomCurso, String[] docentes, String url) throws CursoExcepcion, EdicionExcepcion{
		ArrayList<String> listDocentes = new ArrayList<>();
		for(int i = 0; i < docentes.length; i++) {
			listDocentes.add(docentes[i]);
		}
		try {
			icon.nuevosDatosEdicion(nombre, fechaI, fechaF, cupo, fechaPub, nomCurso, listDocentes, url);
		} catch (EdicionExcepcion e) {
			e.printStackTrace();
			throw new EdicionExcepcion("La edicion de curso " + nombre + " ya existe en el sistema.");
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			throw new CursoExcepcion("El curso " + nomCurso + " ya existe en el sistema.");
		}
	}
	
	@WebMethod
	public DTEdicionCurso verInfoEdicion(String nomEdicion) throws EdicionExcepcion{
		try {
			return icon.verInfoEdicion(nomEdicion);
		} catch (EdicionExcepcion e) {
			e.printStackTrace();
			throw new EdicionExcepcion("La edicion de curso " + nomEdicion + " no existe en el sistema.");
		}
	}
	
	@WebMethod
	public DTEdicionCurso mostrarEdicionVigente(String nomEdicion) throws EdicionExcepcion{
		try {
			return icon.mostrarEdicionVigente(nomEdicion);
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			throw new EdicionExcepcion("La edicion de curso " + nomEdicion + " no existe en el sistema.");
		}
	}
	
	@WebMethod
	public void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) throws Exception{
		try {
			icon.inscribirEstudianteEdicion(nomEdicion, nickUsuario, fecha);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Algo salio mal");
		}
	}
	
	@WebMethod
	public void inscribirEstudiantePrograma(String nomPrograma, String nickUsuario, Date fecha) throws Exception{
		try {
			icon.inscribirEstudiantePrograma(nomPrograma, nickUsuario, fecha);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Algo salio mal");
		}
	}
	
	@WebMethod
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fActual, String url) throws ProgramaFormacionExcepcion{
		try {
			icon.crearProgramaFormacion(nombre, descripcion, fechaI, fechaF, fActual, url);
		} catch (ProgramaFormacionExcepcion e) {
			e.printStackTrace();
			throw new ProgramaFormacionExcepcion("El programa " + nombre + " ya existe en el sistema");
		}
	}
	
	@WebMethod
	public void agregarCursoPrograma(String nomCur, String nomP) throws ProgramaFormacionExcepcion, CursoExcepcion{
		try {
			icon.agregarCursoPrograma(nomCur, nomP);
		} catch (ProgramaFormacionExcepcion e) {
			e.printStackTrace();
			throw new ProgramaFormacionExcepcion("El programa " + nomP + " no existe en el sistema");
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			throw new CursoExcepcion("El curso " + nomCur + " no existe en el sistema");
		}
	}
	
	@WebMethod
	public DTProgramaFormacion verInfoPrograma(String nombreProg) throws ProgramaFormacionExcepcion{
		try {
			return icon.verInfoPrograma(nombreProg);
		} catch (ProgramaFormacionExcepcion e) {
			e.printStackTrace();
			throw new ProgramaFormacionExcepcion("El programa " + nombreProg + " no existe en el sistema");
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
			ArrayList<String> retorno = icon.listarCursosCat(nomCategoria);
			String[] ret = new String[retorno.size()];
			int i = 0;
			for(String s: retorno) {
				ret[i] = s;
				i++;
			}
			return ret;
		} catch (CategoriaExcepcion e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public String[] listarEdiciones(String nomCurso) {
		try {
			ArrayList<String> retorno = icon.listarEdiciones(nomCurso);
			String[] ret = new String[retorno.size()];
			int i = 0;
			for(String s: retorno) {
				ret[i] = s;
				i++;
			}
			return ret;
		} catch (CursoExcepcion e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public String[] listarProgramas() {
		ArrayList<String> retorno = icon.listarProgramas();
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public String[] listarCursos() {
		ArrayList<String> retorno = icon.listarCursos();
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
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
		ArrayList<String> retorno = icon.listarCursosAux(nombreInstituto);
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	//listarEdicionesAux no se deberia usar porque esta repetida
	
	//no se si se usa
	@WebMethod
	public String[] listarDocentesInstituto(String nomInstituto) {
		ArrayList<String> retorno = icon.listarDocentesInstituto(nomInstituto);
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public String[] listarInstitutos() {
		return icon.listarInstitutos();
	}
	
	//no se si se usa
	@WebMethod
	public String[] listarDocentesAux(String nomEdicion) {
		ArrayList<String> retorno = icon.listarDocentesAux(nomEdicion);
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	//no se si se usa
	@WebMethod
	public String[] listarEstudiantes() {
		ArrayList<String> retorno = icon.listarEstudiantes();
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	//no se si se usa
	@WebMethod
	public String[] listarCategorias() {
		ArrayList<String> retorno = icon.listarCategorias();
		String[] ret = new String[retorno.size()];
		int i = 0;
		for(String s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	//no se si se usa
	@WebMethod
	public DTCurso[] listaDTCurso() {
		ArrayList<DTCurso> retorno = icon.listaDTCurso();
		DTCurso[] ret = new DTCurso[retorno.size()];
		int i = 0;
		for(DTCurso s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	//no se si se usa
	@WebMethod
	public DTProgramaFormacion[] listaDTPrograma() {
		ArrayList<DTProgramaFormacion> retorno = icon.listaDTPrograma();
		DTProgramaFormacion[] ret = new DTProgramaFormacion[retorno.size()];
		int i = 0;
		for(DTProgramaFormacion s: retorno) {
			ret[i] = s;
			i++;
		}
		return ret;
	}
	
	
	
	
	

}

