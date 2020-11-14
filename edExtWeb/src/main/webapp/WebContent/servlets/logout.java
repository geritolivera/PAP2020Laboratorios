package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;

@WebServlet("/logout")
public class logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        DTResponse respuesta = new DTResponse();
        if(session != null) {
            session.removeAttribute("nombreUser");
            session.removeAttribute("tipoUser");
            session.invalidate();

            respuesta.setCodigo(0);
            respuesta.setMensaje("Gracias por pasar tiempo de calidad con nuestra pagina web. Te esperamos de vuelta!");
            ObjectMapper mapper = new ObjectMapper();
            String userStr = mapper.writeValueAsString(respuesta);
            response.setContentType("application/json");
            response.getWriter().append(userStr);
//            RequestDispatcher dp = request.getRequestDispatcher("cerrarSesion.jsp");
//            dp.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}