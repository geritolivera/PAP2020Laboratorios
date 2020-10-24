package main.webapp.WebContent.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;
import main.webapp.WebContent.resources.dataType.DTInfo;
import manejadores.manejadorCurso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("busqueda");
        fabrica fab = fabrica.getInstancia();
        IcontroladorCurso icon = fab.getIcontroladorCurso();


        System.out.println("input = " + input);
        request.setAttribute("input", input);

        DTInfo di = new DTInfo();
        di.setCursos(icon.listaDTCurso());
        di.setProgramas(icon.listaDTPrograma());

        ObjectMapper mapper = new ObjectMapper();
        String infoStr = mapper.writeValueAsString(di);
        System.out.println("La info generada es: " + infoStr);

        response.setContentType("application/json");
        response.getWriter().append(infoStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
