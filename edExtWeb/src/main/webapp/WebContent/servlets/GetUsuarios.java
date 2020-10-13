package main.webapp.WebContent.servlets;

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

@WebServlet("/GetUsuarios")
public class GetUsuarios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorUsuario iconu = fabrica.getIcontroladorUsuario();
        ArrayList<String> usuarios = new ArrayList<>();
        try {
            usuarios = iconu.listarUsuarios();
            System.out.println("usuarios = " + usuarios);
            session.setAttribute("listaUsuarios", usuarios);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String usuarioStr = mapper.writeValueAsString(usuarios);
        response.setContentType("application/json");
        response.getWriter().append(usuarioStr);
    }
}
