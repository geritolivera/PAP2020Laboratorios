package publicadores;

public class ControladorUsuarioPublishProxy implements publicadores.ControladorUsuarioPublish {
  private String _endpoint = null;
  private publicadores.ControladorUsuarioPublish controladorUsuarioPublish = null;
  
  public ControladorUsuarioPublishProxy() {
    _initControladorUsuarioPublishProxy();
  }
  
  public ControladorUsuarioPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorUsuarioPublishProxy();
  }
  
  private void _initControladorUsuarioPublishProxy() {
    try {
      controladorUsuarioPublish = (new publicadores.ControladorUsuarioPublishServiceLocator()).getcontroladorUsuarioPublishPort();
      if (controladorUsuarioPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorUsuarioPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorUsuarioPublish != null)
      ((javax.xml.rpc.Stub)controladorUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorUsuarioPublish getControladorUsuarioPublish() {
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish;
  }
  
  public boolean validarCorreo(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.validarCorreo(arg0);
  }
  
  public publicadores.DtUsuario[] listarDTUsuarios() throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.listarDTUsuarios();
  }
  
  public publicadores.DtUsuario verInfoUsuario(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.UsuarioExcepcion{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.verInfoUsuario(arg0);
  }
  
  public void nuevosDatos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.util.Calendar arg3) throws java.rmi.RemoteException, publicadores.UsuarioExcepcion{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    controladorUsuarioPublish.nuevosDatos(arg0, arg1, arg2, arg3);
  }
  
  public java.lang.String[] listarUsuarios() throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.listarUsuarios();
  }
  
  public java.lang.String[] listarInstituto() throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.listarInstituto();
  }
  
  public void altaUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException, publicadores.UsuarioExcepcion{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    controladorUsuarioPublish.altaUsuario(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public void altaInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoExcepcion{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    controladorUsuarioPublish.altaInstituto(arg0);
  }
  
  public void altaCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    controladorUsuarioPublish.altaCategoria(arg0);
  }
  
  public java.lang.String[] listarEstudiantesAux() throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.listarEstudiantesAux();
  }
  
  public publicadores.DtInscripcionED[] listarInscripcionesED(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.listarInscripcionesED(arg0);
  }
  
  public java.lang.String[] listarSeguidos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.listarSeguidos(arg0);
  }
  
  public java.lang.String inscriptoED(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.inscriptoED(arg0, arg1);
  }
  
  public void dejarDeSeguir(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    controladorUsuarioPublish.dejarDeSeguir(arg0, arg1);
  }
  
  public java.lang.String[] listarSeguidores(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.listarSeguidores(arg0);
  }
  
  public boolean validarUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.UsuarioExcepcion{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.validarUsuario(arg0, arg1);
  }
  
  public boolean validarSigue(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.validarSigue(arg0, arg1);
  }
  
  public boolean validarSeguidor(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.validarSeguidor(arg0, arg1);
  }
  
  public boolean inscriptoPF(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.inscriptoPF(arg0, arg1);
  }
  
  public void cambiarInscripcion(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    controladorUsuarioPublish.cambiarInscripcion(arg0, arg1, arg2);
  }
  
  public publicadores.DtEstudiante estudiante() throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.estudiante();
  }
  
  public boolean validarNick(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.validarNick(arg0);
  }
  
  public void comenazarSeguir(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    controladorUsuarioPublish.comenazarSeguir(arg0, arg1);
  }
  
  public publicadores.DtDocente docente() throws java.rmi.RemoteException{
    if (controladorUsuarioPublish == null)
      _initControladorUsuarioPublishProxy();
    return controladorUsuarioPublish.docente();
  }
  
  
}