package presentacion.curso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IcontroladorCurso;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConsultaCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private final IcontroladorCurso icon;
	private final JTextField textNomCurso;
	private final JTextField textDescripcion;
	private final JTextField textUrl;
	private final JTextField textFechaAlta;
	private final JTextField textCantCredito;
	private final JTextField textCantHoras;
	private final JTextField textDuracion;
	
	public ConsultaCurso(IcontroladorCurso icon) {
		
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Curso");
		setBounds(100, 100, 426, 652);
		getContentPane().setLayout(null);
		
		JLabel LabelSelIns = new JLabel("Seleccionar Instituto");
		LabelSelIns.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelIns.setBounds(20, 25, 120, 20);
		getContentPane().add(LabelSelIns);
		
		JComboBox comboBoxInstitutos = new JComboBox();
		comboBoxInstitutos.setBounds(155, 25, 200, 20);
		getContentPane().add(comboBoxInstitutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(155, 68, 200, 105);
		getContentPane().add(scrollPane);
		
		JList<String> ListaCursosAso = new JList<String>();
		scrollPane.setViewportView(ListaCursosAso);
		ListaCursosAso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel LabelCursosAso = new JLabel("Cursos Asociados");
		LabelCursosAso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCursosAso.setBounds(35, 70, 120, 20);
		getContentPane().add(LabelCursosAso);
		
		JLabel lblDatosDelCurso = new JLabel("Datos del Curso:");
		lblDatosDelCurso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosDelCurso.setBounds(20, 210, 135, 20);
		getContentPane().add(lblDatosDelCurso);
		
		JLabel LabelNombreCurso = new JLabel("Nombre de Curso");
		LabelNombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelNombreCurso.setBounds(20, 240, 105, 20);
		getContentPane().add(LabelNombreCurso);
		
		textNomCurso = new JTextField();
		textNomCurso.setColumns(10);
		textNomCurso.setBounds(155, 240, 200, 20);
		getContentPane().add(textNomCurso);
		
		JLabel LabelDesc = new JLabel("Descripcion");
		LabelDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDesc.setBounds(55, 275, 70, 20);
		getContentPane().add(LabelDesc);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(155, 275, 200, 80);
		getContentPane().add(textDescripcion);
		
		JLabel LabelDur = new JLabel("Duracion");
		LabelDur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDur.setBounds(65, 360, 58, 20);
		getContentPane().add(LabelDur);
		
		JLabel LabelMeses = new JLabel("Mes/Meses");
		LabelMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelMeses.setBounds(210, 360, 70, 20);
		getContentPane().add(LabelMeses);
		
		JLabel LabelCantHoras = new JLabel("Cantidad de Horas");
		LabelCantHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCantHoras.setBounds(20, 390, 105, 20);
		getContentPane().add(LabelCantHoras);
		
		JLabel LabelHoras = new JLabel("Por Dia");
		LabelHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelHoras.setBounds(210, 390, 50, 20);
		getContentPane().add(LabelHoras);
		
		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de Creditos");
		lblCantidadDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDeCreditos.setBounds(20, 420, 121, 20);
		getContentPane().add(lblCantidadDeCreditos);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrl.setBounds(100, 450, 30, 20);
		getContentPane().add(lblUrl);
		
		textUrl = new JTextField();
		textUrl.setColumns(10);
		textUrl.setBounds(155, 450, 200, 20);
		getContentPane().add(textUrl);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeAlta.setBounds(50, 480, 90, 20);
		getContentPane().add(lblFechaDeAlta);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setColumns(10);
		textFechaAlta.setBounds(155, 480, 200, 20);
		getContentPane().add(textFechaAlta);
		
		textCantCredito = new JTextField();
		textCantCredito.setColumns(10);
		textCantCredito.setBounds(155, 420, 40, 20);
		getContentPane().add(textCantCredito);
		
		textCantHoras = new JTextField();
		textCantHoras.setColumns(10);
		textCantHoras.setBounds(155, 390, 40, 20);
		getContentPane().add(textCantHoras);
		
		textDuracion = new JTextField();
		textDuracion.setColumns(10);
		textDuracion.setBounds(155, 360, 40, 20);
		getContentPane().add(textDuracion);
		
		JLabel lblEdicionesAsociadas = new JLabel("Ediciones Asociadas");
		lblEdicionesAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdicionesAsociadas.setBounds(20, 510, 120, 20);
		getContentPane().add(lblEdicionesAsociadas);
		
		JComboBox comboBoxEdicionCurso = new JComboBox();
		comboBoxEdicionCurso.setBounds(155, 510, 200, 20);
		getContentPane().add(comboBoxEdicionCurso);
		
		JComboBox comboBoxProAso = new JComboBox();
		comboBoxProAso.setBounds(155, 540, 200, 20);
		getContentPane().add(comboBoxProAso);
		
		JLabel lblProgramasAsociadas = new JLabel("Programas Asociados");
		lblProgramasAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProgramasAsociadas.setBounds(20, 541, 135, 20);
		getContentPane().add(lblProgramasAsociadas);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.setBounds(185, 580, 75, 25);
		getContentPane().add(ButtonCancelar);
		
		JButton btnSeleccionarCurso = new JButton("Seleccionar Curso");
		btnSeleccionarCurso.setBounds(195, 185, 120, 25);
		getContentPane().add(btnSeleccionarCurso);
	}
}
