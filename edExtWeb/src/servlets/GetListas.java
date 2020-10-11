package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.IcontroladorCurso;
import interfaces.fabrica;

/**
 * Servlet implementation class GetListas
 */
@WebServlet("/GetListas")
public class GetListas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	fabrica fabrica = interfaces.fabrica.getInstancia();
	IcontroladorCurso icon = fabrica.getIcontroladorCurso();
	String[] institutos = icon.listarInstitutos();

	public GetListas() {
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
			String[] institutos = icon.listarInstitutos();
			java.util.ArrayList<String> categorias = icon.listarCategorias();
			java.util.ArrayList<String> previas = icon.listarCursos();
			session.setAttribute("institutos", institutos);
			session.setAttribute("previas", previas);
			session.setAttribute("categorias", categorias);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("altaCurso.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}