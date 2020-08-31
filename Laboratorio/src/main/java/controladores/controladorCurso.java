package controladores;

import java.util.List;
import java.util.ArrayList;

import clases.Curso;
import clases.EdicionCurso;
import clases.ProgramaFormacion;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;

import manejadores.manejadorCurso;

import interfaces.IcontroladorCurso;

public class controladorCurso implements IcontroladorCurso{
	public controladorCurso() {
		super();
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//4 - Alta de Curso
	@Override
	public void nuevosDatosCurso(Curso datosCurso) {}
	
	@Override
	public boolean confirmarAltaCurso(String nombre) {
	return true;
	}
	
	@Override
	public void cancelarAlta() {}

	
	/*-------------------------------------------------------------------------------------------------------------*/
	//5 - Consulta de Curso
	@Override
	public ArrayList<String> listarCursos(String nombreInstituto){
		manejadorCurso mCurso = manejadorCurso.getInstancia(); 
		List<String> list = new ArrayList<String>();  
		return list;
	}
	
	@Override
	public DTCurso verInfo(String nomCurso) {
		DTCurso dt = null;
		return dt;
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	@Override
	public void nuevosDatosEdicion(EdicionCurso datosEdicion) {}
	
	@Override
	public boolean confirmarAltaEdicion(String nombre) {
		return true;
	}
	//Se utiliza la mismas funcion cancelarAlta
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//7 - Consulta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	@Override
	public String[] listarEdicones(String nomCurso) {
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		return cars;
	}
	
	@Override
	public DTEdicionCurso verInfoEdicion(String nomEdicion) {
		DTEdicionCurso dt = null;
		return dt;
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//8 - Inscripcion a Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	@Override
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) {
		DTEdicionCurso dt = null;
		return dt;
	}
	
	@Override
	public void cancelarInscripcion() {}
	
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//9 - Crear Programa de Formacion
	@Override
	public void altaProgramaFormacion(ProgramaFormacion datosPrograma){}
	
	@Override
	public boolean confirmarAlta(String nombre){
		return true;
	}
	//Se utiliza la mismas funcion cancelarAlta
	
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//10 - Agregar Curso a Programa de Formacion
	@Override
	public String[] listarProgramas(){
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		return cars;
	}
	
	@Override
	public DTProgramaFormacion verInfoPrograma(String nombreProg){
		DTProgramaFormacion dt = null;
		return dt;
	}
		
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
	@Override
	public void seleccionarPrograma(String nomP){}
	
	//Se utiliza la misma funcion listarCursos
	
	@Override
	public void agregarCursoPrograma(String nomCur){}
	
	@Override
	public void agregarCursoPrograma(ProgramaFormacion p){} //Revisar
		
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
	@Override
	public void ingresarNuevoInstituto(String nombre){}
	
	@Override
	public boolean confirmarAltaInstituto(String nombre){
		return true;
	}
	
	@Override
	public void cancelarAltaInstituto(){}
}
