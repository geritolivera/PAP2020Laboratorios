package main.webapp.WebContent.servlets.consultas;

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
import interfaces.IcontroladorUsuario;
import exepciones.ProgramaFormacionExcepcion;
import datatypes.DTProgramaFormacion;

/**
 * Servlet implementation class consultaProgramaFormacion
 */
@WebServlet("/consultaProgramaFormacion")
public class consultaProgramaFormacion extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		

		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		IcontroladorUsuario iconu = fab.getIcontroladorUsuario();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe programa desde jsp
		String programa = request.getParameter("programa");
		System.out.println("programa = " + programa);
		String url = "";
		try {
			DTProgramaFormacion dtp = icon.verInfoPrograma(programa);
			String fechaInicio = format.format(dtp.getFechaI());
			String fechaFin = format.format(dtp.getFechaF());
			String fechaA = format.format(dtp.getFechaA());
			ArrayList<String> cursos = dtp.getCursos();
			ArrayList<String> categorias = dtp.getCategorias();
			url = dtp.getImagenURL();
			request.setAttribute("tituloPrograma", dtp.getNombre());
			request.setAttribute("desc", dtp.getDescripcion());
			request.setAttribute("fechaInicio", fechaInicio);
			request.setAttribute("fechaFin", fechaFin);
			request.setAttribute("fechaA", fechaA);
			request.setAttribute("cursos", cursos);
			request.setAttribute("categoriass", categorias);
			request.setAttribute("imagenURL", url);
			Boolean userLog = false;
			if(session.getAttribute("nombreUser") != null) {
				userLog = true;
				String nickLog = (String) session.getAttribute("nombreUser");
				if(session.getAttribute("tipoUser").equals("estudiante")) {
					Boolean inscripto = iconu.inscriptoPF(nickLog, programa);
					request.setAttribute("inscripto", inscripto);
				}
			}
			request.setAttribute("userLog", userLog);

		} catch (ProgramaFormacionExcepcion e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/infoPrograma.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}