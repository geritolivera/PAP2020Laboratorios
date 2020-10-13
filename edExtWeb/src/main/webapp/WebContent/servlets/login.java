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

import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;
import datatypes.DTUsuario;
import datatypes.DTDocente;
import datatypes.DTEstudiante;

/**
 * Servlet implementation class iniciarSesion
 */
@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fabrica fab = fabrica.getInstancia();
        IcontroladorUsuario icon = fab.getIcontroladorUsuario();
        PrintWriter out = response.getWriter();

        //request de nickname y password de usuario
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String tipoUser = null;
        //String parse = "iniciarSesion.jsp"; // se usa para probar por el momento

        try {
            //prueba la validez del usuario y su contraseña contra la BD
            if(icon.validarUsuario(nickname, password)) {
                out.print("Bienvenido, "+nickname);
                DTUsuario dtu = icon.verInfoUsuario(nickname);
                if(dtu instanceof DTEstudiante)
                	tipoUser = "estudiante";
                else
                	tipoUser = "docente";
                HttpSession session = request.getSession();
                session.setAttribute("nombreUser", nickname);
                session.setAttribute("tipoUser", tipoUser);
                //parse = "altaProgramaFormacion.jsp";
            }
        } catch (UsuarioExcepcion e) {
            // el usuario no existe
            //parse = "altaUsuario.jsp";
            e.printStackTrace();
        }

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}