package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IcontroladorCurso;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaInstituto extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IcontroladorCurso iconC;
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
	public AltaInstituto(IcontroladorCurso iconC) {
		this.iconC = iconC;
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
		
		JButton btnAceptar = new JButton("Acceptar");
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
			this.iconC.AltaInstituto(nombreInstituto);
			JOptionPane.showMessageDialog(this, "El instituto " + nombreInstituto + " se da de alta con exito " , "Alta Instituto",JOptionPane.INFORMATION_MESSAGE);
		}catch(InstitutoRepetidoExcepcion e) {
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
