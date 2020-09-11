package presentacion;

import exepciones.InstitutoExcepcion;
import interfaces.IcontroladorUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaInstituto extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IcontroladorUsuario iusu;
	private JTextField tfNombreInstituto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					AltaInstituto frame = new AltaInstituto();
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaInstituto(IcontroladorUsuario iusu) {
		this.iusu = iusu;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Instituto");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 35, 46, 14);
		getContentPane().add(lblNombre);
		
		tfNombreInstituto = new JTextField();
		tfNombreInstituto.setBounds(93, 32, 86, 20);
		getContentPane().add(tfNombreInstituto);
		tfNombreInstituto.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAceptarActionPerformed(arg0);		
			}
		});
		btnAceptar.setBounds(52, 152, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancelarActionPerformed(arg0);
			}
		});
		btnCancelar.setBounds(155, 152, 89, 23);
		getContentPane().add(btnCancelar);

	}
	protected void btnAceptarActionPerformed(ActionEvent arg0) {
		String nombreInstituto = this.tfNombreInstituto.getText();
		if (nombreInstituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Alta Instituto",JOptionPane.ERROR_MESSAGE);
		}try {
			this.iusu.AltaInstituto(nombreInstituto);
			JOptionPane.showMessageDialog(this, "El instituto " + nombreInstituto + " se da de alta con exito " , "Alta Instituto",JOptionPane.INFORMATION_MESSAGE);
		}catch(InstitutoExcepcion e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Instituto", JOptionPane.ERROR_MESSAGE);
		}
		tfNombreInstituto.setText("");
        setVisible(false);
	}
	
	protected void btnCancelarActionPerformed(ActionEvent arg0) {
		tfNombreInstituto.setText("");
        setVisible(false);
	}
}
