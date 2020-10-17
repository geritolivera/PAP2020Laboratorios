package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtClase;
import datatypes.DtSocio;
import interfaces.fabrica;
import servlets.RequestDispatcher;
import interfaces.IcontroladorUsuario;

/**
 * Servlet implementation class ModificarDatos
 */
@WebServlet("/ModificarDatos")
public class ModificarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatos() {
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
		// TODO Auto-generated method stub
		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		String nickname  = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		long fechaN = Date.parse(request.getParameter( "fechaNac"));
		Date fechaNaci = new Date(fechaN);
		icon.nuevosDatos(nickname, nombre, apellido, fechaNaci);
		
		if (request.getParameter("boton").equals("nombre")){
			
			request.setAttribute("nombre", nombre);
		}else if (request.getParameter("boton").equals("apellido")) {

			request.setAttribute("apellido", apellido);
		}else
		
			
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/modificarDatosUsuario.jsp");
		rd.forward(request, response);
		doGet(request, response);
	}

}
