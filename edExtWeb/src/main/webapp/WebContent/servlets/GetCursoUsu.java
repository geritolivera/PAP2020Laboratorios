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

@WebServlet("/GetCursoUsu")
public class GetCursoUsu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();
        HttpSession session = request.getSession();

        try {
            String nick =  request.getParameter("nickname");
            java.util.ArrayList<String> cursos = new ArrayList<>(icon.listarEdicionesAux(nick));
            System.out.println("cursos = " + cursos);
            System.out.println("inst = " + nick);
            session.setAttribute("cursos", cursos);

            String cursosStr = mapper.writeValueAsString(cursos);
            System.out.println("	Los recursos que guardo son: " + cursosStr);

            response.setContentType("application/json");
            response.getWriter().append(cursosStr);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
