package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.rmi.RemoteException;

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
import publicadores.DtUsuario;


@WebServlet("/dejarSeguirUsuario")
public class dejarSeguirUsuario extends HttpServlet {
	DTResponse respuesta = new DTResponse();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DTResponse respuesta = new DTResponse();

		HttpSession session = request.getSession();
		String nickUsuario = (String) session.getAttribute("nombreUser");
		String dejarSeguirNickname = request.getParameter("nicknameDejarSeguir");

		if(validarSigue(nickUsuario, dejarSeguirNickname)) {
			dejarDeSeguir(nickUsuario, dejarSeguirNickname);
			respuesta.setCodigo(0);
			respuesta.setMensaje("El usuario " + nickUsuario + " dejo de seguir al usuario " + dejarSeguirNickname + ".");
			session.setAttribute("seguidos", verInfoUsuario(nickUsuario).getSeguidos());
		}else{
			respuesta.setCodigo(1);
			respuesta.setMensaje("El usuario " + nickUsuario + " no sigue a " + dejarSeguirNickname + ".");
		}
		ObjectMapper mapper = new ObjectMapper();
		String programaStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(programaStr);
	}
	
	public boolean validarSigue(String nickname, String dejarSeguirNickname) {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.validarSigue(nickname, dejarSeguirNickname);
			} catch (RemoteException e) {
				System.out.println("RemoteExcepcion");
				e.printStackTrace();
				return false;
			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
			return false;
		}
	}
	
	public void dejarDeSeguir(String nickname, String dejarSeguirNickname) {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				port.dejarDeSeguir(nickname, dejarSeguirNickname);
				respuesta.setCodigo(0);
				respuesta.setMensaje("El usuario " + nickname + " ha dejado de seguir a " + dejarSeguirNickname + ".");

			} catch (RemoteException e) {
				System.out.println("RemoteExcepcion");
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
		}
	}
	
	public DtUsuario verInfoUsuario(String nickname){
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.verInfoUsuario(nickname);
			} catch (publicadores.UsuarioExcepcion e1) {
				System.out.println("UsuarioExcepcion");
				e1.printStackTrace();
				return null;
			} catch (RemoteException e1) {
				System.out.println("RemoteExcepcion");
				e1.printStackTrace();
				return null;
			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
			return null;
		}
	}

}
