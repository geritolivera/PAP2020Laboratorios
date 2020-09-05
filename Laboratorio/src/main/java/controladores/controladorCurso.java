package controladores;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import clases.*;
import datatypes.*;
import exepciones.*;
import manejadores.*;

import interfaces.IcontroladorCurso;

public class controladorCurso implements IcontroladorCurso{
	public controladorCurso() {
		super();
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//4 - Alta de Curso
	@Override
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto) throws CursoRepetidoExcepcion{
		manejadorCurso mc = manejadorCurso.getInstancia();
		manejadorInstituto mI = manejadorInstituto.getInstancia();
		if(mc.existeCurso(nombre))
			throw new CursoRepetidoExcepcion("La clase de Nombre " + nombre + "ya existe dentro del Sistema");
		else {
			if(mI.existeInstituto(instituto)){
				Instituto I = mI.buscarInstituto(instituto);
				Curso cursoNuevo = new Curso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, url, I);
				mc.agregarCurso(cursoNuevo);
			}
			else
				throw new CursoRepetidoExcepcion("El instituto " + instituto + "no existe");
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//5 - Consulta de Curso
	@Override
	public ArrayList<String> listarCursos(String nombreInstituto){
		manejadorInstituto mInst = manejadorInstituto.getInstancia(); 
		Instituto inst = mInst.buscarInstituto(nombreInstituto);
		List<Curso> cursos = inst.getCursos();
		ArrayList<String> listCursos = new ArrayList<String>();
		for(Curso c:cursos) {
			listCursos.add(c.getNombre());
		}
		return listCursos;
	}
	
	@Override
	public DTCurso verInfo(String nomCurso) {
		manejadorCurso mCur = manejadorCurso.getInstancia();
		Curso c = mCur.buscarCurso(nomCurso);
		DTCurso dt = new DTCurso(c);
		return dt;
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	@Override
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, Curso curso, ArrayList<String> docentes) throws EdicionRepetidaExcepcion{
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		if(mEdi.existeEdicion(nombre)) {
			throw new EdicionRepetidaExcepcion("La edicion de Nombre " + nombre + "ya existe dentro del Sistema");
		}
		else {
			EdicionCurso edi = new EdicionCurso(nombre, fechaI, fechaF, cupo, fechaPub, curso);
			for(String s: docentes) {
				Docente d = (Docente) mUsu.buscarUsuario(s);
				edi.agregarDocente(d);
			}
			mEdi.agregarEdicion(edi);
		}
	}
	
	@Override
	public boolean confirmarAltaEdicion(String nombre) {
		return true;
	}
	//Se utiliza la mismas funcion cancelarAlta
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//7 - Consulta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	@Override
	public ArrayList<String> listarEdiciones(String nomCurso) {
		//String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		manejadorCurso mCur = manejadorCurso.getInstancia();
		Curso cur = mCur.buscarCurso(nomCurso);
		List<EdicionCurso> ediciones = cur.getEdiciones();
		ArrayList<String> listEdiciones = new ArrayList<>();
		for (EdicionCurso e:ediciones) {
			listEdiciones.add(e.getNombre());
		}
		return listEdiciones;
	}
	
	@Override
	public DTEdicionCurso verInfoEdicion(String nomEdicion) {
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		EdicionCurso edi = mEdi.buscarEdicion(nomEdicion);
		DTEdicionCurso dt = new DTEdicionCurso(edi);
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
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) throws ProgramaFormacionRepetidoExcepcion{	
		manejadorPrograma mpf = manejadorPrograma.getInstancia();
		if(mpf.existePrograma(nombre)) {
			throw new ProgramaFormacionRepetidoExcepcion("El programa de Formacion de Nombre " + nombre + "ya existe dentro del Sistema");
		} else {
			ProgramaFormacion nuevoProg = new ProgramaFormacion(nombre,descripcion,fechaI,fechaF,fechaA);
			mpf.agregarPrograma(nuevoProg);
		}		
	}
	
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//10 - Agregar Curso a Programa de Formacion
	@Override
	public ArrayList<String> listarProgramas(){
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		List<ProgramaFormacion> programas = mPro.getProgramas();
		ArrayList<String> listProgramas = new ArrayList<>();
		for(ProgramaFormacion p: programas) {
			listProgramas.add(p.getNombre());
		}
		return listProgramas;
	}
	
	@Override
	public void agregarCursoPrograma(String nomCur, String nomP){
		manejadorCurso mCur = manejadorCurso.getInstancia();
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		Curso c = mCur.buscarCurso(nomCur);
		ProgramaFormacion p = mPro.buscarPrograma(nomP);
		p.agregarCurso(c);
		c.agregarPrograma(p);
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
	@Override
	public DTProgramaFormacion verInfoPrograma(String nombreProg){
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		ProgramaFormacion p = mPro.buscarPrograma(nombreProg);
		List<Curso> cursos = p.getCursos();
		DTProgramaFormacion dt = new DTProgramaFormacion(p);
		for(Curso c:cursos) {
			dt.agregarCurso(c.getNombre());
		}
		return dt;
	}
		
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
}
