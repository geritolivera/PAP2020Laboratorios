package main.webapp.WebContent.servlets.altas;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;


@WebServlet("/crearUsuario")
public class crearUsuario extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todo lo que se obtiene del frontend va en comillas
		DTResponse respuesta = new DTResponse();
        //datos del usuario
		String nickname = request.getParameter("nickName");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String url = request.getParameter("imagen");
		String tipoUser =request.getParameter("tipoUser");
		String instituto = null;
		if (!request.getParameter("tipoUser").equals("docente")){
			instituto = request.getParameter("institutos");
		}

		//cambia la string a un date
		long fN = Date.parse(request.getParameter( "fechaN"));
		Date fechaNac = new Date(fN);
		Date todayDate = Calendar.getInstance().getTime();
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();

		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaNac);
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				if(nickname.equals("") || nombre.equals("") || apellido.equals("") || correo.equals("") || password.equals("")) {
					respuesta.setCodigo(1);
					respuesta.setMensaje("No puede haber campos vacios");
					request.setAttribute("mensaje", "No puede haber campos vacios");
				} if(!correo.contains("@")) {
					respuesta.setCodigo(1);
					respuesta.setMensaje("Debe ingresar una direccion de correo valida");
					request.setAttribute("mensaje", "Debe ingresar una direccion de correo valida");
				}else if(fechaNac.compareTo(todayDate) > 0){
					respuesta.setCodigo(1);
					respuesta.setMensaje("Debe ingresar una fecha de nacimiento valida");
					request.setAttribute("mensaje", "Debe ingresar una fecha de nacimiento valida");
				}else if(request.getParameter("tipoUser").equals("docente") && instituto.equals("")){
					respuesta.setCodigo(1);
					respuesta.setMensaje("Debe ingresar un instituto para dara de alta a un Docente");
					request.setAttribute("mensaje", "Debe ingresar un instituto para dara de alta a un Docente");
				} else if(tipoUser.equals("")){
					respuesta.setCodigo(1);
					respuesta.setMensaje("Debe ingresar un tipo de Usuario");
					request.setAttribute("mensaje", "Debe ingresar un tipo de Usuario");
				} else {
					port.altaUsuario(nickname, nombre, apellido, correo, cal, instituto, password, url);
					respuesta.setCodigo(0);
					respuesta.setMensaje("El usuario " + nickname + " se ha ingresado correctamente en el sistema.");
					request.setAttribute("mensaje", "El usuario " + nickname + " se ha ingresado correctamente en el sistema.");
				}
			} catch (publicadores.UsuarioExcepcion e1) {
				System.out.println("UsuarioExcepcion");
				respuesta.setCodigo(1);
				respuesta.setMensaje("El nickname ingresado ya existe");
				e1.printStackTrace();
			} catch (RemoteException e1) {
				System.out.println("RemoteExcepcion");
				e1.printStackTrace();
			}

		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
        String usuarioStr = mapper.writeValueAsString(respuesta);
        response.setContentType("application/json");
        response.getWriter().append(usuarioStr);

	}
}
