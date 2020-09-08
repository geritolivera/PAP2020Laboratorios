package presentacion.usuario;

import java.awt.*;

import javax.swing.*;

import interfaces.IcontroladorUsuario;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNick;
	private JTextField textFieldCorreo;
	private JTextField textFieldFechaNac;
	
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
		
		
		//Lista los usuarios
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 65, 120, 200);
		getContentPane().add(scrollPane);
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		//Boton Listar Usuarios
		JButton ButtonListarUsuarios = new JButton("Listar Usuarios");
		ButtonListarUsuarios.setBounds(20, 20, 120, 25);
		getContentPane().add(ButtonListarUsuarios);
		
		//Boton Seleccionar Usuarios
		JButton ButtonSelccUsuario = new JButton("Seleccionar Usuario");
		ButtonSelccUsuario.setBounds(20, 280, 120, 25);
		getContentPane().add(ButtonSelccUsuario);
		
		//Panel datos Usuario
		JPanel DatosPanel = new JPanel();
		DatosPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Usuario", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		DatosPanel.setBounds(164, 4, 325, 190);
		getContentPane().add(DatosPanel);
		DatosPanel.setLayout(null);
		
		//Label Nombre
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNombre.setBounds(10, 25, 45, 15);
		DatosPanel.add(LabelNombre);
		
		//Label Apellido
		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelApellido.setBounds(10, 60, 45, 15);
		DatosPanel.add(LabelApellido);
		
		//Label Nickname
		JLabel LabelNickname = new JLabel("Nickname");
		LabelNickname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNickname.setBounds(10, 95, 57, 15);
		DatosPanel.add(LabelNickname);
		
		//Label Correo
		JLabel LabelCorreo = new JLabel("Correo");
		LabelCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelCorreo.setBounds(10, 130, 45, 15);
		DatosPanel.add(LabelCorreo);
		
		//Label Fecha Nacimiento
		JLabel LabelFechaNac = new JLabel("Fecha Nacimiento");
		LabelFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelFechaNac.setBounds(10, 162, 100, 15);
		DatosPanel.add(LabelFechaNac);
		
		//Text Nombre
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 20, 180, 20);
		DatosPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		//Text Apellido
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(120, 55, 180, 20);
		DatosPanel.add(textFieldApellido);
		
		//Text Nick
		textFieldNick = new JTextField();
		textFieldNick.setColumns(10);
		textFieldNick.setBounds(120, 90, 180, 20);
		DatosPanel.add(textFieldNick);
		
		//Text Correo
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(120, 125, 180, 20);
		DatosPanel.add(textFieldCorreo);
		
		//Text Fecha Nacimiento
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(120, 160, 180, 20);
		DatosPanel.add(textFieldFechaNac);
		
		
	}
}
