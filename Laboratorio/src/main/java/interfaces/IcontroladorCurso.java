package interfaces;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import exepciones.*;

import java.util.ArrayList;
import java.util.Date;

public interface IcontroladorCurso {
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//4 - Alta de Curso
    void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto, String[] previas) throws CursoExcepcion, InstitutoExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//5 - Consulta de Curso
    ArrayList<String> listarCursos(String nombreInstituto) throws InstitutoExcepcion;
	DTCurso verInfo(String nomCurso) throws CursoExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
    void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String nomCurso, ArrayList<String> docentes) throws EdicionExcepcion, CursoExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//7 - Consulta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
    ArrayList<String> listarEdiciones(String nomCurso) throws CursoExcepcion;
	DTEdicionCurso verInfoEdicion(String nomEdicion) throws EdicionExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//8 - Inscripcion a Edicion de Curso
	//Se utiliza la misma funcion listarCursos
    DTEdicionCurso mostrarEdicionVigente(String nomCurso) throws CursoExcepcion;
	void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) throws UsuarioExcepcion, EdicionExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//9 - Crear Programa de Formacion
    void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) throws ProgramaFormacionExcepcion;
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//10 - Agregar Curso a Programa de Formacion
    ArrayList<String> listarProgramas();
	ArrayList<String> listarCursos();
	void agregarCursoPrograma(String nomCur, String nomP) throws ProgramaFormacionExcepcion, CursoExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
    DTProgramaFormacion verInfoPrograma(String nombreProg) throws ProgramaFormacionExcepcion;

	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares
	//Funciones aux para comboBox de Edicion de cursos

	String[] listarInstitutos();
	String[] listarCursosAux(String nombreInstiuto);
	String[] listarEdicionesAux(String nombreCurso);
	String[] listarDocentesAux(String nomEdicion);
	String[] listarDocentesInstituto(String nomInstituto);
}
