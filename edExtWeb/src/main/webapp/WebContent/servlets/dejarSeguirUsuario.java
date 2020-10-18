package main.webapp.WebContent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import main.webapp.WebContent.resources.dataType.DTResponse;

/**
 * Servlet implementation class dejarSeguirUsuario
 */
@WebServlet("/dejarSeguirUsuario")
public class dejarSeguirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dejarSeguirUsuario() {
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

		DTResponse respuesta = new DTResponse();
		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario iconU = fab.getIcontroladorUsuario();
		
		HttpSession session = request.getSession();
		String nickUsuario = (String) session.getAttribute("nombreUser");
		String dejarSeguirNickname = request.getParameter("nicknameDejarSeguir");		
		
		iconU.dejarDeSeguir(nickUsuario, dejarSeguirNickname);
		respuesta.setCodigo(0);
		respuesta.setMensaje("El usuario " + nickUsuario + " ah comenzado a seguir a " + dejarSeguirNickname + ".");
		request.setAttribute("mensaje", "El usuario " + nickUsuario + " ah comenzado a seguir a " + dejarSeguirNickname + ".");
		
		ObjectMapper mapper = new ObjectMapper();
		String programaStr = mapper.writeValueAsString(respuesta);
		response.setContentType("application/json");
		response.getWriter().append(programaStr);
	}

}
