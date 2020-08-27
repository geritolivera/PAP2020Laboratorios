package manejadores;

import java.util.List;
import java.util.ArrayList;

import clases.Usuario;

public class manejadorUsuario {
	private static manejadorUsuario instancia = null;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private manejadorUsuario(){}
	
	public static manejadorUsuario getInstancia() {
		if(instancia == null)
			instancia = new manejadorUsuario();
		return instancia;
	}
	
	public void addUsuario(Usuario u){
		usuarios.add(u);
	}
	
	public Usuario findUsuario(String nickname) {
		Usuario findU = null;
		for(Usuario u : usuarios) {
			if(u.getNick().equals(nickname)) {
				findU = u;
			}
		}
		return findU;
	}
	
	public boolean existeUsuario(String nickname) {
		boolean existe = false;
		for(Usuario u : usuarios) {
			if(u.getNick().equals(nickname)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public void deleteUsuario(String nickname) {
		Usuario usuBorrar = null;
		for(Usuario u : usuarios) {
			if(u.getNick().equals(nickname)) {
				usuBorrar = u;
			}
		}
		if(usuBorrar != null) {
			usuBorrar = null;
			System.gc();
		}
	}
}
