package main.webapp.WebContent.resources.dataType;

public class DTResponse {

    private Integer codigo;
    private String mensaje;
    private String elemento;

    public DTResponse(){}

    public DTResponse(Integer codigo, String mensaje, String elemento) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.elemento = elemento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
}