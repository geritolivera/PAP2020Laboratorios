package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorCursoPublish;
import publicadores.ControladorCursoPublishService;
import publicadores.ControladorCursoPublishServiceLocator;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import publicadores.DtEstudiante;
import publicadores.DtProgramaFormacion;
import publicadores.DtUsuario;

/**
 * Servlet implementation class inscripcionPrograma
 */
@WebServlet("/inscripcionPrograma")
public class inscripcionPrograma extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Date fecha = Calendar.getInstance().getTime();
		String nickUsuario = (String) session.getAttribute("nombreUser");
		String nomPrograma = request.getParameter("programa");
		System.out.println("nomPrograma = " + nomPrograma);
		System.out.println("nickUsuario = " + nickUsuario);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		DTResponse respuesta = new DTResponse();

		try {
			inscribirEstudiantePrograma(nomPrograma, nickUsuario, cal);
			DtEstudiante usu = (DtEstudiante) verInfoUsuario(nickUsuario);
			respuesta.setCodigo(0);
			ArrayList<String> programas = new ArrayList<>();
			for (DtProgramaFormacion pf:usu.getProgramas()){
				programas.add(pf.getNombre());

			}
			session.setAttribute("programasNombres", programas);
			respuesta.setMensaje("El usuario " + nickUsuario + " se inscribio a " + nomPrograma + " correctamente");
			request.setAttribute("mensaje", "El usuario " + nickUsuario + " se inscribio a " + nomPrograma + " correctamente");
		} catch (Exception e) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("El usuario " + nickUsuario + " ya esta inscripto a " + nomPrograma);
			//algo no existe lol
			e.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
		String inscriStr = mapper.writeValueAsString(respuesta);
		System.out.println("La respuesta generada es: " + inscriStr);

		response.setContentType("application/json");
		response.getWriter().append(inscriStr);
	}
	
	public void inscribirEstudiantePrograma(String nomPrograma, String nickUsuario, Calendar cal) {
		ControladorCursoPublishService ccp = new ControladorCursoPublishServiceLocator();
		try {
			ControladorCursoPublish port = ccp.getcontroladorCursoPublishPort();
			try {
				port.inscribirEstudiantePrograma(nomPrograma, nickUsuario, cal);
			} catch (publicadores.Exception e) {
				System.out.println("ExceptionExcepcion");
				e.printStackTrace();
			} catch (RemoteException e) {
				System.out.println("RemoteExcepcion");
				e.printStackTrace();
			}
		} catch (ServiceException e2) {
			System.out.println("ServiceExcepcion");
			e2.printStackTrace();
		}
	}
	
	public DtUsuario verInfoUsuario(String nickname) {
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
