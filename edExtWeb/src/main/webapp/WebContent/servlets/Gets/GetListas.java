package main.webapp.WebContent.servlets.Gets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;

@WebServlet("/GetListas")
public class GetListas extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		fabrica fabrica = interfaces.fabrica.getInstancia();
		IcontroladorCurso icon = fabrica.getIcontroladorCurso();
		String[] institutos = icon.listarInstitutos();

		try {
			institutos = icon.listarInstitutos();
			request.setAttribute("institutos", institutos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		String institutoStr = mapper.writeValueAsString(institutos);
		response.setContentType("application/json");
		response.getWriter().append(institutoStr);


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}