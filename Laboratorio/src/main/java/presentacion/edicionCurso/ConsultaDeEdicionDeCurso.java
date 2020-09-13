package presentacion.edicionCurso;

import datatypes.DTEdicionCurso;
import exepciones.EdicionExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultaDeEdicionDeCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorCurso iconC;

	private JTextField tfNombre;
	private JTextField tfFechaInicio;
	private JTextField tfFechaFin;
	private JTextField tfCupo;
	private JTextField tfPublicacion;

	private JComboBox<String> comboBoxInstituto;

	private JList<String> listCursos;
	private JList<String> listEdicionesCurso;
	private JList<String> listDocentes;

	private ArrayList<String> listaCursos;
	private ArrayList<String> listaEdiciones;

	private DefaultListModel<String> modelDocentes;
	private DefaultListModel<String> modelDocenteEdiciones;
	private DefaultListModel<String> modelEdiciones;
	private DefaultListModel<String> modelCursos;

	public ConsultaDeEdicionDeCurso(IcontroladorCurso iconC) {

		this.iconC = iconC;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Edicion de Curso");
		setBounds(100, 100, 513, 509);
		getContentPane().setLayout(null);
		
		/*----------------------------------------------------------------------------------------*/
		//Label Instituto
		JLabel lblNewLabel = new JLabel("Instituto");
		lblNewLabel.setBounds(200, 25, 50, 15);
		getContentPane().add(lblNewLabel);
		
		//Label Cursos
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(80, 35, 50, 15);
		getContentPane().add(lblCursos);
		
		//Label Edicion de curso
		JLabel lblEdicionesDeCurso = new JLabel("Ediciones de Curso");
		lblEdicionesDeCurso.setBounds(235, 65, 126, 14);
		getContentPane().add(lblEdicionesDeCurso);
		
		//Label nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 275, 50, 15);
		getContentPane().add(lblNombre);

		//Label fecha de inicio
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		lblFechaDeInicio.setBounds(35, 305, 89, 14);
		getContentPane().add(lblFechaDeInicio);

		//Label fecha de final
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(35, 335, 90, 15);
		getContentPane().add(lblFechaDeFin);

		//Label de cupo
		JLabel lblCupo = new JLabel("Cupo");
		lblCupo.setBounds(35, 365, 46, 14);
		getContentPane().add(lblCupo);
		
		//Label docentes
		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setBounds(365, 250, 46, 14);
		getContentPane().add(lblDocentes);

		//Label fecha publicacion
		JLabel lblFechaDePublicacion = new JLabel("Fecha de publicacion");
		lblFechaDePublicacion.setBounds(35, 395, 115, 15);
		getContentPane().add(lblFechaDePublicacion);

		/*----------------------------------------------------------------------------------------*/
		//Variable de nombre
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setBounds(150, 270, 150, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		//Variable de fecha inicio
		tfFechaInicio = new JTextField();
		tfFechaInicio.setEditable(false);
		tfFechaInicio.setBounds(150, 300, 150, 20);
		getContentPane().add(tfFechaInicio);
		tfFechaInicio.setColumns(10);

		//Variable de fecha fin
		tfFechaFin = new JTextField();
		tfFechaFin.setEditable(false);
		tfFechaFin.setBounds(150, 330, 150, 20);
		getContentPane().add(tfFechaFin);
		tfFechaFin.setColumns(10);

		//Variable cupo
		tfCupo = new JTextField();
		tfCupo.setEditable(false);
		tfCupo.setBounds(150, 360, 150, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);

		//Variable fecha publicacion
		tfPublicacion = new JTextField();
		tfPublicacion.setEditable(false);
		tfPublicacion.setBounds(150, 390, 150, 20);
		getContentPane().add(tfPublicacion);
		tfPublicacion.setColumns(10);


		/*----------------------------------------------------------------------------------------*/
		//Boton Seleccionar Curso
		JButton ButtonSeleccionarCurso = new JButton("Seleccionar");
		ButtonSeleccionarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEdicion(e);
			}
		});
		ButtonSeleccionarCurso.setBounds(45, 210, 120, 25);
		getContentPane().add(ButtonSeleccionarCurso);

		//Boton cancelar
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarConsulta(e);
			}
		});
		ButtonCancelar.setBounds(182, 425, 100, 30);
		getContentPane().add(ButtonCancelar);

		//Boton Consulta
		JButton ButtonConsulta = new JButton("Consultar");
		ButtonConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarEdicion(e);
				}catch (EdicionExcepcion edicionExcepcion) {
					edicionExcepcion.printStackTrace();
				}

			}
		});
		ButtonConsulta.setBounds(365, 140, 120, 25);
		getContentPane().add(ButtonConsulta);

		/*----------------------------------------------------------------------------------------*/
		//Lista de cursos
		JScrollPane scrollPaneCursos = new JScrollPane();
		scrollPaneCursos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCursos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCursos.setBounds(35, 60, 140, 140);
		getContentPane().add(scrollPaneCursos);
		listCursos = new JList<String>();
		scrollPaneCursos.setViewportView(listCursos);

		//Lista de Ediciones
		JScrollPane scrollPaneEdiciones = new JScrollPane();
		scrollPaneEdiciones.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneEdiciones.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEdiciones.setBounds(210, 96, 140, 140);
		getContentPane().add(scrollPaneEdiciones);
		listEdicionesCurso = new JList<String>();
		scrollPaneEdiciones.setViewportView(listEdicionesCurso);

		//Lista de Docentes
		JScrollPane scrollPaneDocentes = new JScrollPane();
		scrollPaneDocentes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDocentes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDocentes.setBounds(320, 275, 150, 140);
		getContentPane().add(scrollPaneDocentes);
		listDocentes = new JList<String>();
		scrollPaneDocentes.setViewportView(listDocentes);

		/*----------------------------------------------------------------------------------------*/
		//Combobox de Instituto
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarCursos(arg0);
			}
		});
		comboBoxInstituto.setBounds(255, 20, 150, 20);
		getContentPane().add(comboBoxInstituto);


	}

	//Inicia el combo box instituto
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		comboBoxInstituto.setModel(modelInstitutos);
	}

	//Lista los cursos asocidados
	protected void listarCursos(ActionEvent e) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		DefaultListModel<String> modelCursos = new DefaultListModel<String>();
		if(!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			listaCursos = iconC.listarCursosAux(nomInstituto);
			for(String s : listaCursos) {
				modelCursos.addElement(s);
			}
			listCursos.setModel(modelCursos);
		} else if(nomInstituto.contains("")) {
			modelCursos.removeAllElements();
			listCursos.setModel(modelCursos);
		}
	}

	//Lista las ediciones asociadas al curso
	protected void listarEdicion(ActionEvent e) {
		String nomCurso = this.listCursos.getSelectedValue().toString();
		DefaultListModel<String> modelEdiciones = new DefaultListModel<String>();
		if(!nomCurso.isEmpty()) {
			listaEdiciones = iconC.listarEdicionesAux(nomCurso);
			for(String s : listaEdiciones) {
				modelEdiciones.addElement(s);
			}
			listEdicionesCurso.setModel(modelEdiciones);
		} else if(nomCurso.isEmpty()) {
			modelEdiciones.removeAllElements();
			listEdicionesCurso.setModel(modelEdiciones);
		}
	}

	protected void seleccionarEdicion(ActionEvent e) throws EdicionExcepcion {
		String nombreEdicion = this.listEdicionesCurso.getSelectedValue().toString();
		if(!nombreEdicion.isEmpty()) {
			DTEdicionCurso datosEdicion = new DTEdicionCurso();
			datosEdicion = iconC.verInfoEdicion(nombreEdicion);
			this.tfNombre.setText(datosEdicion.getNombre());
			this.tfFechaInicio.setText(datosEdicion.getFechaI().toString());
			this.tfFechaFin.setText(datosEdicion.getFechaF().toString());
			this.tfCupo.setText(String.valueOf(datosEdicion.getCupo()));
			this.tfPublicacion.setText(datosEdicion.getFechaPub().toString());
			Integer sais = iconC.listarDocentesAux(nombreEdicion).size();
			String[] listaDocenteEdicione = new String[sais];
			Integer i = 0;
			for(String a: iconC.listarDocentesAux(nombreEdicion)) {
				listaDocenteEdicione[i]=a;
				i++;
			}
			listDocentes.setListData(listaDocenteEdicione);

		} else if(nombreEdicion.isEmpty()) {

			//Si el nombre de instituto es vacio la lista de docentes
			modelDocenteEdiciones.removeAllElements();
			listDocentes.setModel(modelDocenteEdiciones);

			//Si el nombre de instituto es vacio la lista de ediciones tambien
			modelEdiciones.removeAllElements();
			listEdicionesCurso.setModel(modelEdiciones);
		}
	}

	protected void cancelarConsulta(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}

	protected void limpiarFormulario() {
		//Limpiar la lista de cursos
		String[] vacio = new String[1];
		vacio[0] = "";
		inicializarComboBoxInstituto();
        listCursos.setListData(vacio);
        listEdicionesCurso.setListData(vacio);
        listDocentes.setListData(vacio);

        //Limpia las demas variables
		this.tfNombre.setText("");
		this.tfFechaInicio.setText("");
		this.tfFechaFin.setText("");
		this.tfCupo.setText("");
		this.tfPublicacion.setText("");
	}

}
