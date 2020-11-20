package main.webapp.WebContent.servlets.altas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;

@WebServlet("/ValidarNickname")
public class ValidarNickname extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickName");
		//System.out.println(nickname);
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		DTResponse respuesta = new DTResponse();
		
		if (!nickname.equals("")) {
		
			try {
				ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();

				boolean valido = port.validarNick(nickname);
				if (valido){
					respuesta.setCodigo(0);
					respuesta.setMensaje("Valido!");
				}else {
					respuesta.setCodigo(1);
					respuesta.setMensaje("Nickname ya tomado!");
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

}
