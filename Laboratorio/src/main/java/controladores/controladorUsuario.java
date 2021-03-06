package controladores;

import clases.*;
import conexion.Conexion;
import datatypes.*;
import exepciones.*;
import interfaces.IcontroladorUsuario;
import manejadores.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class controladorUsuario implements IcontroladorUsuario {
	public controladorUsuario() {
		super();
	}


	/*-------------------------------------------------------------------------------------------------------------*/
	//Alta de Usuario
	@Override
	public void AltaUsuario(String nickname, String nombre, String apellido, String correo, Date fechaNac, String instituto, String password, String url) throws UsuarioExcepcion {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		manejadorInstituto mIns = manejadorInstituto.getInstancia();
		if (!mUsu.existeUsuarioNick(nickname)) {
			if (!this.existeCorreoUsuario(correo)) {
				//si la string instituto no tiene nada
				if (instituto == null) {
					Estudiante est = new Estudiante(nickname, nombre, apellido, correo, fechaNac, password);
					est.setImagenUrl(url);
					mUsu.agregarUsuario(est);

				} else {
					if (mIns.existeInstituto(instituto)) {
						Conexion con = Conexion.getInstancia();
						EntityManager em = con.getEntityManager();
						Docente doc = new Docente(nickname, nombre, apellido, correo, fechaNac, password);
						doc.setImagenUrl(url);
						Instituto ins = mIns.buscarInstituto(instituto);
						//aniade tambien el docente al instituto
						doc.setInstituto(ins);
						mUsu.agregarUsuario(doc);
						//persiste al instituto
						//es posible que sea innecesario. se mando pregunta al profe
						em.getTransaction().begin();
						em.persist(ins);
						em.getTransaction().commit();
					}
				}
			} else
				throw new UsuarioExcepcion("El correo " + correo + " ya existe en el sistema.");
		} else
			throw new UsuarioExcepcion("El Nickname '" + nickname + "' ya existe en el sistema");
	}



	/*-------------------------------------------------------------------------------------------------------------*/
	//2 - Consulta de Usuario

	public ArrayList<String> listarUsuarios() {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		List<Usuario> usuarios =(List<Usuario>) mUsu.getUsuarios();
		ArrayList<String> listUsers = new ArrayList<>();
		for (Usuario u : usuarios) {
			listUsers.add(u.getNick());
		}
		return listUsers;
	}

	@Override
	public DTUsuario verInfoUsuario(String nickname) throws UsuarioExcepcion {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		DTUsuario dtu = new DTUsuario();
		if (mUsu.existeUsuarioNick(nickname)) {
			Usuario u = mUsu.buscarUsuarioNickname(nickname);
			dtu = new DTUsuario(u);
			List<EdicionCurso> edicionesDoc = new ArrayList<EdicionCurso>();
			List<InscripcionED> inscripcionesEDEst = new ArrayList<>();
			List<InscripcionPF> inscripcionesPFEst = new ArrayList<>();
			//si el usuario es docente
			if (u instanceof Docente) {
				edicionesDoc = ((Docente) u).getEdiciones();
				DTDocente dtd = new DTDocente(dtu);
				for (EdicionCurso e : edicionesDoc) {
					DTEdicionCurso dted = new DTEdicionCurso(e);
					dtd.agregarEdicion(dted);
				}
				return dtd;
			}
			//si el usuario es estudiante
			else {
				DTEstudiante dte = new DTEstudiante(dtu);
				//tiene que sacar el DTEdicion desde las inscripciones
				inscripcionesEDEst = ((Estudiante) u).getInscripcionesED();
				for (InscripcionED i : inscripcionesEDEst) {
					if(i.getEstado().equals(InscripcionEnum.ACEPTADO)) {
						DTEdicionCurso dtee = new DTEdicionCurso(i.getEdicion());
						dte.agregarEdicion(dtee);
					}
				}
				inscripcionesPFEst = ((Estudiante) u).getInscripcionesPF();
				for (InscripcionPF i: inscripcionesPFEst) {
					DTProgramaFormacion dtpe = new DTProgramaFormacion(i.getPrograma());
					dte.agregarPrograma(dtpe);
				}
				return dte;
			}
		} else
			throw new UsuarioExcepcion("El usuario " + nickname + " no existe.");
	}


	/*-------------------------------------------------------------------------------------------------------------*/
	//3 - Modificar Datos de Usuario

	//usa listarUsuarios
	//usa verInfoUsuario
	@Override
	public void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci)throws UsuarioExcepcion {
		manejadorUsuario mu = manejadorUsuario.getInstancia();
		if (mu.existeUsuarioNick(nickname)) {
			Conexion con = Conexion.getInstancia();
			EntityManager em = con.getEntityManager();
			Usuario u = mu.buscarUsuarioNickname(nickname);
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setFechaNac(fechaNaci);
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}
		else
			throw new UsuarioExcepcion("No existe el usuario " + nickname + "en el sistema.");
	}

	/*-------------------------------------------------------------------------------------------------------------*/
	//12 - Alta de Instituto
	@Override
	public void AltaInstituto(String nombre) throws InstitutoExcepcion {
		manejadorInstituto mi = manejadorInstituto.getInstancia();
		if (mi.existeInstituto(nombre)) {
			throw new InstitutoExcepcion("El Instituto con el nombre " + nombre + " ya existe en el Sistema");
		} else {
			Instituto i = new Instituto(nombre);
			mi.agregarInstituto(i);
		}
	}

	/*-------------------------------------------------------------------------------------------------------------*/
	//Funciones auxiliares

	@Override //Lista los DT Usuarios
	public List<DTUsuario> listarDTUsuarios() {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		List<Usuario> usuarios = mUsu.getUsuarios();
		List<DTUsuario> listUsers = new ArrayList<DTUsuario>();
		for (Usuario u : usuarios) {
			DTUsuario dt = new DTUsuario(u);
			listUsers.add(dt);
		}
		return listUsers;
	}

	@Override
	public boolean existeCorreoUsuario(String correo) {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		boolean encontre = false;
		List<Usuario> usuarios =(List<Usuario>) mUsu.getUsuarios();
		for (Usuario u : usuarios) {
			if (u.getCorreo() != null) {
				if (u.getCorreo().equals(correo))
					encontre = true;
			}
		}
		return encontre;
	}


	@Override //Lista los nombres de los institutos
	public String[] listarInstituto() {
		manejadorInstituto mi = manejadorInstituto.getInstancia();
		List<Instituto> listIn = mi.getInstituto();
		String[] listIns = new String[listIn.size()];
		Integer i = 0;
		if (!listIn.isEmpty()) {
			for (Instituto s : listIn) {
				listIns[i] = s.getNombre();
				i++;
			}
		}
		return listIns;
	}


	@Override //Lista los nicknames de los estudiantes
	public String[] listarEstudiantesAux() {
		manejadorUsuario mU = manejadorUsuario.getInstancia();
		List<Usuario> listUs = mU.getUsuarios();
		String[] estudiantes = new String[listUs.size()];//ver esta funcion
		int i = 0;
		for (Usuario us : listUs) {
			if (us instanceof Estudiante) {
				estudiantes[i] = us.getNick();
				i++;
			}
		}
		return estudiantes;
	}

	/*-------------------------------------------------------------------------------------------------------------*/
	//13 - Alta de Categoria
	@Override
	public void AltaCategoria(String nombre) throws CategoriaExcepcion {
		manejadorCategoria mc = manejadorCategoria.getInstancia();
		if (mc.existeCategoria(nombre)) {
			throw new CategoriaExcepcion("La Categoria con el nombre " + " ya existe en el Sistema");
		} else {
			Categoria c = new Categoria(nombre);
			mc.agregarCategoria(c);
		}
	}


	//Validad login usuario
	@Override
	public boolean validarUsuario(String nickname, String password) throws UsuarioExcepcion {
		manejadorUsuario mUsu = manejadorUsuario.getInstancia();
		if (mUsu.existeUsuarioNick(nickname)) {
			Usuario user = mUsu.buscarUsuario(nickname);
			if (user.getPassword().equals(password))
				return true;
			else
				return false;
		} else
			throw new UsuarioExcepcion("El usuario " + nickname + " no existe en el sistema.");
	}
	
	/*-------------------------------------------------------------------------------------------------------------*/
	//Seguir y dejar de seguir users
	@Override
	public void dejarDeSeguir(String nickname, String nicknameSeguido) {
		manejadorUsuario mU = manejadorUsuario.getInstancia();
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		if(mU.existeUsuarioNick(nickname) && mU.existeUsuarioNick(nicknameSeguido)) {
			Usuario currentUser = mU.buscarUsuarioNickname(nickname);
			Usuario dejarSeguir = mU.buscarUsuarioNickname(nicknameSeguido);
			currentUser.removerSigue(dejarSeguir);
			em.getTransaction().begin();
			em.persist(currentUser);
			em.getTransaction().commit();
		}
	}
	
	@Override
    public void comenzarSeguir(String nickname, String nicknameSeguir) {
		manejadorUsuario mU = manejadorUsuario.getInstancia();
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		if(mU.existeUsuarioNick(nickname) && mU.existeUsuarioNick(nicknameSeguir)) {
			Usuario currentUser = mU.buscarUsuarioNickname(nickname);
			Usuario userSeguir = mU.buscarUsuarioNickname(nicknameSeguir);
			currentUser.agregarSigue(userSeguir);
			em.getTransaction().begin();
			em.persist(currentUser);
			em.getTransaction().commit();
		}
    }
	
	@Override
    public ArrayList<String> listarSeguidores(String nickname){
    	ArrayList<String> seguidores = new ArrayList<String>();
		manejadorUsuario mU = manejadorUsuario.getInstancia();
		if(mU.existeUsuarioNick(nickname)) {
			Usuario currentUser = mU.buscarUsuarioNickname(nickname);
			List<Usuario> usuariosSeguidores = currentUser.getSeguidores();
			for(Usuario u : usuariosSeguidores) {
				DTUsuario dtU = new DTUsuario(u);
				seguidores.add(dtU.getNick());
			}
		}
		return seguidores;
    }
	
    @Override
    public ArrayList<String> listarSeguidos(String nickname){
    	ArrayList<String> sigue = new ArrayList<String>();
		manejadorUsuario mU = manejadorUsuario.getInstancia();
		if(mU.existeUsuarioNick(nickname)) {
			Usuario currentUser = mU.buscarUsuarioNickname(nickname);
			List<Usuario> usuariosSigue = currentUser.getSigue();
			for(Usuario u : usuariosSigue) {
				DTUsuario dtU = new DTUsuario(u);
				sigue.add(dtU.getNick());
			}
		}
		return sigue;
    }
    
    @Override
    public boolean validarSigue(String nickname, String nicknameSigue) {
    	manejadorUsuario mU = manejadorUsuario.getInstancia();
		if(mU.existeUsuarioNick(nickname) && mU.existeUsuarioNick(nicknameSigue)) {
			Usuario currentUser = mU.buscarUsuarioNickname(nickname);
			List<Usuario> usuariosSigue = currentUser.getSigue();
			for(Usuario u : usuariosSigue) {
				if(u.getNick().equals(nicknameSigue)) {
					return true;
				}
			}
		}
		return false;
    }
    
    @Override
    public boolean validarSeguidor(String nickname, String nicknameSguidor) {
    	manejadorUsuario mU = manejadorUsuario.getInstancia();
		if(mU.existeUsuarioNick(nickname) && mU.existeUsuarioNick(nicknameSguidor)) {
			Usuario currentUser = mU.buscarUsuarioNickname(nickname);
			List<Usuario> usuariosSeguidores = currentUser.getSeguidores();
			for(Usuario u : usuariosSeguidores) {
				if(nicknameSguidor.contains(u.getNick())) {
					return true;
				}
			}
		}
		return false;
    }
    
    @Override
    public boolean inscriptoPF(String nickname, String nomPrograma) {
    	manejadorUsuario mUsu = manejadorUsuario.getInstancia();
    	Usuario user = mUsu.buscarUsuario(nickname);
    	List<InscripcionPF> inscripciones = ((Estudiante)user).getInscripcionesPF();
    	Boolean inscripto = false;
    	for(InscripcionPF i: inscripciones) {
    		if(i.getNombrePrograma().equals(nomPrograma))
    			inscripto = true;
    	}
    	return inscripto;
    }
    
    @Override
    public String inscriptoED(String nickname, String nomEdicion) {
    	manejadorUsuario mUsu = manejadorUsuario.getInstancia();
    	Usuario user = mUsu.buscarUsuario(nickname);
    	List<InscripcionED> inscripciones = ((Estudiante)user).getInscripcionesED();
    	String inscripto = "No";
    	for(InscripcionED i: inscripciones) {
    		if(i.getNombreEdicion().equals(nomEdicion))
    			inscripto = i.getEstadoString();
    	}
    	return inscripto;
    }
    
    @Override
    public List<DTInscripcionED> listarInscripcionesED(String nomEdicion){
    	manejadorInscripcionED mIns = manejadorInscripcionED.getInstancia();
    	List<InscripcionED> inscripciones = mIns.getInscripciones();
    	List<DTInscripcionED> listIns = new ArrayList<>();
    	for(InscripcionED i: inscripciones) {
    		if(!nomEdicion.equals("undefined")) {
	    		if(i.getNombreEdicion().equals(nomEdicion)) {
	    		//if(i.getEstado() == InscripcionEnum.PENDIENTE) {
		    		DTInscripcionED dti = new DTInscripcionED(i);
		    		listIns.add(dti);
	    		}
    		}
    		else {
    			DTInscripcionED dti = new DTInscripcionED(i);
	    		listIns.add(dti);
    		}
    	}
    	return listIns;
    }
    
    @Override
    public void cambiarInscripcion(String cambio, String nomEdicion, String nomUsuario) {
    	manejadorInscripcionED mIns = manejadorInscripcionED.getInstancia();
    	Conexion con = Conexion.getInstancia();
    	EntityManager em = con.getEntityManager();
    	List<InscripcionED> inscripciones = mIns.getInscripciones();
    	for(InscripcionED i: inscripciones) {
    		if(nomEdicion.equals(i.getNombreEdicion()) && nomUsuario.equals(i.getNickUsuario()) && i.getEstado() == InscripcionEnum.PENDIENTE) {
	    		if(cambio.equals("aceptar"))
	    			i.setEstado(InscripcionEnum.ACEPTADO);
	    		else
	    			i.setEstado(InscripcionEnum.RECHAZADO);
	    		em.getTransaction().begin();
	    		em.persist(i);
	    		em.getTransaction().commit();
    		}
    	}
    }
}