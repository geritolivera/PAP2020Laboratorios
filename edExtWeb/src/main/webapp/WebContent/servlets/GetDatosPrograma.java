package main.webapp.WebContent.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetDatosPrograma")
public class GetDatosPrograma extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();

        try {
            String prog =  request.getParameter("nombre");
            DTProgramaFormacion dtp = icon.verInfoPrograma(prog);
            request.setAttribute("progSelected", dtp);
            String recursosStr = mapper.writeValueAsString(dtp);
            System.out.println("	Los recursos que guardo son: " + recursosStr);

            response.setContentType("application/json");
            response.getWriter().append(recursosStr);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
