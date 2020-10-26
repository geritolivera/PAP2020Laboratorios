package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import datatypes.DTEdicionCurso;
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

@WebServlet("/GetDatosEdicion")
public class GetDatosEdicion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();

        try {
            String edi =  request.getParameter("nombre");
            DTEdicionCurso dte = icon.verInfoEdicion(edi);
            request.setAttribute("ediSelected", dte);

            String recursosStr = mapper.writeValueAsString(dte);
            System.out.println("	Los recursos que guardo son: " + recursosStr);

            response.setContentType("application/json");
            response.getWriter().append(recursosStr);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
