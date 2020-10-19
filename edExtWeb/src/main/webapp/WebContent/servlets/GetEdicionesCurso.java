package main.webapp.WebContent.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GetEdicionesCurso")
public class GetEdicionesCurso extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();
        HttpSession session = request.getSession();

        try {
            String curso =  request.getParameter("curso");
            java.util.ArrayList<String> ediciones = new ArrayList<>();
            ediciones = icon.listarEdicionesAux(curso);
            System.out.println("cursos = " + curso);
            System.out.println("edis = " + ediciones);
            session.setAttribute("edicionesC", ediciones);

            String recursosStr = mapper.writeValueAsString(ediciones);
            System.out.println("	Los recursos que guardo son: " + recursosStr);
            response.setContentType("application/json");
            response.getWriter().append(recursosStr);

        } catch (Exception e) {
            // la categoria no existe
            e.printStackTrace();
        }
    }
}
