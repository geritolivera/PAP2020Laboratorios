package main.webapp.WebContent.resources.dataType;

import datatypes.*;

import java.util.ArrayList;

public class DTInfo {

    private ArrayList<DTCurso> cursos;
    private ArrayList<DTProgramaFormacion> programas;

    public ArrayList<DTCurso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<DTCurso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<DTProgramaFormacion> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<DTProgramaFormacion> programas) {
        this.programas = programas;
    }

}
