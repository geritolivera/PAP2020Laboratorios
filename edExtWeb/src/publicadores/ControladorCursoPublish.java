/**
 * ControladorCursoPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorCursoPublish extends java.rmi.Remote {
    public java.lang.String[] listarCursos() throws java.rmi.RemoteException;
    public java.lang.String[] listarCursosAux(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarCategorias() throws java.rmi.RemoteException;
    public java.lang.String[] listarCursosInst(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstitutos() throws java.rmi.RemoteException;
    public void altaCurso(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.util.Calendar arg5, java.lang.String arg6, java.lang.String arg7, java.lang.String[] arg8, java.lang.String[] arg9, java.lang.String arg10) throws java.rmi.RemoteException, publicadores.CursoExcepcion, publicadores.InstitutoExcepcion;
    public publicadores.DtCurso verInfo(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoExcepcion;
    public void nuevosDatosEdicion(java.lang.String arg0, java.util.Calendar arg1, java.util.Calendar arg2, int arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String[] arg6, java.lang.String arg7) throws java.rmi.RemoteException, publicadores.CursoExcepcion, publicadores.EdicionExcepcion;
    public java.lang.String[] listarDocentesAux(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarEstudiantes() throws java.rmi.RemoteException;
    public publicadores.DtEdicionCurso verInfoEdicion(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionExcepcion;
    public publicadores.DtProgramaFormacion verInfoPrograma(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.ProgramaFormacionExcepcion;
    public java.lang.String[] listarProgramas() throws java.rmi.RemoteException;
    public java.lang.String[] listarDocentesInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public void crearProgramaFormacion(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.util.Calendar arg4, java.lang.String arg5) throws java.rmi.RemoteException, publicadores.ProgramaFormacionExcepcion;
    public void inscribirEstudianteEdicion(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2) throws java.rmi.RemoteException, publicadores.Exception;
    public java.lang.String[] getCategoriasPrograma(java.lang.String arg0) throws java.rmi.RemoteException;
    public void agregarCursoPrograma(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.CursoExcepcion, publicadores.ProgramaFormacionExcepcion;
    public publicadores.DtEdicionCurso mostrarEdicionVigente(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionExcepcion;
    public void inscribirEstudiantePrograma(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2) throws java.rmi.RemoteException, publicadores.Exception;
    public java.lang.String[] listarCursosCat(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarEdiciones(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtCurso[] listaDTCurso() throws java.rmi.RemoteException;
    public publicadores.DtProgramaFormacion[] listaDTPrograma() throws java.rmi.RemoteException;
}
