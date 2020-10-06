package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import exepciones.ProgramaFormacionExcepcion;
import datatypes.DTProgramaFormacion;

/**
 * Servlet implementation class altaUsuario
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe programa desde jsp
		String programa = request.getParameter("programa");
		
		DTProgramaFormacion dtp = null;
		try {
			dtp = icon.verInfoPrograma(programa);
			//request.setAttribute("mensaje", "El programa " + programa + " se ha ingresado correctamente en el sistema.");
		} catch (ProgramaFormacionExcepcion e) {
			//request.setAttribute("mensaje", "El programa " + programa + " se ha ingresado correctamente en el sistema.");
			e.printStackTrace();
		}
				
		String fechaInicio = format.format(dtp.getFechaI());
		String fechaFin = format.format(dtp.getFechaF());
		String fechaActual = format.format(dtp.getFechaA());
		ArrayList<String> categorias = dtp.getCategorias();
		
		request.setAttribute("nombre", dtp.getNombre());
		request.setAttribute("descripcion", dtp.getDescripcion());
		request.setAttribute("fechaI", fechaInicio);
		request.setAttribute("fechaF", fechaFin);
		request.setAttribute("fechaA", fechaActual);
		request.setAttribute("cursos", dtp.getCursos());
		request.setAttribute("categorias", categorias);
				
		RequestDispatcher rd;
		//rd = request.getRequestDispatcher("/notificacion.jsp");
		rd = request.getRequestDispatcher("/infoPrograma.jsp");
		rd.forward(request, response);
	}
}