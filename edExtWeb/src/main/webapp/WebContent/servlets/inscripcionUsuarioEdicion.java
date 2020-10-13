package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import clases.EdicionCurso;
import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import main.webapp.WebContent.resources.dataType.DTResponse;

/**
 * Servlet implementation class inscripcionUsuarioEdicion
 */
@WebServlet("/inscripcionUE")
public class inscripcionUsuarioEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscripcionUsuarioEdicion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		HttpSession session = request.getSession();
		Date fecha = new Date();		
		//String nickUsuario = (String) session.getAttribute("nombreUser");
		String nickUsuario = "kurt";
		String nomEdicion = request.getParameter("edicion");

		DTResponse respuesta = new DTResponse();


		try {
			icon.inscribirEstudianteEdicion(nomEdicion, nickUsuario, fecha);
			respuesta.setCodigo(0);
			respuesta.setMensaje("El usuario " + nickUsuario + " se inscribio a "+ nomEdicion+ " correctamente");
			request.setAttribute("mensaje", "El usuario " + nickUsuario + " se inscribio a "+ nomEdicion+ " correctamente");
		} catch (Exception e) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("El usuario " + nickUsuario + " ya esta inscripto a "+ nomEdicion);
			//algo no existe lol
			e.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
		String inscriStr = mapper.writeValueAsString(respuesta);
		System.out.println("La respuesta generada es: " + inscriStr);

		response.setContentType("application/json");
		response.getWriter().append(inscriStr);
	}
}