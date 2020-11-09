package main.webapp.WebContent.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import datatypes.DTCurso;
import datatypes.DTProgramaFormacion;
import interfaces.IcontroladorCurso;
import interfaces.fabrica;
import main.webapp.WebContent.resources.dataType.DTCursoNeed;
import main.webapp.WebContent.resources.dataType.DTInfo;
import main.webapp.WebContent.resources.dataType.DTProgramaNeed;
import manejadores.manejadorCurso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("busqueda");
        fabrica fab = fabrica.getInstancia();
        IcontroladorCurso icon = fab.getIcontroladorCurso();
        
        request.setAttribute("input", input);

        ArrayList<DTCurso> cursosArray = icon.listaDTCurso();
        ArrayList<DTProgramaFormacion> programasArray = icon.listaDTPrograma();
        ArrayList<DTCursoNeed> cursoNeeds = new ArrayList<>();
        ArrayList<DTProgramaNeed> programasNeeds = new ArrayList<>();


        for (DTCurso c:cursosArray) {
            DTCursoNeed dc = new DTCursoNeed();
            dc.setNombre(c.getNombre());
            dc.setDescripcion(c.getDescripcion());
            cursoNeeds.add(dc);
        }

        for (DTProgramaFormacion pf:programasArray) {
            DTProgramaNeed dp = new DTProgramaNeed();
            dp.setNombre(pf.getNombre());
            dp.setDescripcion(pf.getDescripcion());
            programasNeeds.add(dp);
        }



        DTInfo di = new DTInfo();
        di.setCursos(cursoNeeds);
        di.setProgramas(programasNeeds);

        ObjectMapper mapper = new ObjectMapper();
        String infoStr = mapper.writeValueAsString(di);
        response.setContentType("application/json");
        response.getWriter().append(infoStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
