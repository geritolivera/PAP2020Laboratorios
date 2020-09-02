package interfaces;

import java.util.List;
import java.util.ArrayList;

import clases.Curso;
import clases.EdicionCurso;
import clases.ProgramaFormacion;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;



public interface IcontroladorCurso {

	//4 - Alta de Curso
	public void AltaCurso throws CursoRepetidoException(DTCurso datosCurso);//Falta añadir la excepcion en el import
	
	//5 - Consulta de Curso
	public ArrayList<String> listarCursos(String nombreInstituto);
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
	public void AltaInstituto throws InstitutoRepetidoException(String nombre);//Falta añadir la excepcion en el import
	

}
