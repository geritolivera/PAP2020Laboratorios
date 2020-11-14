package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.lang.Exception;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.*;


@WebServlet("/inscripcionUE")
public class inscripcionUsuarioEdicion extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
		ControladorUsuarioPublishService cup2 = new ControladorUsuarioPublishServiceLocator();

		HttpSession session = request.getSession();
		Date fecha = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		String nickUsuario = (String) session.getAttribute("nombreUser");
		String nomEdicion = request.getParameter("edicion");
		DTResponse respuesta = new DTResponse();


		try {
			ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
			ControladorUsuarioPublish port2 = cup2.getcontroladorUsuarioPublishPort();
			port.inscribirEstudianteEdicion(nomEdicion, nickUsuario, cal);
			ArrayList<String> ediciones = new ArrayList<>();
			DtEdicionCurso[] edis = ((DtEstudiante)port2.verInfoUsuario(nickUsuario)).getEdiciones();
			for (DtEdicionCurso dec:edis) {
				ediciones.add(dec.getNombre());
			}
			session.setAttribute("edicionesNombres", ediciones);
			respuesta.setCodigo(0);
			respuesta.setMensaje("El usuario " + nickUsuario + " se inscribio a "+ nomEdicion+ " correctamente");
			request.setAttribute("mensaje", "El usuario " + nickUsuario + " se inscribio a "+ nomEdicion+ " correctamente");
		} catch (Exception e) {
			System.out.println("e.getMessage() = " + e.getMessage());
			respuesta.setCodigo(1);
			respuesta.setMensaje("El usuario " + nickUsuario + " ya esta inscripto a "+ nomEdicion);
			//algo no existe lol
			e.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
		String inscriStr = mapper.writeValueAsString(respuesta);
		System.out.println("La respuesta generada es: " + inscriStr);

		response.setContentType("application/json");
		response.getWriter().append(inscriStr);
	}
}