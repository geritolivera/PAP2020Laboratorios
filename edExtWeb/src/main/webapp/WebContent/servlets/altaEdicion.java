package main.webapp.WebContent.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
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
        fabrica fab = fabrica.getInstancia();
        IcontroladorCurso icon = fab.getIcontroladorCurso();

        //datos del curso
        //SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        String nombre = request.getParameter("nombre");
        Date today = Calendar.getInstance().getTime();
        long fI = Date.parse(request.getParameter( "fechaI"));
        Date fechaI = new Date(fI);
        long fF = Date.parse(request.getParameter( "fechaF"));
        Date fechaF = new Date(fF);
        System.out.println("fechaI = " + fechaI);

        String instituto = request.getParameter("instituto");
        String cursos = request.getParameter("cursos");
        String[] docentes = request.getParameterValues("docentes");
        Integer cupo = Integer.parseInt(request.getParameter("cupo"));


        //getParameterValues se usa para sacar un array de strings
        ArrayList<String> listDocentes = new ArrayList<>();
        for(String d: docentes) {
            listDocentes.add(d);
        }

        try {
            icon.nuevosDatosEdicion(nombre, today, fechaI, cupo, fechaF,cursos, listDocentes);
        } catch (EdicionExcepcion edicionExcepcion) {
            request.setAttribute("mensaje", "La edicion " + nombre + " ya existe en el sistema.");
            edicionExcepcion.printStackTrace();
        } catch (CursoExcepcion cursoExcepcion) {
            request.setAttribute("mensaje", "El curso " + nombre + " no existe en el sistema.");
            cursoExcepcion.printStackTrace();
        }
        request.setAttribute("mensaje", "La edicion " + nombre + " se ha ingresado correctamente en el sistema.");

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/notificacion.jsp");
        rd.forward(request, response);

    }

}