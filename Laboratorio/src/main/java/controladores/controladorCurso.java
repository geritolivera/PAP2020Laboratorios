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
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto) throws CursoExcepcion, InstitutoExcepcion{
		manejadorCurso mc = manejadorCurso.getInstancia();
		manejadorInstituto mI = manejadorInstituto.getInstancia();
		if(mc.existeCurso(nombre))
			throw new CursoExcepcion("La clase de Nombre " + nombre + "ya existe dentro del Sistema");
		else {
			if(mI.existeInstituto(instituto)){
				Instituto I = mI.buscarInstituto(instituto);
				Curso cursoNuevo = new Curso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, url, I);
				mc.agregarCurso(cursoNuevo);
			}
			else
				throw new InstitutoExcepcion("El instituto " + instituto + "no existe");
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
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, Curso curso, ArrayList<String> docentes) throws EdicionExcepcion{
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		if(mEdi.existeEdicion(nombre)) {
			throw new EdicionExcepcion("La edicion de Nombre " + nombre + "ya existe dentro del Sistema");
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
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) throws CursoExcepcion {
		manejadorCurso mCur = manejadorCurso.getInstancia();
		if(mCur.existeCurso(nomCurso)){
			Curso c = mCur.buscarCurso(nomCurso);
			List<EdicionCurso> ediciones = c.getEdiciones();
			for(EdicionCurso e: ediciones){
				//if(esVigente()){}  //como sabemos cual es vigente? 
				DTEdicionCurso dte = new DTEdicionCurso(e);
			}
			return dte;
		}
		else
			throw new CursoExcepcion("No existe el curso " + nomCurso);
	}
	
	@Override
	public void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) throws UsuarioExcepcion, EdicionExcepcion{
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		if(mUsu.existeUsuarioCorreo(nickUsuario)){
			if(mEdi.existeEdicion(nomEdicion)){
				Usuario u = mUsu.buscarUsuario(nickUsuario);
				if(u instanceof Estudiante) {
					EdicionCurso e = mEdi.buscarEdicion(nomEdicion);
					//funcion agregarInscripcion tambien agrega la inscripcion a la edicion
					((Estudiante) u).agregarInscripcion(fecha, e);
					//funcion agregarEdicion tambien agrega al estudiante a la edicion
					((Estudiante) u).agregarEdicion(e);
				}
				else
					throw new UsuarioExcepcion("El usuario " + nickUsuario + " no es un estudiante");
			}
			else
				throw new EdicionExcepcion("No existe edicion " + nomEdicion);
		}
		else
			throw new UsuarioExcepcion("No existe usuario " + nickUsuario);
	} 
	
	@Override
	public void cancelarInscripcion() {}
	
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//9 - Crear Programa de Formacion
	@Override
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaA) throws ProgramaFormacionExcepcion{	
		manejadorPrograma mpf = manejadorPrograma.getInstancia();
		if(mpf.existePrograma(nombre)) {
			throw new ProgramaFormacionExcepcion("El programa de Formacion de Nombre " + nombre + "ya existe dentro del Sistema");
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
	
	@Override //Agrega curso a programa de formacion
	public void agregarCursoPrograma(String nomCur){}//Revisar
	
	@Override
	public void agregarCursoPrograma(ProgramaFormacion p){} //Revisar
	
	//Se utiliza la misma funcion listarCursos
	
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
		

	/*-------------------------------------------------------------------------------------------------------------*/
	//Listados para comboBoxes
	public String[] listarInstitutos() {
		ArrayList<String> institutos;
		manejadorInstituto mI = manejadorInstituto.getInstancia();
		institutos = mI.obtenerInstitutos();
		String[] institutos_ret = new String[institutos.size()];
        int i=0;
        for(String in:institutos) {
        	institutos_ret[i]=in;
        	i++;
        }
        return institutos_ret;
	}
	
	public String[] listarCursos(nombreInstituto) {
		/*ArrayList<String> cursos;//ver que me devuelva los objetos del curso y buscar los que pertenecen a ese instituto
		manejadorCurso mC = manejadorCurso.getInstancia();
		cursos = mC.obtenerCursos(nombreInstituto);
		String[] cursos_ret = new String[cursos.size()];
        int i=0;
        for(String c:cursos) {
        	cursos_ret[i]=c;
        	i++;
        }
        return cursos_ret;*/	
	}
	
}
