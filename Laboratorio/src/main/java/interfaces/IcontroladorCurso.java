package interfaces;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import clases.*;
import datatypes.*;
import exepciones.*;

public interface IcontroladorCurso {

	//4 - Alta de Curso
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto) throws CursoExcepcion, InstitutoExcepcion;
	
	//5 - Consulta de Curso
	public ArrayList<String> listarCursos(String nombreInstituto);
	public DTCurso verInfo(String nomCurso);
	
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, Curso curso, ArrayList<String> docentes) throws EdicionExcepcion;
	public boolean confirmarAltaEdicion(String nombre);
	//Se utiliza la mismas funcion cancelarAlta
	
	//7 - Consulta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public ArrayList<String> listarEdiciones(String nomCurso);
	public DTEdicionCurso verInfoEdicion(String nomEdicion);
	
	//8 - Inscripcion a Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) throws CursoExcepcion;
	public void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) throws UsuarioExcepcion, EdicionExcepcion;
	public void cancelarInscripcion();
	
	//9 - Crear Programa de Formacion
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) throws ProgramaFormacionExcepcion;
	
	//10 - Agregar Curso a Programa de Formacion
	public ArrayList<String> listarProgramas();
	
	public DTProgramaFormacion verInfoPrograma(String nombreProg);
	
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
	public DTProgramaFormacion seleccionarPrograma(String nomP);
	public void agregarCursoPrograma(String nomCur);
	public void agregarCursoPrograma(ProgramaFormacion p); //Revisar
	public DTCurso seleccionarCursoEnPrograma(String nomC);
	//Se utiliza la misma funcion listarCursos
	
	//Funciones aux para comboBox de Edicion de cursos
	public String[] listarInstitutos();
	public String[] listarCursosAux(String nombreInstiuto);
	public String[] listarEdicionesAux(String nombreCurso);
	public String[] listarDocentesAux(String nomEdicion);
}
