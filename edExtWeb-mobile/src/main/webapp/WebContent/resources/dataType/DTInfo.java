package main.webapp.WebContent.resources.dataType;

import java.util.ArrayList;

public class DTInfo {

    private ArrayList<DTCursoNeed> cursos;
    private ArrayList<DTProgramaNeed> programas;


    public ArrayList<DTCursoNeed> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<DTCursoNeed> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<DTProgramaNeed> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<DTProgramaNeed> programas) {
        this.programas = programas;
    }



}
