package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;
import datatypes.DTUsuario;
import datatypes.DTEstudiante;
import datatypes.DTDocente;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;

/**
 * Servlet implementation class consultaUsuario
 */
@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		ObjectMapper mapper = new ObjectMapper();
		String nickname = request.getParameter("nickname");
		try {
			DTUsuario dt = icon.verInfoUsuario(nickname);;
			if(dt instanceof DTEstudiante) {
				ArrayList<String> ediciones = new ArrayList<>();
				for(DTEdicionCurso d:((DTEstudiante) dt).getEdiciones()){
					if(!((DTEstudiante) dt).getEdiciones().isEmpty()){
						ediciones.add(d.getNombre());
					}

				}
				request.setAttribute("tipo", "estudiante");
				request.setAttribute("dtu", ((DTEstudiante)dt));
				String userStr = mapper.writeValueAsString(((DTEstudiante)dt));
				System.out.println("La respuesta generada es: " + userStr);
				response.setContentType("application/json");
				response.getWriter().append(userStr);
			}else{if(dt instanceof DTDocente){
				ArrayList<String> ediciones = new ArrayList<>();
				for(DTEdicionCurso d:((DTDocente) dt).getEdiciones()){
					if(!((DTDocente) dt).getEdiciones().isEmpty()){
						ediciones.add(d.getNombre());
					}
				}
				request.setAttribute("tipo", "docente");
				request.setAttribute("dtu", ((DTDocente)dt));
				String userStr = mapper.writeValueAsString(((DTDocente)dt));
				System.out.println("La respuesta generada es: " + userStr);
				response.setContentType("application/json");
				response.getWriter().append(userStr);
			}
			}
		} catch (UsuarioExcepcion e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
}