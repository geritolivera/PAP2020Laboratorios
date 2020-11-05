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
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import clases.EdicionCurso;
import com.fasterxml.jackson.databind.ObjectMapper;
import datatypes.DTEdicionCurso;
import datatypes.DTEstudiante;
import interfaces.IcontroladorUsuario;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;
import main.webapp.WebContent.resources.dataType.DTResponse;


@WebServlet("/inscripcionConfirmar")
public class inscripcionConfirmar extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario iconu = fab.getIcontroladorUsuario();
		String edicion = request.getParameter("edicion");
		String usuario = request.getParameter("usuario");
		String action = request.getParameter("action");
		DTResponse respuesta = new DTResponse();
		//int index = Integer.parseInt(indReq);
		System.out.println("edicion: " + edicion);
		System.out.println("usuario: " + usuario);
		System.out.println("action: " + action);
		if(action.equals("aceptar")) {
			iconu.cambiarInscripcion(action, edicion, usuario);
			respuesta.setCodigo(0);
			respuesta.setMensaje("La inscripcion ha sido aceptada");
		}else{
			iconu.cambiarInscripcion(action, edicion, usuario);
			respuesta.setCodigo(1);
			respuesta.setMensaje("La inscripcion ha sido rechazada");

		}
		ObjectMapper mapper = new ObjectMapper();
		String respuestaStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(respuestaStr);

	}
}