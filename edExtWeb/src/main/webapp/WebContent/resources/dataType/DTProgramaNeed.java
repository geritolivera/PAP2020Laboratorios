package main.webapp.WebContent.resources.dataType;

import java.util.ArrayList;

public class DTProgramaNeed {

    private static String tipo = "Programa";
    private ArrayList<String> nombre;
    private ArrayList<String> descripcion;

    public DTProgramaNeed() {
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<String> getNombre() {
        return nombre;
    }

    public void setNombre(ArrayList<String> nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(ArrayList<String> descripcion) {
        this.descripcion = descripcion;
    }


}
