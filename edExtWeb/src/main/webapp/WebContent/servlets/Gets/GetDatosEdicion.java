package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import publicadores.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.lang.Exception;
import java.rmi.RemoteException;
import java.util.ArrayList;

@WebServlet("/GetDatosEdicion")
public class GetDatosEdicion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String edi = request.getParameter("nombre");
        DtEdicionCurso ret = getEdicion(edi);
        ObjectMapper mapper = new ObjectMapper();
        String edicionStr = mapper.writeValueAsString(ret);
        response.setContentType("application/json");
        response.getWriter().append(edicionStr);
    }

    public DtEdicionCurso getEdicion(String nomEdi) {
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            try {
                return port.verInfoEdicion(nomEdi);
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