package main.webapp.WebContent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import exepciones.UsuarioExcepcion;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import main.webapp.WebContent.resources.dataType.DTResponse;


@WebServlet("/dejarSeguirUsuario")
public class dejarSeguirUsuario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DTResponse respuesta = new DTResponse();
		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario iconU = fab.getIcontroladorUsuario();
		
		HttpSession session = request.getSession();
		String nickUsuario = (String) session.getAttribute("nombreUser");
		String dejarSeguirNickname = request.getParameter("nicknameDejarSeguir");
		System.out.println(nickUsuario + " quiere dejar de seguir a " + dejarSeguirNickname);
		System.out.println(nickUsuario + "sigue a " + dejarSeguirNickname+  " ?: " + iconU.validarSigue(nickUsuario, dejarSeguirNickname));
		if(iconU.validarSigue(nickUsuario, dejarSeguirNickname)) {
			iconU.dejarDeSeguir(nickUsuario, dejarSeguirNickname);
			try {
				session.setAttribute("seguidos", iconU.verInfoUsuario(nickUsuario).getSeguidos());
			} catch (UsuarioExcepcion usuarioExcepcion) {
				usuarioExcepcion.printStackTrace();
			}
			respuesta.setCodigo(0);
			respuesta.setMensaje("El usuario " + nickUsuario + " ha dejado de seguir a " + dejarSeguirNickname + ".");
			request.setAttribute("mensaje", "El usuario " + nickUsuario + " ha dejado de seguir a " + dejarSeguirNickname + ".");
		}else{
			respuesta.setCodigo(1);
			respuesta.setMensaje("El usuario " + nickUsuario + " no sigue a " + dejarSeguirNickname + ".");
		}
		ObjectMapper mapper = new ObjectMapper();
		String programaStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(programaStr);
	}

}
