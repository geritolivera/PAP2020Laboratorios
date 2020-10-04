package presentacion;

import exepciones.CategoriaExcepcion;

import java.awt.event.*;

import javax.swing.*;

import interfaces.IcontroladorUsuario;

import java.awt.Font;

public class AltaCategoria extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private IcontroladorUsuario iusu;
	private JTextField NombreCategoria;
	
	public AltaCategoria(IcontroladorUsuario iusu) {
		this.iusu = iusu;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Categoria");
		setBounds(100, 100, 320, 170);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(35, 40, 60, 15);
		getContentPane().add(lblNombre);
		
		NombreCategoria = new JTextField();
		NombreCategoria.setBounds(95, 35, 150, 20);
		getContentPane().add(NombreCategoria);
		NombreCategoria.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAceptarActionPerformed(arg0);
			}
			
		});
		btnAceptar.setBounds(35, 80, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancelarActionPerformed(arg0);
			}
		});
		btnCancelar.setBounds(160, 80, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	protected void btnAceptarActionPerformed(ActionEvent arg0) {
		String nombreCategoria = this.NombreCategoria.getText();
		if (nombreCategoria.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Alta de Categoria",JOptionPane.ERROR_MESSAGE);
		}try {
			this.iusu.AltaCategoria(nombreCategoria);
			JOptionPane.showMessageDialog(this, "La categoria " + nombreCategoria + " se dio de alta con exito " , "Alta de Categoria", JOptionPane.INFORMATION_MESSAGE);
		}catch(CategoriaExcepcion e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Alta de Categoria", JOptionPane.ERROR_MESSAGE);
		}
		NombreCategoria.setText("");
        setVisible(false);
	}
	
	protected void btnCancelarActionPerformed(ActionEvent arg0) {
		NombreCategoria.setText("");
        setVisible(false);
	}
}
