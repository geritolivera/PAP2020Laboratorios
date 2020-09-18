package presentacion.usuario;

import com.toedter.calendar.JDateChooser;
import datatypes.DTUsuario;
import interfaces.IcontroladorUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class ModificarDatosUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	
	private JDateChooser dateChooser;
	private JTextField nuevoApellido;
	private JTextField NuevoNombre;
	private JTextField textNickname;
	private JTextField textCorreo;
	private JList<String> nicknameUsu;
	private List<DTUsuario> listaUsuarios;
	private String[] correos;
	private int contadorCorreo;
	
	public ModificarDatosUsuario(IcontroladorUsuario icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Datos de Usuario");
		setBounds(100, 100, 570, 390);
		getContentPane().setLayout(null);
		
		
		//Lista con usuarios
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(30, 60, 185, 240);
		getContentPane().add(scrollPane);
		nicknameUsu = new JList<String>();
		nicknameUsu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(nicknameUsu);
		
		//Listar Usuario boton
		JButton ButtonListarUsu = new JButton("Listar Usuarios");
		ButtonListarUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUsuarios(e);
			}
		});
		ButtonListarUsu.setBounds(40, 20, 150, 25);
		getContentPane().add(ButtonListarUsu);
	
		//Selecionar usuario boton
		JButton ButtonSeleccionarUsu = new JButton("Seleccionar");
		ButtonSeleccionarUsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarUsuario(e);
			}
		});
		ButtonSeleccionarUsu.setBounds(50, 310, 140, 25);
		getContentPane().add(ButtonSeleccionarUsu);		
		
		JLabel LabelDatosElegidos = new JLabel("Datos de Usuario elegido: ");
		LabelDatosElegidos.setFont(new Font("Times New Roman", Font.BOLD, 15));
		LabelDatosElegidos.setBounds(240, 30, 250, 25);
		getContentPane().add(LabelDatosElegidos);
		
		JLabel LabelNickname = new JLabel("Nickname");
		LabelNickname.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LabelNickname.setBounds(240, 85, 100, 15);
		getContentPane().add(LabelNickname);
		
		textNickname = new JTextField();
		textNickname.setColumns(10);
		textNickname.setBounds(400, 80, 130, 25);
		getContentPane().add(textNickname);
		
		JLabel LabelCorreo = new JLabel("Correo");
		LabelCorreo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LabelCorreo.setBounds(240, 115, 100, 15);
		getContentPane().add(LabelCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(400, 110, 130, 25);
		getContentPane().add(textCorreo);

		JLabel LabelNuevosDatos = new JLabel("Ingresar nuevos datos: ");
		LabelNuevosDatos.setFont(new Font("Times New Roman", Font.BOLD, 15));
		LabelNuevosDatos.setBounds(240, 155, 250, 25);
		getContentPane().add(LabelNuevosDatos);
		
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LabelNombre.setBounds(240, 210, 100, 15);
		getContentPane().add(LabelNombre);
		
		NuevoNombre = new JTextField();
		NuevoNombre.setColumns(10);
		NuevoNombre.setBounds(400, 205, 130, 25);
		getContentPane().add(NuevoNombre);				
		
		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LabelApellido.setBounds(240, 240, 100, 15);
		getContentPane().add(LabelApellido);
		
		nuevoApellido = new JTextField();
		nuevoApellido.setBounds(400, 235, 130, 25);
		getContentPane().add(nuevoApellido);
		nuevoApellido.setColumns(10);
		
		JLabel LabelFechaNac = new JLabel("Fecha de Nacimiento");
		LabelFechaNac.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LabelFechaNac.setBounds(240, 270, 150, 14);
		getContentPane().add(LabelFechaNac);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(400, 265, 130, 25);
		getContentPane().add(dateChooser);
		
		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { modificarDatos(e); }
		});
		ButtonAceptar.setBounds(250, 310, 100, 30);
		getContentPane().add(ButtonAceptar);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarModificarDatos(arg0);
			}
		});
		ButtonCancelar.setBounds(410, 310, 100, 30);
		getContentPane().add(ButtonCancelar);	
				
		
	}
	
	//Cancelar
	protected void cancelarModificarDatos(ActionEvent arg0){
		limpiarFormulario();
		setVisible(false);
	}
	
	//Retorna Nickname de Usuarios 
	public void listarUsuarios(ActionEvent arg0) {
		listaUsuarios = icon.listarDTUsuarios();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		correos = new String[icon.listarDTUsuarios().size()];
		contadorCorreo = 0;
		for(DTUsuario s : listaUsuarios) {
		 	correos[contadorCorreo] = s.getCorreo();
			listModel.addElement(s.getNick());
			contadorCorreo++;
		}
		nicknameUsu.setModel(listModel);
	}
	
	public void seleccionarUsuario(ActionEvent arg0) {
		this.textNickname.setText(nicknameUsu.getSelectedValue());
		this.textCorreo.setText(correos[nicknameUsu.getSelectedIndex()]);
	}
	
	public void modificarDatos(ActionEvent arg0) {
		String nick = nicknameUsu.getSelectedValue();
		String newName = this.NuevoNombre.getText();
		String newApellido = this.nuevoApellido.getText();
		Date newBirthDay = this.dateChooser.getDate();
		icon.nuevosDatos(nick, newName, newApellido, newBirthDay);
		JOptionPane.showMessageDialog(this, "Se han modificado los datos con exito", "ModificarDatosUsuario", JOptionPane.INFORMATION_MESSAGE);
		limpiarFormulario();
		setVisible(false);
	}
	
	
	//Limpia el formulario
	private void limpiarFormulario() {
		textCorreo.setText("");
		textNickname.setText("");
		NuevoNombre.setText("");
		nuevoApellido.setText("");
		dateChooser = null;
	}
}
