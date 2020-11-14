package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;


@WebServlet("/ModificarDatos")
public class ModificarDatos extends HttpServlet {
	DTResponse respuesta = new DTResponse();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entro aca");
		HttpSession session = request.getSession(false);
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		String nickname  = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		System.out.println(request.getParameter( "fechaNacimiento"));
		long fN = Date.parse(request.getParameter( "fechaNacimiento"));
		Date fechaNaci = new Date(fN);
		System.out.println(fechaNaci);
		System.out.println(nickname);
		nuevosDatos(nickname, nombre, apellido, fechaNaci);
		session.setAttribute("nombre", nombre);
		session.setAttribute("apellido", apellido);
		session.setAttribute("fechaNac", fechaNaci);

		ObjectMapper mapper = new ObjectMapper();
		String usuarioStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(usuarioStr);
	}
	
	public void nuevosDatos(String nickname, String nombre, String apellido, Date fechaNaci) {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		Calendar cal = Calendar.getInstance();
    	cal.setTime(fechaNaci);
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				port.nuevosDatos(nickname, nombre, apellido, cal);
				respuesta.setCodigo(0);
				respuesta.setMensaje("El usuario " + nickname + " se ha modificado correctamente en el sistema.");
			} catch (publicadores.UsuarioExcepcion e1) {
				System.out.println("UsuarioExcepcion");
				respuesta.setCodigo(1);
				respuesta.setMensaje(e1.getMessage());
				e1.printStackTrace();
			} catch (RemoteException e1) {
				System.out.println("RemoteExcepcion");
				e1.printStackTrace();
			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
		}
	}

}
