

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public GetListas() {
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
		fabrica fabrica = interfaces.fabrica.getInstancia();
		IcontroladorCurso icon = fabrica.getIcontroladorCurso();
		java.util.ArrayList<String> categorias= icon.listarCategorias();
		request.setAttribute("categorias", categorias);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("infoPrograma.jsp");
		rd.forward(request, response);
	}

}
