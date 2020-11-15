package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import publicadores.ControladorCursoPublish;
import publicadores.ControladorCursoPublishService;
import publicadores.ControladorCursoPublishServiceLocator;

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

@WebServlet("/GetEdicionesCurso")
public class GetEdicionesCurso extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession();

        try {
            String curso = request.getParameter("curso");
            //java.util.ArrayList<String> ediciones = new ArrayList<>();
            String[] ediciones = listarEdiciones(curso);
            request.setAttribute("ediciones : ", ediciones);

            String recursosStr = mapper.writeValueAsString(ediciones);
            System.out.println("    Los recursos que guardo son: " + recursosStr);

            response.setContentType("application/json");
            response.getWriter().append(recursosStr);

        } catch (Exception e) {
            // la categoria no existe
            e.printStackTrace();
        }
    }

    public String[] listarEdiciones(String nomCurso) {
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            try {
                return port.listarEdiciones(nomCurso);
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