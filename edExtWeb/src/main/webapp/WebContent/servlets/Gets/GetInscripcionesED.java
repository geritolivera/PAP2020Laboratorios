package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;

import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorUsuarioPublishService;
import publicadores.ControladorUsuarioPublishServiceLocator;
import publicadores.DtInscripcionED;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/GetInscripcionesED")
public class GetInscripcionesED extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession();
//        fabrica fabrica = interfaces.fabrica.getInstancia();
//        IcontroladorUsuario iconu = fabrica.getIcontroladorUsuario();
        String edicion = request.getParameter("edicion");
        System.out.println("edicion: " + edicion);
        DtInscripcionED[] ret = listarInscripcionesED(edicion);
        List<DtInscripcionED> inscripciones = new ArrayList<>();
        for(int i = 0; i<ret.length; i++) {
        	inscripciones.add(ret[i]);
        }
        try {
            request.setAttribute("dti", inscripciones);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String inscripcionesStr = mapper.writeValueAsString(inscripciones);
        response.setContentType("application/json");
        response.getWriter().append(inscripcionesStr);
    }
    
    public DtInscripcionED[] listarInscripcionesED(String nomEdicion) {
    	ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
		try {
			ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
			try {
				return port.listarInscripcionesED(nomEdicion);
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
