package main.webapp.WebContent.servlets;

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

/**
 * Servlet implementation class consultaCurso
 */
@WebServlet("/consultaCurso")
public class consultaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultaCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe consulta en forma de Instituto o Categoria
		
		String curso = request.getParameter("curso");
		
		DTCurso dtc = null;
		
		try {
			dtc = icon.verInfo(curso);
			//previas y categorias no se precisan
			String fechaR = format.format(dtc.getFechaR());
			ArrayList<String> ediciones = dtc.getEdiciones();
			ArrayList<String> programas = dtc.getProgramas();
			//ArrayList<String> previas = dtc.getPrevias();
			//ArrayList<String> categorias = dtc.getCategorias();
			session.setAttribute("nombre", dtc.getNombre());
			session.setAttribute("descripcion", dtc.getDescripcion());
			session.setAttribute("duracion", dtc.getDuracion());
			session.setAttribute("cantHoras", dtc.getCantHoras());
			session.setAttribute("creditos", dtc.getCreditos());
			session.setAttribute("fechaR", fechaR);
			session.setAttribute("url", dtc.getUrl());
			session.setAttribute("ediciones", ediciones);
			session.setAttribute("programas", programas);
			//session.setAttribute("previas", previas);
			//session.setAttribute("categorias", categorias);
		} catch (CursoExcepcion e) {
			//curso no existe
			e.printStackTrace();
		}
				
		request.getRequestDispatcher("/infoCurso.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}