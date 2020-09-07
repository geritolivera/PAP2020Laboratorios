package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;

import datatypes.DTDocente;
import exepciones.EdicionExcepcion;
import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.awt.List;
import javax.swing.ScrollPaneConstants;

public class AltaDeEdicionDeCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IcontroladorCurso iconC;
	private IcontroladorUsuario iusu;
	private JTextField tfNombreEd;
	private JTextField tfCupo;
	private JComboBox<String> comboBoxInstituto;
	private JComboBox<String> comboBoxCursos;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	private List listaDocentes;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					AltaDeEdicionDeCurso frame = new AltaDeEdicionDeCurso();
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public AltaDeEdicionDeCurso(IcontroladorCurso iconC, IcontroladorUsuario iusu) {
		this.iconC = iconC;
		this.iusu = iusu;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Edicion de Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblinstituto = new JLabel("Instituto");
		lblinstituto.setBounds(10, 35, 46, 14);
		getContentPane().add(lblinstituto);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(217, 35, 46, 14);
		getContentPane().add(lblCursos);
		
		JLabel lblNombreEdicion = new JLabel("Nombre de la edici\u00F3n");
		lblNombreEdicion.setBounds(10, 97, 113, 14);
		getContentPane().add(lblNombreEdicion);
		
		JLabel lblFecha = new JLabel("Fecha de inicio");
		lblFecha.setBounds(10, 128, 99, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(10, 159, 80, 14);
		getContentPane().add(lblFechaDeFin);
		
		JLabel lblCupo = new JLabel("Cupo (opcional)");
		lblCupo.setBounds(10, 190, 99, 14);
		getContentPane().add(lblCupo);
		
		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCursoActionPerformed(arg0);
			}
		});
		comboBoxCursos.setBounds(260, 32, 89, 20);
		getContentPane().add(comboBoxCursos);
		
		tfNombreEd = new JTextField();
		tfNombreEd.setEnabled(false);
		tfNombreEd.setBounds(133, 94, 110, 20);
		getContentPane().add(tfNombreEd);
		tfNombreEd.setColumns(10);
		
		dateInicio = new JDateChooser();
		dateInicio.setEnabled(false);
		dateInicio.setBounds(133, 122, 110, 20);
		getContentPane().add(dateInicio);
		
		dateFin = new JDateChooser();
		dateFin.setEnabled(false);
		dateFin.setBounds(133, 153, 110, 20);
		getContentPane().add(dateFin);
		
		tfCupo = new JTextField();
		tfCupo.setEnabled(false);
		tfCupo.setBounds(133, 184, 110, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaEdAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(274, 139, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaEdCancelarActionPerformed(arg0);
			}
		});
		btnCancelar.setBounds(274, 186, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setBounds(10, 215, 80, 14);
		getContentPane().add(lblDocentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(133, 210, 110, 50);
		getContentPane().add(scrollPane);
		
		listaDocentes = new List();
		listaDocentes.setEnabled(false);
		scrollPane.setViewportView(listaDocentes);
		listaDocentes.setMultipleSelections(false);
		listaDocentes.setEnabled(false);
		
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbInstitutoActionPerformed(arg0);
			}
		});
		comboBoxInstituto.setBounds(66, 32, 99, 20);
		getContentPane().add(comboBoxInstituto);
		
	}
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		comboBoxInstituto.setModel(modelInstitutos);
	}
	
	protected void inicializarComboBoxCursos(String nombreInstituto) {
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>(iconC.listarCursosAux(nombreInstituto));
		comboBoxCursos.setModel(modelCursos);
	}
	
	protected void cbInstitutoActionPerformed(ActionEvent arg0) {
		String nombreInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		if(nombreInstituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Alta Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			inicializarComboBoxCursos(nombreInstituto);
		}	
	}
	
	protected void llenarLista() {//ver
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		String[] lisDocentes = iconC.listarDocentesInstituto(nomInstituto);
		for(int i = 0;i < lisDocentes.length;i++) {
	        listModel.addElement(lisDocentes[i]);
	    }
	}
	protected void cbCursoActionPerformed(ActionEvent arg0) {
		String curso = this.comboBoxCursos.getSelectedItem().toString();
		if (curso.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Alta Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			tfNombreEd.setEnabled(true);
			tfCupo.setEnabled(true);
			listaDocentes.setEnabled(true);
			dateInicio.setEnabled(true);
			dateFin.setEnabled(true);
			//ver aca
		}
	}
	
	protected void altaEdAceptarActionPerformed(ActionEvent arg0){
		String nomEd = this.tfNombreEd.getText();
		Date dateI = this.dateInicio.getDate();
		Date dateF = this.dateFin.getDate();
		String cupo = this.tfCupo.getText();
		String curso = this.comboBoxCursos.getSelectedItem().toString();
		Date fechPubli = Calendar.getInstance().getTime();
		if(checkFormulario()) {
			try{
				this.iconC.nuevosDatosEdicion(nomEd,dateI,dateF,Integer.parseInt(cupo),fechPubli,curso,listaDocentes);//vercon camilo
				JOptionPane.showMessageDialog(this, "Edicion de curso " + nomEd + " se da de alta con exito " , "Alta Edicion de Curso",
	                        JOptionPane.INFORMATION_MESSAGE);
			}catch(EdicionExcepcion e){
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			}			
		}
	}
	
	private boolean checkFormulario(){
		String nomEd = this.tfNombreEd.getText();
		String cupo = this.tfCupo.getText();
		if (nomEd.isEmpty()||cupo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Alta Edicion de Curso",JOptionPane.ERROR_MESSAGE);
			return false;
		}try {
			Integer.parseInt(cupo);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El numero de cupo debe ser un numero" , "Alta Edicion de Curso",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	protected void altaEdCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
	private void limpiarFormulario() {
        tfNombreEd.setText("");
        tfCupo.setText("");
        dateInicio = null;
        dateFin = null;
	}
}