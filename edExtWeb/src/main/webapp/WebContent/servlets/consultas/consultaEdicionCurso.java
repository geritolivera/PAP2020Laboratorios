package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import publicadores.*;


@WebServlet("/consultaEdicionCurso")
public class consultaEdicionCurso extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String edicion = request.getParameter("edicion");
		HttpSession session = request.getSession(false);
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");

		Date today = Calendar.getInstance().getTime();
		DtEdicionCurso dte = null;
		ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
		ControladorUsuarioPublishService cup2 = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
			ControladorUsuarioPublish port2 = cup2.getcontroladorUsuarioPublishPort();
			dte = port.verInfoEdicion(edicion);
			//previas y categorias no se precisan
			String fechaI = format.format(dte.getFechaI());
			String fechaF = format.format(dte.getFechaF());
			String fechaPub = format.format(dte.getFechaPub());
			String[] docentes = dte.getDocentes();
			request.setAttribute("nombre", dte.getNombre());
			request.setAttribute("cupo", dte.getCupo());
			request.setAttribute("fechaI", fechaI);
			request.setAttribute("fechaF", fechaF);
			request.setAttribute("fechaPub", fechaPub);
			request.setAttribute("imagen", dte.getImagenURL());
			String cupo = "Si";
			if(dte.getCupo() <= 0)
				cupo = "No";
			request.setAttribute("haycupo", cupo);
			String vigente = "No";
			if (dte.getFechaF().after(today)) {
				vigente= "Si";
			}
			request.setAttribute("vigencia", vigente);
			ArrayList<String> listDoc = new ArrayList<>();
			for(String s: docentes) {
				try {
					DtDocente dtd = (DtDocente) port2.verInfoUsuario(s);
					String nombreCompleto = dtd.getNombre() + " " + dtd.getApellido() + ", " + dtd.getNick();
					listDoc.add(nombreCompleto);
				} catch (UsuarioExcepcion e) {
					//no existe usuario
					e.printStackTrace();
				}
			}
			String inscripto = "No";
			request.setAttribute("docentes", listDoc);
			Boolean userLog = false;
			if(session.getAttribute("nombreUser") != null) {
				userLog = true;
				String nickLog = (String) session.getAttribute("nombreUser");
				if(session.getAttribute("tipoUser").equals("estudiante")) {
					inscripto = port2.inscriptoED(nickLog, edicion);
					request.setAttribute("inscripto", inscripto);
				}
			}
			System.out.println("inscripto= " + inscripto);
			request.setAttribute("userLog", userLog);
		} catch (EdicionExcepcion | ServiceException e) {
			//no existe edicion
			e.printStackTrace();
		}
				
		request.getRequestDispatcher("/infoEdicion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}