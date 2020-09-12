package presentacion.curso;

import exepciones.InstitutoExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class ConsultaCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorCurso icon;
	private JComboBox<String> comboBoxInstitutos;
	private JList listCursos;
	private JTextField textNomCurso;
	private JTextField textDescripcion;
	private JTextField textUrl;
	private JTextField textFechaAlta;
	private JTextField textCantCredito;
	private JTextField textCantHoras;
	private JTextField textDuracion;
	
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

		comboBoxInstitutos = new JComboBox<String>();
		inicializarComboBoxInstituto();
		comboBoxInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbInstitutosActionPerformed(e);
			}
		});
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

		listCursos = new JList();

		listCursos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()){
					JList source = (JList)listSelectionEvent.getSource();
					String selected = source.getSelectedValue().toString();
				}
			}
		});

		listCursos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listCursos.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		JScrollPane listScroller = new JScrollPane(this.listCursos);
		listScroller.setBounds(155, 415, 200, 100);
		getContentPane().add(listScroller);

		JOptionPane.showMessageDialog(this, this.listCursos);

	}

		private void cbInstitutosActionPerformed(ActionEvent e) {
			String nomInstituto = this.comboBoxInstitutos.getSelectedItem().toString();
			try{
				ArrayList<String> listaCursosDeInst = icon.listarCursos(nomInstituto);
				if(!listaCursosDeInst.isEmpty()) {
					Vector<String> list = new Vector<String>();
					for (String s : listaCursosDeInst) {
						list.addElement(s);
					}
				this.listCursos.setListData(list);
			}}catch (InstitutoExcepcion institutoExcepcion) {
				JOptionPane.showMessageDialog(this, "El instituto no existe");
			}
		}

		public void inicializarComboBoxInstituto() {
			DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(icon.listarInstitutos());
			listInst.insertElementAt((new String("")),0);
			comboBoxInstitutos.setModel(listInst);
			comboBoxInstitutos.setSelectedIndex(0);
		}

		public JComboBox<String> inicializarComboBoxIns() {
			JComboBox<String> listInst = new JComboBox<String>(icon.listarInstitutos());
			listInst.insertItemAt((new String("")), 0);
			listInst.setSelectedIndex(0);
			return listInst;
		}

}
