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

import interfaces.fabrica;
import interfaces.IcontroladorCurso;

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
		System.out.println("Entre al inscripcion");
		HttpSession session = request.getSession();
		Date fecha = new Date();		
		//String nickUsuario = (String) session.getAttribute("nombreUser");
		String nickUsuario = "camilo";
		String nomEdicion = request.getParameter("edicion");
		System.out.println("nom edicion: " + nomEdicion);
		System.out.println("nickUsuario: " + nickUsuario);
		
		try {
			icon.inscribirEstudianteEdicion(nomEdicion, nickUsuario, fecha);
		} catch (Exception e) {
			//algo no existe lol
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		/*RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);*/
	}
}