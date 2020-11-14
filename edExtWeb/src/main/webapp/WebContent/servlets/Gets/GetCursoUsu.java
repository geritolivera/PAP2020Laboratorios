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

@WebServlet("/GetCursoUsu")
public class GetCursoUsu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nickname");
        ArrayList<String> cur = new ArrayList<>();
        String[] cursos = getCurUsuario(nick);

        for (int i = 0; i < cursos.length; i++) {
            cur.add(cursos[i]);
        }
        try {
            System.out.println("cursos = " + cursos);
            request.setAttribute("cursos", cur);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("cursos", cursos);
        request.setAttribute("edicionesConsulta", cursos);


        ObjectMapper mapper = new ObjectMapper();
        String cursosStr = mapper.writeValueAsString(cur);
        response.setContentType("application/json");
        response.getWriter().append(cursosStr);
    }

    public String[] getCurUsuario(String usu) {
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            try {
                return port.listarEdiciones(usu);
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
