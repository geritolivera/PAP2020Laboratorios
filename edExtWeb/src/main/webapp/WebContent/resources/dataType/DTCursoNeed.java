package main.webapp.WebContent.resources.dataType;

import datatypes.DTCurso;
import datatypes.DTProgramaFormacion;

import java.util.ArrayList;

public class DTCursoNeed {

    private static String tipo = "Curso";
    private ArrayList<String> nombre;
    private ArrayList<String> descripcion;

    public DTCursoNeed() {
    }

    public DTCursoNeed(ArrayList<String> nombre, ArrayList<String> descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
