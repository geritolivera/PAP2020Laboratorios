package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import publicadores.DtUsuario;
import datatypes.DTUsuario;
import exepciones.UsuarioExcepcion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;


@WebServlet("/GetSeguidos")
public class GetSeguidos extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        //fabrica fabrica = interfaces.fabrica.getInstancia();
        //IcontroladorUsuario icon = fabrica.getIcontroladorUsuario();
        HttpSession session = request.getSession();

        try {
            String nick = (String) session.getAttribute("nickname");
            System.out.println("nickname seguidos: " + nick);
            DtUsuario dtu = verInfoUsuario(nick);
            String[] ret = dtu.getSeguidos();
            ArrayList<String> seguidos = new ArrayList<>();
            for(int i = 0; i<ret.length; i++) {
            	seguidos.add(ret[i]);
            }
            System.out.println("seguidos= " + seguidos);
            request.setAttribute("seguidos", seguidos);

            String seguidosStr = mapper.writeValueAsString(seguidos);
            System.out.println("	Los recursos que guardo son: " + seguidosStr);
            response.setContentType("application/json");
            response.getWriter().append(seguidosStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public DtUsuario verInfoUsuario(String nickname) throws UsuarioExcepcion{
		ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.verInfoUsuario(nickname);
			} catch (publicadores.UsuarioExcepcion e1) {
				System.out.println("UsuarioExcepcion");
				e1.printStackTrace();
				return null;
			} catch (RemoteException e1) {
				System.out.println("RemoteExcepcion");
				e1.printStackTrace();
				return null;
			}

		} catch (ServiceException e) {
			System.out.println("ServiceExcepcion");
			e.printStackTrace();
			return null;
		}
	}
}
