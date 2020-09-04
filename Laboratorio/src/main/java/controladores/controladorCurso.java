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
	public void AltaCurso(DTCurso datosCurso) throws CursoRepetidoExcepcion{
		manejadorCurso mc = manejadorCurso.getInstancia();
		if(mc.existeCurso(datosCurso.getNombre()))
			throw new CursoRepetidoExcepcion("La clase de Nombre " + datosCurso.getNombre() + "ya existe dentro del Sistema");
		else {
			Instituto I = new Instituto(datosCurso.getNombre());
			Curso cursoNuevo = new Curso(datosCurso.getNombre(),datosCurso.getDescripcion(),datosCurso.getDuracion(),datosCurso.getCantHoras(),datosCurso.getCreditos(),datosCurso.getFechaR(),datosCurso.getUrl(),I);
			mc.agregarCurso(cursoNuevo);
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
	public void altaProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF){}
	
	@Override
	public boolean confirmarAlta(String nombre){
		return true;
	}
	//Se utiliza la mismas funcion cancelarAlta
	
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//10 - Agregar Curso a Programa de Formacion
	@Override
	public ArrayList<String> listarProgramas(){
		//String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
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
	}//Revisar
		
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
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
	@Override
	public DTProgramaFormacion seleccionarPrograma(String nomP){
		manejadorPrograma mp = manejadorPrograma.getInstancia();
		ProgramaFormacion prog = mp.buscarPrograma(nomP);
		if(prog != null) {
			DTProgramaFormacion dtProg = new DTProgramaFormacion(prog);
			return dtProg;
		} else {
			return null;
		}
	}
	
	@Override
	public DTCurso seleccionarCursoEnPrograma(String nomC) {
		manejadorCurso mc = manejadorCurso.getInstancia();
		Curso cur = mc.buscarCurso(nomC);
		if(cur != null) {
			DTCurso dtCur = new DTCurso(cur);
			return dtCur;
		} else {
			return null;
		}
	}
	//Se utiliza la misma funcion listarCursos
	
		
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
	@Override
	public void AltaInstituto(String nombre)/* throws InstitutoRepetidoException*/{
		manejadorInstituto mi = manejadorInstituto.getInstancia();
		Instituto nuevoI = mi.buscarInstituto(nombre);
		if(nuevoI != null) {
			//throw new InstitutoRepetidoException("El Instituto con el nombre " + nombre + " ya existe en el Sistema");
		} else {
			mi.agregarInstituto(nuevoI);
		}
	}
}
