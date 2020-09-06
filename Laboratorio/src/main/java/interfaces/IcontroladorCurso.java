package interfaces;

import java.util.List;
import java.util.ArrayList;

import clases.*;
import datatypes.*;
import exepciones.*;

public interface IcontroladorCurso {

	//4 - Alta de Curso
	public void AltaCurso(DTCurso datosCurso) throws CursoRepetidoExcepcion;
	
	//5 - Consulta de Curso
	public String[] listarCursos(String nombreInstituto);
	public DTCurso verInfo(String nomCurso);
	
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public void nuevosDatosEdicion(EdicionCurso datosEdicion);
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
	public void altaProgramaFormacion(ProgramaFormacion datosPrograma);
	public boolean confirmarAlta(String nombre);
	//Se utiliza la mismas funcion cancelarAlta
	
	//10 - Agregar Curso a Programa de Formacion
	public ArrayList<String> listarProgramas();
	public void agregarCursoPrograma(String nomCur);
	public void agregarCursoPrograma(ProgramaFormacion p); //Revisar
	public DTProgramaFormacion verInfoPrograma(String nombreProg);
	
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
	public DTProgramaFormacion seleccionarPrograma(String nomP);
	public DTCurso seleccionarCursoEnPrograma(String nomC);
	//Se utiliza la misma funcion listarCursos
	
	//12 - Alta de Instituto
	public void AltaInstituto(String nombre)/* throws InstitutoRepetidoException*/;//Falta añadir la excepcion en el import
	
	//public String[] listarCursos(nombreInstituto);
	public String[] listarInstitutos();
}
