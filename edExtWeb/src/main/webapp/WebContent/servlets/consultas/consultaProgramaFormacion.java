package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.Enumeration;
import publicadores.*;

/**
 * Servlet implementation class consultaProgramaFormacion
 */
@WebServlet("/consultaProgramaFormacion")
public class consultaProgramaFormacion extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String programa = request.getParameter("programa");
		HttpSession session = request.getSession(false);
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		String url = "";
		ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
		ControladorUsuarioPublishService cup2 = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
			ControladorUsuarioPublish port2 = cup2.getcontroladorUsuarioPublishPort();
			try {
				DtProgramaFormacion prog = port.verInfoPrograma(programa);
				String fechaInicio = format.format(prog.getFechaI());
				String fechaFin = format.format(prog.getFechaF());
				String fechaA = format.format(prog.getFechaA());
				String[] cursos = prog.getCursos();
				String[] categorias = prog.getCategorias();
				url = prog.getImagenURL();
				request.setAttribute("tituloPrograma", prog.getNombre());
				request.setAttribute("desc", prog.getDescripcion());
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
						Boolean inscripto = port2.inscriptoPF(nickLog, programa);
						request.setAttribute("inscripto", inscripto);
					}
				}
				request.setAttribute("userLog", userLog);

			} catch (publicadores.ProgramaFormacionExcepcion e) {
				System.out.println("ProgramaFormacion");
				e.printStackTrace();

			} catch (RemoteException e) {
				System.out.println("RemoteExcepcion");
				e.printStackTrace();

			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();

		}

		request.getRequestDispatcher("/infoPrograma.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}