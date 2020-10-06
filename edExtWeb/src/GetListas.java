

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter out = response.getWriter();
		fabrica fabrica = interfaces.fabrica.getInstancia();
		IcontroladorCurso icon = fabrica.getIcontroladorCurso();
		String tipo = (String) request.getAttribute("tipo");
		/*if(tipo.equals("institutos")) {
			java.util.ArrayList<String> institutos = icon.listarInstitutos();
			request.setAttribute("institutos", institutos);
			for (String s : institutos){ 
				out.print("<li class='collection-item'>>"+s+"</li>");
			 }
		}*/
		if(tipo.equals("categoria")) {
			java.util.ArrayList<String> categorias= icon.listarCategorias();
			request.setAttribute("categorias", categorias);
			for (String s : categorias){ 
				out.print("<li class='collection-item'>>"+s+"</li>");
			}
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("altaCurso.jsp");
		rd.forward(request, response);
	}
}