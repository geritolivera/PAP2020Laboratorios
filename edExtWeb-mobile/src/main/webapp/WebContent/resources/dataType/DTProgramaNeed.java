package main.webapp.WebContent.resources.dataType;

import java.util.ArrayList;

public class DTProgramaNeed {

    private static String atipo = "Programa";
    private String bnombre;
    private String cdescripcion;
    private String dlink = "";


    public DTProgramaNeed(String nombre, String descripcion) {
        this.bnombre = nombre;
        this.cdescripcion = descripcion;
    }

    public DTProgramaNeed() {}

    public String getTipo() {
        return atipo;
    }

    public String getNombre() {
        return bnombre;
    }

    public String getDescripcion() {
        return cdescripcion;
    }

    public void setDescripcion(String descripcion) {
        this.cdescripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.bnombre = nombre;
        setLink(nombre);
    }

    public void setLink(String nom){
        this.dlink ="<a href=\"consultaProgramaFormacion?programa="+ nom + "\" class=\"content\"><i class=\"material-icons\">pageview</i></a>";
    }

    public String getLink() {
        return dlink;
    }



}
