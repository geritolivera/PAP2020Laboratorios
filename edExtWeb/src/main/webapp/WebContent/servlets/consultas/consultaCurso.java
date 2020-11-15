package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		System.out.println("curso = " + curso);
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		String url = "";
		ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
		//recibe consulta en forma de Instituto o Categoria
		try {
			System.out.println("entra aca");
			ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
			DtCurso dtc = port.verInfo(curso);
			System.out.println(dtc.getFechaR().toString());
			Calendar fechaR = dtc.getFechaR();
			String Fr = format.format(fechaR.getTime());
			System.out.println("Fr = " + Fr);

			String[] ediciones = dtc.getEdiciones();
			String[] programas = dtc.getProgramas();
			String[] previas = dtc.getPrevias();
			String[] categorias = dtc.getCategorias();
			request.setAttribute("nombre", dtc.getNombre());
			request.setAttribute("descripcion", dtc.getDescripcion());
			request.setAttribute("duracion", dtc.getDuracion());
			request.setAttribute("cantHoras", dtc.getCantHoras());
			request.setAttribute("creditos", dtc.getCreditos());
			request.setAttribute("fechaR", Fr);
			request.setAttribute("url", dtc.getUrl());
			request.setAttribute("imagenURL", dtc.getImagenURL());
			request.setAttribute("ediciones", ediciones);
			request.setAttribute("programas", programas);
			request.setAttribute("previas", previas);
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("/infoCurso.jsp").forward(request, response);
		} catch (CursoExcepcion e) {
			System.out.println("e.getMessage() = " + e.getMessage());
			System.out.println("Se rompe aca curso ex");
			e.printStackTrace();
		} catch (ServiceException e) {
			System.out.println("e.getMessage() = " + e.getMessage());
			System.out.println("Se rompe aca service ex");
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}