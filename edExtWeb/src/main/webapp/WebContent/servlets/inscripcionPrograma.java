package main.webapp.WebContent.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import clases.ProgramaFormacion;
import com.fasterxml.jackson.databind.ObjectMapper;
import datatypes.DTEstudiante;
import datatypes.DTProgramaFormacion;
import datatypes.DTUsuario;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import interfaces.IcontroladorCurso;
import main.webapp.WebContent.resources.dataType.DTResponse;

/**
 * Servlet implementation class inscripcionPrograma
 */
@WebServlet("/inscripcionPrograma")
public class inscripcionPrograma extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso icon = fab.getIcontroladorCurso();
		
		HttpSession session = request.getSession();
		Date fecha = Calendar.getInstance().getTime();
		String nickUsuario = (String) session.getAttribute("nombreUser");
		IcontroladorUsuario iconu = fab.getIcontroladorUsuario();
		String nomPrograma = request.getParameter("programa");
		System.out.println("nomPrograma = " + nomPrograma);
		System.out.println("nickUsuario = " + nickUsuario);


		DTResponse respuesta = new DTResponse();

		try {
			icon.inscribirEstudiantePrograma(nomPrograma, nickUsuario, fecha);
			DTEstudiante usu =  new DTEstudiante();
			usu = (DTEstudiante) iconu.verInfoUsuario(nickUsuario);
			respuesta.setCodigo(0);
			ArrayList<String> programas = new ArrayList<>();
			for (DTProgramaFormacion pf:usu.getProgramas()){
				programas.add(pf.getNombre());

			}
			session.setAttribute("programasNombres", programas);
			respuesta.setMensaje("El usuario " + nickUsuario + " se inscribio a " + nomPrograma + " correctamente");
			request.setAttribute("mensaje", "El usuario " + nickUsuario + " se inscribio a " + nomPrograma + " correctamente");
		} catch (Exception e) {
			respuesta.setCodigo(1);
			respuesta.setMensaje("El usuario " + nickUsuario + " ya esta inscripto a " + nomPrograma);
			//algo no existe lol
			e.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
		String inscriStr = mapper.writeValueAsString(respuesta);
		System.out.println("La respuesta generada es: " + inscriStr);

		response.setContentType("application/json");
		response.getWriter().append(inscriStr);
	}

}
