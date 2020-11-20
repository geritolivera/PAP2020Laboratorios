package main.webapp.WebContent.resources.dataType;


public class DTProgramaNeed {

    private static String dTipo = "Programa";
    private String cNombre;
    private String bDescripcion;
    private String aLink = "";


    public DTProgramaNeed() {
    }

    public DTProgramaNeed(String nombre, String descripcion) {
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

    public String getDescripcion() {
        return bDescripcion;
    }

    public void setDescripcion(String descripcion) {
        this.bDescripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.cNombre = nombre;

    }

    public void setLink(String nom){
        this.aLink ="<a href=\"consultaProgramaFormacion?programa="+ nom + "\" class=\"content\"><i class=\"material-icons\">link</i></a>";
    }

    public String getLink() {
        return aLink;
    }



}
