package presentacion.curso;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IcontroladorCurso;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class AltaCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IcontroladorCurso icon;
	private JTextField textNombreCur;
	private JTextField textDescripcion;
	private JTextField textCantCreditos;
	private JTextField textURL;
	private JDateChooser dateChooser;
	
	public AltaCurso(IcontroladorCurso icon) {
		
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Curso");
		setBounds(100, 100, 456, 621);
		getContentPane().setLayout(null);
		
		JLabel LabelSelIns = new JLabel("Seleccionar Instituto");
		LabelSelIns.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelIns.setBounds(20, 30, 120, 20);
		getContentPane().add(LabelSelIns);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(155, 30, 200, 20);
		getContentPane().add(comboBox);
		
		JLabel LabelNombreCurso = new JLabel("Nombre de Curso");
		LabelNombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelNombreCurso.setBounds(35, 70, 105, 20);
		getContentPane().add(LabelNombreCurso);
		
		JLabel LabelDesc = new JLabel("Descripcion");
		LabelDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDesc.setBounds(70, 110, 70, 20);
		getContentPane().add(LabelDesc);
		
		textNombreCur = new JTextField();
		textNombreCur.setBounds(155, 70, 200, 20);
		getContentPane().add(textNombreCur);
		textNombreCur.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(155, 110, 200, 80);
		getContentPane().add(textDescripcion);
		
		JLabel LabelDur = new JLabel("Duracion");
		LabelDur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDur.setBounds(80, 210, 58, 20);
		getContentPane().add(LabelDur);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(155, 210, 50, 20);
		getContentPane().add(comboBox_1);
		
		JLabel LabelMeses = new JLabel("Mes/Meses");
		LabelMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelMeses.setBounds(215, 210, 70, 20);
		getContentPane().add(LabelMeses);
		
		JLabel LabelCantHoras = new JLabel("Cantidad de Horas");
		LabelCantHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCantHoras.setBounds(25, 250, 118, 20);
		getContentPane().add(LabelCantHoras);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(155, 250, 50, 20);
		getContentPane().add(comboBox_1_1);
		
		JLabel LabelHoras = new JLabel("Por Dia");
		LabelHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelHoras.setBounds(215, 250, 50, 20);
		getContentPane().add(LabelHoras);
		
		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de Creditos");
		lblCantidadDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDeCreditos.setBounds(20, 290, 121, 20);
		getContentPane().add(lblCantidadDeCreditos);
		
		textCantCreditos = new JTextField();
		textCantCreditos.setBounds(155, 290, 50, 20);
		getContentPane().add(textCantCreditos);
		textCantCreditos.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrl.setBounds(100, 330, 30, 20);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(155, 330, 200, 20);
		getContentPane().add(textURL);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeAlta.setBounds(50, 370, 90, 20);
		getContentPane().add(lblFechaDeAlta);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(155, 365, 200, 25);
		getContentPane().add(dateChooser);
		
		JLabel lblMateriasPrevias = new JLabel("Materias previas");
		lblMateriasPrevias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMateriasPrevias.setBounds(35, 410, 105, 20);
		getContentPane().add(lblMateriasPrevias);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(155, 415, 200, 100);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.setBounds(70, 540, 100, 30);
		getContentPane().add(ButtonAceptar);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.setBounds(270, 540, 100, 30);
		getContentPane().add(ButtonCancelar);

	}
}
