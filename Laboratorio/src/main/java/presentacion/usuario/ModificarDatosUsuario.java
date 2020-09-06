package presentacion.usuario;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import interfaces.*;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;

public class ModificarDatosUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	
	private JDateChooser dateChooser;
	private JTextField nuevoApellido;
	private JTextField NuevoNombre;
	private JTextField textNickname;
	private JTextField textCorreo;
	
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
				
		JButton ButtonSeleccionarUsu = new JButton("Seleccionar Usuario");
		ButtonSeleccionarUsu.setBounds(340, 15, 130, 30);
		getContentPane().add(ButtonSeleccionarUsu);
		
		JButton ButtonListarUsu = new JButton("Listar Usuarios");
		ButtonListarUsu.setBounds(80, 15, 130, 30);
		getContentPane().add(ButtonListarUsu);
		
		JTable tableUsu = new JTable(new DefaultTableModel(
			new Object[][] {
				{"hOLA", "hOLA", "hOLA", "hOLA", "hOLA"}
			},
			new String[] {
				"Nombre", "Apellido", "Nickname", "Correo", "Fecha Nacimiento"
			}
		));
		tableUsu.setRowSelectionAllowed(false);
		tableUsu.setFillsViewportHeight(true);
		tableUsu.setColumnSelectionAllowed(true);
		tableUsu.setBounds(35, 55, 475, 105);
		getContentPane().add(tableUsu);
		
		JLabel LabelDatosElegidos = new JLabel("Datos de Usuario elegido: ");
		LabelDatosElegidos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		LabelDatosElegidos.setBounds(35, 175, 195, 24);
		getContentPane().add(LabelDatosElegidos);
		
		JLabel LabelNickname = new JLabel("Nickname");
		LabelNickname.setFont(new Font("Times New Roman", Font.BOLD, 13));
		LabelNickname.setBounds(35, 210, 63, 15);
		getContentPane().add(LabelNickname);
		
		textNickname = new JTextField();
		textNickname.setColumns(10);
		textNickname.setBounds(110, 205, 130, 25);
		getContentPane().add(textNickname);
		
		JLabel LabelCorreo = new JLabel("Correo");
		LabelCorreo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		LabelCorreo.setBounds(35, 245, 45, 15);
		getContentPane().add(LabelCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(110, 240, 130, 25);
		getContentPane().add(textCorreo);

		JLabel LabelNuevosDatos = new JLabel("Ingresar nuevos datos: ");
		LabelNuevosDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		LabelNuevosDatos.setBounds(305, 175, 178, 24);
		getContentPane().add(LabelNuevosDatos);
		
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Times New Roman", Font.BOLD, 13));
		LabelNombre.setBounds(310, 210, 45, 15);
		getContentPane().add(LabelNombre);
		
		NuevoNombre = new JTextField();
		NuevoNombre.setColumns(10);
		NuevoNombre.setBounds(380, 205, 130, 25);
		getContentPane().add(NuevoNombre);				
		
		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setFont(new Font("Times New Roman", Font.BOLD, 13));
		LabelApellido.setBounds(310, 245, 45, 15);
		getContentPane().add(LabelApellido);
		
		nuevoApellido = new JTextField();
		nuevoApellido.setBounds(380, 240, 130, 25);
		getContentPane().add(nuevoApellido);
		nuevoApellido.setColumns(10);
		
		JLabel LabelFechaNac = new JLabel("Fecha de Nacimiento");
		LabelFechaNac.setFont(new Font("Times New Roman", Font.BOLD, 13));
		LabelFechaNac.setBounds(250, 280, 120, 14);
		getContentPane().add(LabelFechaNac);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(380, 275, 130, 25);
		getContentPane().add(dateChooser);
		
		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.setBounds(250, 310, 100, 30);
		getContentPane().add(ButtonAceptar);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.setBounds(410, 310, 100, 30);
		getContentPane().add(ButtonCancelar);	

	}
}
