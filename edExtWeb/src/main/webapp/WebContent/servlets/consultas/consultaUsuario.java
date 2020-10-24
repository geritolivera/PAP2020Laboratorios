package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import datatypes.DTUsuario;
import datatypes.DTDocente;
import datatypes.DTEstudiante;

/**
 * Servlet implementation class consultaProgramaFormacion
 */
@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe programa desde jsp
		String nickname = request.getParameter("nickname");
		System.out.println("nickname = " + nickname);
		try {
			DTUsuario dtu = icon.verInfoUsuario(nickname);
			String fechaNac = format.format(dtu.getFechaNac());
			request.setAttribute("nickname", nickname);
			request.setAttribute("nombre", dtu.getNombre());
			request.setAttribute("apellido", dtu.getApellido());
			request.setAttribute("correo", dtu.getCorreo());
			request.setAttribute("fechaNac", fechaNac);
			request.setAttribute("imagenURL", dtu.getImage());
			request.setAttribute("seguidores", dtu.getSeguidores());
			ArrayList<String> seguidos = dtu.getSeguidos();
			request.setAttribute("seguidos", seguidos);
			ArrayList<String> ediciones = new ArrayList<>();
			ArrayList<String> programas = new ArrayList<>();
			String tipo;
			if(dtu instanceof DTDocente) {
				List<DTEdicionCurso> listEdiciones = ((DTDocente)dtu).getEdiciones();
				for(DTEdicionCurso e: listEdiciones)
					ediciones.add(e.getNombre());
				tipo = "docente";
			}
			else {
				List<DTEdicionCurso> listEdiciones = ((DTEstudiante)dtu).getEdiciones();
				for(DTEdicionCurso e: listEdiciones)
					ediciones.add(e.getNombre());
				List<DTProgramaFormacion> listProgramas = ((DTEstudiante)dtu).getProgramas();
				for(DTProgramaFormacion p: listProgramas)
					programas.add(p.getNombre());
				tipo = "estudiante";
			}
			request.setAttribute("ediciones", ediciones);
			request.setAttribute("programas", programas);
			request.setAttribute("tipo", tipo);
			Boolean userLog = false; //hay un usuario logueado?
			Boolean yaSeguido = false; //el usuario ya sigue al consultado?
			Boolean igualdad = false; //el nickname del usuario logueado es igual al del consultado?
			if(session.getAttribute("nombreUser") != null) {
				userLog = true;
				String nickLog = (String) session.getAttribute("nombreUser"); //nick del user logueado
				if(nickLog.equals(nickname)) //si el usuario se esta consultando a si mismo
					igualdad = true;
				else {
					for(String u: seguidos){
						if(nickname.equals(u))
							yaSeguido = true;
					}
				}
			}
			request.setAttribute("userLog", userLog);
			request.setAttribute("yaSeguido", yaSeguido);
			request.setAttribute("igualdad", igualdad);

			System.out.println("ediciones de  " + nickname + ":" + ediciones);
			System.out.println("programas de  " + nickname + ":" + programas);

		} catch (UsuarioExcepcion e) {

			System.out.println("SE RE LIMO");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/infoUsuarioNUEVO.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}