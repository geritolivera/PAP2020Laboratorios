package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class CrearProgramaFormacion extends JInternalFrame {
	private JTextField inputNombre;
	private JTextField inputFechaInicio;
	private JTextField inputFechaFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProgramaFormacion frame = new CrearProgramaFormacion();
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
	public CrearProgramaFormacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel nombrePDF = new JLabel("Nombre: ");
		nombrePDF.setBounds(10, 21, 46, 14);
		getContentPane().add(nombrePDF);
		
		JLabel fechaInicio = new JLabel("(*) Fecha de Inicio:");
		fechaInicio.setBounds(10, 46, 99, 14);
		getContentPane().add(fechaInicio);
		
		JLabel fechaFin = new JLabel("(*) Fecha de Fin:");
		fechaFin.setBounds(10, 71, 82, 14);
		getContentPane().add(fechaFin);
		
		JLabel descripcion = new JLabel("Descripcion:");
		descripcion.setBounds(10, 103, 63, 14);
		getContentPane().add(descripcion);
		
		inputNombre = new JTextField();
		inputNombre.setBounds(112, 18, 86, 20);
		getContentPane().add(inputNombre);
		inputNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(66, 183, 115, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(231, 183, 115, 23);
		getContentPane().add(btnCancelar);
		
		inputFechaInicio = new JTextField();
		inputFechaInicio.setColumns(10);
		inputFechaInicio.setBounds(112, 43, 86, 20);
		getContentPane().add(inputFechaInicio);
		
		inputFechaFin = new JTextField();
		inputFechaFin.setColumns(10);
		inputFechaFin.setBounds(112, 68, 86, 20);
		getContentPane().add(inputFechaFin);
		
		JTextArea inputDescripcion = new JTextArea();
		inputDescripcion.setBounds(83, 103, 326, 57);
		getContentPane().add(inputDescripcion);
		
		JLabel ayudin = new JLabel("(*) Utilizar el formato dd/mm/aa");
		ayudin.setBounds(10, 230, 156, 14);
		getContentPane().add(ayudin);

	}
}
