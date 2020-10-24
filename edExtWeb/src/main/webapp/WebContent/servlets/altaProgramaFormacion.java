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
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import exepciones.ProgramaFormacionExcepcion;
import main.webapp.WebContent.resources.dataType.DTResponse;

/**
 * Servlet implementation class altaProgramaFormacion
 */
@WebServlet("/altaProgramaFormacion")
public class altaProgramaFormacion extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//datos del programa
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("desc");
		DTResponse respuesta = new DTResponse();

		//String imagen = request.getParameter("imagen");
		long fI = Date.parse(request.getParameter( "fechaI"));
		Date fechaI = new Date(fI);
		long fF = Date.parse(request.getParameter( "fechaF"));
		Date fechaF = new Date(fF);
		Date fechaA = Calendar.getInstance().getTime();
		
		if(nombre.equals("") || descripcion.equals("")) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("No puede haber campos vacios");
			request.setAttribute("mensaje", "No puede haber campos vacios");		
		}else if(fechaA.compareTo(fechaF) > 0){
			respuesta.setCodigo(1);
			respuesta.setMensaje("Ingresar una fecha de fin valida");
			request.setAttribute("mensaje", "Ingresar una fecha de fin valida");	
		} else if(fechaF.before(fechaI)){
			respuesta.setCodigo(1);
			respuesta.setMensaje("La fecha de inicio debe ser previa a la de finalizacion\"");
			request.setAttribute("mensaje", "La fecha de inicio debe ser previa a la de finalizacion\"");
		} else {		
			try {
				icon.crearProgramaFormacion(nombre, descripcion, fechaI, fechaF, fechaA);
				respuesta.setCodigo(0);
				respuesta.setMensaje("El programa " + nombre + " se ha ingresado correctamente en el sistema.");
				request.setAttribute("mensaje", "El programa de formacion " + nombre + " se ha ingresado correctamente en el sistema.");
			} catch (ProgramaFormacionExcepcion e) {
				respuesta.setCodigo(1);
				respuesta.setMensaje("El programa  " + nombre + " ya existe en el sistema.");
				request.setAttribute("mensaje", "El programa de formacion " + nombre + " ya existe en el sistema.");
				e.printStackTrace();
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String programaStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(programaStr);
	}
}