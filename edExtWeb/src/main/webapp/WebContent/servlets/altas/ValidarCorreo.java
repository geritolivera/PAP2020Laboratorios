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

/**
 * Servlet implementation class ValidarCorreo
 */
@WebServlet("/ValidarCorreo")
public class ValidarCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarCorreo() {
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
		String correo = request.getParameter("email");
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		DTResponse respuesta = new DTResponse();
		
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			
			boolean valido = port.validarCorreo(correo);
			if (!valido){
				respuesta.setCodigo(0);
				respuesta.setMensaje("Valido!");
			}else {
				respuesta.setCodigo(1);
				respuesta.setMensaje("Correo ya tomado!");
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
