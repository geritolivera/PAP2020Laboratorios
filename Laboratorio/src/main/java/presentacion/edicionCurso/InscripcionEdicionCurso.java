package presentacion.edicionCurso;

import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
import exepciones.UsuarioExcepcion;
import interfaces.IcontroladorCurso;

import datatypes.*;
import interfaces.IcontroladorUsuario;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorCurso iconC;

	private JTextField EdVigente;

	private JComboBox<String> comboBoxInstituto;

	private JList<String> listCursos;
	private JList<String> listEstudiantes;

	private ArrayList<String> listaCursos;
	private ArrayList<String> listaEstudiantes;
	

	public InscripcionEdicionCurso(IcontroladorCurso iconC, IcontroladorUsuario iusu) {

		this.iconC = iconC;
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
		lblNewLabel.setBounds(15, 284, 245, 15);
		getContentPane().add(lblNewLabel);

		//Label edicion vigente
		JLabel lblEdicionVigente = new JLabel("Edicion Vigente");
		lblEdicionVigente.setBounds(30, 250, 102, 14);
		getContentPane().add(lblEdicionVigente);

		
		/*-----------------------------------------------------------------------------------------------*/
		//Variable para edicion vigente
		EdVigente = new JTextField();
		EdVigente.setEditable(false);
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
				listarEstudiantes(arg0);
			}
		});
		comboBoxInstituto.setBounds(90, 15, 150, 20);
		getContentPane().add(comboBoxInstituto);


		/*-----------------------------------------------------------------------------------------------*/
		//Boton de inscribir
		JButton btnInscribir = new JButton("Inscribir");
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inscribirEstudiante(arg0);
			}
		});
		btnInscribir.setBounds(30, 465, 90, 25);
		getContentPane().add(btnInscribir);
		
		//Boton de cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarAction(arg0);
			}
		});
		btnCancelar.setBounds(170, 465, 90, 25);
		getContentPane().add(btnCancelar);

		//Boton Seleccionar
		JButton ButtonSeleccionar = new JButton("Seleccionar");
		ButtonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarEdicionVigente(e);
				} catch (CursoExcepcion cursoExcepcion) {
					cursoExcepcion.printStackTrace();
				}
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
		listEstudiantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneEstudiantes.setViewportView(listEstudiantes);

	}

	private void cancelarAction(ActionEvent arg0) {
		limpiarForm();
		setVisible(false);
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
			listaCursos = iconC.listarDocentesInstituto(nomInstituto);
			Integer i = 0;
			for(i= 0;i<listaCursos.size();i++) {
				modelCursos.addElement("");
			}
			listCursos.setModel(modelCursos);
		}
	}
	
	//Muestra ediciones vigentes
	protected void mostrarEdicionVigente(ActionEvent e) throws CursoExcepcion {
		String nomCurso = this.listCursos.getSelectedValue().toString();
		DTEdicionCurso dt = this.iconC.mostrarEdicionVigente(nomCurso);
		this.EdVigente.setText(dt.getNombre());
	}

	//Lista los estudiantes
	protected void listarEstudiantes(ActionEvent e) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		DefaultListModel<String> modelEstudiante = new DefaultListModel<String>();
		if(!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			listaEstudiantes = this.iconC.listarEstudiantes();
			for(String s : listaEstudiantes) {
				modelEstudiante.addElement(s);
			}
			listEstudiantes.setModel(modelEstudiante);
		} else if(!nomInstituto.contains("")) {
			JLabel lblEdicionVigente = new JLabel("Edicion Vigente");
			listaEstudiantes = iconC.listarDocentesInstituto(nomInstituto);
			Integer i = 0;
			for(i= 0;i<listaEstudiantes.size();i++) {
				modelEstudiante.addElement("");
			}
			listEstudiantes.setModel(modelEstudiante);
		}
	}
	protected void inscribirEstudiante(ActionEvent arg0){
		Date todayDate = Calendar.getInstance().getTime();
		String nickEstudiante = this.listEstudiantes.getSelectedValue().toString();
		String nombreEdicion = this.EdVigente.getText();
		try{
			this.iconC.inscribirEstudianteEdicion(nombreEdicion, nickEstudiante, todayDate);
			JOptionPane.showMessageDialog(this, "El estudiante "+ nickEstudiante + " ha sido inscripto");
		} catch (UsuarioExcepcion e) {
			JOptionPane.showMessageDialog(this, "Usuario");

		} catch (EdicionExcepcion e) {
			JOptionPane.showMessageDialog(this, "Edicion excepcion");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "El estudiante ya esta inscipto en esta edicion");
		}
	}

	public void limpiarForm(){
		this.EdVigente.setText("");
		String[] vacio = new String[1];
		vacio[0] = "";
		inicializarComboBoxInstituto();
		DefaultComboBoxModel<String> vacioModel = new DefaultComboBoxModel<String>();
		vacioModel.addElement(vacio[0]);
		comboBoxInstituto.setModel(vacioModel);

		String[] vacioLista = new String[1];
		vacio[0] = "";
		listCursos.setListData(vacioLista);
		listEstudiantes.setListData(vacioLista);
	}
}
