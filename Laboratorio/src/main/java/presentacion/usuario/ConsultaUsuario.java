package presentacion.usuario;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IcontroladorUsuario;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	
	public ConsultaUsuario(IcontroladorUsuario icon) {

		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Usuario");
		setBounds(100, 100, 513, 354);
		getContentPane().setLayout(null);
		
		
	}

}
