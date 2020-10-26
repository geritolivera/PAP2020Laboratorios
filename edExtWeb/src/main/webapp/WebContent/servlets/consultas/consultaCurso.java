package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import datatypes.*;
import exepciones.CursoExcepcion;
import interfaces.fabrica;
import interfaces.*;


@WebServlet("/consultaCurso")
public class consultaCurso extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe consulta en forma de Instituto o Categoria
		
		String curso = request.getParameter("curso");
		System.out.println("curso = |" + curso);
		DTCurso dtc = new DTCurso();

		try {
			dtc = icon.verInfo(curso);
			//previas y categorias no se precisan
			String fechaR = format.format(dtc.getFechaR());
			ArrayList<String> ediciones = dtc.getEdiciones();
			ArrayList<String> programas = dtc.getProgramas();
			ArrayList<String> previas = dtc.getPrevias();
			ArrayList<String> categorias = dtc.getCategorias();
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