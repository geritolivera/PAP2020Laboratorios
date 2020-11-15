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

@WebServlet("/GetCursoInst")
public class GetCursoInst extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String inst = request.getParameter("instituto");

        ArrayList<String> cur = new ArrayList<>();
        String[] cursos = getCurInstitutos(inst);
        for (int i = 0; i < cursos.length; i++) {
            cur.add(cursos[i]);
        }
        try {
            System.out.println("cursos = " + cursos);
            request.setAttribute("curso", cursos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String cursosStr = mapper.writeValueAsString(cursos);
        response.setContentType("application/json");
        response.getWriter().append(cursosStr);
    }

    public String[] getCurInstitutos(String inst) {
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            try {
                return port.listarCursosAux(inst);
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
