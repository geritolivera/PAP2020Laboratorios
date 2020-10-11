package main.webapp.WebContent.servlets;

import javax.servlet.ServletException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import exepciones.InstitutoExcepcion;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;

@WebServlet("/altaEdicion")
public class altaEdicion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String instituto = request.getParameter("instituto");
        fabrica fab = fabrica.getInstancia();
        IcontroladorCurso icon = fab.getIcontroladorCurso();
        ObjectMapper mapper = new ObjectMapper();

        try {
            ArrayList<String> cur = icon.listarCursosInst(instituto);
            String cursos = mapper.writeValueAsString(cur);
            response.setContentType("application/json");
            response.getWriter().append(cursos);
        } catch (InstitutoExcepcion institutoExcepcion) {
            institutoExcepcion.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        fabrica fab = fabrica.getInstancia();
        IcontroladorCurso icon = fab.getIcontroladorCurso();

        try {
            String[] institutos = icon.listarInstitutos();
            session.setAttribute("institutos", institutos);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getRequestDispatcher("altaEdicion.jsp").forward(request, response);

    }

}