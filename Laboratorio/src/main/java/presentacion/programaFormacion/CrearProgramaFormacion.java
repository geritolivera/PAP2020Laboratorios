package presentacion.programaFormacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

@SuppressWarnings("serial")
public class CrearProgramaFormacion extends JInternalFrame {
	private JTextField inputNombre;
	private JTextArea inputDescripcion;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	

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
		nombrePDF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombrePDF.setBounds(10, 21, 72, 14);
		getContentPane().add(nombrePDF);
		
		JLabel fechaInicio = new JLabel("Fecha de Inicio:");
		fechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fechaInicio.setBounds(10, 57, 130, 14);
		getContentPane().add(fechaInicio);
		
		JLabel fechaFin = new JLabel("Fecha de Fin:");
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fechaFin.setBounds(10, 92, 82, 14);
		getContentPane().add(fechaFin);
		
		JLabel descripcion = new JLabel("Descripcion:");
		descripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descripcion.setBounds(10, 131, 82, 14);
		getContentPane().add(descripcion);
		
		inputNombre = new JTextField();
		inputNombre.setBounds(244, 18, 130, 25);
		getContentPane().add(inputNombre);
		inputNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(86, 208, 115, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarAltaProgramaFormacion(e);
			}
		});
		btnCancelar.setBounds(259, 208, 115, 23);
		getContentPane().add(btnCancelar);
		
		JTextArea inputDescripcion = new JTextArea();
		inputDescripcion.setBounds(102, 128, 296, 57);
		getContentPane().add(inputDescripcion);
		
		JDateChooser dateInicio = new JDateChooser();
		dateInicio.setBounds(244, 56, 130, 25);
		getContentPane().add(dateInicio);
		
		JDateChooser dateFin = new JDateChooser();
		dateFin.setBounds(244, 92, 130, 25);
		getContentPane().add(dateFin);

	}
	protected void cancelarAltaProgramaFormacion(ActionEvent e) {
		//PORQUE EXPLOTA?
		limpiarFormulario(); 
		setVisible(false);
	}

	private void limpiarFormulario() {
		inputNombre.setText("");
		//inputDescripcion.setText("Jorge");
		dateInicio=null;
		dateFin=null;
		
	}
}
