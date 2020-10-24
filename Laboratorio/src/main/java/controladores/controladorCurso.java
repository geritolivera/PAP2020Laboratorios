package controladores;

import conexion.Conexion;
import clases.*;
import datatypes.*;
import exepciones.*;
import interfaces.*;
import manejadores.*;

import javax.persistence.EntityManager;
import java.util.*;

public class controladorCurso implements IcontroladorCurso{
	public controladorCurso() {
		super();
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//4 - Alta de Curso
	@Override
	public void AltaCurso(String nombre, String descripcion, String duracion, int cantHoras, int creditos, Date fechaR, String url, String instituto, ArrayList<String> previas,  ArrayList<String> cats, String imagen) throws CursoExcepcion, InstitutoExcepcion{
		manejadorCurso mc = manejadorCurso.getInstancia();
		manejadorCategoria mcat = manejadorCategoria.getInstancia();
		manejadorInstituto mI = manejadorInstituto.getInstancia();
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		if(mc.existeCurso(nombre))
			throw new CursoExcepcion("La clase de Nombre " + nombre + "ya existe dentro del Sistema.");
		else {
			if(mI.existeInstituto(instituto)){
				Instituto I = mI.buscarInstituto(instituto);
				Curso cursoNuevo = new Curso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, url, I);
				//se fija si hay previas antes de ingresarlas
				if (!previas.isEmpty()){
					for (String s : previas) {
						//System.out.println(s);
						Curso previa = mc.buscarCurso(s);
						cursoNuevo.agregarPrevias(previa);
					}
				}
				if (!cats.isEmpty()){
					for (String cat : cats) {
						//System.out.println(s);
						Categoria c = mcat.buscarCategoria(cat);
						cursoNuevo.agregarCategoria(c);
					}
				}
				cursoNuevo.setImagenUrl(imagen);
				mc.agregarCurso(cursoNuevo);
				I.agregarCurso(cursoNuevo);
				//persiste el nuevo docente agregado al instituto
				em.getTransaction().begin();
				em.persist(I);
				em.getTransaction().commit();
			}
			else
				throw new InstitutoExcepcion("El instituto " + instituto + "no existe");
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//5 - Consulta de Curso
	@Override
	public ArrayList<String> listarCursosInst(String nombreInstituto) throws InstitutoExcepcion{
		manejadorInstituto mInst = manejadorInstituto.getInstancia(); 
		if(mInst.existeInstituto(nombreInstituto)) {
			Instituto inst = mInst.buscarInstituto(nombreInstituto);
			List<Curso> cursos = inst.getCursos();
			ArrayList<String> listCursos = new ArrayList<String>();
			for(Curso c:cursos) {
				listCursos.add(c.getNombre());
			}
			return listCursos;
		}
		else
			throw new InstitutoExcepcion("El instituto " + nombreInstituto + " no existe.");
	}
	
	@Override
	public ArrayList<String> listarCursosCat(String nombreCategoria) throws CategoriaExcepcion{
		manejadorCategoria mCat = manejadorCategoria.getInstancia(); 
		if(mCat.existeCategoria(nombreCategoria)) {
			Categoria cat = mCat.buscarCategoria(nombreCategoria);
			List<Curso> cursos = cat.getCursos();
			ArrayList<String> listCursos = new ArrayList<String>();
			for(Curso c:cursos) {
				listCursos.add(c.getNombre());
			}
			return listCursos;
		}
		else
			throw new CategoriaExcepcion("El instituto " + nombreCategoria + " no existe.");
	}
	
	@Override
	public DTCurso verInfo(String nomCurso) throws CursoExcepcion{
		manejadorCurso mCur = manejadorCurso.getInstancia();
		List<EdicionCurso> ediciones = new ArrayList<>();
		List<ProgramaFormacion> programas = new ArrayList<>();
		List<Curso> previas = new ArrayList<>();
		List<Categoria> categorias = new ArrayList<>();
		if(mCur.existeCurso(nomCurso)) {
			Curso c = mCur.buscarCurso(nomCurso);
			DTCurso dtc = new DTCurso(c);
			System.out.println("dtc.toString() = " + dtc.toString());
			ediciones = c.getEdiciones();
			programas = c.getProgramas();
			previas = c.getPrevias();
			categorias = c.getCategorias();
			//son listas, no requieren informacion de las ediciones o programas
			if(!ediciones.isEmpty()) {
				for (EdicionCurso e : ediciones) {
					dtc.agregarEdicion(e.getNombre());
				}
			}
			if(!programas.isEmpty()) {
				for (ProgramaFormacion p : programas) {
					dtc.agregarPrograma(p.getNombre());
				}
			}
			if (!previas.isEmpty()) {
				for (Curso cur : previas) {
					dtc.agregarPrevia(cur.getNombre());
				}
			}
			if(!categorias.isEmpty()) {
				for (Categoria cat : categorias) {
					dtc.agregarCat(cat.getNombre());
				}
			}
			
			return dtc;
		}
		else
			throw new CursoExcepcion("El curso " + nomCurso + " no existe.");
	}
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//6 - Alta de Edicion de Curso
	@Override
	public void nuevosDatosEdicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub, String nomCurso, ArrayList<String> docentes, String url) throws EdicionExcepcion{
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorCurso mCur = manejadorCurso.getInstancia();
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		if(mEdi.existeEdicion(nombre)) {
			throw new EdicionExcepcion("La edicion de Nombre " + nombre + "ya existe dentro del Sistema");
		}
		else {
			if(mCur.existeCurso(nomCurso)) {
				Curso curso = mCur.buscarCurso(nomCurso);
				EdicionCurso edi = new EdicionCurso(nombre, fechaI, fechaF, cupo, fechaPub, curso);
				edi.setImagenURL(url);
				//se fija que haya docentes para ingresar
				if(!docentes.isEmpty()) {
					for(String s: docentes) {
						Docente d = (Docente) mUsu.buscarUsuario(s);
						if(!d.toString().isEmpty()) {
							edi.agregarDocente(d);
						}
					}
				}
				else
					throw new EdicionExcepcion("Tiene que ingresar docentes.");
				mEdi.agregarEdicion(edi);
				curso.agregarEdicion(edi);
				em.getTransaction().begin();
				em.persist(curso);
				em.getTransaction().commit();
			}
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//7 - Consulta de Edicion de Curso
	@Override
	public ArrayList<String> listarEdiciones(String nomCurso) throws CursoExcepcion{
		manejadorCurso mCur = manejadorCurso.getInstancia();
		if(mCur.existeCurso(nomCurso)) {
			Curso cur = mCur.buscarCurso(nomCurso);
			List<EdicionCurso> ediciones = cur.getEdiciones();
			ArrayList<String> listEdiciones = new ArrayList<>();
			for (EdicionCurso e:ediciones) {
				listEdiciones.add(e.getNombre());
			}
			return listEdiciones;	
		}
		else
			throw new CursoExcepcion("El curso " + nomCurso + " no existe.");
	}
	
	//Obtiene el DT de la edicion de curso
	@Override
	public DTEdicionCurso verInfoEdicion(String nomEdicion) throws EdicionExcepcion{
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		if(mEdi.existeEdicion(nomEdicion)) {
			EdicionCurso edi = mEdi.buscarEdicion(nomEdicion);
			DTEdicionCurso dte = new DTEdicionCurso(edi);
			return dte;
		}
		else
			throw new EdicionExcepcion("La edicion " + nomEdicion + " no existe en el sistema.");
	}
		 
	/*-------------------------------------------------------------------------------------------------------------*/
	//8 - Inscripcion a Edicion de Curso
	@Override
	public DTEdicionCurso mostrarEdicionVigente(String nomCurso) throws CursoExcepcion {
		manejadorCurso mCur = manejadorCurso.getInstancia();
		Date today = Calendar.getInstance().getTime();
		boolean vigente = false;
		if(mCur.existeCurso(nomCurso)){
			Curso c = mCur.buscarCurso(nomCurso);
			List<EdicionCurso> ediciones = c.getEdiciones();
			DTEdicionCurso dte = new DTEdicionCurso();
			for(EdicionCurso e: ediciones) {
				if (e.getFechaF().after(today)) {
					dte.setEdicionCurso(e);
					vigente = true;
					break;
				}
			}
			if(vigente)
				return dte;
			else
				throw new CursoExcepcion("No hay edicion vigente para curso " + nomCurso + ".");
		}
		else
			throw new CursoExcepcion("No existe el curso " + nomCurso);
	}
	
	@Override
	public void inscribirEstudianteEdicion(String nomEdicion, String nickUsuario, Date fecha) throws Exception {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		Boolean yaInscripto = false;
		if(mUsu.existeUsuarioNick(nickUsuario)) {
			Usuario u = mUsu.buscarUsuarioNickname(nickUsuario);
			List<InscripcionED> listIns = ((Estudiante)u).getInscripcionesED();
			for(InscripcionED s : listIns) {
				if(s.getEdicion().getNombre().equals(nomEdicion) && s.getEstado() != InscripcionEnum.RECHAZADO)
					yaInscripto = true;
			}
			if(!yaInscripto){
				System.out.println("No está inscripto en la edicion");
				if (mEdi.existeEdicion(nomEdicion)) {
					if (u instanceof Estudiante) {
						EdicionCurso e = mEdi.buscarEdicion(nomEdicion);
						((Estudiante) u).agregarInscripcionED(fecha, e);
						em.getTransaction().begin();
						em.persist(u);
						em.getTransaction().commit();
					} else
						throw new UsuarioExcepcion("El usuario " + nickUsuario + " no es un estudiante");
				} else
					throw new EdicionExcepcion("No existe edicion " + nomEdicion);
			}else{
				System.out.println("Está inscripto en la edicion");
				throw new Exception("El usuario ya esta inscripto en esta edicion");
			}
		}
		else
			throw new UsuarioExcepcion("No existe usuario " + nickUsuario);
	}

	
	@Override
	public void inscribirEstudiantePrograma(String nomPrograma, String nickUsuario, Date fecha) throws Exception{
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		Boolean yaInscripto = false;
		if(mUsu.existeUsuarioNick(nickUsuario)) {
			Usuario user = mUsu.buscarUsuario(nickUsuario);
			List<InscripcionPF> listIns = ((Estudiante)user).getInscripcionesPF();
			for(InscripcionPF s: listIns) {
				if(s.getPrograma().getNombre().equals(nomPrograma))
					yaInscripto = true;
			}
			if (!yaInscripto) {
				if (mPro.existePrograma(nomPrograma)) {
					if (user instanceof Estudiante) {
						ProgramaFormacion p = mPro.buscarPrograma(nomPrograma);
						((Estudiante)user).agregarInscripcionPF(fecha, p);
						em.getTransaction().begin();
						em.persist(user);
						em.getTransaction().commit();
					} else
						throw new UsuarioExcepcion("El usuario " + nickUsuario + " no es un estudiante");
				} else
					throw new EdicionExcepcion("No existe programa " + nomPrograma);
			}else
				throw new Exception("El usuario ya esta inscripto en esta edicion");
		}
		else
			throw new UsuarioExcepcion("No existe usuario " + nickUsuario);
	}

	/*-------------------------------------------------------------------------------------------------------------*/
	//9 - Crear Programa de Formacion
	@Override
	public void crearProgramaFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fActual, String url) throws ProgramaFormacionExcepcion{
		manejadorPrograma mpf = manejadorPrograma.getInstancia();
		mpf.existePrograma(nombre);
		ProgramaFormacion nuevoProg = new ProgramaFormacion(nombre, descripcion, fechaI, fechaF, fActual);
		nuevoProg.setImagenURL(url);
		mpf.agregarPrograma(nuevoProg);

	}
			
	/*-------------------------------------------------------------------------------------------------------------*/
	//10 - Agregar Curso a Programa de Formacion
	@Override
	public ArrayList<String> listarProgramas(){
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		List<ProgramaFormacion> programas = mPro.getProgramas();
		ArrayList<String> listProgramas = new ArrayList<String>();
		for(ProgramaFormacion p: programas) {
			listProgramas.add(p.getNombre());
		}
		return listProgramas;
	}
	
	@Override
	public ArrayList<String> listarCursos(){
		manejadorCurso mCur = manejadorCurso.getInstancia();
		List<Curso> cursos = mCur.getCursos();
		ArrayList<String> listCursos = new ArrayList<>();
		for(Curso c: cursos) {
			listCursos.add(c.getNombre());
		}
		if (listCursos.size()>0)
			return listCursos;
		else {
			listCursos.add("Sin resultados");
			return listCursos;
		}

	}
	
	@Override
	public void agregarCursoPrograma(String nomCur, String nomP) throws ProgramaFormacionExcepcion, CursoExcepcion{
		manejadorCurso mCur = manejadorCurso.getInstancia();
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		boolean existe = false;
		if(mCur.existeCurso(nomCur)) {
			if(mPro.existePrograma(nomP)) {
				Curso c = mCur.buscarCurso(nomCur);
				ProgramaFormacion p = mPro.buscarPrograma(nomP);
				List<Curso> cursos = p.getCursos();
				for(Curso cur: cursos) {
					if(cur.getNombre().equals(c.getNombre()))
						existe = true;
				}
				if(!existe) {
					p.agregarCurso(c);
					c.agregarPrograma(p);
					//persiste curso y programa
					em.getTransaction().begin();
					em.persist(c);
					em.persist(p);
					em.getTransaction().commit();
				}
				else
					throw new ProgramaFormacionExcepcion("El programa " + nomP + " ya tiene el curso " + nomCur + ".");
			}
			else
				throw new ProgramaFormacionExcepcion("El programa " + nomP + " no existe.");
		}
		else
			throw new CursoExcepcion("El curso " + nomCur + "no existe.");
	}
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//11 - Consulta de Programa de Formacion	
	@Override
	public DTProgramaFormacion verInfoPrograma(String nombreProg) throws ProgramaFormacionExcepcion{
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		if(mPro.existePrograma(nombreProg)) {
			ProgramaFormacion p = mPro.buscarPrograma(nombreProg);
			List<Curso> cursos = p.getCursos();
			DTProgramaFormacion dt = new DTProgramaFormacion(p);
			for(Curso c:cursos) {
				dt.agregarCurso(c.getNombre());
				List<Categoria> categorias = c.getCategorias();
				for(Categoria cat: categorias) {
					if(!dt.existeCategoria(cat.getNombre())) {
						dt.agregarCategoria(cat.getNombre());
					}
				}
			}
			return dt;
		}
		else
			throw new ProgramaFormacionExcepcion("El programa " + nombreProg + " no existe.");
	}
	
	@Override
	public ArrayList<String> getCategoriasPrograma(String nombreProg) {
		manejadorPrograma mPro = manejadorPrograma.getInstancia();
		if(mPro.existePrograma(nombreProg)) {
			ProgramaFormacion p = mPro.buscarPrograma(nombreProg);
			List<Curso> cursos = p.getCursos();
			ArrayList<String> listaCat= new  ArrayList<String>();
			for(Curso c:cursos) {
				List<Categoria> categorias = c.getCategorias();
				for(Categoria cat: categorias) {
					if(!listaCat.contains(cat.getNombre()))
						listaCat.add(cat.getNombre());
				}
			}
			return listaCat;
		}
		return null;
	}
		
	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones Auxiliares
	@Override //Listados para comboBoxes
	public ArrayList<String> listarCursosAux(String nombreInstituto){
		manejadorCurso mC = manejadorCurso.getInstancia();
		List<Curso> cursos =(List<Curso>) mC.getCursos();
		ArrayList<String>cursosRet = new ArrayList<>();
		for(Curso c : cursos) {
			if((c.getInstituto().getNombre()!= null)&&(c.getInstituto().getNombre().equals(nombreInstituto))) {
				cursosRet.add(c.getNombre());
			}
		}
		return cursosRet;
	}

	@Override
	public ArrayList<String> listarEdicionesAux(String nomCurso) {
		manejadorEdicion mE = manejadorEdicion.getInstancia();
		List<EdicionCurso> ediciones =(List<EdicionCurso>) mE.getEdiciones();
		ArrayList<String> ediciones_ret = new ArrayList<String>();
		for (EdicionCurso e:ediciones) {
			if(e.getCurso().getNombre().equals(nomCurso))
			ediciones_ret.add(e.getNombre());
		}
		return ediciones_ret;
	}

	@Override
	public ArrayList<String> listarDocentesInstituto(String nomInstituto) {
		manejadorUsuario mu = manejadorUsuario.getInstancia();
		List<Usuario> listaUsuario = (List<Usuario>) mu.getUsuarios();
		ArrayList<String> docentes = new ArrayList<String>();
		for(Usuario u : listaUsuario) {
			if(u instanceof Docente) {
				if(((Docente) u).getInstituto() != null) {
					if(((Docente) u).getInstituto().getNombre().equals(nomInstituto)) {
						docentes.add(u.getNick());
					}
				}
			}
		}
		return docentes;
	}

	@Override
	public String[] listarInstitutos() {
		manejadorInstituto mi = manejadorInstituto.getInstancia();
		List<Instituto> listIn = mi.getInstituto();
		String[] listIns = new String[listIn.size()];
		Integer i = 0;
		if(!listIn.isEmpty()) {
			for (Instituto s: listIn) {
				listIns[i] = s.getNombre();
				i++;
			}
		}
		return listIns;
	}

	@Override
	public ArrayList<String> listarDocentesAux(String nomEdicion) {
		manejadorEdicion mEdi = manejadorEdicion.getInstancia();
		EdicionCurso e = mEdi.buscarEdicion(nomEdicion);
		List<Docente> docentes = e.getDocentes();
		ArrayList<String> listDoc = new ArrayList<String>();
		for(Docente d:docentes) {
			listDoc.add(d.getNombre());
		}
		return listDoc;
	}
	
	@Override //Lista todos los Estudiantes
	public ArrayList<String> listarEstudiantes(){
		manejadorUsuario mu = manejadorUsuario.getInstancia();
		List<Usuario> listaUsuario = (List<Usuario>) mu.getUsuarios();
		ArrayList<String> estudiantes = new ArrayList<String>();
		for(Usuario u : listaUsuario) {
			if(u instanceof Estudiante) {
				String nombreE = ((Estudiante) u).getNick();
				estudiantes.add(nombreE);
			}
		}
		return estudiantes;
	}
	
	@Override
	public ArrayList<String> listarCategorias(){
		manejadorCategoria mc = manejadorCategoria.getInstancia();
		List<Categoria> listaCategoria = mc.getCategorias();
		ArrayList<String> categorias = new ArrayList<String>();
		for(Categoria c : listaCategoria) {
			categorias.add(c.getNombre());
		}
		return categorias;
	}

	@Override
	public ArrayList<DTCurso> listaDTCurso(){
		manejadorCurso mc = manejadorCurso.getInstancia();
		List<Curso> cursos = mc.getCursos();
		ArrayList<DTCurso> retorno = new ArrayList<>();
		for (Curso c:cursos) {
			DTCurso dtc = new DTCurso(c);
			retorno.add(dtc);
		}
		return retorno;

	}

	@Override
	public ArrayList<DTProgramaFormacion> listaDTPrograma(){
		manejadorPrograma mp = manejadorPrograma.getInstancia();
		List<ProgramaFormacion> programas = mp.getProgramas();
		ArrayList<DTProgramaFormacion> retorno = new ArrayList<>();
		for (ProgramaFormacion p:programas) {
			DTProgramaFormacion dtpf = new DTProgramaFormacion(p);
			retorno.add(dtpf);
		}
		return retorno;

	}


}
