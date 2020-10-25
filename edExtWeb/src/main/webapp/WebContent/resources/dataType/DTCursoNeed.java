package main.webapp.WebContent.resources.dataType;

import datatypes.DTCurso;
import datatypes.DTProgramaFormacion;

import java.util.ArrayList;

public class DTCursoNeed {

    private static String tipo = "Curso";
    private String nombre;
    private String descripcion;

    public DTCursoNeed() {
    }

    public DTCursoNeed(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


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
