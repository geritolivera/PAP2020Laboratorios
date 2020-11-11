package interfaces;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import exepciones.*;

import java.util.ArrayList;
import java.util.Date;

import clases.Docente;

public interface IcontroladorCurso {
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//4 - Alta de Curso
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto, ArrayList<String> previas, ArrayList<String> categorias, String imagen) throws CursoExcepcion, InstitutoExcepcion;
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//5 - Consulta de Curso
	public String[] listarCursosInst(String nombreInstituto) throws InstitutoExcepcion;
	public String[] listarCursosCat(String nombreCategoria) throws CategoriaExcepcion;
	public DTCurso verInfo(String nomCurso) throws CursoExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String nomCurso, ArrayList<String> docentes, String url) throws EdicionExcepcion, CursoExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//7 - Consulta de Edicion de Curso
	public String[] listarEdiciones(String nomCurso) throws CursoExcepcion;
	public DTEdicionCurso verInfoEdicion(String nomEdicion) throws EdicionExcepcion;
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//8 - Inscripcion a Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) throws CursoExcepcion;
	public void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) throws Exception;
	public void inscribirEstudiantePrograma(String nombrePrograma, String nickUsuario, Date fecha) throws Exception;


	/*-------------------------------------------------------------------------------------------------------------*/
	//9 - Crear Programa de Formacion
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA, String url) throws ProgramaFormacionExcepcion;
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//10 - Agregar Curso a Programa de Formacion
	public String[] listarProgramas();
	public String[] listarCursos();
	public void agregarCursoPrograma(String nomCur, String nomP) throws ProgramaFormacionExcepcion, CursoExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//11 - Consulta de Programa de Formacion
	public DTProgramaFormacion verInfoPrograma(String nombreProg) throws ProgramaFormacionExcepcion;
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares
	//Funciones aux para comboBox de Edicion de cursos

	public String[] listarInstitutos();
	public String[] listarCursosAux(String nombreInstiuto);
	public String[] listarDocentesInstituto(String nomInstituto);

	public String[] listarEdicionesAux(String nombreCurso);
	public String[] listarDocentesAux(String nomEdicion);

	public String[] listarEstudiantes();
	
	public String[] listarCategorias();

	public ArrayList<String> getCategoriasPrograma(String programa);

    public DTCurso[] listaDTCurso();

	public DTProgramaFormacion[] listaDTPrograma();
}
