package presentacion.usuario;

import java.util.Date;
import java.util.Calendar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;

import exepciones.*;
import interfaces.*;

import com.toedter.calendar.JDateChooser;

public class AltaUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	
	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JDateChooser dateChooser;
	private JTextField textFieldInstituto;
	

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
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setColumns(10);
		textFieldInstituto.setBounds(165, 220, 130, 25);
		getContentPane().add(textFieldInstituto);

		JButton ButtonAceptar = new JButton("Aceptar");
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
		String instituto = this.textFieldInstituto.getText();
		/*if(checkFormulario()) {
			try {
				if(!instituto.isEmpty()) {
					JOptionPane.showMessageDialog(this, "El Docente se ha creado con éxito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "El Estudiante se ha creado con éxito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch(UsuarioRepetidoExcepcion u) {
			JOptionPane.showMessageDialog(this, u.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			}
		limpiarFormulario();
		setVisible(false);
		}*/
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
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		if(dateChooser.compareTo(todayDate) > 0) {
			JOptionPane.showMessageDialog(this, "Debe ingresar una fecha de nacimiento valida", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
            return false;
		}
		if(!email.contains("@")) {
			JOptionPane.showMessageDialog(this, "Debe añadir una direccion de correo valida", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
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
		textFieldInstituto.setText("");
	}
}
