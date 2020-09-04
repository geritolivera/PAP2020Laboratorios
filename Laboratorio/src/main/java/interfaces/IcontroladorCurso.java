package interfaces;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import clases.*;
import datatypes.*;
import exepciones.*;

public interface IcontroladorCurso {

	//4 - Alta de Curso
	public void AltaCurso(DTCurso datosCurso) throws CursoRepetidoExcepcion;
	
	//5 - Consulta de Curso
	public ArrayList<String> listarCursos(String nombreInstituto);
	public DTCurso verInfo(String nomCurso);
	
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, Curso curso, ArrayList<String> docentes) throws EdicionRepetidaExcepcion;
	public boolean confirmarAltaEdicion(String nombre);
	//Se utiliza la mismas funcion cancelarAlta
	
	//7 - Consulta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public ArrayList<String> listarEdiciones(String nomCurso);
	public DTEdicionCurso verInfoEdicion(String nomEdicion);
	
	//8 - Inscripcion a Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso);
	public void cancelarInscripcion();
	
	//9 - Crear Programa de Formacion
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) throws ProgramaFormacionRepetidoExcepcion;
	
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
}
