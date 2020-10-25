package main.webapp.WebContent.resources.dataType;

import java.util.ArrayList;

public class DTProgramaNeed {

    private static String tipo = "Programa";
    private String nombre;
    private String descripcion;


    public DTProgramaNeed(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public DTProgramaNeed() {}

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
