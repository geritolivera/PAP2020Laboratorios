package presentacion.edicionCurso;

import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;

import datatypes.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IcontroladorCurso iconC;
	private IcontroladorUsuario iusu;
	
	private JTextField EdVigente;
	
	private JComboBox<String> comboBoxInstituto;	
	
	private JList<String> listCursos;
	private JList<String> listEstudiantes;
	
	private ArrayList<String> listaCursos;
	
	public InscripcionEdicionCurso(IcontroladorCurso iconC,IcontroladorUsuario iusu) {
		
		this.iconC = iconC;
		this.iusu = iusu;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a Edicion de Curso");
		setBounds(100, 100, 315, 565);
		getContentPane().setLayout(null);
		
		/*-----------------------------------------------------------------------------------------------*/
		//Label Instituto
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setBounds(30, 20, 50, 15);
		getContentPane().add(lblInstituto);
		
		//Label Cursos
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(30, 60, 46, 14);
		getContentPane().add(lblCursos);
		
		//Label seleccionar
		JLabel lblNewLabel = new JLabel("Seleccione el estudiante que desea inscribir");
		lblNewLabel.setBounds(30, 285, 245, 15);
		getContentPane().add(lblNewLabel);
				
		//Label edicion vigente
		JLabel lblEdicionVigente = new JLabel("Edicion Vigente");
		lblEdicionVigente.setBounds(30, 250, 102, 14);
		getContentPane().add(lblEdicionVigente);
		
		
		/*-----------------------------------------------------------------------------------------------*/
		//Variable para edicion vigente
		EdVigente = new JTextField();
		EdVigente.setEnabled(false);
		EdVigente.setBounds(125, 245, 150, 20);
		getContentPane().add(EdVigente);
		EdVigente.setColumns(10);
				
		
		/*-----------------------------------------------------------------------------------------------*/
		//Combobox instituto
		comboBoxInstituto = new JComboBox<String>();
		inicializarComboBoxInstituto();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarCursos(arg0);
			}
		});
		comboBoxInstituto.setBounds(90, 15, 150, 20);
		getContentPane().add(comboBoxInstituto);
		
		
		/*-----------------------------------------------------------------------------------------------*/
		//Boton de inscribir
		JButton btnInscribir = new JButton("Inscribir");
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnInscribir.setBounds(30, 465, 90, 25);
		getContentPane().add(btnInscribir);
		
		//Boton de cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCancelar.setBounds(170, 465, 90, 25);
		getContentPane().add(btnCancelar);
		
		//Boton Seleccionar
		JButton ButtonSeleccionar = new JButton("Seleccionar");
		ButtonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarEdicionVigente(e);		
			}
		});
		ButtonSeleccionar.setBounds(125, 205, 115, 25);
		getContentPane().add(ButtonSeleccionar);
		
		/*-----------------------------------------------------------------------------------------------*/
		//Lista de Cursos
		JScrollPane scrollPaneCursos = new JScrollPane();
		scrollPaneCursos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCursos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCursos.setBounds(90, 60, 150, 130);
		getContentPane().add(scrollPaneCursos);		
		listCursos = new JList<String>();
		scrollPaneCursos.setViewportView(listCursos);
		
		//Lista de Estudiantes
		JScrollPane scrollPaneEstudiantes = new JScrollPane();
		scrollPaneEstudiantes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEstudiantes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneEstudiantes.setBounds(60, 310, 180, 130);
		getContentPane().add(scrollPaneEstudiantes);		
		listEstudiantes = new JList<String>();
		scrollPaneEstudiantes.setViewportView(listEstudiantes);

	}

	//Iniciar comboBox instituto
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
	
	protected void mostrarEdicionVigente(ActionEvent e) {
		String nomCurso = this.listCursos.getSelectedValue().toString();
		DTEdicionCurso dt = this.iconC.mostrarEdicionVigente(nomCurso);
		this.EdVigente.setText(dt.getNombre());
	}
		
}
