package presentacion.curso;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
import exepciones.ProgramaFormacionExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class ConsultaCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorCurso icon;
	private JTextArea textDescripcion;
	private JTextField textUrl;
	private JTextField textFechaAlta;
	private JTextField textCantCredito;
	private JTextField textCantHoras;
	private JTextField textDuracion;
	private JComboBox<String> comboBoxEdicionCurso;
	private JComboBox<String> comboBoxPrevias;
	private JComboBox<String> comboBoxProAso;
	private JComboBox<String> comboBoxInstitutos;
	private JComboBox<String> comboBoxCursos;
	private JComboBox<String> comboBoxCategoria;
	private JTextField textFieldFechaI;
	private JTextField textFieldFechaF;
	private JTextField textFieldFechP;
	private JTextField textFieldCupo;
	private JTextField textFieldFechaIP;
	private JTextField textFieldFechaFP;
	private JTextField textFieldFechaIngresoP;
	private JTextArea textFieldDescripcionP;

	public ConsultaCurso(IcontroladorCurso icon) {

		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Curso");
		setBounds(100, 100, 1134, 580);
		getContentPane().setLayout(null);

		JLabel LabelSelIns = new JLabel("Seleccionar Instituto");
		LabelSelIns.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelIns.setBounds(20, 25, 147, 20);
		getContentPane().add(LabelSelIns);

		comboBoxInstitutos = new JComboBox<String>();
		comboBoxInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxInstitutosActionPerformed(arg0);
			}
		});
		comboBoxInstitutos.setBounds(169, 25, 200, 20);
		getContentPane().add(comboBoxInstitutos);

		JLabel LabelCursosAso = new JLabel("Cursos Asociados");
		LabelCursosAso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCursosAso.setBounds(30, 59, 120, 20);
		getContentPane().add(LabelCursosAso);

		JPanel panelCurso = new JPanel();
		panelCurso.setLayout(null);
		panelCurso.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del Curso",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panelCurso.setBounds(10, 103, 408, 400);
		getContentPane().add(panelCurso);

		JLabel LabelDesc = new JLabel("Descripcion");
		LabelDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDesc.setBounds(17, 32, 88, 20);
		panelCurso.add(LabelDesc);

		textDescripcion = new JTextArea();
		textDescripcion.setEnabled(false);
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(169, 32, 200, 51);
		panelCurso.add(textDescripcion);

		JLabel LabelDur = new JLabel("Duracion");
		LabelDur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDur.setBounds(17, 89, 58, 20);
		panelCurso.add(LabelDur);

		JLabel LabelMeses = new JLabel("Mes/Meses");
		LabelMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelMeses.setBounds(214, 94, 88, 20);
		panelCurso.add(LabelMeses);

		JLabel LabelCantHoras = new JLabel("Cantidad de Horas");
		LabelCantHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCantHoras.setBounds(17, 137, 135, 20);
		panelCurso.add(LabelCantHoras);

		JLabel LabelHoras = new JLabel("Por Dia");
		LabelHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelHoras.setBounds(216, 137, 50, 20);
		panelCurso.add(LabelHoras);

		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de Creditos");
		lblCantidadDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDeCreditos.setBounds(17, 187, 147, 20);
		panelCurso.add(lblCantidadDeCreditos);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrl.setBounds(17, 217, 30, 20);
		panelCurso.add(lblUrl);

		textUrl = new JTextField();
		textUrl.setEnabled(false);
		textUrl.setColumns(10);
		textUrl.setBounds(169, 218, 200, 20);
		panelCurso.add(textUrl);

		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeAlta.setBounds(17, 248, 90, 20);
		panelCurso.add(lblFechaDeAlta);

		textFechaAlta = new JTextField();
		textFechaAlta.setEnabled(false);
		textFechaAlta.setColumns(10);
		textFechaAlta.setBounds(169, 249, 200, 20);
		panelCurso.add(textFechaAlta);

		textCantCredito = new JTextField();
		textCantCredito.setEnabled(false);
		textCantCredito.setColumns(10);
		textCantCredito.setBounds(169, 187, 40, 20);
		panelCurso.add(textCantCredito);

		textCantHoras = new JTextField();
		textCantHoras.setEnabled(false);
		textCantHoras.setColumns(10);
		textCantHoras.setBounds(166, 138, 40, 20);
		panelCurso.add(textCantHoras);

		textDuracion = new JTextField();
		textDuracion.setEnabled(false);
		textDuracion.setColumns(10);
		textDuracion.setBounds(166, 94, 40, 20);
		panelCurso.add(textDuracion);

		JLabel lblEdicionesAsociadas = new JLabel("Ediciones Asociadas");
		lblEdicionesAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdicionesAsociadas.setBounds(17, 279, 147, 20);
		panelCurso.add(lblEdicionesAsociadas);

		comboBoxEdicionCurso = new JComboBox<String>();
		comboBoxEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxEdicionCursoActionPerformed(arg0);
			}
		});
		comboBoxEdicionCurso.setEnabled(false);
		comboBoxEdicionCurso.setBounds(169, 280, 200, 20);
		panelCurso.add(comboBoxEdicionCurso);

		JLabel labelPrevias = new JLabel("Previas Asociadas");
		labelPrevias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPrevias.setBounds(17, 310, 147, 20);
		panelCurso.add(labelPrevias);

		comboBoxPrevias = new JComboBox<String>();
		comboBoxPrevias.setEnabled(false);
		comboBoxPrevias.setBounds(169, 311, 200, 20);
		panelCurso.add(comboBoxPrevias);
		
		JLabel lblProgramasAsociadas = new JLabel("Programas Asociados");
		lblProgramasAsociadas.setBounds(17, 341, 134, 20);
		panelCurso.add(lblProgramasAsociadas);
		lblProgramasAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 13));

		comboBoxProAso = new JComboBox<String>();
		comboBoxProAso.setBounds(169, 341, 200, 20);
		panelCurso.add(comboBoxProAso);
		comboBoxProAso.setEnabled(false);
						
		comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.setEnabled(false);
		comboBoxCategoria.setBounds(169, 369, 200, 20);
		panelCurso.add(comboBoxCategoria);
						
		JLabel lblCategoria = new JLabel("Categorias");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategoria.setBounds(17, 369, 134, 20);
		panelCurso.add(lblCategoria);
		comboBoxProAso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					comboBoxProAsoActionPerformed(arg0);
			}
		});

		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.setEnabled(false);
		comboBoxCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxCursosActionPerformed(arg0);
			}
		});
		comboBoxCursos.setBounds(169, 57, 200, 24);
		getContentPane().add(comboBoxCursos);

		JPanel panelEdiciones = new JPanel();
		panelEdiciones.setBounds(428, 103, 350, 206);
		panelEdiciones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Edicion",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		getContentPane().add(panelEdiciones);
		panelEdiciones.setLayout(null);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(10, 40, 66, 16);
		panelEdiciones.add(lblFechaInicio);
		lblFechaInicio.setFont(new Font("Dialog", Font.PLAIN, 12));

		textFieldFechaI = new JTextField();
		textFieldFechaI.setBounds(154, 39, 102, 19);
		panelEdiciones.add(textFieldFechaI);
		textFieldFechaI.setEnabled(false);
		textFieldFechaI.setColumns(10);

		JLabel lblFechaPub = new JLabel("Fecha Publ");
		lblFechaPub.setBounds(10, 128, 80, 15);
		panelEdiciones.add(lblFechaPub);
		lblFechaPub.setFont(new Font("Dialog", Font.PLAIN, 12));

		textFieldFechP = new JTextField();
		textFieldFechP.setBounds(154, 126, 102, 19);
		panelEdiciones.add(textFieldFechP);
		textFieldFechP.setEnabled(false);
		textFieldFechP.setColumns(10);

		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(10, 85, 70, 15);
		panelEdiciones.add(lblFechaFin);
		lblFechaFin.setFont(new Font("Dialog", Font.PLAIN, 12));

		textFieldFechaF = new JTextField();
		textFieldFechaF.setBounds(154, 83, 102, 19);
		panelEdiciones.add(textFieldFechaF);
		textFieldFechaF.setEnabled(false);
		textFieldFechaF.setColumns(10);

		JLabel lblCupo = new JLabel("Cupo");
		lblCupo.setBounds(10, 169, 70, 15);
		panelEdiciones.add(lblCupo);
		lblCupo.setFont(new Font("Dialog", Font.PLAIN, 12));

		textFieldCupo = new JTextField();
		textFieldCupo.setBounds(154, 167, 47, 19);
		panelEdiciones.add(textFieldCupo);
		textFieldCupo.setEnabled(false);
		textFieldCupo.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del Programa",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_1.setBounds(789, 103, 325, 228);
		getContentPane().add(panel_1);

		JLabel label_2 = new JLabel("Descripcion");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 60, 73, 15);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("Fecha Inicio");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(10, 129, 73, 15);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Fecha Fin");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(10, 155, 73, 15);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("Fecha de Ingreso");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(10, 181, 100, 15);
		panel_1.add(label_5);

		textFieldDescripcionP = new JTextArea();
		textFieldDescripcionP.setEditable(false);
		textFieldDescripcionP.setColumns(10);
		textFieldDescripcionP.setBounds(120, 63, 180, 53);
		panel_1.add(textFieldDescripcionP);

		textFieldFechaIP = new JTextField();
		textFieldFechaIP.setEditable(false);
		textFieldFechaIP.setColumns(10);
		textFieldFechaIP.setBounds(120, 127, 180, 20);
		panel_1.add(textFieldFechaIP);

		textFieldFechaFP = new JTextField();
		textFieldFechaFP.setEditable(false);
		textFieldFechaFP.setColumns(10);
		textFieldFechaFP.setBounds(120, 153, 180, 20);
		panel_1.add(textFieldFechaFP);

		textFieldFechaIngresoP = new JTextField();
		textFieldFechaIngresoP.setEditable(false);
		textFieldFechaIngresoP.setColumns(10);
		textFieldFechaIngresoP.setBounds(120, 179, 180, 20);
		panel_1.add(textFieldFechaIngresoP);

		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarConsultaCurso(e);
			}
		});
		button.setBounds(428, 25, 120, 25);
		getContentPane().add(button);

		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 34, 45, 15);

	}

	// aca llena el cb de los institutos(inicializar del principal view)
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(icon.listarInstitutos());
		comboBoxInstitutos.setModel(modelInstitutos);
	}

	// lleno el cb de ediciones
	protected void listarEdicionesAsociadas(ArrayList<String> ediciones) {
		//ArrayList<String> listEdiciones = cur.getEdiciones();
		//listEdiciones = icon.listarEdicionesAux(nomCurso);
		DefaultComboBoxModel<String> modelEdiciones = new DefaultComboBoxModel<String>();
		for (String l : ediciones) {
			//System.out.println(l);
			modelEdiciones.addElement(l);
		}
		comboBoxEdicionCurso.setModel(modelEdiciones);
	}

	// lleno el cb de programas
	protected void listarProgramasAsociados(ArrayList<String> programas) {
		//ArrayList<String> listProgramas = new ArrayList<String>();
		//listProgramas = icon.listarProgramasAux(nomCurso);
		DefaultComboBoxModel<String> modelProgramas = new DefaultComboBoxModel<String>();
		for (String l : programas) {
			modelProgramas.addElement(l);
		}
		comboBoxProAso.setModel(modelProgramas);
	}

	protected void listarCursos(String nomInstituto) {
		String instituto = this.comboBoxInstitutos.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>();
		if (!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			ArrayList<String> listaCursos = icon.listarCursosAux(nomInstituto);
			for (String s : listaCursos) {
				modelCursos.addElement(s);
			}
			comboBoxCursos.setModel(modelCursos);
		} else if (nomInstituto.contains("")) {
			modelCursos.removeAllElements();
			comboBoxCursos.setModel(modelCursos);
		}
	}

	protected void listarPrevias(ArrayList<String> previas) {
		DefaultComboBoxModel<String> modelPrevias = new DefaultComboBoxModel<String>();
		for (String s : previas) {
			modelPrevias.addElement(s);
		}
		comboBoxPrevias.setModel(modelPrevias);
	}

	// aca lista los cursos
	private void comboBoxInstitutosActionPerformed(ActionEvent arg0) {
		String nomInstituto = this.comboBoxInstitutos.getSelectedItem().toString();
		if (nomInstituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un instituto", "Consulta de Curso",
					JOptionPane.ERROR_MESSAGE);
		} else {// listo los cursos asociados
			comboBoxCursos.setEnabled(true);
			listarCursos(nomInstituto);
		}
	}

	// muestro los datos del curso elegido
	private void comboBoxCursosActionPerformed(ActionEvent arg0) {
		String nomCurso = this.comboBoxCursos.getSelectedItem().toString();
		if (nomCurso.isEmpty())
			JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Consulta de Curso",
					JOptionPane.ERROR_MESSAGE);
		else {
			try {
				DTCurso infoCurso = icon.verInfo(nomCurso);
				textDescripcion.setEnabled(true);
				textCantCredito.setEnabled(true);
				textDuracion.setEnabled(true);
				textCantHoras.setEnabled(true);
				textFechaAlta.setEnabled(true);
				textUrl.setEnabled(true);
				comboBoxEdicionCurso.setEnabled(true);
				comboBoxPrevias.setEnabled(true);
				comboBoxProAso.setEnabled(true);
				textDuracion.setText(infoCurso.getDuracion());
				textDescripcion.setText(infoCurso.getDescripcion());
				textCantCredito.setText(Integer.toString(infoCurso.getCreditos()));
				textCantHoras.setText(Integer.toString(infoCurso.getCantHoras()));
				textUrl.setText(infoCurso.getUrl());
				SimpleDateFormat fechaAlta = new SimpleDateFormat("yyyy/MM/dd");
				String fechaA = fechaAlta.format(infoCurso.getFechaR());
				textFechaAlta.setText(fechaA);
				ArrayList<String> ediciones = infoCurso.getEdiciones();
				ArrayList<String> programas = infoCurso.getProgramas();
				ArrayList<String> previas = infoCurso.getPrevias();
				listarEdicionesAsociadas(ediciones);
				listarProgramasAsociados(programas);
				listarPrevias(previas);
			} catch (CursoExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta de Curso", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	// muestro los datos de la edicion
	protected void comboBoxEdicionCursoActionPerformed(ActionEvent arg0) {
		String nomEdicion = this.comboBoxEdicionCurso.getSelectedItem().toString();
		if (!nomEdicion.isEmpty()) {
			try {
				DTEdicionCurso infoEd = icon.verInfoEdicion(nomEdicion);
				textFieldFechaI.setEnabled(true);
				textFieldFechaF.setEnabled(true);
				textFieldFechP.setEnabled(true);
				textFieldCupo.setEnabled(true);
				SimpleDateFormat fechaInicio = new SimpleDateFormat("yyyy/MM/dd");
				String fechaI = fechaInicio.format(infoEd.getFechaI());
				textFieldFechaI.setText(fechaI);
				SimpleDateFormat fechaFin = new SimpleDateFormat("yyyy/MM/dd");
				String fechaF = fechaFin.format(infoEd.getFechaF());
				textFieldFechaF.setText(fechaF);
				SimpleDateFormat fechaPubli = new SimpleDateFormat("yyyy/MM/dd");
				String fechaP = fechaPubli.format(infoEd.getFechaPub());
				textFieldFechP.setText(fechaP);
				textFieldCupo.setText(Integer.toString(infoEd.getCupo()));
			} catch (EdicionExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta de Curso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// muestro los datos del prog de form
	protected void comboBoxProAsoActionPerformed(ActionEvent arg0) {
		String nomPrograma = this.comboBoxProAso.getSelectedItem().toString();
		if (!nomPrograma.isEmpty()) {
			try {
				DTProgramaFormacion infoPro = icon.verInfoPrograma(nomPrograma);
				textFieldDescripcionP.setEnabled(true);
				textFieldFechaIP.setEnabled(true);
				textFieldFechaFP.setEnabled(true);
				textFieldFechaIngresoP.setEnabled(true);
				textFieldDescripcionP.setText(infoPro.getDescripcion());
				SimpleDateFormat fechaInicio = new SimpleDateFormat("yyyy/MM/dd");
				String fechaI = fechaInicio.format(infoPro.getFechaI());
				textFieldFechaIP.setText(fechaI);
				SimpleDateFormat fechaFin = new SimpleDateFormat("yyyy/MM/dd");
				String fechaF = fechaFin.format(infoPro.getFechaF());
				textFieldFechaFP.setText(fechaF);
				SimpleDateFormat fechaIngreso = new SimpleDateFormat("yyyy/MM/dd");
				String fechaIng = fechaIngreso.format(infoPro.getFechaA());
				textFieldFechaIngresoP.setText(fechaIng);

			} catch (ProgramaFormacionExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta de Curso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void limpiarForm() {
		String[] vacio = new String[1];
		vacio[0] = "";
		inicializarComboBoxInstituto();
		DefaultComboBoxModel<String> vacioModel = new DefaultComboBoxModel<String>();
		vacioModel.addElement(vacio[0]);
		comboBoxCursos.setModel(vacioModel);
		comboBoxEdicionCurso.setModel(vacioModel);
		comboBoxProAso.setModel(vacioModel);
		comboBoxPrevias.setModel(vacioModel);
		textDescripcion.setText("");
		textUrl.setText("");
		textFechaAlta.setText("");
		textCantCredito.setText("");
		textCantHoras.setText("");
		textDuracion.setText("");
		textFieldFechaI.setText("");
		textFieldFechaF.setText("");
		textFieldFechP.setText("");
		textFieldCupo.setText("");
		textFieldDescripcionP.setText("");
		textFieldFechaIP.setText("");
		textFieldFechaFP.setText("");

	}

	protected void cancelarConsultaCurso(ActionEvent e) {
		limpiarForm();
		setVisible(false);
	}
}