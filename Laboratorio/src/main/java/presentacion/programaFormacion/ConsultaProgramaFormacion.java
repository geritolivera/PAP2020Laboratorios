package presentacion.programaFormacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
@SuppressWarnings("serial")
public class ConsultaProgramaFormacion extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProgramaFormacion frame = new ConsultaProgramaFormacion();
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
	public ConsultaProgramaFormacion() {
		setBounds(100, 100, 711, 455);
		getContentPane().setLayout(null);
		
		JLabel lblProgramaFormacion = new JLabel("Programa de Formacion");
		lblProgramaFormacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramaFormacion.setBounds(38, 36, 160, 20);
		getContentPane().add(lblProgramaFormacion);
		
		JComboBox comboBoxPorgramaFormacion = new JComboBox();
		comboBoxPorgramaFormacion.setBounds(38, 67, 174, 22);
		getContentPane().add(comboBoxPorgramaFormacion);
		
		JPanel panelPProgramaFormacion = new JPanel();
		panelPProgramaFormacion.setLayout(null);
		panelPProgramaFormacion.setBorder(new TitledBorder(null, "Informacion de Programa de Formacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPProgramaFormacion.setBounds(38, 131, 304, 187);
		getContentPane().add(panelPProgramaFormacion);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(10, 24, 72, 14);
		panelPProgramaFormacion.add(label_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(102, 21, 113, 20);
		panelPProgramaFormacion.add(textField);
		
		JLabel label_3 = new JLabel("Descripcion");
		label_3.setBounds(10, 62, 72, 14);
		panelPProgramaFormacion.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(102, 59, 113, 20);
		panelPProgramaFormacion.add(textField_1);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setBounds(10, 96, 72, 14);
		panelPProgramaFormacion.add(lblFechaDeInicio);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(102, 93, 113, 20);
		panelPProgramaFormacion.add(textField_2);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de FIn");
		lblFechaDeFin.setBounds(10, 131, 95, 14);
		panelPProgramaFormacion.add(lblFechaDeFin);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(102, 128, 113, 20);
		panelPProgramaFormacion.add(textField_3);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Informacion de Cursos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(381, 131, 256, 155);
		getContentPane().add(panel);
		
		JComboBox comboBoxCursos = new JComboBox();
		comboBoxCursos.setBounds(104, 27, 113, 20);
		panel.add(comboBoxCursos);
		
		JLabel label = new JLabel("Cursos");
		label.setBounds(10, 29, 46, 14);
		panel.add(label);
		
		JButton button = new JButton("Ver Mas");
		button.setBounds(104, 86, 89, 23);
		panel.add(button);

	}
}
