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

import exepciones.UsuarioExcepcion;
import interfaces.fabrica;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import interfaces.IcontroladorUsuario;

/**
 * Servlet implementation class ModificarDatos
 */
@WebServlet("/ModificarDatos")
public class ModificarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entro aca");
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//fabrica fab = fabrica.getInstancia();
		//IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		HttpSession session = request.getSession(false);
		String nickname  = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		System.out.println(request.getParameter( "fechaNacimiento"));
		long fN = Date.parse(request.getParameter( "fechaNacimiento"));
		Date fechaNaci = new Date(fN);
		System.out.println(fechaNaci);
		System.out.println(nickname);
		DTResponse respuesta = new DTResponse();
		try {
			//TODO poner excepcion en publicador
			nuevosDatos(nickname, nombre, apellido, fechaNaci);
			session.setAttribute("nombre", nombre);
			session.setAttribute("apellido", apellido);
			session.setAttribute("fechaNac", fechaNaci);
			respuesta.setCodigo(0);
			respuesta.setMensaje("El usuario " + nickname + " se ha modificado correctamente en el sistema.");
			request.setAttribute("mensaje", "El usuario " + nickname + " se ha modificado correctamente en el sistema.");
		} catch (UsuarioExcepcion e) {
			respuesta.setCodigo(1);
			respuesta.setMensaje(e.getMessage());
			respuesta.setElemento("nickName");
			request.setAttribute("mensaje", "No se pudieron modificar los datos.");
			e.printStackTrace();
		}
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
			} catch (RemoteException e) {
				System.out.println("RemoteExcepcion");
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
		}
	}

}
