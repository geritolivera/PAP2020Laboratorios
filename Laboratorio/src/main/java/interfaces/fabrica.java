package interfaces;

import controladores.controladorUsuario;
import controladores.controladorCurso;


public class fabrica {
	private static fabrica instancia = null;
	
	private fabrica() {}
	
	public static fabrica getInstancia() {
		if (instancia == null) {
			instancia = new fabrica();
		}
		return instancia;
	}
	
	public IcontroladorUsuario getIcontroladorUsuario() {
		return new controladorUsuario();
	}
	
	public IcontroladorCurso getIcontroladorCurso() {
		return new controladorCurso();
	}
}
