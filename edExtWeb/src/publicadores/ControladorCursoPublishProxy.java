package publicadores;

public class ControladorCursoPublishProxy implements publicadores.ControladorCursoPublish {
  private String _endpoint = null;
  private publicadores.ControladorCursoPublish controladorCursoPublish = null;
  
  public ControladorCursoPublishProxy() {
    _initControladorCursoPublishProxy();
  }
  
  public ControladorCursoPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorCursoPublishProxy();
  }
  
  private void _initControladorCursoPublishProxy() {
    try {
      controladorCursoPublish = (new publicadores.ControladorCursoPublishServiceLocator()).getcontroladorCursoPublishPort();
      if (controladorCursoPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorCursoPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorCursoPublish != null)
      ((javax.xml.rpc.Stub)controladorCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorCursoPublish getControladorCursoPublish() {
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish;
  }
  
  public java.lang.String[] listarDocentesInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarDocentesInstituto(arg0);
  }
  
  public void inscribirEstudianteEdicion(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2) throws java.rmi.RemoteException, publicadores.Exception{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    controladorCursoPublish.inscribirEstudianteEdicion(arg0, arg1, arg2);
  }
  
  public void crearProgramaFormacion(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.util.Calendar arg4, java.lang.String arg5) throws java.rmi.RemoteException, publicadores.ProgramaFormacionExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    controladorCursoPublish.crearProgramaFormacion(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public publicadores.DtEdicionCurso mostrarEdicionVigente(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.mostrarEdicionVigente(arg0);
  }
  
  public void agregarCursoPrograma(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.CursoExcepcion, publicadores.ProgramaFormacionExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    controladorCursoPublish.agregarCursoPrograma(arg0, arg1);
  }
  
  public java.lang.String[] getCategoriasPrograma(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.getCategoriasPrograma(arg0);
  }
  
  public void altaCurso(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.util.Calendar arg5, java.lang.String arg6, java.lang.String arg7, java.lang.String[] arg8, java.lang.String[] arg9, java.lang.String arg10) throws java.rmi.RemoteException, publicadores.CursoExcepcion, publicadores.InstitutoExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    controladorCursoPublish.altaCurso(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }
  
  public java.lang.String[] listarCursosAux(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarCursosAux(arg0);
  }
  
  public java.lang.String[] listarCursosInst(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarCursosInst(arg0);
  }
  
  public java.lang.String[] listarCursos() throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarCursos();
  }
  
  public java.lang.String[] listarCategorias() throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarCategorias();
  }
  
  public java.lang.String[] listarInstitutos() throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarInstitutos();
  }
  
  public void verInfo(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    controladorCursoPublish.verInfo(arg0);
  }
  
  public void nuevosDatosEdicion(java.lang.String arg0, java.util.Calendar arg1, java.util.Calendar arg2, int arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String[] arg6, java.lang.String arg7) throws java.rmi.RemoteException, publicadores.CursoExcepcion, publicadores.EdicionExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    controladorCursoPublish.nuevosDatosEdicion(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public java.lang.String[] listarDocentesAux(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarDocentesAux(arg0);
  }
  
  public java.lang.String[] listarEstudiantes() throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarEstudiantes();
  }
  
  public publicadores.DtEdicionCurso verInfoEdicion(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.verInfoEdicion(arg0);
  }
  
  public java.lang.String[] listarProgramas() throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarProgramas();
  }
  
  public publicadores.DtProgramaFormacion verInfoPrograma(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.ProgramaFormacionExcepcion{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.verInfoPrograma(arg0);
  }
  
  public void inscribirEstudiantePrograma(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2) throws java.rmi.RemoteException, publicadores.Exception{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    controladorCursoPublish.inscribirEstudiantePrograma(arg0, arg1, arg2);
  }
  
  public java.lang.String[] listarEdiciones(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarEdiciones(arg0);
  }
  
  public publicadores.DtCurso[] listaDTCurso() throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listaDTCurso();
  }
  
  public publicadores.DtProgramaFormacion[] listaDTPrograma() throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listaDTPrograma();
  }
  
  public java.lang.String[] listarCursosCat(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorCursoPublish == null)
      _initControladorCursoPublishProxy();
    return controladorCursoPublish.listarCursosCat(arg0);
  }
  
  
}