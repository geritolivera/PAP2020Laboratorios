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
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;


@WebServlet("/inscripcionConfirmar")
public class inscripcionConfirmar extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		ControladorUsuarioPublish port;
		try {
			port = cup.getcontroladorUsuarioPublishPort();
			String edicion = request.getParameter("edicion");
			String usuario = request.getParameter("usuario");
			String action = request.getParameter("action");
			DTResponse respuesta = new DTResponse();
			//int index = Integer.parseInt(indReq);
			System.out.println("edicion: " + edicion);
			System.out.println("usuario: " + usuario);
			System.out.println("action: " + action);
			if(action.equals("aceptar")) {
				port.cambiarInscripcion(action, edicion, usuario);
				respuesta.setCodigo(0);
				respuesta.setMensaje("La inscripcion ha sido aceptada");
			}else{
				port.cambiarInscripcion(action, edicion, usuario);
				respuesta.setCodigo(1);
				respuesta.setMensaje("La inscripcion ha sido rechazada");
			}
			ObjectMapper mapper = new ObjectMapper();
			String respuestaStr = mapper.writeValueAsString(respuesta);
			response.setContentType("application/json");
			response.getWriter().append(respuestaStr);
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
		}
	}
}