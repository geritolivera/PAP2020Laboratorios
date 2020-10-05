package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;

/**
 * Servlet implementation class altaUsuario
 */
@WebServlet("/altaUsuario")
public class altaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaUsuario() {
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
		IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//todo lo que se obtiene del frontend va en comillas
		//datos del usuario
		String nick = request.getParameter("nickName");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("email");
		String passwd = request.getParameter("password");
		//cambia la string a un date
		Date fechaNac = null;
		try {
			fechaNac = format.parse(request.getParameter("fechaNacimiento"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}		
		//tipoUser
		String instituto = null;
		if (request.getParameter("tipoUser").equals("docente"))
			instituto = request.getParameter("instituto");
		try {
			icon.AltaUsuario(nick, nombre, apellido, correo, fechaNac, instituto, passwd);
			request.setAttribute("mensaje", "El usuario " + nick + " se ha ingresado correctamente en el sistema.");
		} catch (UsuarioExcepcion e) {
			request.setAttribute("mensaje", "El usuario de nickname " + nick + " ya existe en el sistema.");
			e.printStackTrace();
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
}