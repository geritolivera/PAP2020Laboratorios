package interfaces;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import exepciones.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IcontroladorCurso {
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//4 - Alta de Curso
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto, String[] previas) throws CursoExcepcion, InstitutoExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//5 - Consulta de Curso
	public List<String> listarCursos(String nombreInstituto) throws InstitutoExcepcion;
	public DTCurso verInfo(String nomCurso) throws CursoExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String nomCurso, ArrayList<String> docentes) throws EdicionExcepcion, CursoExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//7 - Consulta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public ArrayList<String> listarEdiciones(String nomCurso) throws CursoExcepcion;
	public DTEdicionCurso verInfoEdicion(String nomEdicion) throws EdicionExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//8 - Inscripcion a Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) throws CursoExcepcion;
	public void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) throws UsuarioExcepcion, EdicionExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//9 - Crear Programa de Formacion
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) throws ProgramaFormacionExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//10 - Agregar Curso a Programa de Formacion
	public ArrayList<String> listarProgramas();
	public ArrayList<String> listarCursos();
	public void agregarCursoPrograma(String nomCur, String nomP) throws ProgramaFormacionExcepcion, CursoExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
	public DTProgramaFormacion verInfoPrograma(String nombreProg) throws ProgramaFormacionExcepcion;

	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares
	//Funciones aux para comboBox de Edicion de cursos

	public String[] listarInstitutos();
	public String[] listarCursosAux(String nombreInstiuto);
	public String[] listarEdicionesAux(String nombreCurso);
	public String[] listarDocentesAux(String nomEdicion);
	public String[] listarDocentesInstituto(String nomInstituto);
}
