package main.webapp.WebContent.servlets.Gets;

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
	fabrica fabrica = interfaces.fabrica.getInstancia();
	IcontroladorCurso icon = fabrica.getIcontroladorCurso();
	java.util.ArrayList<String> cursos = icon.listarCursos();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			request.setAttribute("cursosagregar", cursos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		String cursosStr = mapper.writeValueAsString(cursos);
		response.setContentType("application/json");
		response.getWriter().append(cursosStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}