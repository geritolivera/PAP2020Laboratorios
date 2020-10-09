package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.Enumeration;

import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import exepciones.ProgramaFormacionExcepcion;
import datatypes.DTProgramaFormacion;

/**
 * Servlet implementation class consultaProgramaFormacion
 */
@WebServlet("/consultaProgramaFormacion")
public class consultaProgramaFormacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultaProgramaFormacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe programa desde jsp
		String programa = request.getParameter("programa");

		try {
			DTProgramaFormacion dtp = icon.verInfoPrograma(programa);
			String fechaInicio = format.format(dtp.getFechaI());
			String fechaFin = format.format(dtp.getFechaF());
			String fechaActual = format.format(dtp.getFechaA());
			ArrayList<String> categorias = dtp.getCategorias();
			session.setAttribute("tituloPrograma", dtp.getNombre());
			session.setAttribute("desc", dtp.getDescripcion());
			session.setAttribute("fechaInicio", fechaInicio);
			session.setAttribute("fechaFin", fechaFin);
			session.setAttribute("fechaA", fechaActual);
			session.setAttribute("cursos", dtp.getCursos());
			session.setAttribute("categorias", categorias);
			session.setAttribute("imagenURL", "resources/images/asd.jpg");



		} catch (ProgramaFormacionExcepcion e) {

			e.printStackTrace();
		}

		request.getRequestDispatcher("/infoPrograma.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}