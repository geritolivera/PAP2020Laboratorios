package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import publicadores.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.lang.Exception;
import java.rmi.RemoteException;
import java.util.ArrayList;

@WebServlet("/GetProgramasFormacion")
public class GetProgramasFormacion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> programaForm = new ArrayList<>();
        String[] ret = getProgramForm();
        for(int i = 0; i<ret.length; i++) {
            programaForm.add(ret[i]);
        }
        try {
            System.out.println("progForm = " + programaForm);
            request.setAttribute("programa", programaForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String usuarioStr = mapper.writeValueAsString(programaForm);
        response.setContentType("application/json");
        response.getWriter().append(usuarioStr);
    }

    public String[] getProgramForm() {
        ControladorCursoPublishService cup = new ControladorCursoPublishServiceLocator();
        try {
            ControladorCursoPublish port = cup.getcontroladorCursoPublishPort();
            try {
                return port.listarProgramas();
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
