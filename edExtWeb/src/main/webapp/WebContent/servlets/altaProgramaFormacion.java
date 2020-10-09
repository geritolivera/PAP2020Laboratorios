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
import java.util.Date;

import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import exepciones.ProgramaFormacionExcepcion;

/**
 * Servlet implementation class altaProgramaFormacion
 */
@WebServlet("/altaProgramaFormacion")
public class altaProgramaFormacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaProgramaFormacion() {
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
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//datos del programa
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("desc");
		//String imagen = request.getParameter("imagen");
		Date fechaI = null;
		Date fechaF = null;
		Date fechaA = new Date();
		//fecha inicio
		try {
			fechaI = format.parse(request.getParameter("fechaInicio"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		//fecha fin
		try {
			fechaF = format.parse(request.getParameter("fechaFin"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}	
		//tipoUser
		try {
			icon.crearProgramaFormacion(nombre, descripcion, fechaI, fechaF, fechaA);
			request.setAttribute("mensaje", "El programa de formacion " + nombre + " se ha ingresado correctamente en el sistema.");
		} catch (ProgramaFormacionExcepcion e) {
			request.setAttribute("mensaje", "El programa de formacion " + nombre + " ya existe en el sistema.");
			e.printStackTrace();
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
}