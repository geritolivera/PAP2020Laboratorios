package controladores;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import clases.*;
import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import exepciones.*;
import interfaces.IcontroladorCurso;
import manejadores.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
	public DTCurso verInfo(String nomCurso) throws CursoExcepcion{
		manejadorCurso mCur = manejadorCurso.getInstancia();
		if(mCur.existeCurso(nomCurso)) {
			Curso c = mCur.buscarCurso(nomCurso);
			DTCurso dtc = new DTCurso(c);
			return dtc;
		}
		else
			throw new CursoExcepcion("El curso " + nomCurso + " no existe.");
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	@Override
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String nomCurso, ArrayList<String> docentes) throws EdicionExcepcion, CursoExcepcion{
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorCurso mCur = manejadorCurso.getInstancia();
		if(mEdi.existeEdicion(nombre)) {
			throw new EdicionExcepcion("La edicion de Nombre " + nombre + "ya existe dentro del Sistema");
		}
		else {
			if(mCur.existeCurso(nomCurso)) {
				Curso curso = mCur.buscarCurso(nomCurso);
				EdicionCurso edi = new EdicionCurso(nombre, fechaI, fechaF, cupo, fechaPub, curso);
				for(String s: docentes) {
					Docente d = (Docente) mUsu.buscarUsuario(s);
					d.agregarEdicion(edi);
				}
				mEdi.agregarEdicion(edi);
			}
			else
				throw new CursoExcepcion("El curso " + nomCurso + " no existe.");
		}
	}
	
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
	public DTEdicionCurso verInfoEdicion(String nomEdicion) throws EdicionExcepcion{
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		if(mEdi.existeEdicion(nomEdicion)) {
			EdicionCurso edi = mEdi.buscarEdicion(nomEdicion);
			DTEdicionCurso dte = new DTEdicionCurso(edi);
			return dte;
		}
		else
			throw new EdicionExcepcion("La edicion " + nomEdicion + " no existe.");
	}
	
	 
	/*-------------------------------------------------------------------------------------------------------------*/
	//8 - Inscripcion a Edicion de Curso
	//Se utiliza la misma funcion listarCursos
	@Override
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) throws CursoExcepcion {
		manejadorCurso mCur = manejadorCurso.getInstancia();
		Date today = Calendar.getInstance().getTime();
		if(mCur.existeCurso(nomCurso)){
			Curso c = mCur.buscarCurso(nomCurso);
			List<EdicionCurso> ediciones = c.getEdiciones();
			DTEdicionCurso dte = new DTEdicionCurso();
			for(EdicionCurso e: ediciones) {
				if (e.getFechaF().after(today)) {
					dte.setNombre(e.getNombre());
					dte.setFechaPub(e.getFechaPub());
					dte.setFechaI(e.getFechaI());
					dte.setFechaF(e.getFechaF());
					dte.setCurso(e.getNomCurso());
					dte.setCupo(e.getCupo());
				}
			}
			return null;
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

	/*-------------------------------------------------------------------------------------------------------------*/
	//9 - Crear Programa de Formacion
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fActual) throws ProgramaFormacionExcepcion{	
		manejadorPrograma mpf = manejadorPrograma.getInstancia();
		if(mpf.existePrograma(nombre)) {
			throw new ProgramaFormacionExcepcion("El programa de Formacion de Nombre " + nombre + "ya existe dentro del Sistema");
		} else {
			ProgramaFormacion nuevoProg = new ProgramaFormacion(nombre,descripcion,fechaI,fechaF,fActual);
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
	//es necesaria otra funcion para listarCursos 
	@Override
	public ArrayList<String> listarCursos(){
		manejadorCurso mCur = manejadorCurso.getInstancia();
		List<Curso> cursos = mCur.getCursos();
		ArrayList<String> listCursos = new ArrayList<>();
		for(Curso c: cursos) {
			listCursos.add(c.getNombre());
		}
		return listCursos;
	}
	
	@Override
	public void agregarCursoPrograma(String nomCur, String nomP) throws ProgramaFormacionExcepcion, CursoExcepcion{
		manejadorCurso mCur = manejadorCurso.getInstancia();
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		if(mCur.existeCurso(nomCur)) {
			if(mPro.existePrograma(nomP)) {
				Curso c = mCur.buscarCurso(nomCur);
				ProgramaFormacion p = mPro.buscarPrograma(nomP);
				p.agregarCurso(c);
				c.agregarPrograma(p);
			}
			else
				throw new ProgramaFormacionExcepcion("El programa " + nomP + " no existe.");
		}
		else
			throw new CursoExcepcion("El curso " + nomCur + "no existe.");
	}
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//11 - Consulta de Programa de Formacion
	//Se utiliza la misma funcion de listarProgramas
	
	@Override
	public DTProgramaFormacion verInfoPrograma(String nombreProg) throws ProgramaFormacionExcepcion{
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		if(mPro.existePrograma(nombreProg)) {
			ProgramaFormacion p = mPro.buscarPrograma(nombreProg);
			List<Curso> cursos = p.getCursos();
			DTProgramaFormacion dt = new DTProgramaFormacion(p);
			for(Curso c:cursos) {
				dt.agregarCurso(c.getNombre());
			}
			return dt;
		}
		else
			throw new ProgramaFormacionExcepcion("El programa " + nombreProg + " no existe.");
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	//Funciones Auxiliares
	@Override //Listados para comboBoxes
	public String[] listarCursosAux(String nombreInstituto){
		manejadorInstituto mI = manejadorInstituto.getInstancia(); 
		Instituto inst = mI.buscarInstituto(nombreInstituto);
		List<Curso> cursos = inst.getCursos();
		String[] cursos_ret = new String[cursos.size()] ;
		int i=0;
		for(Curso c:cursos) {
			cursos_ret[i]=c.getNombre();
			i++;
		}
		return cursos_ret;
	}
	
	@Override
	public String[] listarEdicionesAux(String nomCurso) {
		manejadorCurso mC = manejadorCurso.getInstancia();
		Curso curso = mC.buscarCurso(nomCurso);
		List<EdicionCurso> ediciones = curso.getEdiciones();
		String[] ediciones_ret = new String[ediciones.size()];
		int i=0;
		for (EdicionCurso e:ediciones) {
			ediciones_ret[i]=e.getNombre();
			i++;
		}
		return ediciones_ret;
	}

//	public String[] listarDocentesAux(String nomEdicion){
//		manejadorEdicion mE =manejadorEdicion.getInstancia();
//		EdicionCurso edicion= mE.buscarEdicion(nomEdicion);
//		List<Docente> docentes = edicion.getDocentes();
//		String[] docente_ret = new String[docentes.size()];
//		int i=0;
//		for (Docente d:docentes) {
//			docente_ret[i]=d.getNick();
//			i++;
//		}
//		return docente_ret; 
//	}
//	
	public String[] listarDocentesInstituto(String nomInstituto) {
		manejadorInstituto mI = manejadorInstituto.getInstancia();
		Instituto inst = mI.buscarInstituto(nomInstituto);
		List<Docente> docentes = inst.getDocentes();
		String[] docentes_ret = new String[docentes.size()] ;
		int i=0;
		for(Docente d:docentes) {
			docentes_ret[i]=d.getNick();
			i++;
		}
		return docentes_ret;
	}


	public String[] listarInstitutos() {
			manejadorInstituto mi = manejadorInstituto.getInstancia();
			List<Instituto> listIn = mi.getInstituto();
			String[] institutos = new String[listIn.size()];
			int i = 0;
			for(Instituto ins : listIn) {
				institutos[i] = ins.getNombre();
				i++;
			}
			return institutos;
	}

	@Override
	public String[] listarDocentesAux(String nomEdicion) {
		// TODO Auto-generated method stub
		return null;
	}
}
