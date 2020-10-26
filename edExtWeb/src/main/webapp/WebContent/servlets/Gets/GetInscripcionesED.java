package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import clases.InscripcionED;
import datatypes.DTInscripcionED;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/GetInscripcionesED")
public class GetInscripcionesED extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorUsuario iconu = fabrica.getIcontroladorUsuario();
        String edicion = request.getParameter("edicion");
        System.out.println("edicion: " + edicion);
        List<DTInscripcionED> inscripciones = iconu.listarInscripcionesED(edicion);
        try {
            request.setAttribute("dti", inscripciones);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String inscripcionesStr = mapper.writeValueAsString(inscripciones);
        response.setContentType("application/json");
        response.getWriter().append(inscripcionesStr);
    }
}
