package main.webapp.WebContent.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.webapp.WebContent.resources.dataType.DTCursoNeed;
import main.webapp.WebContent.resources.dataType.DTInfo;
import main.webapp.WebContent.resources.dataType.DTProgramaNeed;
import publicadores.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;

@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("busqueda");
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();

        request.setAttribute("input", input);

        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            DtCurso[] cursosArray = port.listaDTCurso();
            DtProgramaFormacion[] programasArray = port.listaDTPrograma();
            DTCursoNeed[] cursoNeeds = new DTCursoNeed[cursosArray.length];
            DTProgramaNeed[] programasNeeds = new DTProgramaNeed[programasArray.length];
            Integer i=0;
            for (DtCurso c : cursosArray) {
                DTCursoNeed dc = new DTCursoNeed();
                dc.setNombre(c.getNombre());
                dc.setDescripcion(c.getDescripcion());
                dc.setLink(c.getNombre());
                cursoNeeds[i] = dc;
                i++;
            }
            i=0;
            for (DtProgramaFormacion pf : programasArray) {
                DTProgramaNeed dp = new DTProgramaNeed();
                dp.setNombre(pf.getNombre());
                dp.setDescripcion(pf.getDescripcion());
                dp.setLink(pf.getNombre());
                programasNeeds[i] = dp;
                i++;
            }


            DTInfo di = new DTInfo();
            di.setCursos(cursoNeeds);
            di.setProgramas(programasNeeds);
            ObjectMapper mapper = new ObjectMapper();
            String infoStr = mapper.writeValueAsString(di);
            response.setContentType("application/json");
            response.getWriter().append(infoStr);


        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
