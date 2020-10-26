package main.webapp.WebContent.resources.dataType;

import java.util.ArrayList;

public class DTCurInsPre {

    private ArrayList<String> categorias;
    private ArrayList<String> institutos;
    private ArrayList<String> cursos;

    public DTCurInsPre() {
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<String> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(ArrayList<String> institutos) {
        this.institutos = institutos;
    }

    public ArrayList<String> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }
}
