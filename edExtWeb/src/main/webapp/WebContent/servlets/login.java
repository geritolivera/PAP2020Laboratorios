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
import com.fasterxml.jackson.databind.ObjectMapper;
import datatypes.*;
import exepciones.EdicionExcepcion;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;
import interfaces.IcontroladorUsuario;
import exepciones.UsuarioExcepcion;
import main.webapp.WebContent.resources.dataType.DTResponse;


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
        DTResponse respuesta = new DTResponse();

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
                    session.setAttribute("imagen", dtu.getImage());
                    ArrayList<String> prog = new ArrayList<String>();
                    for (DTProgramaFormacion pro : (((DTEstudiante) dtu).getProgramas())) {
                        prog.add(pro.getNombre());
                    }
                    System.out.println("prog = " + prog);
                    session.setAttribute("programasNombre", prog);
                    ArrayList<String> edis = new ArrayList<String>();
                    for (DTEdicionCurso edi : (((DTEstudiante) dtu).getEdicionesAprobado())) {
                        edis.add(edi.getNombre());
                    }
                    System.out.println("edis = " + edis);
                    session.setAttribute("edicionesNombres", edis);
                    ArrayList<String> seguido = dtu.getSeguidos();
                    ArrayList<String> seguidor = dtu.getSeguidores();
                    session.setAttribute("seguidos", seguido);
                    session.setAttribute("seguidores", seguidor);
                    respuesta.setCodigo(0);
                    respuesta.setMensaje(nickname);
                    ObjectMapper mapper = new ObjectMapper();
                    String userStr = mapper.writeValueAsString(respuesta);
                    response.setContentType("application/json");
                    response.getWriter().append(userStr);
//                    RequestDispatcher rd;
//                    rd = request.getRequestDispatcher("/index.jsp");
//                    rd.forward(request, response);
                } else {
                    tipoUser = "docente";
                    session.setAttribute("nombreUser", nickname);
                    session.setAttribute("tipoUser", tipoUser);
                    session.setAttribute("nickname", dtu.getNick());
                    session.setAttribute("nombre", dtu.getNombre());
                    session.setAttribute("apellido", dtu.getApellido());
                    session.setAttribute("correo", dtu.getCorreo());
                    session.setAttribute("fechaNac", dtu.getFechaNac());
                    session.setAttribute("imagen", dtu.getImage());
                    System.out.println("dtu.getImage() = " + dtu.getImage());
                    ArrayList<String> seguido = dtu.getSeguidos();
                    ArrayList<String> seguidor = dtu.getSeguidores();
                    session.setAttribute("seguidos", seguido);
                    session.setAttribute("seguidores", seguidor);
                    ArrayList<String> edis = new ArrayList<String>();
                    for (DTEdicionCurso edi : (((DTDocente) dtu).getEdiciones())) {
                        edis.add(edi.getNombre());
                    }
                    System.out.println("edis = " + edis);
                    session.setAttribute("ediciones", edis);

                    respuesta.setCodigo(0);
                    respuesta.setMensaje(nickname);
                    ObjectMapper mapper = new ObjectMapper();
                    String userStr = mapper.writeValueAsString(respuesta);
                    response.setContentType("application/json");
                    response.getWriter().append(userStr);
                    //parse = "altaProgramaFormacion.jsp";
//                    RequestDispatcher rd;
//                    rd = request.getRequestDispatcher("/index.jsp");
//                    rd.forward(request, response);
                    }
            }else{
                respuesta.setCodigo(1);
                respuesta.setMensaje("Constrase;a incorrecta para" + nickname);
                ObjectMapper mapper = new ObjectMapper();
                String userStr = mapper.writeValueAsString(respuesta);
                response.setContentType("application/json");
                response.getWriter().append(userStr);
            }
        }catch (UsuarioExcepcion | EdicionExcepcion e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje("El nickname ingresado " + nickname + "no existe.");
            ObjectMapper mapper = new ObjectMapper();
            String userStr = mapper.writeValueAsString(respuesta);
            response.setContentType("application/json");
            response.getWriter().append(userStr);

            e.printStackTrace();
        }
    }
}