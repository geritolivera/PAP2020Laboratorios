package presentacion.edicionCurso;

import com.toedter.calendar.JDateChooser;
import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AltaDeEdicionDeCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorCurso iconC;

	private JTextField tfNombreEd;
	private JTextField tfCupo;

	private JComboBox<String> comboBoxInstituto;

	private JDateChooser dateInicio;
	private JDateChooser dateFin;

	private JList<String> listaDocentes;
	private JList<String> listCursos;

	private ArrayList<String> lisDocentes = new ArrayList<String>();
	private ArrayList<String> lisCursos;


	public AltaDeEdicionDeCurso(IcontroladorCurso iconC) {

		this.iconC = iconC;
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Alta de Edicion de Curso");
		setBounds(100, 100, 355, 528);
		getContentPane().setLayout(null);

		/*--------------------------------------------------------------------------------------------------------------------*/
		//Label Instituto
		JLabel lblinstituto = new JLabel("Institutos");
		lblinstituto.setBounds(10, 35, 50, 15);
		getContentPane().add(lblinstituto);

		//Label Cursos
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(10, 70, 45, 14);
		getContentPane().add(lblCursos);

		//Label Nombre de la edicion
		JLabel lblNombreEdicion = new JLabel("Nombre de la edicion");
		lblNombreEdicion.setBounds(10, 200, 120, 14);
		getContentPane().add(lblNombreEdicion);

		//Label fecha de inicio
		JLabel lblFecha = new JLabel("Fecha de inicio");
		lblFecha.setBounds(10, 235, 99, 14);
		getContentPane().add(lblFecha);

		//Label fecha de fin
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(10, 270, 80, 14);
		getContentPane().add(lblFechaDeFin);

		//Label cupo
		JLabel lblCupo = new JLabel("Cupo (opcional)");
		lblCupo.setBounds(10, 305, 99, 14);
		getContentPane().add(lblCupo);

		//Label docentes
		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setBounds(10, 335, 80, 14);
		getContentPane().add(lblDocentes);


		/*--------------------------------------------------------------------------------------------------------------------*/
		//Variable string nombre de edicion
		tfNombreEd = new JTextField();
		tfNombreEd.setEnabled(false);
		tfNombreEd.setBounds(140, 195, 150, 20);
		getContentPane().add(tfNombreEd);
		tfNombreEd.setColumns(10);

		//Variable fecha de inicio
		dateInicio = new JDateChooser();
		dateInicio.setEnabled(false);
		dateInicio.setDateFormatString("dd-MM-yyyy");
		dateInicio.setBounds(140, 230, 150, 20);
		getContentPane().add(dateInicio);

		//Variable fecha de fin
		dateFin = new JDateChooser();
		dateFin.setEnabled(false);
		dateFin.setDateFormatString("dd-MM-yyyy");
		dateFin.setBounds(140, 265, 150, 20);
		getContentPane().add(dateFin);

		//Variable de cupo
		tfCupo = new JTextField();
		tfCupo.setEnabled(false);
		tfCupo.setBounds(140, 300, 150, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);

		/*--------------------------------------------------------------------------------------------------------------------*/
		//Boton aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaEdAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(50, 450, 90, 25);
		getContentPane().add(btnAceptar);

		//Boton cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaEdCancelarActionPerformed(arg0);
			}
		});
		btnCancelar.setBounds(200, 450, 90, 25);
		getContentPane().add(btnCancelar);


		/*--------------------------------------------------------------------------------------------------------------------*/
		//Lista de docentes con scroll pane
		JScrollPane scrollPaneDocente = new JScrollPane();
		scrollPaneDocente.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDocente.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDocente.setBounds(140, 335, 150, 100);
		getContentPane().add(scrollPaneDocente);
		listaDocentes = new JList<String>();
		scrollPaneDocente.setViewportView(listaDocentes);
		listaDocentes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaDocentes.setEnabled(false);
		//modelDocentes = new DefaultListModel<String>();


		//Lista de Cursos con scroll pane
		JScrollPane scrollPaneCursos = new JScrollPane();
		scrollPaneCursos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCursos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCursos.setBounds(140, 65, 150, 115);
		getContentPane().add(scrollPaneCursos);
		listCursos = new JList<String>();
		scrollPaneCursos.setViewportView(listCursos);
		listCursos.setEnabled(false);
		//modelCursos = new DefaultListModel<String>();

		/*--------------------------------------------------------------------------------------------------------------------*/
		//Combobox instituto
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarDocentes(e);
				listarCursos(e);
				habilitarIngresarDatos(e);
			}
		});
		comboBoxInstituto.setBounds(66, 30, 150, 20);
		getContentPane().add(comboBoxInstituto);

	}

	//Lista en el combobox los institutos
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		comboBoxInstituto.setModel(listInst);
	}

	//Lista todos los docentes
	protected void listarDocentes(ActionEvent e) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		DefaultListModel<String> modelDocentes = new DefaultListModel<String>();
		if (!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			listaDocentes.setEnabled(true);
			lisDocentes = iconC.listarDocentesInstituto(nomInstituto);
			for (String s : lisDocentes) {
				modelDocentes.addElement(s);
			}
			listaDocentes.setModel(modelDocentes);
		}
	}

	//Lista los cursos
	protected void listarCursos(ActionEvent e) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		DefaultListModel<String> modelCursos = new DefaultListModel<String>();
		if (!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			listCursos.setEnabled(true);
			lisCursos = iconC.listarCursosAux(nomInstituto);
			for (String s : lisCursos) {
				modelCursos.addElement(s);
			}
			listCursos.setModel(modelCursos);
		}
	}

	protected void habilitarIngresarDatos(ActionEvent e) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		if (!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			tfNombreEd.setEnabled(true);
			dateInicio.setEnabled(true);
			dateFin.setEnabled(true);
			tfCupo.setEnabled(true);

		} else {
			JOptionPane.showMessageDialog(this, "Seleccione un instituto", "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void altaEdAceptarActionPerformed(ActionEvent arg0) {
		String nomEd = this.tfNombreEd.getText();
		Date dateI = this.dateInicio.getDate();
		Date dateF = this.dateFin.getDate();
		String cupo = this.tfCupo.getText();
		String curso = this.listCursos.getSelectedValue();
		Date fechPubli = Calendar.getInstance().getTime();
		if (!listaDocentes.getSelectedValuesList().isEmpty()) {
			this.lisDocentes = (ArrayList<String>) listaDocentes.getSelectedValuesList();
		}
		ArrayList<String> docentes = (ArrayList<String>) listaDocentes.getSelectedValuesList();
		if (checkFormulario()) {
			try {
				this.iconC.nuevosDatosEdicion(nomEd, dateI, dateF, Integer.parseInt(cupo), fechPubli, curso, docentes);
				JOptionPane.showMessageDialog(this, "Edicion de curso " + nomEd + " se da de alta con exito ", "Alta Edicion de Curso", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			} catch (EdicionExcepcion | CursoExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private boolean checkFormulario() {
		String nomEd = this.tfNombreEd.getText();
		String cupo = this.tfCupo.getText();
		String fechaInicio = this.dateInicio.toString();
		String fechaFin = this.dateFin.toString();
		Date dateInicio = this.dateInicio.getDate();
		Date dateFin = this.dateFin.getDate();

		if (nomEd.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios", "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (dateFin.compareTo(dateInicio) < 0 || dateInicio.compareTo(dateFin) == 0) {
			JOptionPane.showMessageDialog(this, "La fecha de inicio de curso tiene que ser\n menor a la fecha de fin de curso", "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if(listaDocentes.getSelectedValuesList().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar docente/s", "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				Integer.parseInt(cupo);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El numero de cupo debe ser un numero", "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	protected void altaEdCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}

	private void limpiarFormulario() {
		inicializarComboBoxInstituto();

		tfNombreEd.setText("");

		dateInicio.revalidate();

		dateFin.revalidate();

		tfCupo.setText("");

		Integer i = 0;
		DefaultListModel<String> modelCursos = new DefaultListModel<String>();
		for (i = 0; i < listCursos.getModel().getSize(); i++) {
			modelCursos.addElement("");
		}
		listCursos.setModel(modelCursos);

		Integer j = 0;
		DefaultListModel<String> modelDocentes = new DefaultListModel<String>();
		for (j = 0; j < listaDocentes.getModel().getSize(); j++) {
			modelDocentes.addElement("");
		}
		listaDocentes.setModel(modelDocentes);
	}
}
