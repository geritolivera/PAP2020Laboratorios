package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;

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
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultaUsuario() {
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
		fabrica fab = fabrica.getInstancia();
		IcontroladorUsuario icon = fab.getIcontroladorUsuario();
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		//recibe nickname de usuario desde jsp
		String nickname = request.getParameter("nickname");
		
		DTUsuario dtu = null;
		try {
			dtu = icon.verInfoUsuario(nickname);
			//request.setAttribute("mensaje", "El programa " + programa + " se ha ingresado correctamente en el sistema.");
		} catch (UsuarioExcepcion e) {
			//request.setAttribute("mensaje", "El programa " + programa + " se ha ingresado correctamente en el sistema.");
			e.printStackTrace();
		}
		
		String fechaNac = format.format(dtu.getFechaNac());
		
		request.setAttribute("nickname", nickname);
		request.setAttribute("nombre", dtu.getNombre());
		request.setAttribute("apellido", dtu.getApellido());
		request.setAttribute("correo", dtu.getCorreo());
		request.setAttribute("fechaNac", fechaNac);
		request.setAttribute("seguidores", dtu.getSeguidores());
		request.setAttribute("seguidos", dtu.getSeguidos());
		
		if(dtu instanceof DTDocente) {
			//en caso de ser necesario tener las strings
			/*List<DTEdicionCurso> ediciones = ((DTDocente)dtu).getEdiciones();
			ArrayList<String> listEdiciones = new ArrayList<>();
			for(DTEdicionCurso e : ediciones) {
				listEdiciones.add(e.getNombre());
			}*/
			request.setAttribute("ediciones", ((DTDocente)dtu).getEdiciones());
		}
		else {
			//en caso de ser necesario tener las strings
			/*List<DTEdicionCurso> ediciones = ((DTEstudiante)dtu).getEdiciones();
			List<DTProgramaFormacion> programas = ((DTEstudiante)dtu).getProgramas();
			ArrayList<String> listEdiciones = new ArrayList<>();
			for(DTEdicionCurso e : ediciones) {
				listEdiciones.add(e.getNombre());
			}
			ArrayList<String> listProgramas = new ArrayList<>();
			for(DTProgramaFormacion p : programas) {
				listProgramas.add(p.getNombre());
			}*/
			request.setAttribute("ediciones", ((DTEstudiante)dtu).getEdiciones());
			request.setAttribute("programas", ((DTEstudiante)dtu).getProgramas());
		}
				
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/infoUsuario.jsp");
		rd.forward(request, response);
	}
}