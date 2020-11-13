/**
 * ControladorUsuarioPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorUsuarioPublish extends java.rmi.Remote {
    public java.lang.String[] listarInstituto() throws java.rmi.RemoteException;
    public void altaUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException;
    public publicadores.DtUsuario[] listarDTUsuarios() throws java.rmi.RemoteException;
    public java.lang.String[] listarUsuarios() throws java.rmi.RemoteException;
    public publicadores.DtUsuario verInfoUsuario(java.lang.String arg0) throws java.rmi.RemoteException;
    public void nuevosDatos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3) throws java.rmi.RemoteException;
    public void altaCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public void altaInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtInscripcionED[] listarInscripcionesED(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarEstudiantesAux() throws java.rmi.RemoteException;
    public boolean validarUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean validarSeguidor(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String inscriptoED(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean validarSigue(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] listarSeguidos(java.lang.String arg0) throws java.rmi.RemoteException;
    public void cambiarInscripcion(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public boolean inscriptoPF(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] listarSeguidores(java.lang.String arg0) throws java.rmi.RemoteException;
    public void dejarDeSeguir(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public void comenazarSeguir(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
