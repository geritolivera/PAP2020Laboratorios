package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import publicadores.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.rmi.RemoteException;

@WebServlet("/GetDatosPrograma")
public class GetDatosPrograma extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String prg = request.getParameter("nombre");
        DtProgramaFormacion ret = getPrograma(prg);
        ObjectMapper mapper = new ObjectMapper();
        String edicionStr = mapper.writeValueAsString(ret);
        response.setContentType("application/json");
        response.getWriter().append(edicionStr);
    }

    public DtProgramaFormacion getPrograma(String nomPrg) {
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            try {
                return port.verInfoPrograma(nomPrg);
            } catch (RemoteException e) {
                System.out.println("RemoteExcepcion");
                e.printStackTrace();
                return null;
            }
        } catch (ServiceException e) {
            System.out.println("ServiceExcepcion");
            e.printStackTrace();
            return null;
        }

    }
}
