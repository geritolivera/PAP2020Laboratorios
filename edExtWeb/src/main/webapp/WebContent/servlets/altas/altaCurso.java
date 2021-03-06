package main.webapp.WebContent.servlets.altas;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;
import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import exepciones.CursoExcepcion;
import exepciones.InstitutoExcepcion;

/**
 * Servlet implementation class altaCurso
 */
@WebServlet("/altaCurso")
public class altaCurso extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DTResponse respuesta = new DTResponse();
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();

		//datos del curso
		//SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("desc");
		String duracion = request.getParameter("duracion");
		System.out.println("duracion: " + request.getParameter("duracion"));
		System.out.println("cant horas: " + request.getParameter("cantHoras"));
		System.out.println("CREDITOS: " + request.getParameter("creditos"));

		String imagen = request.getParameter("imagen");
		Integer cantHoras = Integer.parseInt(request.getParameter("cantHoras"));
		Integer creditos = Integer.parseInt(request.getParameter("creditos"));
		Date fechaR = new Date();
		String url = request.getParameter("url");
		String instituto = request.getParameter("instituto");
		//getParameterValues se usa para sacar un array de strings
		String[] previas = request.getParameter("previas").split(",");
		String[] categorias = request.getParameter("categorias").split(",");

		System.out.println("previas = " + previas.toString());
		System.out.println("categorias = " + categorias.toString());
		
		ArrayList<String> listPrevias = new ArrayList<>();
		for(String s: previas) {
			listPrevias.add(s);
		}
		ArrayList<String> listCategorias = new ArrayList<>();
		for(String su: categorias) {
			listCategorias.add(su);
		}
		
		if(nombre.equals("") || descripcion.equals("") || url.equals("") || duracion.equals("0") || cantHoras == 0 || creditos == 0) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("No puede haber campos vacios");
			request.setAttribute("mensaje", "No puede haber campos vacios");
		} else if(instituto.equals("")){
			respuesta.setCodigo(1);
			respuesta.setMensaje("Debe ingresar un instituto para dar de alta a un Curso");
			request.setAttribute("mensaje", "Debe ingresar un instituto para dar de alta a un Curso");
		} else if(listCategorias.contains("")){
			respuesta.setCodigo(1);
			respuesta.setMensaje("Debe ingresar al menos una categoria para dar de alta a un Curso");
			request.setAttribute("mensaje", "Debe ingresar al menos una categoria para dar de alta a un Curso");
		} else if(!url.contains("www") || !url.contains(".com")){
			respuesta.setCodigo(1);
			respuesta.setMensaje("Debe ingresar una URL valida para dar de alta a un Curso");
			request.setAttribute("mensaje", "Debe ingresar una URL valida para dar de alta a un Curso");
		} else {
			try {
				icon.AltaCurso(nombre, descripcion, duracion, cantHoras, creditos, fechaR, url, instituto, listPrevias, listCategorias, imagen);
				request.setAttribute("mensaje", "El curso " + nombre + " se ha ingresado correctamente en el sistema.");
				respuesta.setCodigo(0);
				respuesta.setMensaje("El curso " + nombre + " se ha ingresado correctamente en el sistema");
			} catch (CursoExcepcion e) {
				request.setAttribute("mensaje", "El curso de nombre " + nombre + " ya existe en el sistema.");
				respuesta.setCodigo(1);
				respuesta.setMensaje("El curso " + nombre + " ya existe en el sistema");
				respuesta.setElemento("nombre");
				e.printStackTrace();
			} catch (InstitutoExcepcion e) {
				request.setAttribute("mensaje", "El instituto de nombre " + instituto + " no existe en el sistema.");
				respuesta.setCodigo(1);
				respuesta.setMensaje("El instituto " + instituto + " no existe en el sistema");
				respuesta.setElemento("instituto");
				e.printStackTrace();
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String cursoStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(cursoStr);
	}
}