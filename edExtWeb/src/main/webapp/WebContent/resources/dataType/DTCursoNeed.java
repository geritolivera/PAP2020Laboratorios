package main.webapp.WebContent.resources.dataType;

public class DTCursoNeed {

    private static String atipo = "Curso";
    private String bnombre;
    private String cdescripcion;
    private String dlink = "";

    public DTCursoNeed() {
    }

    public DTCursoNeed(String nombre, String descripcion) {
        this.bnombre = nombre;
        this.cdescripcion = descripcion;
    }


    public String getTipo() {
        return atipo;
    }

    public String getNombre() {
        return bnombre;
    }

    public void setNombre(String nombre) {
        this.bnombre = nombre;
        setLink(nombre);
    }
    public void setLink(String nom){
        this.dlink ="<a href=\"consultaCurso?curso="+ nom + "\" class=\"content\"><i class=\"material-icons\">pageview</i></a>";
    }

    public String getLink() {
        return dlink;
    }

    public String getDescripcion() {
        return cdescripcion;
    }

    public void setDescripcion(String descripcion) {
        this.cdescripcion = descripcion;
    }




}
