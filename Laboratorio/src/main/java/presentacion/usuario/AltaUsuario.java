package presentacion.usuario;

import com.toedter.calendar.JDateChooser;
import exepciones.UsuarioExcepcion;
import interfaces.IcontroladorUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class AltaUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private final IcontroladorUsuario icon;
	
	private final JTextField textFieldNick;
	private final JTextField textFieldNombre;
	private final JTextField textFieldApellido;
	private final JTextField textFieldEmail;
	private JDateChooser dateChooser;
	private final JComboBox<String> institutoChoose;
	

	public AltaUsuario(IcontroladorUsuario icon) {
		
		this.icon = icon;

		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel LabelNickname = new JLabel("Nickname");
		LabelNickname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNickname.setBounds(25, 25, 90, 15);
		getContentPane().add(LabelNickname);

		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNombre.setBounds(25, 63, 70, 15);
		getContentPane().add(LabelNombre);

		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelApellido.setBounds(25, 105, 68, 14);
		getContentPane().add(LabelApellido);

		JLabel LabelEmail = new JLabel("Correo Electronico");
		LabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelEmail.setBounds(25, 145, 140, 15);
		getContentPane().add(LabelEmail);

		JLabel LabelFechaNac = new JLabel("Fecha de Nacimiento");
		LabelFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelFechaNac.setBounds(25, 185, 130, 15);
		getContentPane().add(LabelFechaNac);
		
		JLabel LabelInstituto = new JLabel("Instituto");
		LabelInstituto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelInstituto.setBounds(25, 225, 70, 15);
		getContentPane().add(LabelInstituto);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(165, 140, 130, 25);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		textFieldNick = new JTextField();
		textFieldNick.setColumns(10);
		textFieldNick.setBounds(165, 20, 130, 25);
		getContentPane().add(textFieldNick);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(165, 60, 130, 25);
		getContentPane().add(textFieldNombre);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(165, 100, 130, 25);
		getContentPane().add(textFieldApellido);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(165, 180, 130, 25);
		getContentPane().add(dateChooser);

		institutoChoose = new JComboBox<String>();
		iniciarlizarComboBoxes();
		institutoChoose.setBounds(165, 225, 130, 25);
		getContentPane().add(institutoChoose);

		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaUsuarioActionPerformed(e);
			}
		});
		ButtonAceptar.setBounds(325, 70, 90, 25);
		getContentPane().add(ButtonAceptar);

		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarAltaUsuario(arg0);
			}
		});
		ButtonCancelar.setBounds(325, 140, 90, 25);
		getContentPane().add(ButtonCancelar);
		
	}

	protected void cancelarAltaUsuario(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}

	protected void AltaUsuarioActionPerformed(ActionEvent arg0) {
		String nickname = this.textFieldNick.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldNombre.getText();
		String email = this.textFieldEmail.getText();
		Date dateChooser = this.dateChooser.getDate();
		String instituto = this.institutoChoose.getSelectedItem().toString();
		Boolean institutoVacio;
		institutoVacio = this.institutoChoose.getSelectedItem().toString().isEmpty();
		if(checkFormulario()) {
			try {
				if(!institutoVacio) {
					this.icon.AltaUsuario(nickname, nombre, apellido, email, dateChooser, instituto);
					JOptionPane.showMessageDialog(this, "El Docente se ha creado con exito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
				} else {
					this.icon.AltaUsuario(nickname, nombre, apellido, email, dateChooser, null);
					JOptionPane.showMessageDialog(this, "El Estudiante se ha creado con exito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch(UsuarioExcepcion u) {
				JOptionPane.showMessageDialog(this, u.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			}
		}
		limpiarFormulario();
		setVisible(false);
	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(icon.listarInstituto());
		listInst.insertElementAt((""),0);
		institutoChoose.setModel(listInst);
		institutoChoose.setSelectedIndex(0);
	}
	
	private boolean checkFormulario() {
		String nickname = this.textFieldNick.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldNombre.getText();
		String email = this.textFieldEmail.getText();
		Date dateChooser = this.dateChooser.getDate();
		String fechaString = dateChooser.toString();
		Date todayDate = Calendar.getInstance().getTime();
		if(nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || fechaString.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vac�s", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		if(dateChooser.compareTo(todayDate) > 0) {
			JOptionPane.showMessageDialog(this, "Debe ingresar una fecha de nacimiento valida", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		if(!email.contains("@")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar una direccion de correo valida", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
		textFieldEmail.setText("");
		textFieldNick.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		dateChooser = null;
	}
}
