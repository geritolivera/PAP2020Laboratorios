package presentacion.programaFormacion;
import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
import exepciones.ProgramaFormacionExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ConsultaProgramaFormacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	////--------------------------PROGRAMAS----------------------------------------//
	private IcontroladorCurso icon;
	private JComboBox<String> comboProgramas;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JTextField textFieldInicio;
	private JTextField textFieldFin;
	private JTextField textFieldFechaIngreso;
	private ArrayList<String> listaProgramas; //populate programas
	private JComboBox<String> comboCursos;
	private DTProgramaFormacion programaDT; //programa seleccionado
	////--------------------------CURSOS----------------------------------------//
	private DTCurso cursoDT;
	private JComboBox<String> comboEdiciones;
	private JTextField textFieldNombreCurso;
	private JTextArea textAreaDescripcionCurso;
	private JTextField textFieldDuracion;
	private JTextField textFieldCantHoras;
	private JTextField textFieldCreditos;
	private JTextField textFieldFechaRegistro;
	private JTextField textFieldURL;
	private DTEdicionCurso edicionDT; //edicion seleccionada
	private JTextField textField_VigenteEdicion;

	////--------------------------EDICIONES----------------------------------------//

	private JTextField textFieldNombreEdicion;
	private JTextField textFieldFechaInicioEdicion;
	private JTextField textFieldFechaFinEdicion;
	private JTextField textFieldFechaPublicacionEdicion;



	public ConsultaProgramaFormacion(IcontroladorCurso icon) {

		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Programa De Formacion");
		setBounds(100, 100, 1130, 499);
		getContentPane().setLayout(null);



		//Combo programas
		listaProgramas=icon.listarProgramas();
		comboProgramas = new JComboBox(listaProgramas.toArray());
		comboProgramas.setBounds(20, 50, 180, 22);
		getContentPane().add(comboProgramas);

		//Boton seleccionar Programa
		JButton ButtonSelectPrograma = new JButton("");
		ButtonSelectPrograma.setIcon(new ImageIcon("C:\\Users\\Nico\\eclipse-workspace\\PAP2020Laboratorios\\Laboratorio\\src\\main\\resources\\Imagenes\\check.png"));
		ButtonSelectPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpiarFormulario();
					seleccionarPrograma(e);
				} catch (ProgramaFormacionExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ButtonSelectPrograma.setBounds(228, 47, 31, 25);
		getContentPane().add(ButtonSelectPrograma);

		//Panel datos Programa
		JPanel PanelPrograma = new JPanel();
		PanelPrograma.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del Programa", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		PanelPrograma.setBounds(20, 94, 325, 297);
		getContentPane().add(PanelPrograma);
		PanelPrograma.setLayout(null);

		//Label Nombre Programa
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNombre.setBounds(10, 34, 45, 15);
		PanelPrograma.add(LabelNombre);

		//Label Descripcion
		JLabel LabelDescripcion = new JLabel("Descripcion");
		LabelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelDescripcion.setBounds(10, 60, 73, 15);
		PanelPrograma.add(LabelDescripcion);

		//Label Fecha Inicio
		JLabel LabelNickname = new JLabel("Fecha Inicio");
		LabelNickname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNickname.setBounds(10, 129, 73, 15);
		PanelPrograma.add(LabelNickname);

		//Label Fecha Fin
		JLabel LabelCorreo = new JLabel("Fecha Fin");
		LabelCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelCorreo.setBounds(10, 155, 73, 15);
		PanelPrograma.add(LabelCorreo);

		//Label Fecha de Ingreso al sistema
		JLabel LabelFechaNac = new JLabel("Fecha de Ingreso");
		LabelFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelFechaNac.setBounds(10, 181, 100, 15);
		PanelPrograma.add(LabelFechaNac);

		//Text Nombre
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(120, 32, 180, 20);
		PanelPrograma.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		//Text Area Descripcion
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setColumns(10);
		textAreaDescripcion.setBounds(120, 63, 180, 53);
		PanelPrograma.add(textAreaDescripcion);

		//Text Fecha Inicio
		textFieldInicio = new JTextField();
		textFieldInicio.setEditable(false);
		textFieldInicio.setColumns(10);
		textFieldInicio.setBounds(120, 127, 180, 20);
		PanelPrograma.add(textFieldInicio);

		//Text Fecha Fin
		textFieldFin = new JTextField();
		textFieldFin.setEditable(false);
		textFieldFin.setColumns(10);
		textFieldFin.setBounds(120, 153, 180, 20);
		PanelPrograma.add(textFieldFin);


		//Text Fecha Ingreso
		textFieldFechaIngreso = new JTextField();
		textFieldFechaIngreso.setEditable(false);
		textFieldFechaIngreso.setColumns(10);
		textFieldFechaIngreso.setBounds(120, 179, 180, 20);
		PanelPrograma.add(textFieldFechaIngreso);

		//Cursos del programa seleccionado
		JLabel LabelCursos = new JLabel("Cursos");
		LabelCursos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelCursos.setBounds(10, 213, 100, 15);
		PanelPrograma.add(LabelCursos);

		//Combo con los cursos del programa
		comboCursos = new JComboBox();
		comboCursos.setBounds(120, 210, 180, 22);
		PanelPrograma.add(comboCursos);

		JButton button = new JButton("Seleccionar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				try {
					seleccionarCurso(e2);
				} catch (CursoExcepcion e21) {
					// TODO Auto-generated catch block
					e21.printStackTrace();
				}
			}
		});
		button.setBounds(120, 243, 180, 25);
		PanelPrograma.add(button);

		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarConsultaEdicion(e);
			}
		});
		ButtonCancelar.setBounds(20, 416, 120, 25);
		getContentPane().add(ButtonCancelar);

		JLabel labelSeleccionePrograma = new JLabel("Seleccione Programa");
		labelSeleccionePrograma.setToolTipText("Seleccione un programa en la lista para obtener los resultados");
		labelSeleccionePrograma.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelSeleccionePrograma.setBounds(20, 24, 131, 15);
		getContentPane().add(labelSeleccionePrograma);

		////--------------------------CURSOS----------------------------------------//

		JPanel PanelCurso = new JPanel();
		PanelCurso.setLayout(null);
		PanelCurso.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del Curso", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		PanelCurso.setBounds(371, 94, 339, 347);
		getContentPane().add(PanelCurso);

		JLabel labelNombreCurso = new JLabel("Nombre");
		labelNombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNombreCurso.setBounds(10, 34, 45, 15);
		PanelCurso.add(labelNombreCurso);

		JLabel labelDescripcionCurso = new JLabel("Descripcion");
		labelDescripcionCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDescripcionCurso.setBounds(10, 60, 73, 15);
		PanelCurso.add(labelDescripcionCurso);

		JLabel labelDuracionCurso = new JLabel("Duracion de Curso");
		labelDuracionCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDuracionCurso.setBounds(10, 129, 100, 15);
		PanelCurso.add(labelDuracionCurso);

		JLabel labelCantHorasCurso = new JLabel("Cantidad de horas");
		labelCantHorasCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCantHorasCurso.setBounds(10, 155, 100, 15);
		PanelCurso.add(labelCantHorasCurso);

		JLabel lablelCreditosCurso = new JLabel("Creditos");
		lablelCreditosCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lablelCreditosCurso.setBounds(10, 181, 100, 15);
		PanelCurso.add(lablelCreditosCurso);

		textFieldNombreCurso = new JTextField();
		textFieldNombreCurso.setEditable(false);
		textFieldNombreCurso.setColumns(10);
		textFieldNombreCurso.setBounds(120, 32, 180, 20);
		PanelCurso.add(textFieldNombreCurso);

		textAreaDescripcionCurso= new JTextArea();
		textAreaDescripcionCurso.setEditable(false);
		textAreaDescripcionCurso.setColumns(10);
		textAreaDescripcionCurso.setBounds(120, 63, 180, 53);
		PanelCurso.add(textAreaDescripcionCurso);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setEditable(false);
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(120, 127, 180, 20);
		PanelCurso.add(textFieldDuracion);

		textFieldCantHoras = new JTextField();
		textFieldCantHoras.setEditable(false);
		textFieldCantHoras.setColumns(10);
		textFieldCantHoras.setBounds(120, 153, 180, 20);
		PanelCurso.add(textFieldCantHoras);

		textFieldCreditos = new JTextField();
		textFieldCreditos.setEditable(false);
		textFieldCreditos.setColumns(10);
		textFieldCreditos.setBounds(120, 179, 180, 20);
		PanelCurso.add(textFieldCreditos);

		JLabel labelEdiciones = new JLabel("Ediciones");
		labelEdiciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelEdiciones.setBounds(10, 281, 100, 15);
		PanelCurso.add(labelEdiciones);

		comboEdiciones = new JComboBox();
		comboEdiciones.setBounds(120, 278, 180, 22);
		PanelCurso.add(comboEdiciones);

		JButton button_1 = new JButton("Seleccionar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarEdicion(e);
				} catch (EdicionExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_1.setBounds(120, 311, 180, 25);
		PanelCurso.add(button_1);

		JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro");
		lblFechaDeRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDeRegistro.setBounds(10, 212, 100, 15);
		PanelCurso.add(lblFechaDeRegistro);
		
		textFieldFechaRegistro = new JTextField();
		textFieldFechaRegistro.setEditable(false);
		textFieldFechaRegistro.setColumns(10);
		textFieldFechaRegistro.setBounds(120, 210, 180, 20);
		PanelCurso.add(textFieldFechaRegistro);

		JLabel lblURL = new JLabel("URL");
		lblURL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblURL.setBounds(10, 243, 100, 15);
		PanelCurso.add(lblURL);

		textFieldURL = new JTextField();
		textFieldURL.setEditable(false);
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(120, 241, 180, 20);
		PanelCurso.add(textFieldURL);

		////--------------------------EDICION----------------------------------------//


		JPanel panelEdicion = new JPanel();
		panelEdicion.setLayout(null);
		panelEdicion.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Edicion", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panelEdicion.setBounds(738, 94, 339, 199);
		getContentPane().add(panelEdicion);

		JLabel labelNombreEdicion = new JLabel("Nombre");
		labelNombreEdicion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNombreEdicion.setBounds(10, 34, 45, 15);
		panelEdicion.add(labelNombreEdicion);

		JLabel labelFechaIEdicion = new JLabel("Fecha Inicio");
		labelFechaIEdicion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFechaIEdicion.setBounds(10, 60, 100, 15);
		panelEdicion.add(labelFechaIEdicion);

		JLabel labelFechaFinEdcion = new JLabel("Fecha Fin");
		labelFechaFinEdcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFechaFinEdcion.setBounds(10, 96, 100, 15);
		panelEdicion.add(labelFechaFinEdcion);

		textFieldNombreEdicion = new JTextField();
		textFieldNombreEdicion.setEditable(false);
		textFieldNombreEdicion.setColumns(10);
		textFieldNombreEdicion.setBounds(120, 32, 180, 20);
		panelEdicion.add(textFieldNombreEdicion);

		textFieldFechaInicioEdicion = new JTextField();
		textFieldFechaInicioEdicion.setEditable(false);
		textFieldFechaInicioEdicion.setColumns(10);
		textFieldFechaInicioEdicion.setBounds(120, 63, 180, 20);
		panelEdicion.add(textFieldFechaInicioEdicion);
		
		textFieldFechaFinEdicion = new JTextField();
		textFieldFechaFinEdicion.setEditable(false);
		textFieldFechaFinEdicion.setColumns(10);
		textFieldFechaFinEdicion.setBounds(120, 94, 180, 20);
		panelEdicion.add(textFieldFechaFinEdicion);

		JLabel lblFechaDePublicacion = new JLabel("Fecha Publicacion");
		lblFechaDePublicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDePublicacion.setBounds(10, 126, 100, 15);
		panelEdicion.add(lblFechaDePublicacion);
		
		textFieldFechaPublicacionEdicion = new JTextField();
		textFieldFechaPublicacionEdicion.setEditable(false);
		textFieldFechaPublicacionEdicion.setColumns(10);
		textFieldFechaPublicacionEdicion.setBounds(120, 125, 180, 20);
		panelEdicion.add(textFieldFechaPublicacionEdicion);
		
		JLabel Vigente = new JLabel("Vigente");
		Vigente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Vigente.setBounds(10, 158, 100, 15);
		panelEdicion.add(Vigente);
		
		textField_VigenteEdicion = new JTextField();
		textField_VigenteEdicion.setEditable(false);
		textField_VigenteEdicion.setColumns(10);
		textField_VigenteEdicion.setBounds(120, 156, 180, 20);
		panelEdicion.add(textField_VigenteEdicion);

		

	}

	public void seleccionarPrograma(ActionEvent arg0) throws ProgramaFormacionExcepcion{
		String programa = (String) comboProgramas.getSelectedItem();
		programaDT= icon.verInfoPrograma(programa);
		this.textFieldNombre.setText(programaDT.getNombre());
		this.textAreaDescripcion.setText(programaDT.getDescripcion());
		this.textFieldInicio.setText(programaDT.getFechaI().toString());
		this.textFieldFin.setText(programaDT.getFechaI().toString());
		this.textFieldFechaIngreso.setText(programaDT.getFechaA().toString());
		ArrayList<String> listaCursos = programaDT.getCursos();
		for (String curso : listaCursos) {
			comboCursos.addItem(curso);;
		}
	}

	public void seleccionarCurso(ActionEvent arg0) throws CursoExcepcion{
		String curso = (String) comboCursos.getSelectedItem();
		cursoDT= icon.verInfo(curso);
		ArrayList<String> listaEdiciones = cursoDT.getEdiciones();
		this.textFieldNombreCurso.setText(cursoDT.getNombre());
		this.textAreaDescripcionCurso.setText(cursoDT.getDescripcion());
		this.textFieldDuracion.setText(cursoDT.getDuracion());
		this.textFieldCantHoras.setText(String.valueOf(cursoDT.getCantHoras()));
		this.textFieldCreditos.setText(String.valueOf(cursoDT.getCreditos()));
		this.textFieldFechaRegistro.setText(cursoDT.getFechaR().toString());
		this.textFieldURL.setText(cursoDT.getUrl());
		for (String edicion : listaEdiciones) {
			comboEdiciones.addItem(edicion);
		}
	}
	public void seleccionarEdicion(ActionEvent arg0) throws EdicionExcepcion{
		String edicion = (String) comboEdiciones.getSelectedItem();
		edicionDT= icon.verInfoEdicion(edicion);
		Date today = Calendar.getInstance().getTime();
		this.textFieldNombreEdicion.setText(edicionDT.getNombre());
		this.textFieldFechaInicioEdicion.setText(edicionDT.getFechaI().toString());
		this.textFieldFechaFinEdicion.setText(edicionDT.getFechaF().toString());
		this.textFieldFechaPublicacionEdicion.setText(edicionDT.getFechaPub().toString());
		if (edicionDT.getFechaF().after(today))
			this.textField_VigenteEdicion.setText("Si");
		else
			this.textField_VigenteEdicion.setText("No");
	}
	protected void cancelarConsultaEdicion(ActionEvent e) {
		limpiarFormulario();
		//comboProgramas.removeAllItems();
		setVisible(false);
	}

	public void refreshCombo() {
		ArrayList<String> listaProgramas =icon.listarProgramas();
		DefaultComboBoxModel<String> modeloProg = new DefaultComboBoxModel<String>();
		for(String s:listaProgramas) {
			modeloProg.addElement(s);
		}
		comboProgramas.setModel(modeloProg);
	}

	private void limpiarFormulario() {

	 //limpio textFields
	 textFieldNombre.setText("");;
	 textAreaDescripcion.setText("");;
	 textFieldInicio.setText("");;
	 textFieldFin.setText("");;
	 textFieldFechaIngreso.setText("");;
	 textFieldNombreCurso.setText("");;
	 textAreaDescripcionCurso.setText("");;
	 textFieldDuracion.setText("");;
	 textFieldCantHoras.setText("");;
	 textFieldCreditos.setText("");;
	 textFieldFechaRegistro.setText("");;
	 textFieldURL.setText("");;
	 textField_VigenteEdicion.setText("");;
	 textFieldNombreEdicion.setText("");;
	 textFieldFechaInicioEdicion.setText("");;
	 textFieldFechaFinEdicion.setText("");;
	 textFieldFechaPublicacionEdicion.setText("");;

	 //limpio combos
	 comboCursos.removeAllItems();
	 comboEdiciones.removeAllItems();

		

	}
}
