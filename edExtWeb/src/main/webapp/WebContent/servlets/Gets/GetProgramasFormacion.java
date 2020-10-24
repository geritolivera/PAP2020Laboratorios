package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GetProgramasFormacion")
public class GetProgramasFormacion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();
        ArrayList<String> programas = new ArrayList<>();
        try {
            programas = icon.listarProgramas();
            System.out.println("programas = " + programas);
            request.setAttribute("programas", programas);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String programasStr = mapper.writeValueAsString(programas);
        response.setContentType("application/json");
        response.getWriter().append(programasStr);
    }
}
