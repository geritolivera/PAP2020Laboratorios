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
	
	private ArrayList<String> listaCursos;
	private ArrayList<String> listaEdiciones;
	
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
		tfNombre.setEnabled(false);
		tfNombre.setBounds(150, 270, 150, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
				
		//Variable de fecha inicio
		tfFechaInicio = new JTextField();
		tfFechaInicio.setEnabled(false);
		tfFechaInicio.setBounds(150, 300, 150, 20);
		getContentPane().add(tfFechaInicio);
		tfFechaInicio.setColumns(10);
				
		//Variable de fecha fin
		tfFechaFin = new JTextField();
		tfFechaFin.setEnabled(false);
		tfFechaFin.setBounds(150, 330, 150, 20);
		getContentPane().add(tfFechaFin);
		tfFechaFin.setColumns(10);
				
		//Variable cupo
		tfCupo = new JTextField();
		tfCupo.setEnabled(false);
		tfCupo.setBounds(150, 360, 150, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);
				
		//Variable fecha publicacion
		tfPublicacion = new JTextField();
		tfPublicacion.setEnabled(false);
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
				seleccionarEdicion(e);
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
	
	protected void seleccionarEdicion(ActionEvent e) {
		String nombreEdicion = this.listEdicionesCurso.getSelectedValue().toString();
		if(!nombreEdicion.isEmpty()) {
			DTEdicionCurso datosEdicion = new DTEdicionCurso();
			datosEdicion = iconC.verInfoEdicion(nombreEdicion);
			this.tfNombre.setEnabled(true);
			this.tfNombre.setText(datosEdicion.getNombre());
			
			this.tfFechaInicio.setEnabled(true);
			this.tfFechaInicio.setText(datosEdicion.getFechaI().toString());
			
			this.tfFechaFin.setEnabled(true);
			this.tfFechaFin.setText(datosEdicion.getFechaF().toString());
			
			this.tfCupo.setEnabled(true);
			this.tfCupo.setText(String.valueOf(datosEdicion.getCupo()));
			
			this.tfPublicacion.setEnabled(true);
			this.tfPublicacion.setText(datosEdicion.getFechaPub().toString());
			
			ArrayList<String> listaDocenteEdicione = new ArrayList<String>();
			listaDocenteEdicione = iconC.listarDocentesAux(nombreEdicion);
			DefaultListModel<String> modelDocenteEdiciones = new DefaultListModel<String>();
			for(String s : listaDocenteEdicione) {
				modelDocenteEdiciones.addElement(s);
			}
			listDocentes.setModel(modelDocenteEdiciones);
		} else if(!nombreEdicion.isEmpty()) {
			//Si no se elige Edicion se limpian los datos y la lista de docentes
			this.tfNombre.setEnabled(false);
			this.tfFechaInicio.setEnabled(false);
			this.tfFechaFin.setEnabled(false);
			this.tfCupo.setEnabled(false);
			this.tfPublicacion.setEnabled(false);
			DefaultListModel<String> modelDocenteEdiciones = new DefaultListModel<String>();
			Integer i = 0;
			for(i=0;i< listDocentes.getModel().getSize();i++) {
				modelDocenteEdiciones.addElement("");
			}
			listDocentes.setModel(modelDocenteEdiciones);			
		}
	}
	
	protected void cancelarConsulta(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}
	
	protected void limpiarFormulario() {
		//Limpiar la lista de cursos
		Integer i = 0;
        DefaultListModel<String> modelCursos = new DefaultListModel<String>();
        for(i=0;i<listCursos.getModel().getSize();i++) {
        	modelCursos.addElement("");
        }
        listCursos.setModel(modelCursos);
		
        //Limpiar la lista de Ediciones
        Integer j = 0;
        DefaultListModel<String> modelEdiciones = new DefaultListModel<String>();
        for(j=0;j<listEdicionesCurso.getModel().getSize();j++) {
        	modelCursos.addElement("");
        }
        listEdicionesCurso.setModel(modelEdiciones);
        
        //Limpiar la lista de Docentes
        Integer l = 0;
        DefaultListModel<String> modelDocentes = new DefaultListModel<String>();
        for(l=0;l<listDocentes.getModel().getSize();l++) {
        	modelCursos.addElement("");
        }
        listDocentes.setModel(modelDocentes);
		
        //Limpia las demas variables
		this.tfNombre.setText("");
		this.tfFechaInicio.setText("");
		this.tfFechaFin.setText("");
		this.tfCupo.setText("");
		this.tfPublicacion.setText("");
	}
	
}
