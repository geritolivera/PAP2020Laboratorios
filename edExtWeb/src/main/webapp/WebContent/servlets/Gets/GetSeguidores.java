package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import publicadores.DtUsuario;
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


@WebServlet("/GetSeguidores")
public class GetSeguidores extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        //fabrica fabrica = interfaces.fabrica.getInstancia();
        //IcontroladorUsuario icon = fabrica.getIcontroladorUsuario();
        HttpSession session = request.getSession();

        try {
            String nick = (String) session.getAttribute("nickname");
            DtUsuario dtu = verInfoUsuario(nick);
            String[] ret = dtu.getSeguidos();
            ArrayList<String> seguidores = new ArrayList<>();
            for(int i = 0; i<ret.length; i++) {
            	seguidores.add(ret[i]);
            }
            System.out.println("seguidores= " + seguidores);
            request.setAttribute("seguidores", seguidores);

            String seguidoresStr = mapper.writeValueAsString(seguidores);
            System.out.println("	Los recursos que guardo son: " + seguidoresStr);
            response.setContentType("application/json");
            response.getWriter().append(seguidoresStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public DtUsuario verInfoUsuario(String nickname){
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
