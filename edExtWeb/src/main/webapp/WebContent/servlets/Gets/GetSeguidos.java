package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import datatypes.DTUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/GetSeguidos")
public class GetSeguidos extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorUsuario icon = fabrica.getIcontroladorUsuario();
        HttpSession session = request.getSession();

        try {
            String nick = (String) session.getAttribute("nickname");
            System.out.println("nickname seguidos: " + nick);
            DTUsuario dtu = icon.verInfoUsuario(nick);
            java.util.ArrayList<String> seguidos = dtu.getSeguidos();
            System.out.println("seguidos= " + seguidos);
            request.setAttribute("seguidos", seguidos);

            String seguidosStr = mapper.writeValueAsString(seguidos);
            System.out.println("	Los recursos que guardo son: " + seguidosStr);
            response.setContentType("application/json");
            response.getWriter().append(seguidosStr);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
