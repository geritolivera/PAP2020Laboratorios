package presentacion.usuario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaUsuario extends JInternalFrame {
	private JTextField textFieldEmail;
	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldFechaNa;
	private JTextField textFieldInstituto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaUsuario() {
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
		LabelFechaNac.setBounds(25, 185, 175, 15);
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

		textFieldFechaNa = new JTextField();
		textFieldFechaNa.setColumns(10);
		textFieldFechaNa.setBounds(165, 180, 130, 25);
		getContentPane().add(textFieldFechaNa);

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

	private void limpiarFormulario() {
		textFieldEmail.setText("");
		textFieldNick.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldFechaNa.setText("");
		textFieldInstituto.setText("");
	}

}
