package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.taglibs.standard.tei.DeclareTEI;
import publicadores.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetEdicionesUsu")
public class GetEdicionesUsu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> ediciones = new ArrayList<String>();

        String nickname = request.getParameter("nickname");
        ControladorUsuarioPublishService cup = new ControladorUsuarioPublishServiceLocator();
        try {
            ControladorUsuarioPublish port = cup.getcontroladorUsuarioPublishPort();
            try {
                DtUsuario usu = port.verInfoUsuario(nickname);
                if (usu instanceof DtEstudiante) {
                    DtEstudiante estudiante = ((DtEstudiante) port.verInfoUsuario(nickname));
                    DtEdicionCurso[] ed = estudiante.getEdiciones();
                    for (DtEdicionCurso edi : ed) {
                        ediciones.add(edi.getNombre());
                    }
                } else {
                    DtDocente docente = ((DtDocente) port.verInfoUsuario(nickname));
                    DtEdicionCurso[] ed = docente.getEdiciones();
                    for (DtEdicionCurso edi : ed) {
                        ediciones.add(edi.getNombre().toString());
                    }
                }

                String edicionesStr = mapper.writeValueAsString(ediciones);
                System.out.println("Los recursos que guardo son: " + edicionesStr);
                response.setContentType("application/json");
                response.getWriter().append(edicionesStr);
            } catch (publicadores.UsuarioExcepcion e) {
                System.out.println("UsuarioExcepcion");
                e.printStackTrace();

            } catch (RemoteException e) {
                System.out.println("RemoteExcepcion");
                e.printStackTrace();

            }
        } catch (ServiceException e) {
            System.out.println("ServiceExcepcion");
            e.printStackTrace();

        }
    }

}

