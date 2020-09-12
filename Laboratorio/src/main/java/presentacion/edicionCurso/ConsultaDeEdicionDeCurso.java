package presentacion.edicionCurso;

import javax.swing.*;

import datatypes.DTEdicionCurso;

import interfaces.IcontroladorCurso;

import java.awt.event.*;

import java.util.*;

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
		lblNewLabel.setBounds(120, 25, 50, 15);
		getContentPane().add(lblNewLabel);
		
		//Label Cursos
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(80, 65, 50, 15);
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
		lblFechaDePublicacion.setBounds(35, 395, 109, 15);
		getContentPane().add(lblFechaDePublicacion);
		
		/*----------------------------------------------------------------------------------------*/
		//Variable de nombre
		tfNombre = new JTextField();
		tfNombre.setBounds(145, 270, 150, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
				
		//Variable de fecha inicio
		tfFechaInicio = new JTextField();
		tfFechaInicio.setBounds(145, 300, 150, 20);
		getContentPane().add(tfFechaInicio);
		tfFechaInicio.setColumns(10);
				
		//Variable de fecha fin
		tfFechaFin = new JTextField();
		tfFechaFin.setBounds(145, 330, 150, 20);
		getContentPane().add(tfFechaFin);
		tfFechaFin.setColumns(10);
				
		//Variable cupo
		tfCupo = new JTextField();
		tfCupo.setBounds(145, 360, 150, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);
				
		//Variable fecha publicacion
		tfPublicacion = new JTextField();
		tfPublicacion.setBounds(145, 390, 150, 20);
		getContentPane().add(tfPublicacion);
		tfPublicacion.setColumns(10);
		
		
		/*----------------------------------------------------------------------------------------*/
		//Boton cancelar
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.setBounds(182, 425, 100, 30);
		getContentPane().add(ButtonCancelar);
		
		//Boton Seleccionar
		JButton ButtonSeleccionar = new JButton("Seleccionar");
		ButtonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarEdicion(e);
			}
		});
		ButtonSeleccionar.setBounds(375, 140, 90, 25);
		getContentPane().add(ButtonSeleccionar);
		
		/*----------------------------------------------------------------------------------------*/
		//Lista de cursos
		JScrollPane scrollPaneCursos = new JScrollPane();
		scrollPaneCursos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCursos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCursos.setBounds(35, 95, 140, 140);
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
				listarEdicion(arg0);
			}
		});
		comboBoxInstituto.setBounds(195, 20, 150, 20);
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
		ArrayList<String> listaCursos = new ArrayList<String>();
		listaCursos = iconC.listarCursosAux(nomInstituto);
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>();
		for(String s : listaCursos) {
			modelCursos.addElement(s);
		}
		listCursos.setModel(modelCursos);
	}
	
	//Lista las ediciones asociadas al curso
	protected void listarEdicion(ActionEvent e) {
		String nomCurso = this.listCursos.getSelectedValue().toString();
		ArrayList<String> listaEdiciones = new ArrayList<String>();
		listaEdiciones = iconC.listarEdicionesAux(nomCurso);
		DefaultComboBoxModel<String> modelEdiciones = new DefaultComboBoxModel<String>();
		for(String s : listaEdiciones) {
			modelEdiciones.addElement(s);
		}
		listEdicionesCurso.setModel(modelEdiciones);
	}
	
	protected void seleccionarEdicion(ActionEvent e) {
		String nombreEdicion = this.listEdicionesCurso.getSelectedValue().toString();
		DTEdicionCurso datosEdicion = new DTEdicionCurso();
		datosEdicion = iconC.verInfoEdicion(nombreEdicion);
		this.tfNombre.setText(datosEdicion.getNombre());
		this.tfFechaInicio.setText(datosEdicion.getFechaI().toString());
		this.tfFechaFin.setText(datosEdicion.getFechaF().toString());
		this.tfCupo.setText(String.valueOf(datosEdicion.getCupo()));
		this.tfPublicacion.setText(datosEdicion.getFechaPub().toString());
	}
	
}
