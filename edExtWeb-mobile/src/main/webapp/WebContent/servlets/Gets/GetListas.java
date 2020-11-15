package main.webapp.WebContent.servlets.Gets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.fasterxml.jackson.databind.ObjectMapper;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;

@WebServlet("/GetListas")
public class GetListas extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] institutos = null;
		
		try {
			institutos = listarInstitutos();
			request.setAttribute("institutos", institutos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		String institutoStr = mapper.writeValueAsString(institutos);
		response.setContentType("application/json");
		response.getWriter().append(institutoStr);


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public String[] listarInstitutos() {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.listarInstituto();
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