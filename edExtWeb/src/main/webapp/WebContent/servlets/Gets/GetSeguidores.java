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


@WebServlet("/GetSeguidores")
public class GetSeguidores extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorUsuario icon = fabrica.getIcontroladorUsuario();
        HttpSession session = request.getSession();

        try {
            String nick = (String) session.getAttribute("nickname");
            DTUsuario dtu = icon.verInfoUsuario(nick);
            java.util.ArrayList<String> seguidores = dtu.getSeguidores();
            System.out.println("seguidores= " + seguidores);
            request.setAttribute("seguidores", seguidores);

            String seguidoresStr = mapper.writeValueAsString(seguidores);
            System.out.println("	Los recursos que guardo son: " + seguidoresStr);
            response.setContentType("application/json");
            response.getWriter().append(seguidoresStr);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
