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

	private IcontroladorUsuario icon;
	
	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JDateChooser dateChooser;
	private JComboBox<String> institutoChoose;
	private JPasswordField  textFieldPasswrd;
	private JPasswordField  textFieldPasswordOK;
	

	public AltaUsuario(IcontroladorUsuario icon) {
		
		this.icon = icon;

		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Usuario");
		setBounds(100, 100, 449, 380);
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

		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelPassword.setBounds(25, 185, 140, 15);
		getContentPane().add(LabelPassword);
				
		JLabel LabelConfirmPassword = new JLabel("Confirmar Password");
		LabelConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelConfirmPassword.setBounds(25, 225, 140, 15);
		getContentPane().add(LabelConfirmPassword);		
		
		JLabel LabelFechaNac = new JLabel("Fecha de Nacimiento");
		LabelFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelFechaNac.setBounds(25, 265, 130, 15);
		getContentPane().add(LabelFechaNac);
		
		JLabel LabelInstituto = new JLabel("Instituto");
		LabelInstituto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelInstituto.setBounds(25, 305, 70, 15);
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
		
		textFieldPasswrd = new JPasswordField ();
		textFieldPasswrd.setColumns(10);
		textFieldPasswrd.setBounds(165, 180, 130, 25);
		getContentPane().add(textFieldPasswrd);
		
		textFieldPasswordOK = new JPasswordField ();
		textFieldPasswordOK.setColumns(10);
		textFieldPasswordOK.setBounds(165, 220, 130, 25);
		getContentPane().add(textFieldPasswordOK);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(165, 260, 130, 25);
		getContentPane().add(dateChooser);

		institutoChoose = new JComboBox<String>();
		iniciarlizarComboBoxes();
		institutoChoose.setBounds(165, 300, 130, 25);
		getContentPane().add(institutoChoose);

		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaUsuarioActionPerformed(e);
			}
		});
		ButtonAceptar.setBounds(325, 100, 90, 25);
		getContentPane().add(ButtonAceptar);

		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarAltaUsuario(arg0);
			}
		});
		ButtonCancelar.setBounds(325, 180, 90, 25);
		getContentPane().add(ButtonCancelar);
		
		
	}

	protected void cancelarAltaUsuario(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}

	protected void AltaUsuarioActionPerformed(ActionEvent arg0) {
		String nickname = this.textFieldNick.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		String pswwd = String.valueOf(this.textFieldPasswrd.getPassword());
		Date dateChooser = this.dateChooser.getDate();
		if(checkFormulario()) {
			try {
				String instituto = this.institutoChoose.getSelectedItem().toString();
				if(!instituto.isEmpty()) {
					this.icon.AltaUsuario(nickname, nombre, apellido, email, dateChooser, instituto, pswwd, "");
					JOptionPane.showMessageDialog(this, "El Docente se ha creado con exito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
					limpiarFormulario();
					setVisible(false);
				} else {
					this.icon.AltaUsuario(nickname, nombre, apellido, email, dateChooser, null, pswwd, "");
					JOptionPane.showMessageDialog(this, "El Estudiante se ha creado con exito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
					limpiarFormulario();
					setVisible(false);
				}
			} catch(UsuarioExcepcion u) {
				JOptionPane.showMessageDialog(this, u.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(icon.listarInstituto());
		listInst.insertElementAt((new String("")),0);
		institutoChoose.setModel(listInst);
		institutoChoose.setSelectedIndex(0);
	}
	
	private boolean checkFormulario() {
		String nickname = this.textFieldNick.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldNombre.getText();
		String email = this.textFieldEmail.getText();
		String pswwd = String.valueOf(this.textFieldPasswrd.getPassword());
		String pswwdOK = String.valueOf(this.textFieldPasswordOK.getPassword());
		Date dateChooser = this.dateChooser.getDate();
		String fechaString = dateChooser.toString();

		Date todayDate = Calendar.getInstance().getTime();
		if(nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || fechaString.isEmpty() || pswwd.isEmpty() || pswwdOK.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacioss", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
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
		if(!pswwd.equals(pswwdOK)) {
			JOptionPane.showMessageDialog(this, "Password no es igual, por favor ingresa los datos de nuevo", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			textFieldPasswrd.setText("");
			textFieldPasswordOK.setText("");
            return false;
		}
		if(pswwd.length() < 8) {
			JOptionPane.showMessageDialog(this, "Password debe tener al menos 8 caracteres", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
		textFieldEmail.setText("");
		textFieldNick.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldPasswrd.setText("");
		textFieldPasswordOK.setText("");
		dateChooser.setDate((Date)null);
		dateChooser.revalidate();
	}
}
