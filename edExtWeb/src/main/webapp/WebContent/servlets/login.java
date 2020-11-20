package main.webapp.WebContent.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTResponse;
import publicadores.*;

import static javax.swing.text.html.HTML.Tag.U;


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
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
        ControladorUsuarioPublishService cup2 = new ControladorUsuarioPublishServiceLocator();
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
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
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            ControladorUsuarioPublish port2 = cup2.getcontroladorUsuarioPublishPort();
            if(port2.validarUsuario(nickname, password)) {
                DtUsuario dtu = port2.verInfoUsuario(nickname);
                session.setAttribute("nombreUser", nickname);
                session.setAttribute("tipoUser", tipoUser);
                session.setAttribute("nickname", dtu.getNick());
                session.setAttribute("nombre", dtu.getNombre());
                session.setAttribute("apellido", dtu.getApellido());
                session.setAttribute("correo", dtu.getCorreo());
                Calendar fechaN = dtu.getFechaNac();
                String FN = format.format(fechaN.getTime());
                session.setAttribute("fechaNac", FN);
                if(dtu.getSeguidos() != null) {
                        String[] seguido = dtu.getSeguidos();
                        session.setAttribute("seguidos", seguido);
                }
                if(dtu.getSeguidos() != null) {
                    String[] seguidor = dtu.getSeguidores();
                    session.setAttribute("seguidores", seguidor);
                }

                if (dtu instanceof DtEstudiante) {
                    tipoUser = "estudiante";
                    session.setAttribute("tipoUser", tipoUser);
                    if(dtu.getImage().isEmpty()){
                        session.setAttribute("imagen", "resources/images/estud.jpg");
                    }else {
                        session.setAttribute("imagen", dtu.getImage());
                    }
                    ArrayList<String> prog = new ArrayList<String>();
                    if((((DtEstudiante) dtu).getProgramas()) != null) {
                        for (DtProgramaFormacion pro : (((DtEstudiante) dtu).getProgramas())) {
                            prog.add(pro.getNombre());
                        }
                    }
                    System.out.println("prog = " + prog);
                    session.setAttribute("programasNombre", prog);
                    ArrayList<String> edis = new ArrayList<String>();
                    if((((DtEstudiante) dtu).getEdiciones())!= null) {
                        for (DtEdicionCurso edi : (((DtEstudiante) dtu).getEdiciones())) {
                            edis.add(edi.getNombre());
                        }
                    }
                    System.out.println("edis = " + edis);
                    session.setAttribute("edicionesNombres", edis);
                    respuesta.setCodigo(0);
                    respuesta.setMensaje(nickname);
                    ObjectMapper mapper = new ObjectMapper();
                    String userStr = mapper.writeValueAsString(respuesta);
                    response.setContentType("application/json");
                    response.getWriter().append(userStr);

                } else {
                    tipoUser = "docente";
                    session.setAttribute("tipoUser", tipoUser);
                    if(dtu.getImage().isEmpty()){
                        session.setAttribute("imagen", "resources/images/docente.jpg");
                    }else {
                        session.setAttribute("imagen", dtu.getImage());
                    }
                    ArrayList<String> edis = new ArrayList<String>();
                    if (((DtDocente) dtu).getEdiciones() != null) {
                        for (DtEdicionCurso edi : (((DtDocente) dtu).getEdiciones())) {
                            edis.add(edi.getNombre());
                        }
                    }
                    System.out.println("edis = " + edis);
                    session.setAttribute("ediciones", edis);

                    respuesta.setCodigo(0);
                    respuesta.setMensaje(nickname);
                    ObjectMapper mapper = new ObjectMapper();
                    String userStr = mapper.writeValueAsString(respuesta);
                    response.setContentType("application/json");
                    response.getWriter().append(userStr);
                    }
            }else{
                respuesta.setCodigo(1);
                respuesta.setMensaje("Constraseña incorrecta para  " + nickname);
                ObjectMapper mapper = new ObjectMapper();
                String userStr = mapper.writeValueAsString(respuesta);
                response.setContentType("application/json");
                response.getWriter().append(userStr);
            }
        }catch (UsuarioExcepcion | EdicionExcepcion | ServiceException e) {
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