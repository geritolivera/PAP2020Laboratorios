package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;

/**
 * Servlet implementation class GetListas
 */
@WebServlet("/GetCursos")
public class GetCursos extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	fabrica fabrica = interfaces.fabrica.getInstancia();
	IcontroladorCurso icon = fabrica.getIcontroladorCurso();
	String[] institutos = icon.listarInstitutos();

	public GetCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		try {
			java.util.ArrayList<String> cursos = icon.listarCursos();
			session.setAttribute("cursosagregar", cursos);
			ObjectMapper mapper = new ObjectMapper();
			String cursosStr = mapper.writeValueAsString(cursos);
			response.setContentType("application/json");
			response.getWriter().append(cursosStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}