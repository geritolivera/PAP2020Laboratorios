package main.webapp.WebContent.servlets.Gets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Exception;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.fasterxml.jackson.databind.ObjectMapper;
import publicadores.*;

/**
 * Servlet implementation class GetListas
 */
@WebServlet("/GetCursos")
public class GetCursos extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] cursos = listarCursos();
		try {
			cursos = listarCursos();
			request.setAttribute("cursosagregar", cursos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		String cursosStr = mapper.writeValueAsString(cursos);
		response.setContentType("application/json");
		response.getWriter().append(cursosStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public String[] listarCursos(){
		ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
		try {
			ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
			try {
				String[] ret = port.listarCursos();
				return ret;
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