package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Usuario;
import datatypes.*;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;


@WebServlet("/login")
public class login extends HttpServlet {
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fabrica fab = fabrica.getInstancia();
        IcontroladorUsuario icon = fab.getIcontroladorUsuario();
        IcontroladorCurso iconc = fab.getIcontroladorCurso();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        //request de nickname y password de usuario
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String tipoUser = "";
        System.out.println("nickname = " + nickname);
        System.out.println("password = " + password);
        try {
            if(icon.validarUsuario(nickname, password)) {
                DTUsuario dtu = icon.verInfoUsuario(nickname);
                if (dtu instanceof DTEstudiante) {
                    tipoUser = "estudiante";
                    session.setAttribute("nombreUser", nickname);
                    session.setAttribute("tipoUser", tipoUser);
                    session.setAttribute("nickname", dtu.getNick());
                    session.setAttribute("nombre", dtu.getNombre());
                    session.setAttribute("apellido", dtu.getApellido());
                    session.setAttribute("correo", dtu.getCorreo());
                    session.setAttribute("fechaNac", dtu.getFechaNac());
                    ArrayList<String> prog = new ArrayList<String>();
                    for (DTProgramaFormacion pro : (((DTEstudiante) dtu).getProgramas())) {
                        prog.add(pro.getNombre());
                    }
                    session.setAttribute("programas", prog);
                    ArrayList<String> edis = new ArrayList<String>();
                    for (DTEdicionCurso edi : (((DTEstudiante) dtu).getEdiciones())) {
                        edis.add(edi.getNombre());
                    }
                    session.setAttribute("edicionesNombres", edis);


                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } else {
                    tipoUser = "docente";
                    session.setAttribute("nombreUser", nickname);
                    session.setAttribute("tipoUser", tipoUser);
                    session.setAttribute("nickname", dtu.getNick());
                    session.setAttribute("nombre", dtu.getNombre());
                    session.setAttribute("apellido", dtu.getApellido());
                    session.setAttribute("correo", dtu.getCorreo());
                    session.setAttribute("fechaNac", dtu.getFechaNac());
                    ArrayList<String> edis = new ArrayList<String>();
                    for (DTEdicionCurso edi : (((DTDocente) dtu).getEdiciones())) {
                        edis.add(edi.getNombre());
                    }
                    System.out.println("edis = " + edis);
                    List<DTEdicionCurso> ediciones =  ((DTDocente) dtu).getEdiciones();
                    session.setAttribute("ediciones", ediciones);
                    //parse = "altaProgramaFormacion.jsp";
                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }
            }else{
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/iniciarSesion.jsp");
                rd.forward(request, response);
                System.out.println("nickname no es valido = " + nickname);

            }
        }catch (UsuarioExcepcion e) {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/iniciarSesion.jsp");
            rd.forward(request, response);
            System.out.println("nickname no es valido = " + nickname);
            // el usuario no existe
            //parse = "altaUsuario.jsp";
            e.printStackTrace();
        }
    }
}