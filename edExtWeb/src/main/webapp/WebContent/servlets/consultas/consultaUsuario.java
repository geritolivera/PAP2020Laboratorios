package main.webapp.WebContent.servlets.consultas;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.rpc.ServiceException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Enumeration;

import com.fasterxml.jackson.databind.ObjectMapper;

import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import publicadores.DtDocente;
import publicadores.DtEdicionCurso;
import publicadores.DtEstudiante;
import publicadores.DtProgramaFormacion;
import publicadores.DtUsuario;


@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
		String nickname = request.getParameter("nickname");
		System.out.println("nickname = " + nickname);
		try {
			DtUsuario dtu = verInfoUsuario(nickname);
			Calendar fechaFin = dtu.getFechaNac();
			String fechaNac = format.format(fechaFin.getTime());
			request.setAttribute("nickname", nickname);
			request.setAttribute("nombre", dtu.getNombre());
			request.setAttribute("apellido", dtu.getApellido());
			request.setAttribute("correo", dtu.getCorreo());
			request.setAttribute("fechaNac", fechaNac);
			request.setAttribute("imagenURL", dtu.getImage());
			ArrayList<String> seguidores = new ArrayList<String>();
			String[] retSeg = dtu.getSeguidores();
			if(retSeg != null) {
				for (String se : retSeg) {
					seguidores.add(se);
				}
			}
			request.setAttribute("seguidores", seguidores);
			ArrayList<String> seguidos = new ArrayList<String>();
			String[] retSe = dtu.getSeguidos();
			if(retSe != null) {
				for (String se : retSe) {
					seguidos.add(se);
				}
			}
			request.setAttribute("seguidos", seguidos);
			String tipo;
			if(dtu instanceof DtDocente) {
				ArrayList<String> ediciones = new ArrayList<String>();
				DtEdicionCurso[] retDE = ((DtDocente) dtu).getEdiciones();
				if(retDE != null) {
					for (DtEdicionCurso dtEdicionCurso : retDE) {
						ediciones.add(dtEdicionCurso.getNombre());
					}
				}
				request.setAttribute("ediciones", ediciones);
				tipo = "docente";
				request.setAttribute("tipo", tipo);
			}
			if(dtu instanceof DtEstudiante){
				ArrayList<String> ediciones = new ArrayList<String>();
				DtEdicionCurso[] retDE = ((DtEstudiante) dtu).getEdiciones();
				if(retDE != null){
					for (DtEdicionCurso dtEdicionCurso : retDE) {
						ediciones.add(dtEdicionCurso.getNombre());
					}
				}
				request.setAttribute("ediciones", ediciones);
				ArrayList<String> programas = new ArrayList<String>();
				DtProgramaFormacion[] retPR = ((DtEstudiante) dtu).getProgramas();
				if(retPR!=null) {
					for (DtProgramaFormacion dtProgramaFormacion : retPR) {
						programas.add(dtProgramaFormacion.getNombre());
					}
				}
				request.setAttribute("programas", programas);
				tipo = "estudiante";
				request.setAttribute("tipo", tipo);
			}

			boolean userLog = false; //hay un usuario logueado?
			boolean yaSeguido = false; //el usuario ya sigue al consultado?
			boolean igualdad = false; //el nickname del usuario logueado es igual al del consultado?
			if(session.getAttribute("nombreUser") != null) {
				userLog = true;
				String nickLog = (String) session.getAttribute("nombreUser"); //nick del user logueado
				if(nickLog.equals(nickname)) //si el usuario se esta consultando a si mismo
					igualdad = true;
				else {
					if(dtu.getSeguidores() != null) {
						for (String s: dtu.getSeguidores()) {
							if (nickLog.equals(s))
								yaSeguido = true;
						}
					}
				}
			}
			request.setAttribute("userLog", userLog);
			request.setAttribute("yaSeguido", yaSeguido);
			request.setAttribute("igualdad", igualdad);
			request.getRequestDispatcher("/infoUsuarioNUEVO.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("SE RE LIMO");
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public DtUsuario verInfoUsuario(String nickname) {
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.verInfoUsuario(nickname);
			} catch (publicadores.UsuarioExcepcion e) {
				System.out.println("UsuarioExcepcion");
				e.printStackTrace();
				return null;
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