package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import interfaces.IcontroladorCurso;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaDeEdicionDeCurso extends JInternalFrame {
	private IcontroladorCurso iconC;
	private JTextField tfNombre;
	private JTextField tfFechaInicio;
	private JTextField tfFechaFin;
	private JTextField tfCupo;
	private JTextField tfPublicacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					ConsultaDeEdicionDeCurso frame = new ConsultaDeEdicionDeCurso(null);
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param iconC 
	 */
	public ConsultaDeEdicionDeCurso(IcontroladorCurso iconC) {
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Edicion de Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Instituto");
		lblNewLabel.setBounds(32, 22, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(186, 22, 46, 14);
		getContentPane().add(lblCursos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(230, 19, 86, 20);
		getContentPane().add(comboBox);
		
		JLabel lblEdicionesDeCurso = new JLabel("Ediciones de Curso");
		lblEdicionesDeCurso.setBounds(32, 77, 126, 14);
		getContentPane().add(lblEdicionesDeCurso);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(181, 74, 109, 20);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(85, 19, 73, 20);
		getContentPane().add(comboBox_2);
		
		JButton btnVerInfo = new JButton("Ver Info");
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVerInfoActionPerformed(arg0);
			}
		});
		btnVerInfo.setBounds(311, 73, 89, 23);
		getContentPane().add(btnVerInfo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 147, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		lblFechaDeInicio.setBounds(32, 174, 89, 14);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(32, 199, 89, 14);
		getContentPane().add(lblFechaDeFin);
		
		JLabel lblCupo = new JLabel("Cupo");
		lblCupo.setBounds(32, 224, 46, 14);
		getContentPane().add(lblCupo);
		
		JLabel lblFechaDePublicacion = new JLabel("Fecha de publicacion");
		lblFechaDePublicacion.setBounds(32, 245, 120, 14);
		getContentPane().add(lblFechaDePublicacion);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(146, 144, 86, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfFechaInicio = new JTextField();
		tfFechaInicio.setBounds(146, 171, 86, 20);
		getContentPane().add(tfFechaInicio);
		tfFechaInicio.setColumns(10);
		
		tfFechaFin = new JTextField();
		tfFechaFin.setBounds(146, 196, 86, 20);
		getContentPane().add(tfFechaFin);
		tfFechaFin.setColumns(10);
		
		tfCupo = new JTextField();
		tfCupo.setBounds(146, 221, 86, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);
		
		tfPublicacion = new JTextField();
		tfPublicacion.setBounds(146, 245, 86, 20);
		getContentPane().add(tfPublicacion);
		tfPublicacion.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 147, 109, 112);
		getContentPane().add(scrollPane);
		
		JTextPane textPaneDocentes = new JTextPane();
		scrollPane.setViewportView(textPaneDocentes);
		
		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setBounds(314, 126, 46, 14);
		getContentPane().add(lblDocentes);

	}
	protected void btnVerInfoActionPerformed(ActionEvent arg0) {
		
	}
}
