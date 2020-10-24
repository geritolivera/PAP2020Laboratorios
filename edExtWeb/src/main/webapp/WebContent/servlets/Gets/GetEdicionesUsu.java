package main.webapp.WebContent.servlets.Gets;

import com.fasterxml.jackson.databind.ObjectMapper;
import datatypes.DTDocente;
import datatypes.DTEdicionCurso;
import datatypes.DTEstudiante;
import datatypes.DTUsuario;
import exepciones.UsuarioExcepcion;
import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import org.apache.taglibs.standard.tei.DeclareTEI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetEdicionesUsu")
public class GetEdicionesUsu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        fabrica fabrica = interfaces.fabrica.getInstancia();
        IcontroladorCurso icon = fabrica.getIcontroladorCurso();
        IcontroladorUsuario iconu = fabrica.getIcontroladorUsuario();
        //HttpSession session = request.getSession();
        ArrayList<String> ediciones = new ArrayList<String>();

        String nick = request.getParameter("nickname");

        try {
            DTUsuario usu = iconu.verInfoUsuario(nick);
            if(usu instanceof DTEstudiante) {
                DTEstudiante estudiante = ((DTEstudiante) iconu.verInfoUsuario(nick));
                List<DTEdicionCurso> ed = estudiante.getEdiciones();
                for (DTEdicionCurso edi:ed){
                    ediciones.add(edi.getNombre());
                }
            }else{
                DTDocente docente = ((DTDocente) iconu.verInfoUsuario(nick));
                List<DTEdicionCurso> ed = docente.getEdiciones();
                for (DTEdicionCurso edi:ed){
                    ediciones.add(edi.getNombre().toString());
                }

            }

            String edicionesStr = mapper.writeValueAsString(ediciones);
            System.out.println("	Los recursos que guardo son: " + edicionesStr);
            response.setContentType("application/json");
            response.getWriter().append(edicionesStr);

        } catch (UsuarioExcepcion usuarioExcepcion) {
            usuarioExcepcion.printStackTrace();
        }


    }
}
