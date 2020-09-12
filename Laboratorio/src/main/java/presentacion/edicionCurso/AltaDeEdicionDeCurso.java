package presentacion.edicionCurso;

import com.toedter.calendar.JDateChooser;
import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AltaDeEdicionDeCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private final IcontroladorCurso iconC;
	private IcontroladorUsuario iusu;
	private final JTextField tfNombreEd;
	private final JTextField tfCupo;
	private final JComboBox<String> comboBoxInstituto;
	private final JComboBox<String> comboBoxCursos;
	private JDateChooser dateInicio;
	private JDateChooser dateFin;
	private final JList<String> listaDocentes;
	private String[] lisDocentes;
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
	public AltaDeEdicionDeCurso(IcontroladorCurso iconC) {
		this.iconC = iconC;
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


		comboBoxInstituto = new JComboBox<String>();
		inicializarComboBoxInstituto();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbInstitutoActionPerformed(arg0);
			}
		});
		comboBoxInstituto.setBounds(66, 32, 99, 20);
		getContentPane().add(comboBoxInstituto);


		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCursoActionPerformed(arg0);
			}
		});
		comboBoxCursos.setBounds(260, 32, 89, 20);
		getContentPane().add(comboBoxCursos);
		
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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(133, 210, 110, 50);
		getContentPane().add(scrollPane);
		
		listaDocentes = new JList<String>();
		scrollPane.setViewportView(listaDocentes);
		listaDocentes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaDocentes.setEnabled(false);
		

		
	}
	public void inicializarComboBoxInstituto() {
			DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
			listInst.insertElementAt((""),0);
			comboBoxInstituto.setModel(listInst);
			comboBoxInstituto.setSelectedIndex(0);
	}
	
	protected void inicializarComboBoxCursos(String nombreInstituto) {
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>(iconC.listarCursosAux(nombreInstituto));
		modelCursos.insertElementAt((""),0);
		comboBoxCursos.setModel(modelCursos);
		comboBoxCursos.setSelectedIndex(0);
	}
	
	protected void cbInstitutoActionPerformed(ActionEvent arg0) {
		String nombreInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		if(!nombreInstituto.isEmpty()) {
			inicializarComboBoxCursos(nombreInstituto);
		}/*else {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Alta Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}*/

	}
	protected void llenarLista() {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		DefaultListModel<String> modelDocentes = new DefaultListModel<String>();
		lisDocentes = iconC.listarDocentesInstituto(nomInstituto);
		for(int i = 0;i < lisDocentes.length;i++) {
	        modelDocentes.addElement(lisDocentes[i]);
	    }
		listaDocentes.setModel(modelDocentes);
	}

	protected void cbCursoActionPerformed(ActionEvent arg0) {
		inicializarComboBoxCursos(this.comboBoxInstituto.getSelectedItem().toString());
		String curso = this.comboBoxCursos.getSelectedItem().toString();
		if (!curso.isEmpty()) {
			tfNombreEd.setEnabled(true);
			tfCupo.setEnabled(true);
			listaDocentes.setEnabled(true);
			dateInicio.setEnabled(true);
			dateFin.setEnabled(true);
			llenarLista();
		}
	}
	
	protected void altaEdAceptarActionPerformed(ActionEvent arg0){
		String nomEd = this.tfNombreEd.getText();
		Date dateI = this.dateInicio.getDate();
		Date dateF = this.dateFin.getDate();
		String cupo = this.tfCupo.getText();
		String curso = this.comboBoxCursos.getSelectedItem().toString();
		Date fechPubli = Calendar.getInstance().getTime();
		String nomInst = this.comboBoxInstituto.getSelectedItem().toString();
		ArrayList<String> docentes = (ArrayList<String>) listaDocentes.getSelectedValuesList();
		if(checkFormulario()) {
			try{
				this.iconC.nuevosDatosEdicion(nomEd,dateI,dateF,Integer.parseInt(cupo),fechPubli,curso,docentes);
				JOptionPane.showMessageDialog(this, "Edicion de curso " + nomEd + " se da de alta con exito " , "Alta Edicion de Curso",
	                        JOptionPane.INFORMATION_MESSAGE);
			}catch(EdicionExcepcion e){
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			}catch(CursoExcepcion e){
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
		inicializarComboBoxInstituto();
        tfNombreEd.setText("");
        tfCupo.setText("");
        dateInicio = null;
        dateFin = null;
	}
}
