package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;
import datatypes.DTUsuario;
import datatypes.DTEstudiante;
import datatypes.DTDocente;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;

/**
 * Servlet implementation class consultaUsuario
 */
@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = request.getSession();
		String nickname = request.getParameter("nickname");
		DTUsuario dtu = new DTUsuario();
		try {
			dtu = icon.verInfoUsuario(nickname);
			if(dtu instanceof DTDocente) {
				session.setAttribute("tipoUser", "docente");
				String userStr = mapper.writeValueAsString(dtu);
				System.out.println(session.getAttribute("tipoUser"));
				System.out.println("La respuesta generada es: " + userStr);

				response.setContentType("application/json");
				response.getWriter().append(userStr);

			} else {
				session.setAttribute("tipoUser", "estudiante");
				String userStr = mapper.writeValueAsString(dtu);
				System.out.println("La respuesta generada es: " + userStr);

				response.setContentType("application/json");
				response.getWriter().append(userStr);

			}

		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
}