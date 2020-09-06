package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.IcontroladorCurso;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IcontroladorCurso iconC;
	private JTextField tfEdVigente;
	private JComboBox<String> comboBoxInstituto;
	private JComboBox<String> comboBoxEstudiante;
	private JComboBox<String> comboBoxCurso;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					InscripcionEdicionCurso frame = new InscripcionEdicionCurso();
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param iconC 
	 */
	public InscripcionEdicionCurso(IcontroladorCurso iconC) {
		this.iconC = iconC;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a Edicion de Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setBounds(32, 11, 46, 14);
		getContentPane().add(lblInstituto);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(198, 11, 46, 14);
		getContentPane().add(lblCursos);
		
		comboBoxCurso = new JComboBox<String>();
		comboBoxCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCursosActionEvent(arg0);
			}
		});
		comboBoxCurso.setEnabled(false);
		comboBoxCurso.setBounds(242, 11, 92, 20);
		getContentPane().add(comboBoxCurso);
		
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbInstitutoActionPerformed(arg0);
			}
		});
		comboBoxInstituto.setBounds(89, 11, 85, 20);
		getContentPane().add(comboBoxInstituto);
		
		JLabel lblNewLabel = new JLabel("Seleccione el estudiante que desea inscribir");
		lblNewLabel.setBounds(10, 151, 212, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxEstudiante = new JComboBox<String>();
		comboBoxEstudiante.setEnabled(false);
		comboBoxEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbEstudianteActionPerformed(arg0);
			}
		});
		comboBoxEstudiante.setBounds(232, 148, 102, 20);
		getContentPane().add(comboBoxEstudiante);
		
		JLabel lblEdicionVigente = new JLabel("Edicion Vigente");
		lblEdicionVigente.setBounds(10, 104, 102, 14);
		getContentPane().add(lblEdicionVigente);
		
		tfEdVigente = new JTextField();
		tfEdVigente.setEnabled(false);
		tfEdVigente.setBounds(120, 101, 86, 20);
		getContentPane().add(tfEdVigente);
		tfEdVigente.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(53, 225, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(193, 225, 89, 23);
		getContentPane().add(btnCancelar);

	}
	//inicia con los institutos cargados.
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		comboBoxInstituto.setModel(modelInstitutos);
		comboBoxCurso.setEnabled(true);
	}
	//inicia los cursos asociados a ese istituto
	protected void cbInstitutoActionPerformed(ActionEvent arg0) {
		String nombreInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		if(nombreInstituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Inscripcion a Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>(iconC.listarCursos(nombreInstituto));
			comboBoxCurso.setModel(modelCursos);
		}
	}
	protected void cbCursosActionPerformed(ActionEvent arg0) {
		String nombreCurso = this.comboBoxCurso.getSelectedItem().toString();
		if(nombreCurso.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Inscripcion a Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			tfEdVigente.setEnabled(true);
			comboBoxEstudiante.setEnabled(true);
			cbEstudianteActionPerformed(arg0);
		}
	}
	//inicializar el combo de estudiantes 
	protected void cbEstudianteActionPerformed(ActionEvent arg0) {
		DefaultComboBoxModel<String> modelEstudiantes = new DefaultComboBoxModel<String>(iconC.listarEstudiantes());
		comboBoxEstudiante.setModel(modelEstudiantes);	
	}
	
	
	
}
