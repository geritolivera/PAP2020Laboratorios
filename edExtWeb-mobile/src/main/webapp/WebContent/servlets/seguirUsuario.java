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
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import publicadores.DtUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/seguirUsuario")
public class seguirUsuario extends HttpServlet {
	DTResponse respuesta = new DTResponse();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		String nickUsuario = (String) session.getAttribute("nombreUser");
		System.out.println("nickUsuario = " + nickUsuario);
		String aSeguirNickname = request.getParameter("nicknameSeguir");
		System.out.println("aSeguirNickname = " + aSeguirNickname);

		if(validarSigue(nickUsuario, aSeguirNickname)){
			respuesta.setCodigo(1);
			respuesta.setMensaje("El usuario " + nickUsuario + " ya sigue " + aSeguirNickname + ".");
		}else {
			comenzarSeguir(nickUsuario, aSeguirNickname);
			DtUsuario usu = verInfoUsuario(nickUsuario);
			session.setAttribute("seguidos", usu.getSeguidos());

		}
		ObjectMapper mapper = new ObjectMapper();
		String programaStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(programaStr);
	}
	
	public boolean validarSigue(String nickname, String nicknameSigue) {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.validarSigue(nickname, nicknameSigue);
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
	
	public void comenzarSeguir(String nickname, String nicknameSigue) {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				port.comenazarSeguir(nickname, nicknameSigue);
				respuesta.setCodigo(0);
				respuesta.setMensaje("El usuario " + nickname + " ha comenzado a seguir a " + nicknameSigue + ".");
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
			} catch (publicadores.UsuarioExcepcion e) {
				System.out.println("UsuarioExcepcion");
				e.printStackTrace();
				return null;
			} catch (RemoteException e) {
				System.out.println("RemoteExcepcion");
				e.printStackTrace();
				return null;
			}
		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
			return null;
		}
	}

}
