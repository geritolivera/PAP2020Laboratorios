package main.webapp.WebContent.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import exepciones.InstitutoExcepcion;
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

@WebServlet("/GetCursoInst")
public class GetCursoInst extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();
        HttpSession session = request.getSession();

        try {
            String instituto =  request.getParameter("instituto");
            java.util.ArrayList<String> cursos = icon.listarCursosInst(instituto);
            System.out.println("cursos = " + cursos);
            session.setAttribute("cursos", cursos);


            String recursosStr = mapper.writeValueAsString(cursos);
            System.out.println("	Los recursos que guardo son: " + recursosStr);

            response.setContentType("application/json");
            response.getWriter().append(recursosStr);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}