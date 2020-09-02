package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AgregarCursoPorgramaFormacion extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCursoPorgramaFormacion frame = new AgregarCursoPorgramaFormacion();
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
	public AgregarCursoPorgramaFormacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPdf = new JLabel("Seleccionar Programa de Formacion");
		lblPdf.setBounds(25, 45, 178, 14);
		getContentPane().add(lblPdf);
		
		JLabel lblCurso = new JLabel("Seleccionar Curso");
		lblCurso.setBounds(25, 96, 178, 14);
		getContentPane().add(lblCurso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(232, 45, 178, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(232, 92, 178, 22);
		getContentPane().add(comboBox_1);
		
		JButton button = new JButton("Aceptar");
		button.setBounds(58, 171, 115, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(232, 171, 115, 23);
		getContentPane().add(button_1);

	}
}
