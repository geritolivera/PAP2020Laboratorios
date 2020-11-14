package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import publicadores.*;


@WebServlet("/consultaCurso")
public class consultaCurso extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		String curso = request.getParameter("curso");
		HttpSession session = request.getSession(false);
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		String url = "";
		ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
		ControladorUsuarioPublishService cup2 = new ControladorUsuarioPublishServiceLocator();
		//recibe consulta en forma de Instituto o Categoria
		
		DtCurso dtc = new DtCurso();

		try {
			ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
			ControladorUsuarioPublish port2 = cup2.getcontroladorUsuarioPublishPort();
			dtc = port.verInfo(curso);
			//previas y categorias no se precisan
			String fechaR = format.format(dtc.getFechaR());
			String[] ediciones = dtc.getEdiciones();
			String[] programas = dtc.getProgramas();
			String[] previas = dtc.getPrevias();
			String[] categorias = dtc.getCategorias();
			request.setAttribute("nombre", dtc.getNombre());
			request.setAttribute("descripcion", dtc.getDescripcion());
			request.setAttribute("duracion", dtc.getDuracion());
			request.setAttribute("cantHoras", dtc.getCantHoras());
			request.setAttribute("creditos", dtc.getCreditos());
			request.setAttribute("fechaR", fechaR);
			request.setAttribute("url", dtc.getUrl());
			request.setAttribute("imagenURL", dtc.getImagenURL());
			request.setAttribute("ediciones", ediciones);
			request.setAttribute("programas", programas);
			request.setAttribute("previas", previas);
			request.setAttribute("categorias", categorias);
		} catch (CursoExcepcion e) {
			//curso no existe
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		if (dtc!= null) {
			request.getRequestDispatcher("/infoCurso.jsp").forward(request, response);
		}else{
			System.out.println("dtc (si null algo paso atras) = " + dtc );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}