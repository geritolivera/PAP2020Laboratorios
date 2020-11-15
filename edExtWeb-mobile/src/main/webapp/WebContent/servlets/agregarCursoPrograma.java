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
import java.util.Date;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorCursoPublish;
import publicadores.ControladorCursoPublishService;
import publicadores.ControladorCursoPublishServiceLocator;
import publicadores.CursoExcepcion;
import publicadores.ProgramaFormacionExcepcion;


@WebServlet("/agregarCursoPrograma")
public class agregarCursoPrograma extends HttpServlet {
	DTResponse respuesta = new DTResponse();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomCurso = request.getParameter("curso");
		String nomPrograma = request.getParameter("programa");

		try {
			agregarCursoPrograma(nomCurso, nomPrograma);
			respuesta.setCodigo(0);
			respuesta.setMensaje("El curso " + nomCurso + " fue agregado al programa " + nomPrograma + " correctamente");
			request.setAttribute("mensaje", "El curso " + nomCurso + " fue agregado al programa " + nomPrograma + " correctamente");
		} catch (Exception e) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("El curso " + nomCurso + " ya se encuentra en el programa " + nomPrograma);
			//algo no existe lol
			e.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
		String inscriStr = mapper.writeValueAsString(respuesta);
		System.out.println("La respuesta generada es: " + inscriStr);

		response.setContentType("application/json");
		response.getWriter().append(inscriStr);
	}
	
	public void agregarCursoPrograma(String nomCurso, String nomPrograma) throws ProgramaFormacionExcepcion, CursoExcepcion{
		ControladorCursoPublishService ccp = new ControladorCursoPublishServiceLocator();
		try {
			ControladorCursoPublish port = ccp.getcontroladorCursoPublishPort();
			try {
				port.agregarCursoPrograma(nomCurso, nomPrograma);
			} catch (CursoExcepcion e1) {
				respuesta.setCodigo(1);
				respuesta.setMensaje("El curso " + nomCurso + " ya se encuentra en el programa " + nomPrograma);
				System.out.println("CursoExcepcion");
				e1.printStackTrace();
			} catch (ProgramaFormacionExcepcion e1) {
				System.out.println("ProgramaFormacionExcepcion");
				e1.printStackTrace();
			} catch (RemoteException e1) {
				System.out.println("RemoteExcepcion");
				e1.printStackTrace();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
