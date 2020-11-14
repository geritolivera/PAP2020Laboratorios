package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.fabrica;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import publicadores.DtDocente;
import publicadores.DtEdicionCurso;
import publicadores.DtEstudiante;
import publicadores.DtProgramaFormacion;
import publicadores.DtUsuario;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import datatypes.DTUsuario;
import datatypes.DTDocente;
import datatypes.DTEstudiante;

/**
 * Servlet implementation class consultaProgramaFormacion
 */
@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//fabrica fab = fabrica.getInstancia();
		//IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe programa desde jsp
		String nickname = request.getParameter("nickname");
		System.out.println("nickname = " + nickname);
		try {
			DtUsuario dtu = verInfoUsuario(nickname);
			String fechaNac = format.format(dtu.getFechaNac());
			request.setAttribute("nickname", nickname);
			request.setAttribute("nombre", dtu.getNombre());
			request.setAttribute("apellido", dtu.getApellido());
			request.setAttribute("correo", dtu.getCorreo());
			request.setAttribute("fechaNac", fechaNac);
			request.setAttribute("imagenURL", dtu.getImage());
			request.setAttribute("seguidores", dtu.getSeguidores());
			ArrayList<String> seguidos = new ArrayList<>();
			String[] ret = dtu.getSeguidos();
			for(int i = 0; i<ret.length; i++) {
				seguidos.add(ret[i]);
			}
			request.setAttribute("seguidos", seguidos);
			ArrayList<String> ediciones = new ArrayList<>();
			ArrayList<String> programas = new ArrayList<>();
			String tipo;
			if(dtu instanceof DtDocente) {
				DtEdicionCurso[] retDE = ((DtDocente)dtu).getEdiciones();
				for(DtEdicionCurso e: retDE)
					ediciones.add(e.getNombre());
				tipo = "docente";
			}
			else {
				DtEdicionCurso[] retEE = ((DtEstudiante)dtu).getEdiciones();
				for(DtEdicionCurso e: retEE)
					ediciones.add(e.getNombre());
				DtProgramaFormacion[] retEP = ((DtEstudiante)dtu).getProgramas();
				for(DtProgramaFormacion p: retEP)
					programas.add(p.getNombre());
				tipo = "estudiante";
			}
			request.setAttribute("ediciones", ediciones);
			request.setAttribute("programas", programas);
			request.setAttribute("tipo", tipo);
			Boolean userLog = false; //hay un usuario logueado?
			Boolean yaSeguido = false; //el usuario ya sigue al consultado?
			Boolean igualdad = false; //el nickname del usuario logueado es igual al del consultado?
			if(session.getAttribute("nombreUser") != null) {
				userLog = true;
				String nickLog = (String) session.getAttribute("nombreUser"); //nick del user logueado
				if(nickLog.equals(nickname)) //si el usuario se esta consultando a si mismo
					igualdad = true;
				else {
					for(String u: seguidos){
						if(nickname.equals(u))
							yaSeguido = true;
					}
				}
			}
			request.setAttribute("userLog", userLog);
			request.setAttribute("yaSeguido", yaSeguido);
			request.setAttribute("igualdad", igualdad);

			System.out.println("ediciones de  " + nickname + ":" + ediciones);
			System.out.println("programas de  " + nickname + ":" + programas);

		} catch (UsuarioExcepcion e) {

			System.out.println("SE RE LIMO");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/infoUsuarioNUEVO.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public DtUsuario verInfoUsuario(String nickname) throws UsuarioExcepcion{
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.verInfoUsuario(nickname);
			} catch (publicadores.UsuarioExcepcion e) {
				System.out.println("UsuarioExcepcion");
				e.printStackTrace();
				return null;
			} catch (RemoteException e) {
				System.out.println("RemoteExcepcion");
				e.printStackTrace();
				return null;
			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
			return null;
		}
	}
}