package main.webapp.WebContent.resources.dataType;

public class DTCursoNeed {

    private static String dTipo = "Curso";
    private String cNombre;
    private String bDescripcion;
    private String aLink = "";

    public DTCursoNeed() {
    }

    public DTCursoNeed(String nombre, String descripcion) {
        this.setNombre(nombre);
        this.bDescripcion = descripcion;
        this.setLink(nombre);
    }


    public String getTipo() {
        return dTipo;
    }

    public String getNombre() {
        return cNombre;
    }

    public void setNombre(String nombre) {
        this.cNombre = nombre;
        setLink(nombre);
    }
    public void setLink(String nom){
        this.aLink ="<a href=\"consultaCurso?curso="+ nom + "\" class=\"content\"><i class=\"material-icons\">link</i></a>";
    }

    public String getLink() {
        return aLink;
    }

    public String getDescripcion() {
        return bDescripcion;
    }

    public void setDescripcion(String descripcion) {
        this.bDescripcion = descripcion;
    }




}
